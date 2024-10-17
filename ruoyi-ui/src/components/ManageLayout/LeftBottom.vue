<template>
  <div>
    <slot></slot>
    <!-- 按钮组 -->
    <div style="margin-left: 20px">
      <el-button type="primary" @click="handleAdd">新增</el-button>
      <el-button type="danger" @click="handleAllDelete">删除</el-button>
      <el-button type="info">导入</el-button>
    </div>
    <el-divider></el-divider>
    <!-- 表格 -->
    <div>
      <Table :tableData="tableList" :dialogData="dialogData">
        <template>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button
                size="mini"
                @click="handleEdit(scope.$index, scope.row)"
                >编辑</el-button
              >
              <el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.$index, scope.row)"
                >删除</el-button
              >
            </template>
          </el-table-column>
        </template>
      </Table>
    </div>
  </div>
</template>
<script>
import Table from "@/components/Table/index.vue";
export default {
  components: { Table },
  props:["data"],
  
  data() {
    return {
      dialogData: {
        dialogVisible: false,
      },
      tableList: {
        selection:true,
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
    handleAdd(){
      this.$emit('handleAdd','')
    },
    handleDelete(index, row) {
      this.dialogData = {
        title: "删除确认",
        content: "是否确认删除当前项？",
        dialogVisible: true,
      };
    },
    handleAllDelete(){
       this.dialogData = {
        title: "批量删除",
        content: "是否确认删除已选中项？",
        dialogVisible: true,
      };
    }
  },
};
</script>
