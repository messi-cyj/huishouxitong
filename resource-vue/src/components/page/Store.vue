<template>
  <el-card shadow="never" class="aui-card--fill">
    <div class="mod__store">
      <el-form :inline="true" :model="query" @keyup.enter.native="getData()">
        <el-form-item>
          <el-input v-model="query.storeName" placeholder="仓库名" clearable></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="getData()">查询</el-button>
          <el-button @click="reset()">重置</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addStoreInfo">添加</el-button>
        </el-form-item>
        <el-form-item>
          <el-button :disabled="this.multipleSelection.length === 0" type="danger" @click="delBatchStoreInfo">批量删除
          </el-button>
        </el-form-item>
      </el-form>
      <el-table v-loading="tableDataLoading" :data="tableData" border @selection-change="selectionChange"
                style="width: 100%;">
        <el-table-column type="selection" header-align="center" align="center" width="50"></el-table-column>
        <el-table-column prop="storeName" label="仓库名" header-align="center" align="center"></el-table-column>
        <el-table-column label="操作" fixed="right" header-align="center" align="center" width="150">
          <template slot-scope="scope">
            <el-button type="success" size="small" @click="updateStoreInfo(scope.row)">更新</el-button>
            <el-button type="danger" size="small" @click="delStoreInfo(scope.row.id)">删除</el-button>
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
          <el-form-item label="仓库名" prop="storeName">
            <el-input v-model="form.storeName" placeholder="仓库名"></el-input>
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

import {getStoreInfo, saveStoreInfo, updateStoreInfo, delStoreInfo, delBatchStoreInfo} from '../../api/store'
import SingleUpload from '../common/singleUpload';


export default {
  components: {},

  data() {
    return {
      tableData: [],
      query: {
        pageNum: 1,
        pageSize: 10,
        storeName: null,
      },
      form: {},
      multipleSelection: [],
      tableDataLoading: false,
      total: 0,
      addOrUpdateVisible: false,
      rule: {
        storeName: [{required: true, message: '仓库名不得为空', trigger: "blur"}],
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
     * 获取所有仓库信息
     */
    getData() {
      getStoreInfo(this.query).then(res => {
        this.tableData = res.data.list;
        this.total = res.data.total;
      })
    },

    /**
     * 打开添加框
     */
    addStoreInfo() {
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
    updateStoreInfo(row) {
      this.form = JSON.parse(JSON.stringify(row));
      this.addOrUpdateVisible = true;
    },

    /**
     * 按住enter键或者确定按钮提交数据,对后台发请求
     * 如果id为null,就是走添加仓库信息的接口
     * 如果id不为null,就是走更新仓库信息的接口
     */
    formSubmitHandle() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.id === null) {
            saveStoreInfo(this.form).then(res => {
              if (res.code === 1) {
                this.$message.success('添加成功');
                this.getData();
                this.addOrUpdateVisible = false;
              }
            })
          } else {
            updateStoreInfo(this.form).then(res => {
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
    delStoreInfo(id) {
      this.$confirm('确定要删除所选择的吗？', '提示', {
        type: 'warning'
      }).then(action => {
        if (action === 'confirm') {
          delStoreInfo(id).then(res => {
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
     * 批量删除仓库信息的接口
     */
    delBatchStoreInfo() {
      delBatchStoreInfo(this.multipleSelection.join(',')).then(res => {
        this.$message.success('批量删除成功');
        this.getData();
      })
    },

    /**
     * 重置数据
     */
    reset() {
      this.query.storeName = null;
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
