<template>
  <div class="login-wrap">
    <div class="ms-login">
      <div class="ms-title">{{ this.GLOBAL.title }}</div>
      <el-form :model="param" :rules="rules" ref="login" label-width="0px" class="ms-content">
        <el-form-item prop="userName">
          <el-input v-model="param.userName" placeholder="userName">
            <el-button slot="prepend" icon="el-icon-lx-people"></el-button>
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
              type="password"
              placeholder="password"
              v-model="param.password"
              @keyup.enter.native="submitForm()">
            <el-button slot="prepend" icon="el-icon-lx-lock"></el-button>
          </el-input>
        </el-form-item>
        <div class="login-btn" style="display: inline-flex">
          <el-button type="primary" style="width: 140px" @click="submitForm()">登录</el-button>
          <el-button type="primary" style="width: 140px" @click="register()">注册</el-button>
        </div>
      </el-form>
    </div>
    <el-dialog title="注册" :modal="false" :visible.sync="addVisible" width="33%" :before-close="clearAddForm">
      <el-form label-position="left" ref="addForm" label-width="80px" :model="form">
        <el-form-item label="用户名">
          <el-input v-model="form.userName"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="form.password"></el-input>
        </el-form-item>
        <el-form-item label="真实姓名">
          <el-input v-model="form.realName"></el-input>
        </el-form-item>
        <el-form-item label="手机号">
          <el-input v-model="form.phone"></el-input>
        </el-form-item>
        <el-form-item label="地址">
          <el-input v-model="form.address"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
                <el-button @click="clearAddForm">取 消</el-button>
                <el-button type="primary" @click="saveAndUpdateUserInfo">确 定</el-button>
            </span>
    </el-dialog>
  </div>
</template>

<script>


import {Login} from '../../api/user';

export default {
  data: function () {
    return {
      param: {
        username: '',
        password: '',
      },
      form: {},
      rules: {
        userName: [{required: true, message: '请输入用户名', trigger: 'blur'}],
        password: [{required: true, message: '请输入密码', trigger: 'blur'},
          {min: 5, max: 10, message: '长度在 5到 10 个字符'}],
        userType: [{required: true, message: '请选择用户类型', trigger: 'blur'}],
      },
      addVisible: false,
    };
  },
  methods: {

    submitForm() {
      this.$refs.login.validate(valid => {
        if (valid) {
          Login(this.param).then(res => {
            if (res.code === 1) {
              sessionStorage.setItem("userStatus", "1");
              sessionStorage.setItem("userId", res.data.id);
              sessionStorage.setItem("userType", res.data.userType)
              this.$message.success('登录成功');
              sessionStorage.setItem("realName", res.data.realName);
              this.$router.push('/user');
            } else {
              this.$message.error('登录失败')
            }
          })
        } else {
          this.$message.error('请输入账号和密码');
          return false;
        }
      });
    },

    register() {
      sessionStorage.setItem('userStatus', "11");
      this.$router.push('/register')
    },
    clearAddForm() {
      this.addVisible = false;
    },
  },
};
</script>

<style scoped>
.login-wrap {
  position: relative;
  width: 100%;
  height: 100%;
  background-image: url(../../assets/img/b5.jpg);
  background-repeat: no-repeat;
  background-size: cover;
  background-position: center center;

  background-size: 100%;
}

.ms-title {
  width: 100%;
  line-height: 50px;
  text-align: center;
  font-size: 20px;
  color: #fff;
  border-bottom: 1px solid #ddd;
}

.ms-login {
  position: absolute;
  left: 50%;
  top: 50%;
  width: 350px;
  margin: -190px 0 0 -175px;
  border-radius: 5px;
  background: rgba(255, 255, 255, 0.3);
  overflow: hidden;
}

.ms-content {
  padding: 30px 30px;
}

.login-btn {
  text-align: center;
}

.login-btn button {
  width: 100%;
  height: 36px;
  margin-bottom: 10px;
}

.login-tips {
  font-size: 12px;
  line-height: 30px;
  color: #fff;
}
</style>
