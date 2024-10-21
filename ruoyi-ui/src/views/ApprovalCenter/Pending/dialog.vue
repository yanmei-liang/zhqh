<template>
  <el-dialog title="批量审批" :visible.sync="data" width="40%" style="border-radius: 10px;" :before-close="handleClose">
    <p>当前选中 11 条审批项</p>
    <div>
      <span>请选择审批操作：</span>
      <el-radio v-model="radio" label="1" text-color="green">审批通过</el-radio>
      <el-radio v-model="radio" label="0" text-color="red">审批驳回</el-radio>
    </div>
    <el-input
      type="textarea"
      placeholder="请输入内容"
      v-model="textarea"
      maxlength="300"
      show-word-limit
      style="margin: 20px 0"
    >
    </el-input>
    <div>
      <span>便捷应答</span>
      <el-button
        size="mini"
        @click="handleClick('允许通过')"
        style="margin-left: 10px"
        >允许通过</el-button
      >
      <el-button size="mini" @click="handleClick('不允许通过')"
        >不允许通过</el-button
      >
    </div>

    <span slot="footer" class="dialog-footer">
      <el-button @click="handleClose" style="margin-right: 10%"
        >取 消</el-button
      >
      <el-button type="primary" @click="handleSubmit" style="margin-left: 10%"
        >提 交</el-button
      >
    </span>
  </el-dialog>
</template>
<script>
export default {
  props: ["data"],
  data() {
    return {
      dialogVisible: false,
      radio: "1",
      textarea: "",
    };
  },
  computed: {
  },
  methods: {
    handleClose() {
      this.$emit('handleClose')
    },
    handleClick(val) {
      this.textarea = val;
    },
    handleSubmit() {
      this.$emit('handleSubmit')
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
