<template>
  <div class="container">
    <el-row class="row">
      <el-col :span="12" style="position: relative">
        <LeftTop :data="data.LeftTop || null">
          <template>
            <slot name="LeftBottom"></slot>
          </template>
        </LeftTop>
      </el-col>
      <el-col :span="12" style="position: relative">
        <RightTop  :data="data.RightTop || null">
          <template>
            <slot name="LeftBottom"></slot>
          </template>
        </RightTop>
      </el-col>
    </el-row>
    <el-row :gutter="20" class="flex" style="justify-content: space-between">
      <el-col class="block" :span="16" style="margin-right: 10px">
        <LeftBottom @handleAdd="handleAdd"   :data="data.LeftBottom || null">
          <template>
            <slot name="LeftBottom"></slot>
          </template>
        </LeftBottom>
      </el-col>
      <el-col :span="8" class="block">
        <RightBottom  :data="data.RightBottom || null">
          <template>
            <slot name="RightBottom"></slot>
          </template>
        </RightBottom>
      </el-col>
    </el-row>
  </div>
</template>
<script>
import LeftTop from "./LeftTop.vue";
import RightTop from "./RightTop.vue";
import LeftBottom from "./LeftBottom.vue";
import RightBottom from "./RightBottom.vue";
export default {
  components: { LeftTop, RightTop, LeftBottom, RightBottom },
  props:["data"],
  data() {
    return {};
  },
  mounted() {
    console.log(this.$props)
  },
  methods: {
    handleAdd(){
      this.$emit('handleAdd')
    }
  },
};
</script>
<style scoped lang="scss">
.btn_chart {
  position: absolute;
  right: 10px;
  top: 10px;
}
.container {
  margin: 20px;
  height: 100%;
  .row {
    background-color: rgb(242, 242, 242);
    height: 300px;
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-bottom: 10px;
    .el-col {
      height: 95%;
      width: 49%;
      background-color: #ffffff;
    }
  }
}
.flex {
  display: flex;
  align-items: center;
}

.block {
  height: 600px;
  border: 1px solid #dcdfe6;
  border-radius: 10px;
  padding: 20px;
}
</style>
