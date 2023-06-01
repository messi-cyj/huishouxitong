<template>
  <div class="member-details-content">
    <div class="title">员工详细信息</div>
    <div class="row">
      <div class="col item-name">
        <div class="col-label">员工姓名：</div>
        <div class="col-value">{{ data.name }}</div>
      </div>
      <div class="col item-sex">
        <div class="col-label">员工性别：</div>
        <div class="col-value">{{ data.sex === 0 ? "男" : "女" }}</div>
      </div>
      <div class="col item-phone">
        <div class="col-label">联系电话：</div>
        <div class="col-value">{{ data.phone }}</div>
      </div>
      <div class="col item-email">
        <div class="col-label">邮箱：</div>
        <div class="col-value">{{ data.email }}</div>
      </div>
      <div class="col item-address">
        <div class="col-label">地址：</div>
        <div class="col-value">{{ data.address }}</div>
      </div>
      <div class="col item-roleName">
        <div class="col-label">角色名称：</div>
        <div class="col-value">{{ data.roleName }}</div>
      </div>
      <div class="col item-contact">
        <div class="col-label">相关联系人：</div>
        <div class="col-value">{{ data.contact }}</div>
      </div>
    </div>
    <FooterBtn />
  </div>
</template>

<script>
import {} from "../../utils/validator";

import { getStaffDetails } from "../../api/member";
import FooterBtn from "../common/FooterBtn.vue";

export default {
  components: {
    FooterBtn,
  },

  data() {
    return {
      data: [],
    };
  },
  created() {
    this.getData();
  },
  computed: {
    userType() {
      return Number(sessionStorage.getItem("userType"));
    },
  },

  methods: {
    /**
     * 获取所有员工信息
     */
    getData() {
      getStaffDetails(this.$route.query.id).then((res) => {
        if (res.code == 0) {
          this.data = res.data;
          console.log(this.data);
        }
      });
    },
  },
};
</script>
<style>
.member-details-content {
  width: 100%;
  height: 100%;
  background-color: white;
  position: relative;
  padding: 24px;
  box-sizing: border-box;
}
.member-details-content .title {
  width: 100%;
  /* height: 60px; */
  /* line-height: 60px; */
  background-color: #ededed;
  padding: 13px 20px;
  font-size: 16px;
  font-weight: 500;
  color: #262626;
  box-sizing: border-box;
  margin-bottom: 20px;
}
.member-details-content .row .col {
  display: flex;
  align-items: center;
  margin: 0px 0px 24px;
}
.member-details-content .row .col .col-label {
  width: 100px;
  font-size: 14px;
  color: rgba(0, 0, 0, 0.85);
  padding-left: 24px;
}
.member-details-content .row .col .col-value {
  font-size: 14px;
  color: rgba(0, 0, 0, 0.65);
}
</style>
