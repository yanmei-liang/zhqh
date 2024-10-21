<template>
  <div class="container">
    <el-dialog
      :title="dialog.title || '标题'"
      :visible.sync="dialog.dialogVisible"
      width="30%"
    >
      <span>{{dialog.content}}</span>
      <span slot="footer" class="dialog-footer" v-if="!dialog.footer">
        <el-button @click="dialog.dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialog.dialogVisible = false"
          >确 定</el-button
        >
      </span>
      <slot slot="footer" name="footer"></slot>
    </el-dialog>
  </div>
</template>
<script>
export default {
  props: ["dialog"],
  computed: {},
  data() {
    return {};
  },
};
</script>
<style scoped>
.el-dialog__wrapper {
  top: 50%;
  transform: translate(0, -50%);
}
::v-deep .el-dialog__footer,
::v-deep .el-dialog__body {
  display: flex;
  justify-content: center;
}
</style>
