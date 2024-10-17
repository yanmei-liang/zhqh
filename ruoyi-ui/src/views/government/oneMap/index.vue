<template>
  <div class="container">
    <div class="check-block">
      <el-checkbox-group style="margin-left: 10px" v-model="checkList">
        <el-checkbox label="地名标志"></el-checkbox>
        <el-checkbox label="界限标志"></el-checkbox>
        <el-checkbox label="XXX标志"></el-checkbox>
      </el-checkbox-group>
    </div>
    <div class="_check-block">
      <el-tabs
        v-model="activeName"
        type="card"
        :stretch="true"
        @tab-click="handleClick"
    
      >
        <el-tab-pane label="行政区划" name="first">用户管理</el-tab-pane>
        <el-tab-pane label="大类" name="second"   style="margin: 0 50px;height: 300px;">
          <el-input
            size="mini"
            placeholder="请输入内容"
            v-model="input3"
            class="input-with-select"
          >
            <el-button
              size="mini"
              slot="append"
              icon="el-icon-search"
            ></el-button>
          </el-input>
          <el-tree
            size="mini"
            :data="data"
            show-checkbox
            default-expand-all
            node-key="id"
            ref="tree"
            highlight-current
            :props="defaultProps"
          >
          </el-tree>
        </el-tab-pane>
        <el-tab-pane label="小类" name="third">角色管理</el-tab-pane>
      </el-tabs>
    </div>
    <div id="mapDiv"></div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      checkList: [],
      activeName: "second",
      data: [
        {
          id: 1,
          label: "全部(18)",
          children: [
            {
              id: 4,
              label: "陆地水系（3）",
              children: [
                {
                  id: 9,
                  label: "汉江",
                },
                {
                  id: 10,
                  label: "堵河",
                },
                {
                  id: 11,
                  label: "滔河",
                },
              ],
            },
            {
              id: 5,
              label: "陆地地形（5）",
            },
            {
              id: 6,
              label: "行政区域（9）",
            },
            {
              id: 7,
              label: "非行政区域（1）",
            },
          ],
        },
      ],
      defaultProps: {
        children: "children",
        label: "label",
      },
    };
  },
  mounted() {
    var map;
    var zoom = 12;
    map = new T.Map("mapDiv", {
      projection: "EPSG:4326",
    });
    map.centerAndZoom(new T.LngLat(116.40769, 39.89945), zoom);
  },
};
</script>
<style scoped lang="scss">
#mapDiv {
  width: 100%;
  height: calc(100vh - 84px);
}
.check-block {
  position: absolute;
  left: 20px;
  bottom: 200px;
  width: 100px;
  height: 100px;
  background-color: rgba(215, 215, 215, 1);
  z-index: 99999;
  display: flex;
  align-items: center;
}
._check-block {
  width: 380px;
  min-height:65vh;
  position: absolute;
  top: 50px;
  right: 50px;
  z-index: 99999;
  background-color: #FFFFFF;
}
</style>
