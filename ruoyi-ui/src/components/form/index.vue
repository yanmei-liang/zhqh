<template>
  <el-form
    label-position="left"
    :model="model"
    :rules="rules"
    label-width="120px"
  >
 
    <div class="form-top">
      <div class="form-top--left">
        <slot name="left"></slot>
      </div>
      <div class="form-top--right">
        <slot name="right"></slot>
      </div>
    </div>
       <slot></slot>
    <!-- <div class="form-bottom" v-if="slot.bottom">
      <slot name="bottom"></slot>
    </div> -->
  </el-form>
</template>

//
<script setup lang="ts">
// const slot = useSlots();
//
</script>
<script>
export default {
  props: ["rules", "model"],
};
</script>
<style lang="scss" scoped>
.form-top {
  display: flex;
  justify-content: space-between;
  .form-top--left {
    flex: 1;
  }
  .form-top--right {
    flex: 1;
  }
}
.form-bottom {
  display: flex;
  justify-content: flex-end;
}
</style>
