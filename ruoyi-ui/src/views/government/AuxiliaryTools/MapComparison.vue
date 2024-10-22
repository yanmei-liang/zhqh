<template>
  <div class="container">
    <div class="header" size="medium">
      <el-input placeholder="请输入内容" v-model="input" clearable> </el-input>
      <el-button type="primary">查询</el-button>
    </div>
    <div class="header box">
      <span>操作：</span>
      <el-checkbox-group v-model="checkList">
        <el-checkbox label="查询同步"></el-checkbox>
        <el-checkbox label="比例同步"></el-checkbox>
        <el-checkbox label="描述显示"></el-checkbox>
      </el-checkbox-group>
    </div>

    <el-row :gutter="10">
      <el-col :span="8">
        <div class="col">
          <p>平台地图</p>
          <p style="cursor: pointer">收起</p>
        </div>
        <div id="mapMain"></div>
      </el-col>
      <el-col :span="8">
        <div class="col">
          <p>高德地图</p>
          <p style="cursor: pointer">收起</p>
        </div>
        <div id="mapMain1"></div>
      </el-col>
      <el-col :span="8">
        <div class="col">
          <p>百度地图</p>
          <p style="cursor: pointer">收起</p>
        </div>
        <div id="mapMain2"></div>
      </el-col>
    </el-row>
  </div>
</template>
<script>
export default {
  data() {
    return {
      input: "",
      checkList: ["复选框 A"],
    };
  },
  created() {
    this.$nextTick(() => {
      this.getMap("mapMain");
      this.getMap("mapMain1");
      this.getMap("mapMain2");
    });
  },
  methods: {
    getMap(val) {
      var map;
      var zoom = 12;
      map = new T.Map(val, {
        projection: "EPSG:4326",
      });
      map.centerAndZoom(new T.LngLat(116.40769, 39.89945), zoom);
    },
  },
};
</script>
<style scoped lang="scss">
.container {
  margin: 0 10px;
}
#mapMain,#mapMain1,#mapMain2 {
  width: 100%;
  height: calc(100vh - 260px);
  border-bottom: 1px solid black;
  border-left: 1px solid black;
  border-right: 1px solid black;
}
p {
  color: #ffffff;
  margin: 5px 0;
}
.header {
  display: flex;
  max-width: 50%;
  margin: 10px auto;
}
.box {
  line-height: 40px;
  border: 1px dashed #409eff;

  padding: 10px 0 10px 10px;
  border-radius: 10px;
}
.col {
  display: flex;
  justify-content: space-between;
  background-color: #409eff;
  padding: 0 20px;
  border: 1px solid black;
  border-bottom: #ffffff;
}
</style>
