<template>
  <el-card shadow="never" class="aui-card--fill">
    <div class="mod__product">
      <el-form :inline="true" :model="query" @keyup.enter.native="getData()">
        <el-form-item>
          <el-input v-model="query.productName" placeholder="回收物名" clearable></el-input>
        </el-form-item>
        <el-form-item>
        </el-form-item>
        <el-form-item>
        </el-form-item>
        <el-form-item>
          <el-select v-model="query.status" placeholder="请选择状态">
            <el-option key="1" label="未开始" value="1"></el-option>
            <el-option key="2" label="进行中" value="2"></el-option>
            <el-option key="3" label="已结束" value="3"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-input v-model="query.sortName" placeholder="分类名" clearable></el-input>
        </el-form-item>
        <el-form-item>
          <el-input v-model="query.realName" placeholder="姓名" clearable></el-input>
        </el-form-item>
        <el-form-item>
          <el-input v-model="query.employeeName" placeholder="员工2" clearable></el-input>
        </el-form-item>
        <el-form-item>
          <el-input v-model="query.storeName" placeholder="仓库名" clearable></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="getData()">查询</el-button>
          <el-button @click="reset()">重置</el-button>
        </el-form-item>
        <el-form-item v-if="userType === 3">
          <el-button type="primary" @click="addProductInfo">添加</el-button>
        </el-form-item>
        <el-form-item>
          <el-button :disabled="this.multipleSelection.length === 0" type="danger" @click="delBatchProductInfo">批量删除
          </el-button>
        </el-form-item>
      </el-form>
      <el-table v-loading="tableDataLoading" :data="tableData" border @selection-change="selectionChange"
                style="width: 100%;">
        <el-table-column type="selection" header-align="center" align="center" width="50"></el-table-column>
        <el-table-column prop="productName" label="回收物名" header-align="center" align="center"></el-table-column>
        <el-table-column prop="imageUrl" label="图片" header-align="center" align="center">
          <template slot-scope="scope">
            <el-image
                style="width: 60px; height: 60px"
                :src="scope.row.imageUrl"
                :preview-src-list="[scope.row.imageUrl]">
            </el-image>
          </template>
        </el-table-column>
        <el-table-column prop="remark" label="备注信息" header-align="center" align="center"></el-table-column>
        <el-table-column prop="status" label="状态" header-align="center" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.status === 1">未开始</span>
            <span v-if="scope.row.status === 2">进行中</span>
            <span v-if="scope.row.status === 3">已结束</span>
          </template>
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" header-align="center" align="center"></el-table-column>
        <el-table-column prop="realName" label="姓名" header-align="center" align="center"></el-table-column>
        <el-table-column prop="employeeName" label="员工" header-align="center" align="center"></el-table-column>
        <el-table-column prop="sortName" label="分类名" header-align="center" align="center"></el-table-column>
        <el-table-column prop="storeName" label="仓库名" header-align="center" align="center"></el-table-column>
        <el-table-column label="操作" fixed="right" header-align="center" align="center" width="150">
          <template slot-scope="scope">
            <el-button type="success" size="small" @click="updateProductInfo(scope.row)">更新</el-button>
            <el-button type="danger" size="small" @click="delProductInfo(scope.row.id)">删除</el-button>
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
          <el-form-item label="回收物名" prop="productName">
            <el-input v-model="form.productName" placeholder="回收物名"></el-input>
          </el-form-item>
          <el-form-item label="图片" prop="imageUrl">
            <single-upload v-model="form.imageUrl"></single-upload>
          </el-form-item>
          <el-form-item label="备注信息" prop="remark">
            <el-input v-model="form.remark" placeholder="备注信息"></el-input>
          </el-form-item>
          <el-form-item label="状态" prop="status" v-if="userType !==3">
            <el-radio-group v-model="form.status">
              <el-radio :label="1">未开始</el-radio>
              <el-radio :label="2">进行中</el-radio>
              <el-radio :label="3">已结束</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="分类" prop="sortId" v-if="userType ===2">
            <el-select v-model="form.sortId" placeholder="请选择分类">
              <el-option
                  v-for="item in options"
                  :key="item.id"
                  :label="item.sortName"
                  :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="员工" prop="employeeId" v-if="userType === 1">
            <el-select v-model="form.employeeId" placeholder="请选择员工">
              <el-option
                  v-for="item in options2"
                  :key="item.id"
                  :label="item.realName"
                  :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="仓库名" prop="storeId" v-if="userType === 2">
            <el-select v-model="form.storeId" placeholder="请选择仓库名">
              <el-option
                  v-for="item in options3"
                  :key="item.id"
                  :label="item.storeName"
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

