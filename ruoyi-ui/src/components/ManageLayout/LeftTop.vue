<template>
  <div style="height: 100%">
    <div class="flex">
      <div class="line"></div>
      <p>{{ data.title || "标题" }}</p>
    </div>
    <div id="main"></div>
    <el-button
      class="btn_chart"
      type="warning"
      icon="el-icon-download"
      size="mini"
      @click="handleExport"
      >导出</el-button
    >
  </div>
</template>
<script>
import * as echarts from "echarts";
export default {
  props: ["data"],
  data() {
    return {};
  },
  mounted() {
    this.SetChart("main");
  },
  methods: {
    handleExport() {},
    SetChart(value) {
      var chartDom = document.getElementById(value);
      var myChart = echarts.init(chartDom);
      var option;
      option = {
        xAxis: {
          type: "category",
          data: [
            "Mon",
            "Tue",
            "Wed",
            "Thu",
            "Fri",
            "Sat",
            "Sun",
            "Mon",
            "Tue",
            "Wed",
            "Thu",
            "Fri",
            "Sat",
            "Sun",
          ],
        },
        yAxis: {
          type: "value",
        },
        series: [
          {
            data: [
              120, 200, 150, 80, 70, 110, 130, 120, 200, 150, 80, 70, 110, 130,
            ],
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
.flex {
  display: flex;
  align-items: center;
}
#main {
  width: 100%;
  height: 95%;
  margin: 0 auto;
}
.line {
  width: 5px;
  height: 20px;
  background-color: blue;
  margin: 0 10px;
}
.btn_chart {
  position: absolute;
  right: 10px;
  top: 10px;
}
</style>
