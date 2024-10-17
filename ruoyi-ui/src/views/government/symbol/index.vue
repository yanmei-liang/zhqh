<template>
  <ManageLayout :data="dataList">
    <template #LeftBottom>
      <el-form
        :inline="true"
        :model="formInline"
        class="demo-form-inline"
        size="mini"
      >
        <el-form-item label="标准地名">
          <el-input v-model="formInline.user" placeholder="请输入"></el-input>
        </el-form-item>
        <el-form-item label="设立年限">
          <el-input
            v-model.number="formInline.date"
            placeholder="请输入"
          ></el-input>
        </el-form-item>
        <el-form-item label="数据来源">
          <el-select v-model="formInline.region" placeholder="">
            <el-option label="全部" value="a"></el-option>
            <el-option label="平台录入" value="b"></el-option>
            <el-option label="市级推送" value="c"></el-option>
            <el-option label="县级推送" value="d"></el-option>
            <el-option label="其他" value="e"></el-option>
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
            style="margin-right: 0"
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
        <el-tab-pane label="相关附件" name="second">
          <p>多媒体照片</p>
          <p>多媒体视频</p>
          <p>原读音</p>
          <p>其他附件</p>
        </el-tab-pane>
      </el-tabs>
    </template>
  </ManageLayout>
</template>
<script>
import ManageLayout from "@/components/ManageLayout";
export default {
  components: { ManageLayout },
  data() {
    return {
      formInline: {
        user: "",
        date: "",
        region: "a",
        value1: "",
      },
      dataList: {
        LeftTop: {
          title: "按界线标志类别统计",
          data: [],
        },
        RightTop: {
          title: "按界线标志区划统计",
        },
      },
      activeName:''
    };
  },
};
</script>
<style scoped lang="scss">
.el-input,
.el-input__inner,
.el-select {
  width: 50%;
}
.el-form-item {
  margin-right: -80px;
}
</style>
