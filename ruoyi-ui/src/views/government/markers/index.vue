<template>
  <div class="container">
    <ManageLayout :data="dataList">
      <template #LeftBottom>
        <el-form
        style="width:95%"
          :inline="true"
          :model="formInline"
          class="demo-form-inline"
          size="mini"
        >
          <el-form-item label="界桩编号">
            <el-input v-model="formInline.user" placeholder="请输入"></el-input>
          </el-form-item>
          <el-form-item label="界线代码">
            <el-input
              v-model="formInline.user1"
              placeholder="请输入"
            ></el-input>
          </el-form-item>
          <el-form-item label="界线等级">
            <el-select v-model="formInline.region" placeholder="">
              <el-option label="全部" value="a"></el-option>
              <el-option label="企业" value="b"></el-option>
              <el-option label="旅游景点" value="c"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="数据类型">
            <el-select v-model="formInline.setDate" placeholder="">
              <el-option label="全部" value="a"></el-option>
              <el-option label="现今地名" value="b"></el-option>
              <el-option label="历史地名" value="b"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="更新时间">
            <el-date-picker
              size="mini"
              v-model="formInline.value1"
              type="datetimerange"
              range-separator="至"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
            >
            </el-date-picker>
          </el-form-item>
          <el-form-item>
            <el-button type="primary">查询</el-button>
            <el-button>重置</el-button>
          </el-form-item>
        </el-form>
      </template>
      <template #RightBottom>
        <el-tabs
          v-model="activeName"
          type="card"
          :stretch="true"
          style="width: 100%"
        >
          <el-tab-pane label="核心属性" name="first">
            <p>标志代码：4203021002351300003202</p>
            <p>地名代码：42030211300003202</p>
            <p>标准地名：中心街</p>
            <p>罗马字母拼写：Zhōngxīn Jiē</p>
            <p>行政区划：十堰市/张湾区</p>
            <p>设置单位：十堰市张湾区民政局</p>
            <p>设立年份 ：2023</p>
            <p>东经：38517094.4549</p>
            <p>北纬：31.8000673</p>
            <p>生产厂家：河南省项城市中浩电力设备有限公司</p>
            <p>规格：1350mm*450*300mm</p>
            <p>所在（跨）行政区：</p>
            <p>是否可公开：是</p>
          </el-tab-pane>
          <el-tab-pane label="基本属性">
            <p>界桩颗数：2</p>
            <p>单立柱颗数：1</p>
            <p>双立柱颗数：1</p>
            <p>三立柱颗数：1</p>
            <p>其他</p>
          </el-tab-pane>
          <el-tab-pane label="相关附件" name="second">
            <p>多媒体照片</p>
            <p>多媒体视频</p>
            <p>原读音</p>
            <p>其他附件</p>
          </el-tab-pane>
        </el-tabs>
      </template>
    </ManageLayout>
  </div>
</template>
<script>
import ManageLayout from "@/components/ManageLayout";
export default {
  components: { ManageLayout },
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
            r:'11111'
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
      formInline: {
        user: "",
        user1: "",
        date: "",
        region: "a",
        value1: "",
        setDate: "",
      },
      activeName: "first",
      value1: "",
      options: "",
      dataList: {
        LeftTop: {
          title: "按界线标志类别统计",
          data: [],
        },
        RightTop: {
          title: "按界线标志区划统计",
        },
      },
    };
  },
  mounted() {
    // this.SetChart("main");
    // this.SetChart("main22");
  },
  methods: {
    // SetChart(value) {
    //   var chartDom = document.getElementById(value);
    //   var myChart = echarts.init(chartDom);
    //   var option;
    //   option = {
    //     xAxis: {
    //       type: "category",
    //       data: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
    //     },
    //     yAxis: {
    //       type: "value",
    //     },
    //     series: [
    //       {
    //         data: [120, 200, 150, 80, 70, 110, 130],
    //         type: "bar",
    //       },
    //     ],
    //   };
    //   myChart.setOption(option);
    // },
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
.el-input,
.el-input__inner,
.el-select {
  width: 50%;
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
.el-form-item {
  margin-right: -80px;
}
</style>
