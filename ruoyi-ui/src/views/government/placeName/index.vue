<template>
  <div class="container">
    <div>
      <el-row>
        <el-col :span="11" :offset="1">
          <div id="main" style="width: 600px; height: 400px"></div>
          <el-button
            type="warning"
            icon="el-icon-download"
            size="mini"
            @click="handleExport"
            >导出</el-button
          >
        </el-col>
        <el-col :span="11">
          <div id="main22" style="width: 600px; height: 400px"></div>
          <el-button
            type="warning"
            icon="el-icon-download"
            size="mini"
            @click="handleExport"
            >导出</el-button
          >
        </el-col>
      </el-row>
      <el-row>
        <!-- top-left -->
        <el-col class="block" :span="17" :offset="1">
          <!-- 搜索组 -->
          <el-row class="row">
            <el-col :span="6">
              <span>区划名称</span>
              <el-input
                v-model="input"
                placeholder="请输入内容"
                size="small"
              ></el-input>
            </el-col>

            <el-col :span="7">
              <span>行政级别</span>
              <el-select
                v-model="selectVal"
                size="small"
                clearable
                placeholder="请选择"
              >
                <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                >
                </el-option>
              </el-select>
            </el-col>

            <el-col :span="7">
              <span>更新时间</span>
              <el-date-picker
                size="small"
                v-model="value1"
                type="datetime"
                placeholder="选择日期时间"
              >
              </el-date-picker>
            </el-col>

            <el-col :span="2">
              <el-button type="primary" size="small">查询</el-button>
            </el-col>
            <el-col :span="2">
              <el-button type="primary" size="small">重置</el-button>
            </el-col>
          </el-row>
          <!-- 按钮组 -->
          <div>
            <el-button type="primary">新增</el-button>
            <el-button type="danger">删除</el-button>
            <el-button type="info">导入</el-button>
          </div>
          <el-divider></el-divider>
          <!-- 表格 -->
          <div>
            <!-- <el-table
              size="small"
              ref="multipleTable"
              :data="tableData"
              tooltip-effect="dark"
              style="width: 100%"
            >
              <el-table-column type="selection" width="55"> </el-table-column>
              <el-table-column label="日期" width="120">
                <template slot-scope="scope">{{ scope.row.date }}</template>
              </el-table-column>
              <el-table-column prop="name" label="姓名" width="120">
              </el-table-column>
              <el-table-column
                prop="address"
                label="地址"
                show-overflow-tooltip
              >
              </el-table-column>
            </el-table> -->
            <Table :tableData="tableList" />
          </div>
        </el-col>
        <!-- top-right -->
        <el-col :span="6">
          <el-tabs
            v-model="activeName"
            type="card"
            :stretch="true"
            style="width: 100%"
          >
            <el-tab-pane label="核心属性" name="first">核心属性</el-tab-pane>
            <el-tab-pane label="基本属性" name="second">基本属性</el-tab-pane>
            <el-tab-pane label="相关附件" name="second">相关附件</el-tab-pane>
          </el-tabs>
        </el-col>
      </el-row>
    </div>
  </div>
</template>
<script>
import Table from "@/components/Table/index.vue";
import * as echarts from "echarts";
export default {
  components: { Table },
  data() {
    return {
      input: "",
      selectVal: "",
      tableList: {
        data: [
          {
            date: "2016-05-03",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1518 弄",
          },
          {
            date: "2016-05-02",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1518 弄",
          },
          {
            date: "2016-05-04",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1518 弄",
          },
          {
            date: "2016-05-01",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1518 弄",
          },
          {
            date: "2016-05-08",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1518 弄",
          },
          {
            date: "2016-05-06",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1518 弄",
          },
          {
            date: "2016-05-07",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1518 弄",
          },
        ],
        dataLength: 200,
        column: [
          {
            prop: "date",
            label: "日期",
            width: "180",
          },
          {
            prop: "name",
            label: "姓名",
            width: "180",
          },
          {
            prop: "address",
            label: "地址",
            // width: "180",
          },
        ],
      },

      activeName: "first",
      value1: "",
      options: "",
    };
  },
  mounted() {
    this.SetChart("main");
    this.SetChart("main22");
  },
  methods: {
    SetChart(value) {
      var chartDom = document.getElementById(value);
      var myChart = echarts.init(chartDom);
      var option;
      option = {
        xAxis: {
          type: "category",
          data: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
        },
        yAxis: {
          type: "value",
        },
        series: [
          {
            data: [120, 200, 150, 80, 70, 110, 130],
            type: "bar",
          },
        ],
      };

      myChart.setOption(option);
    },
  },
};
</script>
<style scoped>
.container {
  width: 100%;
}
.el-col {
  /* border: 1px solid black; */
  display: flex;
  align-items: center;
}
span {
  font-size: 12px;
}
.el-input {
  width: 70%;
}
.block {
  display: block;
}
#main {
  width: 100%;
  height: 300px;
}
.el-tabs__nav-scroll {
  width: 100%;
}
.row {
  margin: 20px 0;
}
</style>
