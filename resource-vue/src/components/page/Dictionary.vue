<template>
  <el-card shadow="never" class="aui-card--fill">
    <div class="mod__dictionary">
      <el-form :inline="true" :model="query" @keyup.enter.native="getData()">
        <el-form-item>
          <el-input v-model="query.name" placeholder="名称" clearable></el-input>
        </el-form-item>
        <el-form-item>
          <el-select v-model="query.status" placeholder="请选择状态">
            <el-option key="1" label="开启" value="1"></el-option>
            <el-option key="2" label="关闭" value="2"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button @click="getData()">查询</el-button>
          <el-button @click="reset()">重置</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addDictionaryInfo">添加</el-button>
        </el-form-item>
        <el-form-item>
          <el-button :disabled="this.multipleSelection.length === 0" type="danger" @click="delBatchDictionaryInfo">
            批量删除
          </el-button>
        </el-form-item>
      </el-form>
      <el-table v-loading="tableDataLoading" :data="tableData" border @selection-change="selectionChange"
                style="width: 100%;">
        <el-table-column type="selection" header-align="center" align="center" width="50"></el-table-column>
        <el-table-column prop="name" label="名称" header-align="center" align="center"></el-table-column>
        <el-table-column prop="status" label="状态" header-align="center" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.status === 1">开启</span>
            <span v-if="scope.row.status === 2">关闭</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" fixed="right" header-align="center" align="center" width="150">
          <template slot-scope="scope">
            <el-button type="success" size="small" @click="updateDictionaryInfo(scope.row)">更新</el-button>
            <el-button type="danger" size="small" @click="delDictionaryInfo(scope.row.id)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
          :current-page="query.pageNum"
          :page-sizes="[10, 20, 50, 100]"
          :page-size="query.pageSize"
          :total="total"
          layout="total, sizes, prev, pager, next, jumper"
          @size-change="pageSizeChange"
          @current-change="pageCurrentChange">
      </el-pagination>
      <!-- 弹窗, 新增 / 修改 -->
      <el-dialog :visible.sync="addOrUpdateVisible" :title="!form.id ? '新增' : '编辑'" :close-on-click-modal="false"
                 :close-on-press-escape="false">
        <el-form :model="form" :rules="rule" ref="form" @keyup.enter.native="formSubmitHandle()" label-width="100px">
          <el-form-item label="名称" prop="name">
            <el-input v-model="form.name" placeholder="名称"></el-input>
          </el-form-item>
          <el-form-item label="状态" prop="status">
            <el-radio-group v-model="form.status">
              <el-radio :label="1">开启</el-radio>
              <el-radio :label="2">关闭</el-radio>
            </el-radio-group>
          </el-form-item>
        </el-form>
        <template slot="footer">
          <el-button @click="addOrUpdateVisible = false">取消</el-button>
          <el-button type="primary" @click="formSubmitHandle()">确认</el-button>
        </template>
      </el-dialog>

    </div>
  </el-card>
</template>

<script>
import {} from '../../utils/validator'

import {
  getDictionaryInfo,
  saveDictionaryInfo,
  updateDictionaryInfo,
  delDictionaryInfo,
  delBatchDictionaryInfo
} from '../../api/dictionary'
import SingleUpload from '../common/singleUpload';


export default {
  components: {},

  data() {
    return {
      tableData: [],
      query: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        status: null,
      },
      form: {},
      multipleSelection: [],
      tableDataLoading: false,
      total: 0,
      addOrUpdateVisible: false,
      rule: {
        name: [{required: true, message: '名称不得为空', trigger: "blur"}],
        status: [{required: true, message: '状态不得为空', trigger: "change"}],
      },
    }
  },
  created() {
    this.getData();
  },
  computed: {
    userType() {
      return Number(sessionStorage.getItem('userType'))
    }
  },

  methods: {


    /**
     * 获取所有字典管理
     */
    getData() {
      getDictionaryInfo(this.query).then(res => {
        this.tableData = res.data.list;
        this.total = res.data.total;
      })
    },

    /**
     * 打开添加框
     */
    addDictionaryInfo() {
      this.form = {};
      this.form.id = null;
      if (this.$refs['form'] !== undefined) {
        this.$refs['form'].resetFields();
      }
      this.addOrUpdateVisible = true;
    },

    /**
     * 打开更新框
     */
    updateDictionaryInfo(row) {
      this.form = JSON.parse(JSON.stringify(row));
      this.addOrUpdateVisible = true;
    },

    /**
     * 按住enter键或者确定按钮提交数据,对后台发请求
     * 如果id为null,就是走添加字典管理的接口
     * 如果id不为null,就是走更新字典管理的接口
     */
    formSubmitHandle() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.id === null) {
            saveDictionaryInfo(this.form).then(res => {
              if (res.code === 1) {
                this.$message.success('添加成功');
                this.getData();
                this.addOrUpdateVisible = false;
              }
            })
          } else {
            updateDictionaryInfo(this.form).then(res => {
              this.$message.success('更新成功');
              this.getData();
              this.addOrUpdateVisible = false;
            })
          }
          // this.$refs['form'].resetFields()

        }
      })
    },

    /**
     *单个删除数据
     */
    delDictionaryInfo(id) {
      this.$confirm('确定要删除所选择的吗？', '提示', {
        type: 'warning'
      }).then(action => {
        if (action === 'confirm') {
          delDictionaryInfo(id).then(res => {
            if (res.code === 1) {
              this.$message.success('删除成功');
              this.getData();
            } else {
              return this.$message.error(res.msg)
            }

          })
        }
      }).catch(() => {
      });

    },


    /**
     * 选中table表格事件
     */
    selectionChange(val) {
      this.multipleSelection = [];
      val.forEach((item) => {
        this.multipleSelection.push(item.id);
      });
    },

    /**
     * 批量删除字典管理的接口
     */
    delBatchDictionaryInfo() {
      delBatchDictionaryInfo(this.multipleSelection.join(',')).then(res => {
        this.$message.success('批量删除成功');
        this.getData();
      })
    },

    /**
     * 重置数据
     */
    reset() {
      this.query.name = null;
      this.query.status = null;
      this.$set(this.query, 'pageNum', 1);
      this.getData();
    },


    /**
     * 分页(改变页码)
     * @param val
     */
    pageCurrentChange(val) {
      this.$set(this.query, 'pageNum', val);
      this.getData();
    },

    /**
     * 分页(改变每页条数)
     * @param val
     */
    pageSizeChange(val) {
      this.$set(this.query, 'pageSize', val);
      this.getData();
    },

    /**
     * 关闭弹窗
     */
    clearAddForm() {
      this.addOrUpdateVisible = false;
    }
  },


}
</script>
