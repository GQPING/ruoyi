<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="账单年份" prop="year">
        <el-date-picker clearable size="small"
          v-model="queryParams.year"
          type="year"
          format="yyyy"
          value-format="yyyy"
          placeholder="选择账单年份"
          :picker-options="pickerOptions_expireTime">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="账单类型" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择账单类型" clearable size="small">
          <el-option
            v-for="dict in dict.type.BillType"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['local:year:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['local:year:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="yearList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <af-table-column
        label="序号"
        type="index"
        align="center"
      >
        <template slot-scope="scope">
          <span>{{ (queryParams.pageNum-1) * queryParams.pageSize + scope.$index +1 }}</span>
        </template>
      </af-table-column>
      <el-table-column label="账单年份" align="center" prop="year" width="80">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.year, '{y}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="账单金额" align="center" prop="money" />
      <el-table-column label="账单类型" align="center" prop="type" width="80">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.BillType" :value="scope.row.type"/>
        </template>
      </el-table-column>
      <el-table-column label="所属用户" align="center" prop="userId" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="182">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="130" fixed="right" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['local:year:remove']"
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
  </div>
</template>

<script>
import { listYear, getYear, delYear, addYear, updateYear } from "@/api/local/year";

export default {
  name: "Year",
  dicts: ['BillType'],
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
      // 年度账单表格数据
      yearList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        year: null,
        type: null,
        userId: null,
      },
      //设置不可选择未来日期
      pickerOptions_expireTime:{
        disabledDate:(time) => {
          return time.getTime() > Date.now();
        }
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询年度账单列表 */
    getList() {
      this.loading = true;
      listYear(this.queryParams).then(response => {
        this.yearList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
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
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除年度账单编号为"' + ids + '"的数据项？').then(function() {
        return delYear(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('local/year/export', {
        ...this.queryParams
      }, `year_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
