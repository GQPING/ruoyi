<template>
  <div class="app-container">
    <!-- 设置父Table列合同规则 -->
    <el-table
      :data="tableData" border
      :span-method="spanMethodOfParent"
      class="myTable" :highlight-current-row="false"
    >
      <el-table-column label="序号" align="center" type="index"></el-table-column>
      <el-table-column label="资源方" align="center" prop="resourceName"></el-table-column>
      <el-table-column label="计划周期" align="center" prop="planCycle"></el-table-column>
      <el-table-column label="输气站场统计" align="center">
        <!-- 在父Table的输气场站单元格中嵌套子Table -->
        <el-table-column label="输气站场" align="center" width="180">
          <template slot-scope="scope">
            <!-- 设置子Table隐藏表头 -->
            <el-table row-key="id"
                      :data="scope.row.tableData"
                      :show-header="false" border :tree-props="{children: 'children', hasChildren: 'hasChildren'}"
            >
              <!-- 子Table中各行列只是容纳在了父Table的输气场站单元格中 -->
              <el-table-column label="输气站场" align="center" prop="id" width="180"></el-table-column>
              <el-table-column label="日指定量" align="center" prop="date" width="180"></el-table-column>
              <el-table-column label="计划备注" align="center" prop="name" width="180"></el-table-column>
              <el-table-column label="日批复量" align="center" prop="address" width="300"></el-table-column>
              <el-table-column label="上报状态" align="center" prop="address" width="300"></el-table-column>
            </el-table>
          </template>
        </el-table-column>
        <!-- 下面父Table中的列，用于父Table表头显示，不用设置prop属性 -->
        <el-table-column label="日指定量" align="center" width="180"></el-table-column>
        <el-table-column label="计划备注" align="center" width="180"></el-table-column>
        <el-table-column label="日批复量" align="center" width="300"></el-table-column>
        <el-table-column label="上报状态" align="center" width="300"></el-table-column>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "intable",
  data() {
    return {
      tableData: [
        {
          planCycle: '2022-10 ~ 2023-02',
          resourceName: '山西恒新天然气销售有限公司',
          tableData: [
            {
              id: 1,
              date: '2016-05-01',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1519 弄',
              children: [{
                id: 2,
                date: '2016-05-01',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1519 弄'
              }, {
                id: 3,
                date: '2016-05-01',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1519 弄'
              }, {
                id: 4,
                date: '2016-05-03',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1516 弄'
              }]
            }],
        },
      ],
    };
  },
  created() {
  },
  methods: {
    // 父Table列合并规则
    spanMethodOfParent({row, column, rowIndex, columnIndex}) {
      // 从父Table的第3列开始，合并之后的5列（包含第3列），将5列合同成一个单元格，容纳子Table
      if (columnIndex === 3) {
        return [1, 5]
      }
      // 隐藏父Table中的第3列到第7列
      if (columnIndex > 3 && columnIndex < 8) {
        return [0, 0]
      }
    },
  }
};
</script>

<style lang="scss" scoped>
::v-deep .myTable table tbody > tr > td:nth-child(4) {
  padding: 0px !important;
  div:first-child {
    padding-left: 0px !important;
    padding-right: 0px !important;
    .el-table--group, .el-table--border{
      border: 0px;
    }
    .el-table--scrollable-x .el-table__body-wrapper{
      overflow-x: hidden;
    }
  }
}
::v-deep .el-table__body tr.hover-row.current-row>td, .el-table__body tr.hover-row.el-table__row--striped.current-row>td, .el-table__body tr.hover-row.el-table__row--striped>td, .el-table__body tr.hover-row>td{
  background-color:transparent !important;
}
</style>
