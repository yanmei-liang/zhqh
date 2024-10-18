<template>
  <div class="container">
    <div>
      <el-form :inline="true" :model="formInline" class="demo-form-inline">
        <el-form-item label="审批人">
          <el-input v-model="formInline.user" placeholder="审批人"></el-input>
        </el-form-item>
        <el-form-item label="业务类型">
          <el-select v-model="formInline.region" placeholder="活动区域">
            <el-option label="区域一" value="shanghai"></el-option>
            <el-option label="区域二" value="beijing"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="提交单位">
          <el-select v-model="formInline.region" placeholder="活动区域">
            <el-option label="区域一" value="shanghai"></el-option>
            <el-option label="区域二" value="beijing"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="提交人">
          <el-input v-model="formInline.user" placeholder="审批人"></el-input>
        </el-form-item>
        <el-form-item label="提交时间">
          <el-date-picker
            v-model="formInline.value1"
            type="datetimerange"
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">查询</el-button>
          <el-button type="primary" @click="onSubmit">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div style="padding-bottom: 20px; border-bottom: 1px solid black">
      <el-button type="primary">批量审批</el-button>
    </div>
    <div>
      <Table :tableData="tableData">
        <template>
          <el-table-column fixed="right" label="操作" width="100">
            <el-button type="text" size="small">审批</el-button>
          </el-table-column>
        </template>
      </Table>
    </div>
    <Dialog />
  </div>
</template>
<script>
import Table from "@/components/Table/index.vue";
import Dialog from "./dialog.vue";
export default {
  components: { Table, Dialog },
  data() {
    return {
      formInline: {
        user: "",
        region: "",
        value1:''
      },
      tableData: {
        selection: true,
        data: [
          {
            date: "2016-05-03",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1518 弄",
          },
          {
            date: "2016-05-02",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1518 弄",
          },
          {
            date: "2016-05-04",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1518 弄",
          },
          {
            date: "2016-05-01",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1518 弄",
          },
          {
            date: "2016-05-08",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1518 弄",
          },
          {
            date: "2016-05-06",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1518 弄",
          },
          {
            date: "2016-05-07",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1518 弄",
          },
        ],
        dataLength: 200,
        column: [
          {
            prop: "date",
            label: "日期",
            width: "180",
          },
          {
            prop: "name",
            label: "姓名",
            width: "180",
          },
          {
            prop: "address",
            label: "地址",
            // width: "180",
          },
        ],
      },
    };
  },
  methods: {
    onSubmit() {
      console.log("submit!");
    },
  },
};
</script>
<style scoped lang="scss">
.container {
  margin: 20px 10%;
}
.el-input,
.el-select {
  width: 50%;
}

.el-form-item {
  margin-right: -5%;
  &:nth-last-child(1) {
    margin-left: 6%;
  }
}
</style>
