<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="账单日期，yyyy-MM-dd" prop="date">
        <el-input
          v-model="queryParams.date"
          placeholder="请输入账单日期，yyyy-MM-dd"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="账单金额，2位小数" prop="money">
        <el-input
          v-model="queryParams.money"
          placeholder="请输入账单金额，2位小数"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="账单类型，01:：收入，02：支出" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择账单类型，01:：收入，02：支出" clearable size="small">
          <el-option
            v-for="dict in dict.type.BillType"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="支付方式，01：微信，02：支付宝，03：银行卡，04：现金" prop="payWay">
        <el-input
          v-model="queryParams.payWay"
          placeholder="请输入支付方式，01：微信，02：支付宝，03：银行卡，04：现金"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="支付类型，01：电费，02：水费，03：房租，04：通讯费，05：蔬果费，06：电影费，07：交通费，08：早餐费，09：午餐费，10：晚餐费，11：零食费，12：衣服鞋帽，13：外卖费，14：其它杂费" prop="payType">
        <el-select v-model="queryParams.payType" placeholder="请选择支付类型，01：电费，02：水费，03：房租，04：通讯费，05：蔬果费，06：电影费，07：交通费，08：早餐费，09：午餐费，10：晚餐费，11：零食费，12：衣服鞋帽，13：外卖费，14：其它杂费" clearable size="small">
          <el-option
            v-for="dict in dict.type.PayType"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="所属用户" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入所属用户"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建时间" prop="createdTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.createdTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择创建时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['local:day:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['local:day:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['local:day:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['local:day:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="dayList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="账单日期，yyyy-MM-dd" align="center" prop="date" />
      <el-table-column label="账单金额，2位小数" align="center" prop="money" />
      <el-table-column label="账单类型，01:：收入，02：支出" align="center" prop="type">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.BillType" :value="scope.row.type"/>
        </template>
      </el-table-column>
      <el-table-column label="支付方式，01：微信，02：支付宝，03：银行卡，04：现金" align="center" prop="payWay">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.PayWay" :value="scope.row.payWay"/>
        </template>
      </el-table-column>
      <el-table-column label="支付类型，01：电费，02：水费，03：房租，04：通讯费，05：蔬果费，06：电影费，07：交通费，08：早餐费，09：午餐费，10：晚餐费，11：零食费，12：衣服鞋帽，13：外卖费，14：其它杂费" align="center" prop="payType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.PayType" :value="scope.row.payType"/>
        </template>
      </el-table-column>
      <el-table-column label="账单描述" align="center" prop="details" />
      <el-table-column label="所属用户" align="center" prop="userId" />
      <el-table-column label="创建时间" align="center" prop="createdTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createdTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['local:day:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['local:day:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改日度账单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="账单日期，yyyy-MM-dd" prop="date">
          <el-input v-model="form.date" placeholder="请输入账单日期，yyyy-MM-dd" />
        </el-form-item>
        <el-form-item label="账单金额，2位小数" prop="money">
          <el-input v-model="form.money" placeholder="请输入账单金额，2位小数" />
        </el-form-item>
        <el-form-item label="账单类型，01:：收入，02：支出" prop="type">
          <el-select v-model="form.type" placeholder="请选择账单类型，01:：收入，02：支出">
            <el-option
              v-for="dict in dict.type.BillType"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="支付方式，01：微信，02：支付宝，03：银行卡，04：现金" prop="payWay">
          <el-input v-model="form.payWay" placeholder="请输入支付方式，01：微信，02：支付宝，03：银行卡，04：现金" />
        </el-form-item>
        <el-form-item label="支付类型，01：电费，02：水费，03：房租，04：通讯费，05：蔬果费，06：电影费，07：交通费，08：早餐费，09：午餐费，10：晚餐费，11：零食费，12：衣服鞋帽，13：外卖费，14：其它杂费" prop="payType">
          <el-select v-model="form.payType" placeholder="请选择支付类型，01：电费，02：水费，03：房租，04：通讯费，05：蔬果费，06：电影费，07：交通费，08：早餐费，09：午餐费，10：晚餐费，11：零食费，12：衣服鞋帽，13：外卖费，14：其它杂费">
            <el-option
              v-for="dict in dict.type.PayType"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="账单描述" prop="details">
          <el-input v-model="form.details" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="所属用户" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入所属用户" />
        </el-form-item>
        <el-form-item label="创建时间" prop="createdTime">
          <el-date-picker clearable size="small"
            v-model="form.createdTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择创建时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listDay, getDay, delDay, addDay, updateDay } from "@/api/local/day";

export default {
  name: "Day",
  dicts: ['PayType', 'BillType'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 日度账单表格数据
      dayList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        date: null,
        money: null,
        type: null,
        payWay: null,
        payType: null,
        details: null,
        userId: null,
        createdTime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询日度账单列表 */
    getList() {
      this.loading = true;
      listDay(this.queryParams).then(response => {
        this.dayList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        date: null,
        money: null,
        type: null,
        payWay: null,
        payType: null,
        details: null,
        userId: null,
        createdTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加日度账单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getDay(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改日度账单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateDay(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDay(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除日度账单编号为"' + ids + '"的数据项？').then(function() {
        return delDay(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('local/day/export', {
        ...this.queryParams
      }, `day_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
