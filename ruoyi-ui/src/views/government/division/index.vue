<template>
  <div class="container">
    <div>
      <el-row>
        <!-- top-left -->
        <el-col class="block" :span="15" :offset="1">
          <!-- 搜索组 -->
          <el-row class="row">
            <el-col :span="6">
              <span>区划名称</span>
              <el-input
                v-model="input"
                placeholder="请输入内容"
                size="small"
              ></el-input>
            </el-col>

            <el-col :span="7">
              <span>行政级别</span>
              <el-select
                v-model="selectVal"
                size="small"
                clearable
                placeholder="请选择"
              >
                <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                >
                </el-option>
              </el-select>
            </el-col>

            <el-col :span="7">
              <span>更新时间</span>
              <el-date-picker
                size="small"
                v-model="value1"
                type="datetime"
                placeholder="选择日期时间"
              >
              </el-date-picker>
            </el-col>

            <el-col :span="2">
              <el-button type="primary" size="small">查询</el-button>
            </el-col>
            <el-col :span="2">
              <el-button type="primary" size="small">重置</el-button>
            </el-col>
          </el-row>
          <!-- 按钮组 -->
          <div>
            <el-button type="primary" @click="dialogVisible = true"
              >新增</el-button
            >
            <el-button type="danger" @click="handleAllDelete">删除</el-button>
            <el-button type="info">导入</el-button>
          </div>
          <el-divider></el-divider>
          <!-- 表格 -->
          <div>
            <Table
              :tableData="tableList"
              @selection-change="handleSelectionChange"
            >
              <template #selection>
                <el-table-column type="selection" width="55"> </el-table-column>
              </template>
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
        </el-col>
        <!-- top-right -->
        <el-col :span="8">
          <el-tabs
            v-model="activeName"
            type="card"
            :stretch="true"
            style="width: 100%"
          >
            <el-tab-pane label="核心属性" name="first">核心属性</el-tab-pane>
            <el-tab-pane label="相关附件" name="second">相关附件</el-tab-pane>
          </el-tabs>
        </el-col>
      </el-row>
      <el-row style="height: 300px;margin-top:20px">
        <el-col :span="12" style="position: relative; height: 100%">
          <!-- <div style="height: 100%;width:100%">
            <div class="flex">
              <div class="line"></div>
              <p>按级别统计</p>
            </div>
            <div id="main"></div>
            <el-button
              class="btn_chart"
              type="warning"
              icon="el-icon-download"
              size="mini"
              @click="handleExport"
              >导出</el-button
            >
          </div> -->
          <LeftTop :data="LeftTop">
            
          </LeftTop>
        </el-col>
        <el-col :span="12" style="position: relative; height: 100%">
         <RightTop :data="RightTop"></RightTop>
        </el-col>
      </el-row>
    </div>
    <el-dialog
      title="提示"
      :visible.sync="dialogVisible"
      width="60%"
      :before-close="handleClose"
    >
      <p>核心信息</p>
      <el-divider></el-divider>
      <Form :model="formData" :rules="rules">
        <template #left>
          <el-form-item label="行政区划名称:" prop="name">
            <el-input v-model="formData.name" placeholder="" />
          </el-form-item>
          <el-form-item label="驻地地址:" prop="address">
            <el-input v-model="formData.address" placeholder="" />
          </el-form-item>
          <el-form-item label="邮政编码:" prop="code">
            <el-input v-model="formData.code" placeholder="" />
          </el-form-item>
          <el-form-item label="上一级区划名称:" prop="previous">
            <el-input v-model="formData.previous" placeholder="" />
          </el-form-item>
          <el-form-item label="单位网址:" prop="unit">
            <el-input v-model="formData.unit" placeholder="" />
          </el-form-item>
          <el-form-item label="展示图片:" prop="photo">
            <el-upload
              action="https://jsonplaceholder.typicode.com/posts/"
              list-type="picture-card"
              :on-preview="handlePictureCardPreview"
              :on-remove="handleRemove"
            >
              <i class="el-icon-plus"></i>
            </el-upload>
            <el-dialog :visible.sync="dialogVisible1">
              <img width="100%" :src="dialogImageUrl" alt="" />
            </el-dialog>
          </el-form-item>
        </template>
        <template #right>
          <el-form-item label="行政区划代码:" prop="nameNum">
            <el-input v-model="formData.nameNum" placeholder="" />
          </el-form-item>
          <el-form-item label="面积(km²):" prop="area">
            <el-input v-model="formData.area" placeholder="" />
          </el-form-item>
          <el-form-item label="面积(km²):" prop="administrative">
            <el-input v-model="formData.administrative" placeholder="" />
          </el-form-item>
          <el-form-item label="上一级区划代码:" prop="previousNum">
            <el-input v-model="formData.area" placeholder="" />
          </el-form-item>
          <el-form-item label="联系电话:" prop="phoneNum">
            <el-input v-model="formData.phoneNum" placeholder="" />
          </el-form-item>
        </template>
      </Form>
      <p>相关附件</p>
      <el-divider></el-divider>
    </el-dialog>
    <DialogDelete :data="dialogData" />
  </div>
