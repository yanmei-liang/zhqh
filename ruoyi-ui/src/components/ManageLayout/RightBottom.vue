<template>
<div>
 <slot>
 
  </slot>
</div>
 
</template>
<script>
export default {
  props:["data"],
  data() {
    return {
      activeName: "first",
    };
  },
};
</script>
<style scoped>
.el-tabs__content {
  margin: 20px;
}
</style>
