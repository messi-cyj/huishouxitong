<template>
  <el-card shadow="never" class="aui-card--fill">
    <div class="mod__user">
      <el-form :inline="true" :model="query" @keyup.enter.native="getData()">
        <el-form-item>
          <el-input v-model="query.realName" placeholder="姓名" clearable></el-input>
        </el-form-item>
        <el-form-item>
          <el-input v-model="query.address" placeholder="地址" clearable></el-input>
        </el-form-item>
        <el-form-item>
          <el-select v-model="query.userType" placeholder="请选择用户类型">
            <el-option key="1" label="管理员" value="1"></el-option>
            <el-option key="2" label="用户" value="2"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button @click="getData()">查询</el-button>
          <el-button @click="reset()">重置</el-button>
        </el-form-item>
        <el-form-item v-if="userType === 1">
          <el-button type="primary" @click="addUserInfo">添加</el-button>
        </el-form-item>
        <el-form-item v-if="userType === 1">
          <el-button :disabled="this.multipleSelection.length === 0" type="danger" @click="delBatchUserInfo">批量删除
          </el-button>
        </el-form-item>
      </el-form>
      <el-table v-loading="tableDataLoading" :data="tableData" border @selection-change="selectionChange"
                style="width: 100%;">
        <el-table-column type="selection" header-align="center" align="center" width="50"></el-table-column>
        <el-table-column prop="userName" label="用户名" header-align="center" align="center"></el-table-column>
        <el-table-column prop="password" label="密码" header-align="center" align="center"></el-table-column>
        <el-table-column prop="realName" label="姓名" header-align="center" align="center"></el-table-column>
        <el-table-column prop="address" label="地址" header-align="center" align="center"></el-table-column>
        <el-table-column prop="email" label="邮箱" header-align="center" align="center"></el-table-column>
        <el-table-column prop="phone" label="联系方式" header-align="center" align="center"></el-table-column>
        <el-table-column prop="sex" label="性别" header-align="center" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.sex === '1'">男</span>
            <span v-if="scope.row.sex === '2'">女</span>
          </template>
        </el-table-column>
        <el-table-column prop="userType" label="用户类型" header-align="center" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.userType === 1">管理员</span>
            <span v-if="scope.row.userType === 2">员工</span>
            <span v-if="scope.row.userType === 3">用户</span>
          </template>
        </el-table-column>
        <el-table-column prop="imageUrl" label="头像" header-align="center" align="center">
          <template slot-scope="scope">
            <el-image
                style="width: 60px; height: 60px"
                :src="scope.row.imageUrl"
                :preview-src-list="[scope.row.imageUrl]">
            </el-image>
          </template>
        </el-table-column>
        <el-table-column label="操作" fixed="right" header-align="center" align="center" width="150">
          <template slot-scope="scope">
            <el-button type="success" size="small" @click="updateUserInfo(scope.row)">更新</el-button>
            <el-button type="danger" size="small" @click="delUserInfo(scope.row.id)" v-if="userType === 1">删除
            </el-button>
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
          <el-form-item label="用户名" prop="userName">
            <el-input v-model="form.userName" placeholder="用户名"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input v-model="form.password" placeholder="密码"></el-input>
          </el-form-item>
          <el-form-item label="姓名" prop="realName">
            <el-input v-model="form.realName" placeholder="姓名"></el-input>
          </el-form-item>
          <el-form-item label="地址" prop="address">
            <el-input v-model="form.address" placeholder="地址"></el-input>
          </el-form-item>
          <el-form-item label="联系方式" prop="phone">
            <el-input v-model="form.phone" placeholder="联系方式"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="form.email" placeholder="邮箱"></el-input>
          </el-form-item>
          <el-form-item label="性别" prop="sex">
            <el-radio-group v-model="form.sex">
              <el-radio :label="1">男</el-radio>
              <el-radio :label="2">女</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="用户类型" prop="userType" v-if="userType === 1">
            <el-radio-group v-model="form.userType">
              <el-radio :label="1">管理员</el-radio>
              <el-radio :label="2">员工</el-radio>
              <el-radio :label="3">用户</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="头像" prop="imageUrl">
            <single-upload v-model="form.imageUrl"></single-upload>
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
import SingleUpload from '../common/singleUpload';
import {validatePhone,} from '../../utils/validator'

import {getUserInfo, saveUserInfo, updateUserInfo, delUserInfo, delBatchUserInfo} from '../../api/user'


export default {
  components: {SingleUpload},

  data() {
    return {
      tableData: [],
      query: {
        pageNum: 1,
        pageSize: 10,
        realName: null,
        address: null,
        userType: null,
      },
      form: {},
      multipleSelection: [],
      tableDataLoading: false,
      total: 0,
      addOrUpdateVisible: false,
      rule: {
        userName: [{required: true, message: '用户名不得为空', trigger: "blur"}],
        password: [{required: true, message: '密码不得为空', trigger: "blur"}],
        realName: [{required: true, message: '姓名不得为空', trigger: "blur"}],
        address: [{required: true, message: '地址不得为空', trigger: "blur"}],
        phone: [{required: true, message: '联系方式不得为空', trigger: 'blur'}, {validator: validatePhone, trigger: 'blur'}],
        userType: [{required: true, message: '用户类型不得为空', trigger: "change"}],
        sex: [{required: true, message: '性别不得为空', trigger: "change"}],
        imageUrl: [{required: true, message: '头像不得为空', trigger: "blur"}],
        email: [{required: true, message: '邮箱不得为空', trigger: "blur"}],
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
     * 获取所有用户信息
     */
    getData() {
      if (Number(sessionStorage.getItem('userType')) !== 1) {
        this.query.id = sessionStorage.getItem('userId')
      }
      getUserInfo(this.query).then(res => {
        this.tableData = res.data.list;
        this.total = res.data.total;
      })
    },


    /**
     * 打开添加框
     */
    addUserInfo() {
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
    updateUserInfo(row) {
      this.form = JSON.parse(JSON.stringify(row));
      this.addOrUpdateVisible = true;
    },

    /**
     * 按住enter键或者确定按钮提交数据,对后台发请求
     * 如果id为null,就是走添加用户信息的接口
     * 如果id不为null,就是走更新用户信息的接口
     */
    formSubmitHandle() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.id === null) {
            saveUserInfo(this.form).then(res => {
              this.$message.success('添加成功');
              this.getData();
            })
          } else {
            updateUserInfo(this.form).then(res => {
              this.$message.success('更新成功');
              this.getData();
            })
          }
          // this.$refs['form'].resetFields();
          this.addOrUpdateVisible = false;

        }
      });
    },

    /**
     *单个删除数据
     */
    delUserInfo(id) {
      this.$confirm('确定要删除所选择的吗？', '提示', {
        type: 'warning'
      }).then(action => {
        if (action === 'confirm') {
          delUserInfo(id).then(res => {
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
     * 批量删除用户信息的接口
     */
    delBatchUserInfo() {
      delBatchUserInfo(this.multipleSelection.join(',')).then(res => {
        this.$message.success('批量删除成功');
        this.getData();
      })
    },

    /**
     * 重置数据
     */
    reset() {
      this.query.realName = null;
      this.query.address = null;
      this.query.userType = null;
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
