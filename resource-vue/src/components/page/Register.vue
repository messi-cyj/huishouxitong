<template>
  <div class="login-wrap">
    <div class="ms-login">
      <div class="ms-title">注册</div>
      <el-form :model="param" :rules="rules" ref="login" label-width="0px" class="ms-content">
        <el-form-item prop="userName">
          <el-input v-model="param.userName" placeholder="请输入用户名">
            <el-button slot="prepend" icon="el-icon-lx-people"></el-button>
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
              type="password"
              placeholder="请输入密码"
              v-model="param.password">
            <el-button slot="prepend" icon="el-icon-lx-lock"></el-button>
          </el-input>
        </el-form-item>
        <el-form-item prop="userName">
          <el-input v-model="param.realName" placeholder="请输入真实姓名">
          </el-input>
        </el-form-item>
        <el-form-item prop="userName">
          <el-input v-model="param.address" placeholder="请输入地址">
          </el-input>
        </el-form-item>
        <el-form-item prop="userName">
          <el-input v-model="param.phone" placeholder="请输入手机号">
          </el-input>
        </el-form-item>
        <el-form-item prop="email">
          <el-input v-model="param.email" placeholder="请输入邮箱">
          </el-input>
        </el-form-item>
        <el-form-item prop="sex">
          <el-select v-model="param.sex" style="width: 390px" placeholder="请选择性别">
            <el-option label="男" value="1"></el-option>
            <el-option label="女" value="2"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="imageUrl">
          <single-upload v-model="param.imageUrl"></single-upload>
        </el-form-item>
        <div class="login-btn">
          <el-button type="primary" @click="saveAndUpdateUserInfo">注册</el-button>
        </div>
      </el-form>
    </div>
  </div>
</template>
<script>
import SingleUpload from '../common/singleUpload';
import {saveUserInfo} from '../../api/user';

export default {
  components: {SingleUpload},
  data: function () {
    return {
      param: {
        username: '',
        password: '',
      },
      addVisible: false,
      form: {},
      rules: {
        userName: [{required: true, message: '请输入用户名', trigger: 'blur'}],
        password: [{required: true, message: '请输入密码', trigger: 'blur'},
          {min: 5, max: 10, message: '长度在 5到 10 个字符'}],
        userType: [{required: true, message: '请选择用户类型', trigger: 'blur'}],
      },
      code: '',
    };
  },
  methods: {
    saveAndUpdateUserInfo() {
      this.param.userType = 3;
      saveUserInfo(this.param).then(res => {
        if (res.code === 1) {
          this.$message.success('注册成功,现在可以去登录了');
          sessionStorage.setItem('userStatus', "111");
          setTimeout(() => {
            this.$router.push('/login')
          }, 2000)
        } else {
          this.$message.error('注册失败');
        }
      })
    },

    createCode() {
      let code = '';
      //设置长度，这里看需求，我这里设置了4
      let codeLength = 5;

      //设置随机字符
      let random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
      let random2 = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"];

      for (let i = 0; i < 1; i++) {
        let index = Math.floor(Math.random() * 9);
        //字符串拼接 将每次随机的字符 进行拼接
        code += random2[index];
      }


      for (let i = 0; i < codeLength; i++) {
        //设置随机数范围,这设置为0 ~ 36
        let index = Math.floor(Math.random() * 9);
        //字符串拼接 将每次随机的字符 进行拼接
        code += random[index];
      }
      //将拼接好的字符串赋值给展示的code
      this.code = code;
    },
  },
};
</script>

<style scoped>
.login-wrap {
  position: relative;
  width: 100%;
  height: 100%;
  background-image: url(../../assets/img/xk.png);
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
  left: 45%;
  top: 35%;
  width: 450px;
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
