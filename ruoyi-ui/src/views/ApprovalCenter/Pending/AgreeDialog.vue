<template>
  <el-dialog title="审批" :visible.sync="dialogVisible" width="40%">
    <p v-if="dialogData">请输入通过理由</p>
    <p v-else>请输入驳回理由</p>
    <el-input
      type="textarea"
      placeholder="请输入内容"
      v-model="textarea"
      maxlength="300"
      show-word-limit
      style="margin: 20px 0"
    >
    </el-input>
    <div v-if="dialogData">
      <span>便捷应答</span>
      <el-button
        size="mini"
        @click="handleClick('确认通过，允许改地名发布')"
        style="margin-left: 10px"
        >确认通过，允许改地名发布</el-button
      >
      <el-button size="mini" @click="handleClick('允许通过')"
        >允许通过</el-button
      >
      <el-button size="mini" @click="handleClick('同意此方案')"
        >同意此方案</el-button
      >
    </div>
    <div v-else>
      <span>便捷应答</span>
      <el-button
        size="mini"
        @click="handleClick(' 不可通过，地名预审信息有误')"
        style="margin-left: 10px"
      >
        不可通过，地名预审信息有误</el-button
      >
      <el-button size="mini" @click="handleClick('不允许通过')"
        >不允许通过</el-button
      >
      <el-button size="mini" @click="handleClick('不同意此方案')"
        >不同意此方案</el-button
      >
    </div>
    <span slot="footer" class="dialog-footer">
      <el-button @click="dialogVisible = false" style="margin-right: 10%"
        >取 消</el-button
      >
      <el-button
        v-if="dialogData"
        type="success"
        @click="handleSubmit"
        style="margin-left: 10%"
        >确认通过</el-button
      >
      <el-button
        v-else
        type="danger"
        @click="handleSubmit"
        style="margin-left: 10%"
        >确认驳回</el-button
      >
    </span>
  </el-dialog>
</template>
<script>
export default {
  props: ["dialogData", "dialogVisible"],
  data() {
    return {
      dialogVisible: true,
      radio: "1",
      textarea: "",
    };
  },
  methods: {
    handleClick(val) {
      this.textarea = val;
    },
    handleSubmit() {
      this.$message({
        message: "操作成功",
        type: "success",
      });
    },
  },
};
</script>
<style scoped>
::v-deep .el-textarea__inner {
  height: 200px !important;
  font-size: 18px;
  font-weight: 600;
}
p {
  font-weight: 800;
}
.el-button {
  border-radius: 10px;
}
.dialog-footer {
  display: flex;
  justify-content: center;
}
</style>
