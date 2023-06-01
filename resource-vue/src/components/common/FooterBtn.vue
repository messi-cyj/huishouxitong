<template>
  <div class="footer-content">
    <el-button class="btn" type="primary" size="small" @click="returnFunc">返回</el-button>
  </div>
</template>

<script>
import bus from "./bus";
export default {
  data() {
    return {
      tagsList: [],
    };
  },
  methods: {
    returnFunc(){
        this.$router.go(-1);
    }
  },
};
</script>

<style>
.footer-content{
    width: calc(100% + 10px);
    height: 60px;
    background-color: white;
    display: flex;
    justify-content: flex-end;
    box-shadow: 0px -7px 10px 0px rgba(0, 0, 0, 0.05);
    position: absolute;
    bottom: -10px;
    right: 0px;
    box-sizing: border-box;
    padding: 14px 20px;
}
.footer-content .btn{
    flex-grow: 0;
}
</style>
