<template>
  <el-card shadow="never" class="aui-card--fill">
    <div class="mod__store">
      <el-form :inline="true" :model="query" @keyup.enter.native="getData()">
        <el-form-item label="员工姓名" name="name">
          <el-input
            v-model="query.name"
            placeholder="请输入员工姓名"
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
          prop="id"
          label="员工编号"
          header-align="center"
          align="center"
        ></el-table-column>
        <el-table-column
          prop="name"
          label="员工姓名"
          header-align="center"
          align="center"
        ></el-table-column>
        <el-table-column prop="sex" label="性别" header-align="center" align="center">
          <template v-slot="scope">
            {{ scope.row.sex === 0 ? "男" : "女" }}
          </template>
        </el-table-column>
        <el-table-column
          prop="phone"
          label="联系电话"
          header-align="center"
          align="center"
        ></el-table-column>
        <el-table-column
          prop="email"
          label="邮箱"
          header-align="center"
          align="center"
        ></el-table-column>
        <el-table-column
          prop="roleName"
          label="角色名称"
          header-align="center"
          align="center"
        >
          <template v-slot="scope">
            {{ scope.row.roleName ? scope.row.roleName : "--" }}
          </template>
        </el-table-column>
        <el-table-column
          prop="contact"
          label="相关联系人"
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
            <el-button type="danger" size="small" @click="deleteStaff(scope.row.id)"
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
          <!-- <el-form-item label="员工编号" prop="id">
            <el-input v-model="form.id" placeholder="员工编号"></el-input>
          </el-form-item> -->
          <el-form-item label="员工姓名" prop="name">
            <el-input v-model="form.name" placeholder="员工姓名"></el-input>
          </el-form-item>
          <el-form-item label="性别" prop="sex">
            <!-- <el-input v-model="form.sex" placeholder="性别"></el-input> -->
            <el-radio v-model="form.sex" :label="0">男</el-radio>
            <el-radio v-model="form.sex" :label="1">女</el-radio>
          </el-form-item>
          <el-form-item label="联系电话" prop="phone">
            <el-input v-model="form.phone" placeholder="联系电话"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="form.email" placeholder="邮箱"></el-input>
          </el-form-item>
          <el-form-item label="角色名称" prop="roleName">
            <el-input v-model="form.roleName" placeholder="请输入角色名称"></el-input>
          </el-form-item>
          <el-form-item label="地址" prop="address">
            <el-input v-model="form.address" placeholder="地址"></el-input>
          </el-form-item>
          <el-form-item label="相关联系人" prop="contact">
            <el-input v-model="form.contact" placeholder="相关联系人"></el-input>
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

import { getStaffList, saveStaff, updateStaff, deleteStaff } from "../../api/member";

export default {
  components: {},

  data() {
    return {
      tableData: [],
      query: {
        page: 1,
        limit: 10,
        name: null,
      },
      form: {},
      multipleSelection: [],
      tableDataLoading: false,
      total: 0,
      addOrUpdateVisible: false,
      rule: {
        name: [{ required: true, message: "员工姓名不得为空", trigger: "blur" }],
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
     * 获取所有员工信息
     */
    getData() {
      getStaffList(this.query).then((res) => {
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
      this.$router.push(`/member/member-details?id=${id}`);
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
            saveStaff(this.form).then((res) => {
              if (res.code === 0) {
                this.$message.success("添加成功");
                this.getData();
                this.addOrUpdateVisible = false;
              }
            });
          } else {
            updateStaff(this.form).then((res) => {
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
    deleteStaff(id) {
      this.$confirm("确定要删除所选择的吗？", "提示", {
        type: "warning",
      })
        .then((action) => {
          if (action === "confirm") {
            deleteStaff(id).then((res) => {
              if (res.code === 1) {
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
      this.query.storeName = null;
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
