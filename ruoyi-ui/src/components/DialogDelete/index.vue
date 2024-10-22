<template>
  <el-dialog
    :title="dataList.title"
    :visible.sync="dataList.dialogVisible"
    style="margin-top: 10%"
    width="25%"
  >
    <div style="text-align: center; margin: 10px 0">
      <span>{{ dataList.content }}</span>
    </div>

    <span slot="footer" class="dialog-footer">
      <el-button type="danger">删 除</el-button>
      <el-button type="info">取 消</el-button>
    </span>
  </el-dialog>
</template>
<script>
export default {
  props: ["data"],
  data() {
    return {
      list: {
        title: "刪除",
        dialogVisible: false,
        content: "是否确认删除",
      },
    };
  },
  computed: {
    dataList() {
      if (!!this.$props.data) {
        return this.$props.data;
      } else {
        return this.list;
      }
    },
    // title() {
    //   if (!!this.$props.data && this.$props.data.title != "") {
    //     return this.$props.data.title;
    //   } else {
    //     return "删除";
    //   }
    // },
    // dialogVisible() {
    //   if (!!this.$props.data && this.$props.data.dialogVisible != "") {
    //     return this.$props.data.dialogVisible;
    //   } else {
    //     return false;
    //   }
    // },
  },
};
</script>
<style scoped>
.dialog-footer {
  display: flex;
  justify-content: space-around;
}
</style>