import {
  getProductInfo,
  saveProductInfo,
  updateProductInfo,
  delProductInfo,
  delBatchProductInfo
} from '../../api/product'
import {getSortInfo,} from '../../api/sort'
import {getUserInfo,} from '../../api/user'
import {getStoreInfo,} from '../../api/store'
import SingleUpload from '../common/singleUpload';


export default {
  components: {
    SingleUpload
  },

  data() {
    return {
      options: [],
      options2: [],
      options3: [],
      tableData: [],
      query: {
        pageNum: 1,
        pageSize: 10,
        productName: null,
        sortId: null,
        userId: null,
        status: null,
        sortName: null,
        realName: null,
        employeeName: null,
        storeName: null,
      },
      form: {},
      multipleSelection: [],
      tableDataLoading: false,
      total: 0,
      addOrUpdateVisible: false,
      rule: {
        productName: [{required: true, message: '回收物名不得为空', trigger: "blur"}],
        imageUrl: [{required: true, message: '图片不得为空', trigger: "blur"}],
        sortId: [{required: true, message: '分类不得为空', trigger: "blur"}],
        remark: [{required: true, message: '备注信息不得为空', trigger: "blur"}],
        userId: [{required: true, message: '用户不得为空', trigger: "blur"}],
        employeeId: [{required: true, message: '员工不得为空', trigger: "blur"}],
        storeId: [{required: true, message: '仓库名不得为空', trigger: "blur"}],
        status: [{required: true, message: '状态不得为空', trigger: "change"}],
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
     * 获取所有回收物
     */
    getData() {
      if (Number(sessionStorage.getItem('userType')) === 3) {
        this.query.userId = sessionStorage.getItem('userId')
      }
      if (Number(sessionStorage.getItem('userType')) === 2) {
        this.query.employeeId = sessionStorage.getItem('userId')
      }
      getProductInfo(this.query).then(res => {
        this.tableData = res.data.list;
        this.total = res.data.total;
      })
      getSortInfo({pageSize: 100}).then(res => {
        this.options = res.data.list;
      })


      getUserInfo({pageSize: 100, userType: 2}).then(res => {
        this.options2 = res.data.list;
      })

      getStoreInfo({pageSize: 100}).then(res => {
        this.options3 = res.data.list;
      })

    },

    /**
     * 打开添加框
     */
    addProductInfo() {
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
    updateProductInfo(row) {
      this.form = JSON.parse(JSON.stringify(row));
      this.addOrUpdateVisible = true;
    },

    /**
     * 按住enter键或者确定按钮提交数据,对后台发请求
     * 如果id为null,就是走添加回收物的接口
     * 如果id不为null,就是走更新回收物的接口
     */
    formSubmitHandle() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.id === null) {
            this.form.userId = sessionStorage.getItem('userId')
            saveProductInfo(this.form).then(res => {
              if (res.code === 1) {
                this.$message.success('添加成功');
                this.getData();
                this.addOrUpdateVisible = false;
              }
            })
          } else {
            updateProductInfo(this.form).then(res => {
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
    delProductInfo(id) {
      this.$confirm('确定要删除所选择的吗？', '提示', {
        type: 'warning'
      }).then(action => {
        if (action === 'confirm') {
          delProductInfo(id).then(res => {
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
     * 批量删除回收物的接口
     */
    delBatchProductInfo() {
      delBatchProductInfo(this.multipleSelection.join(',')).then(res => {
        this.$message.success('批量删除成功');
        this.getData();
      })
    },

    /**
     * 重置数据
     */
    reset() {
      this.query.productName = null;
      this.query.sortId = null;
      this.query.userId = null;
      this.query.status = null;
      this.query.sortName = null
      this.query.realName = null
      this.query.employeeName = null
      this.query.storeName = null
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
