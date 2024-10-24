<template>
  <div style="height: 100%; width: 100%">
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
    >导出</el-button>
  </div>
</template>
<script>
import * as echarts from "echarts";
export default {
  props: ["data"],
  data() {
    return {
      arrYData: [
        120,
        200,
        150,
        80,
        70,
        110,
        130,
        120,
        200,
        150,
        80,
        70,
        110,
        130,
        120,
        200,
        150,
        80,
        70,
        110,
        130,
        120,
        200,
        150,
        80,
        70,
        110,
        130,
        120,
        200,
        150,
        80,
        70,
        110,
        130,
        120,
        200,
        150,
        80,
        70,
        110,
        130,
        120,
        200,
        150,
        80,
        70,
        110,
        130,
        120,
        200,
        150,
        80,
        70,
        110,
        130,
        120,
        200,
        150,
        80,
        70,
        110,
        130,
        120,
        200,
        150,
        80,
        70,
        110,
        130,
        120,
        200,
        150,
        80,
        70,
        110,
        130,
        120,
        200,
        150,
        80,
        70,
        110,
        130
      ],
      arrXData: ["乡", "镇", "街道"]
    };
  },
  created() {
    this.$nextTick(() => {
      this.SetChart("main");
    });
  },
  mounted() {},
  methods: {
    handleExport() {},
    SetChart(value) {
      var _DEPTNUMER = []; //存入所有科室
      var showEchart = true;
      var nameNum = 0;
      if (_DEPTNUMER.length > 0) {
        nameNum = Math.floor(100 / (_DEPTNUMER.length / 3)); //这个3可以顺便调整是用来判断当前视图要显示几个
        if (_DEPTNUMER.length > 3) {
          //3也可以调整用来判断是否显示滚动条
          showEchart = true;
        } else {
          showEchart = true;
        }
      }
      var chartDom = document.getElementById(value);
      var myChart = echarts.init(chartDom);
      var option;
      option = {
        tooltip: {
          trigger: "axis"
        },
        xAxis: {
          type: "category",
          data: this.arrXData,
          axisLabel: {
            interval: 0,
            rotate: -45
          }
        },
        yAxis: {
          type: "value"
        },
        dataZoom: [
          {
            type: "slider",
            realtime: true,
            start: 0,
            end: nameNum, // 数据窗口范围的结束百分比。范围是：0 ~ 100。
            height: 1, //组件高度
            left: 20, //左边的距离
            right: 20, //右边的距离
            bottom: 40, //下边的距离
            show: showEchart, // 是否展示
            fillerColor: "rgba(17, 100, 210, 0.42)", // 滚动条颜色
            borderColor: "rgba(17, 100, 210, 0.12)",
            handleSize: 0, //两边手柄尺寸
            showDetail: false, //拖拽时是否展示滚动条两侧的文字
            zoomLock: true, //是否只平移不缩放
            moveOnMouseMove: false, //鼠标移动能触发数据窗口平移
            //zoomOnMouseWheel: false, //鼠标移动能触发数据窗口缩放
            //下面是自己发现的一个问题，当点击滚动条横向拖拽拉长滚动条时，会出现文字重叠，导致效果很不好，以此用下面四个属性进行设置，当拖拽时，始终保持显示六个柱状图，可结合自己情况进行设置。添加这个属性前后的对比见**图二**
            startValue: 0, // 从头开始。
            endValue: 20, // 最多六个
            minValueSpan: 20, // 放大到最少几个
            maxValueSpan: 10 //  缩小到最多几个
          },
          {
            type: "inside", // 支持内部鼠标滚动平移
            start: 0,
            end: nameNum,
            zoomOnMouseWheel: false, // 关闭滚轮缩放
            moveOnMouseWheel: true, // 开启滚轮平移
            moveOnMouseMove: true // 鼠标移动能触发数据窗口平移
          }
        ],
        series: [
          {
            barWidth: 10,
            barCategoryGap: 10,
            data: this.arrYData,
            type: "bar",
            color: "#409EFF"
          }
        ]
      };
      myChart.setOption(option);
    }
  }
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
