<template>
  <el-card shadow="never" class="aui-card--fill">
    <div class="mod__notice">
      <el-form :inline="true" :model="query" @keyup.enter.native="getData()">
        <el-form-item>
          <el-input v-model="query.title" placeholder="标题" clearable></el-input>
        </el-form-item>
        <el-form-item>
        </el-form-item>
        <el-form-item>
          <el-select v-model="query.type" placeholder="请选择类型">
            <el-option key="1" label="系统推送" value="1"></el-option>
            <el-option key="2" label="紧急通知" value="2"></el-option>
            <el-option key="3" label="普通推送" value="3"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-input v-model="query.realName" placeholder="接收人" clearable></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="getData()">查询</el-button>
          <el-button @click="reset()">重置</el-button>
        </el-form-item>
        <el-form-item v-if="userType === 1">
          <el-button type="primary" @click="addNoticeInfo">添加</el-button>
        </el-form-item>
        <el-form-item v-if="userType === 1">
          <el-button :disabled="this.multipleSelection.length === 0" type="danger" @click="delBatchNoticeInfo">批量删除
          </el-button>
        </el-form-item>
      </el-form>
      <el-table v-loading="tableDataLoading" :data="tableData" border @selection-change="selectionChange"
                style="width: 100%;">
        <el-table-column type="selection" header-align="center" align="center" width="50"></el-table-column>
        <el-table-column prop="title" label="标题" header-align="center" align="center"></el-table-column>
        <el-table-column prop="content" label="内容" header-align="center" align="center"></el-table-column>
        <el-table-column prop="type" label="类型" header-align="center" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.type === 1">系统推送</span>
            <span v-if="scope.row.type === 2">紧急通知</span>
            <span v-if="scope.row.type === 3">普通推送</span>
          </template>
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" header-align="center" align="center"></el-table-column>
        <el-table-column prop="realName" label="接收人" header-align="center" align="center"></el-table-column>
        <el-table-column label="操作" fixed="right" header-align="center" align="center" width="150"
                         v-if="userType === 1">
          <template slot-scope="scope">
            <el-button type="success" size="small" @click="updateNoticeInfo(scope.row)">更新</el-button>
            <el-button type="danger" size="small" @click="delNoticeInfo(scope.row.id)">删除</el-button>
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
          <el-form-item label="标题" prop="title">
            <el-input v-model="form.title" placeholder="标题"></el-input>
          </el-form-item>
          <el-form-item label="内容" prop="content">
            <el-input v-model="form.content" placeholder="内容"></el-input>
          </el-form-item>
          <el-form-item label="类型" prop="type">
            <el-radio-group v-model="form.type">
              <el-radio :label="1">系统推送</el-radio>
              <el-radio :label="2">紧急通知</el-radio>
              <el-radio :label="3">普通推送</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="接收人" prop="userId">
            <el-select v-model="form.userId" placeholder="请选择接收人">
              <el-option
                  v-for="item in options"
                  :key="item.id"
                  :label="item.realName"
                  :value="item.id">
              </el-option>
            </el-select>
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

import {getNoticeInfo, saveNoticeInfo, updateNoticeInfo, delNoticeInfo, delBatchNoticeInfo} from '../../api/notice'
import {getUserInfo,} from '../../api/user'
import SingleUpload from '../common/singleUpload';


export default {
  components: {},

  data() {
    return {
      options: [],
      tableData: [],
      query: {
        pageNum: 1,
        pageSize: 10,
        title: null,
        userId: null,
        type: null,
        realName: null,
      },
      form: {},
      multipleSelection: [],
      tableDataLoading: false,
      total: 0,
      addOrUpdateVisible: false,
      rule: {
        title: [{required: true, message: '标题不得为空', trigger: "blur"}],
        content: [{required: true, message: '内容不得为空', trigger: "blur"}],
        userId: [{required: true, message: '接收人不得为空', trigger: "blur"}],
        type: [{required: true, message: '类型不得为空', trigger: "change"}],
        createTime: [{required: true, message: '创建时间不得为空', trigger: "blur"}],
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
     * 获取所有通知信息
     */
    getData() {
      if (Number(sessionStorage.getItem('userType')) === 2) {
        this.query.userId = sessionStorage.getItem('userId');
      }
      getNoticeInfo(this.query).then(res => {
        this.tableData = res.data.list;
        this.total = res.data.total;
      })
      getUserInfo({pageSize: 100, userType: 2}).then(res => {
        this.options = res.data.list;
      })

    },

    /**
     * 打开添加框
     */
    addNoticeInfo() {
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
    updateNoticeInfo(row) {
      this.form = JSON.parse(JSON.stringify(row));
      this.addOrUpdateVisible = true;
    },

    /**
     * 按住enter键或者确定按钮提交数据,对后台发请求
     * 如果id为null,就是走添加通知信息的接口
     * 如果id不为null,就是走更新通知信息的接口
     */
    formSubmitHandle() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.id === null) {
            saveNoticeInfo(this.form).then(res => {
              if (res.code === 1) {
                this.$message.success('添加成功');
                this.getData();
                this.addOrUpdateVisible = false;
              } else {
                this.$message.warning(res.msg)
              }
            })
          } else {
            updateNoticeInfo(this.form).then(res => {
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
    delNoticeInfo(id) {
      this.$confirm('确定要删除所选择的吗？', '提示', {
        type: 'warning'
      }).then(action => {
        if (action === 'confirm') {
          delNoticeInfo(id).then(res => {
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
     * 批量删除通知信息的接口
     */
    delBatchNoticeInfo() {
      delBatchNoticeInfo(this.multipleSelection.join(',')).then(res => {
        this.$message.success('批量删除成功');
        this.getData();
      })
    },

    /**
     * 重置数据
     */
    reset() {
      this.query.title = null;
      this.query.userId = null;
      this.query.type = null;
      this.query.realName = null
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
