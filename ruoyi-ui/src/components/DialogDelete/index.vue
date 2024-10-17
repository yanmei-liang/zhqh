<template>
  <el-dialog
    :title="data.title||'删除'"
    :visible.sync="data.dialogVisible"
    style="margin-top: 10%"
    width="25%"
  >
  <div style="text-align: center;margin: 10px 0;">
     <span>{{data.content||'是否确认删除'}}</span>
  </div>
   
    <span slot="footer" class="dialog-footer">
      <el-button  type="danger" @click="data.dialogVisible = false">删 除</el-button>
      <el-button type="info" @click="data.dialogVisible = false">取 消</el-button>
    </span>
  </el-dialog>
</template>
<script>
export default {
    props:['data'],
    data() {
        return {
        }
    },
}
</script>
<style scoped>
.dialog-footer{
    display: flex;
    justify-content: space-around;
}
</style>