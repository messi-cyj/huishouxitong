<template>
  <el-card shadow="never" class="aui-card--fill">
    <div class="mod__store">
      <el-form :inline="true" :model="query" @keyup.enter.native="getData()">
        <el-form-item label="车辆牌号" name="carNo">
          <el-input
            v-model="query.carNo"
            placeholder="请输入车辆牌号"
            clearable
          ></el-input>
        </el-form-item>
        <el-form-item label="车辆类型" name="carType">
          <!-- <el-select v-model="query.carType" placeholder="请选择">
            <el-option
              :label="item.label"
              :value="item.value"
            >
            </el-option>
            <el-option
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select> -->
          <el-input
            v-model="query.carType"
            placeholder="请输入车辆类型"
            clearable
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="getData()">查询</el-button>
          <el-button @click="reset()">重置</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addStoreInfo">添加</el-button>
        </el-form-item>
      </el-form>
      <el-table
        v-loading="tableDataLoading"
        :data="tableData"
        border
        @selection-change="selectionChange"
        style="width: 100%"
      >
        <el-table-column
          type="selection"
          header-align="center"
          align="center"
          width="50"
        ></el-table-column>
        <el-table-column
          prop="carNo"
          label="车辆牌号"
          header-align="center"
          align="center"
        ></el-table-column>
        <el-table-column
          prop="licensePlateColor"
          label="车牌颜色"
          header-align="center"
          align="center"
        ></el-table-column>
        <el-table-column
          prop="carType"
          label="车辆类型"
          header-align="center"
          align="center"
        ></el-table-column>
        <el-table-column
          prop="carStatus"
          label="运营状态"
          header-align="center"
          align="center"
        >
          <template v-slot="scope">
            {{ scope.row.carStatus === 0 ? "营运" : "停业" }}
          </template>
        </el-table-column>
        <el-table-column
          prop="totalMass"
          label="总质量"
          header-align="center"
          align="center"
        ></el-table-column>
        <el-table-column
          prop="checkWeight"
          label="核载质量"
          header-align="center"
          align="center"
        ></el-table-column>
        <el-table-column
          label="操作"
          fixed="right"
          header-align="center"
          align="center"
          width="225"
        >
          <template slot-scope="scope">
            <el-button type="primary" size="small" @click="openDetails(scope.row.id)"
              >详情</el-button
            >
            <el-button type="success" size="small" @click="updateStoreInfo(scope.row)"
              >更新</el-button
            >
            <el-button type="danger" size="small" @click="deleteCar(scope.row.id)"
              >删除</el-button
            >
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
        @current-change="pageCurrentChange"
      >
      </el-pagination>
      <!-- 弹窗, 新增 / 修改 -->
      <el-dialog
        :visible.sync="addOrUpdateVisible"
        :title="!form.id ? '新增' : '编辑'"
        :close-on-click-modal="false"
        :close-on-press-escape="false"
      >
        <el-form
          :model="form"
          :rules="rule"
          ref="form"
          @keyup.enter.native="formSubmitHandle()"
          label-width="100px"
        >
          <el-form-item label="车辆牌号" prop="carNo">
            <el-input v-model="form.carNo" placeholder="车辆牌号"></el-input>
          </el-form-item>
          <el-form-item label="车牌颜色" prop="licensePlateColor">
            <el-input v-model="form.licensePlateColor" placeholder="车牌颜色"></el-input>
          </el-form-item>
          <el-form-item label="车辆类型" prop="carType">
            <el-input v-model="form.carType" placeholder="车辆类型"></el-input>
          </el-form-item>
          <el-form-item label="运营状态" prop="carStatus">
            <el-radio v-model="form.carStatus" :label="0">营运</el-radio>
            <el-radio v-model="form.carStatus" :label="1">停业</el-radio>
          </el-form-item>
          <el-form-item label="经营范围" prop="manageScope">
            <el-input v-model="form.manageScope" placeholder="请输入经营范围"></el-input>
          </el-form-item>
          <el-form-item label="总质量" prop="totalMass">
            <el-input v-model="form.totalMass" placeholder="总质量"></el-input>
          </el-form-item>
          <el-form-item label="核载质量" prop="checkWeight">
            <el-input v-model="form.checkWeight" placeholder="核载质量"></el-input>
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
import {} from "../../utils/validator";

import { getCarList, saveCar, updateCar, deleteCar } from "../../api/bus";

export default {
  components: {},

  data() {
    return {
      tableData: [],
      query: {
        page: 1,
        limit: 10,
        // storeName: null,
        carNo: "",
        carType: "",
      },
      form: {},
      multipleSelection: [],
      tableDataLoading: false,
      total: 0,
      addOrUpdateVisible: false,
      rule: {
        carNo: [{ required: true, message: "车辆牌号不得为空", trigger: "blur" }],
      },
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
     * 获取所有车辆信息
     */
    getData() {
      getCarList(this.query).then((res) => {
        // console.log(res);
        this.tableData = res.data;
        this.total = res.data.length;
      });
    },

    /**
     * 打开添加框
     */
    addStoreInfo() {
      this.form = {};
      this.form.id = null;
      if (this.$refs["form"] !== undefined) {
        this.$refs["form"].resetFields();
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
     * 打开详情页面
     * @param {*} id
     */
    openDetails(id) {
      this.$router.push(`/bus/bus-details?id=${id}`);
    },

    /**
     * 按住enter键或者确定按钮提交数据,对后台发请求
     * 如果id为null,就是走添加仓库信息的接口
     * 如果id不为null,就是走更新仓库信息的接口
     */
    formSubmitHandle() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.id === null) {
            saveCar(this.form).then((res) => {
              console.log(res);
              if (res.code === 0) {
                this.$message.success("添加成功");
                this.getData();
                this.addOrUpdateVisible = false;
              }
            });
          } else {
            updateCar(this.form).then((res) => {
              this.$message.success("更新成功");
              this.getData();
              this.addOrUpdateVisible = false;
            });
          }
          // this.$refs['form'].resetFields()
        }
      });
    },

    /**
     *单个删除数据
     */
    deleteCar(id) {
      this.$confirm("确定要删除所选择的吗？", "提示", {
        type: "warning",
      })
        .then((action) => {
          if (action === "confirm") {
            deleteCar(id).then((res) => {
              if (res.code === 0) {
                this.$message.success("删除成功");
                this.getData();
              } else {
                return this.$message.error(res.msg);
              }
            });
          }
        })
        .catch(() => {});
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
     * 重置数据
     */
    reset() {
      this.query.carNo = null;
      this.query.carType = null;
      this.$set(this.query, "pageNum", 1);
      this.getData();
    },

    /**
     * 分页(改变页码)
     * @param val
     */
    pageCurrentChange(val) {
      this.$set(this.query, "pageNum", val);
      this.getData();
    },

    /**
     * 分页(改变每页条数)
     * @param val
     */
    pageSizeChange(val) {
      this.$set(this.query, "pageSize", val);
      this.getData();
    },

    /**
     * 关闭弹窗
     */
    clearAddForm() {
      this.addOrUpdateVisible = false;
    },
  },
};
</script>