</template>
<script>
import LeftTop from "@/components/ManageLayout/LeftTop.vue"
import RightTop from "@/components/ManageLayout/RightTop.vue"
import Table from "@/components/Table/index.vue";
import Form from "@/components/form/index.vue";
import DialogDelete from "@/components/DialogDelete/index.vue";
import * as echarts from "echarts";
export default {
  components: { Table, Form, DialogDelete ,LeftTop,RightTop},
  data() {
    return {
      LeftTop:{
        title:'按级别统计'
      },
      RightTop:{
        title:'按面积统计'
      },
      dialogData: {
        dialogVisible: false,
      },
      formData: {
        name: "",
        nameNum: "",
        address: "",
        code: "",
        previous: "",
        area: "",
        previousNum: "",
        administrative: "",
        unit: "",
        phoneNum: "",
        photo: "",
      },
      rules: {
        name: [
          { required: true, message: "请输入活动名称", trigger: "blur" },
          { min: 3, max: 5, message: "长度在 3 到 5 个字符", trigger: "blur" },
        ],
      },
      dialogVisible: false,
      input: "",
      selectVal: "",
      tableList: {
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
      activeName: "first",
      value1: "",
      options: "",
      dialogImageUrl: "",
      dialogVisible1: false,
    };
  },
  mounted() {
    this.SetChart("main");
    this.SetChart("main22");
  },
  methods: {
    handleSelectionChange(val) {
      console.log(val);
    },
    handleEdit(index, row) {
      console.log(index, row);
    },
    handleDelete(index, row) {
      this.dialogData = {
        title: "删除确认",
        content: "是否确认删除当前项？",
        dialogVisible: true,
      };
      console.log(this.dialogData);
    },
    handleAllDelete() {
      this.dialogData = {
        title: "批量删除",
        content: "是否确认删除已选中项？",
        dialogVisible: true,
      };
    },
    SetChart(value) {
      var chartDom = document.getElementById(value);
      var myChart = echarts.init(chartDom);
      var option;
      option = {
        xAxis: {
          type: "category",
          data: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
        },
        yAxis: {
          type: "value",
        },
        series: [
          {
            data: [120, 200, 150, 80, 70, 110, 130],
            type: "bar",
          },
        ],
      };

      myChart.setOption(option);
    },
    //新增
    handAdd() {
      this.dialogVisible = true;
    },
    //文件导出
    handleExport() {},
    handleClose(done) {
      this.$confirm("确认关闭？")
        .then((_) => {
          done();
        })
        .catch((_) => {});
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
  },
};
</script>
<style scoped>
.btn_chart {
  position: absolute;
  right: 10px;
  top: 10px;
}
.container {
  width: 100%;
}
.el-col {
  /* border: 1px solid black; */
  display: flex;
  align-items: center;
}
span {
  font-size: 12px;
}
.el-input {
  width: 70%;
}
.block {
  display: block;
}
#main,
#main22 {
  width: 100%;
  height: 95%;
  margin: 0 auto;
}
.el-tabs__nav-scroll {
  width: 100%;
}
.row {
  margin: 20px 0;
}
.el-tabs__item.is-active {
  color: #ffffff;
  background-color: rgba(22, 31, 112, 1);
}
.flex {
  display: flex;
  align-items: center;
}
.line {
  width: 5px;
  height: 20px;
  background-color: blue;
  margin: 0 10px;
}
</style>
