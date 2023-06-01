<template>
  <div class="bus-details-content">
    <div class="title">车辆详细信息</div>
    <div class="row">
      <div class="col item-carNo">
        <div class="col-label">车辆牌号：</div>
        <div class="col-value">{{ data.carNo }}</div>
      </div>
      <div class="col item-licensePlateColor">
        <div class="col-label">车牌颜色：</div>
        <div class="col-value">{{ data.licensePlateColor }}</div>
      </div>
      <div class="col item-carType">
        <div class="col-label">车辆类型：</div>
        <div class="col-value">{{ data.carType }}</div>
      </div>
      <div class="col item-carStatus">
        <div class="col-label">运营状态：</div>
        <div class="col-value">{{ data.carStatus === 0 ? "营运" : "停业" }}</div>
      </div>
      <div class="col item-manageScope">
        <div class="col-label">经营范围：</div>
        <div class="col-value">{{ data.manageScope }}</div>
      </div>
      <div class="col item-totalMass">
        <div class="col-label">总质量：</div>
        <div class="col-value">{{ data.totalMass }}</div>
      </div>
      <div class="col item-checkWeight">
        <div class="col-label">核载质量：</div>
        <div class="col-value">{{ data.checkWeight }}</div>
      </div>
    </div>
  <FooterBtn />
  </div>
</template>

<script>
import {} from "../../utils/validator";

import { getCarDetails } from "../../api/bus";
import FooterBtn from "../common/FooterBtn.vue";

export default {
  components: {
    FooterBtn
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
     * 获取车辆详情
     */
    getData() {
      getCarDetails(this.$route.query.id).then((res) => {
        if(res.code == 0){
          console.log(res.data);
          this.data = res.data;
        }
      });
    },
  },
};
</script>

<style>
.bus-details-content{
  width: 100%;
  height: 100%;
  background-color: white;
  position: relative;
  padding: 24px;
  box-sizing: border-box;
}
.bus-details-content .title {
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
.bus-details-content .row .col {
  display: flex;
  align-items: center;
  margin: 0px 0px 24px;
}
.bus-details-content .row .col .col-label {
  width: 100px;
  font-size: 14px;
  color: rgba(0, 0, 0, 0.85);
  padding-left: 24px;
}
.bus-details-content .row .col .col-value {
  font-size: 14px;
  color: rgba(0, 0, 0, 0.65);
}
</style>
