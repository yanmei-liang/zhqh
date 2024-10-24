<template>
  <div class="container">
    <div>
      <el-row>
        <!-- top-left -->
        <el-col class="block" :span="15" :offset="1">
          <!-- 搜索组 -->
          <el-row class="row">
            <el-col :span="6">
              <span class="text-ident">区划名称</span>
              <el-input
                v-model="formData.administrativeDivisionName"
                placeholder="请输入内容"
                size="mini"
                @keyup.enter.native="handleQuery"
              ></el-input>
            </el-col>

            <el-col :span="7">
              <span class="text-ident">行政级别</span>
              <el-select
                v-model="formData.administrativeLevel"
                size="mini"
                clearable
                placeholder="请选择"
                @change="getList"
              >
                <el-option
                  v-for="item in optionslist"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                ></el-option>
              </el-select>
            </el-col>

            <el-col :span="7">
              <span class="text-ident">更新时间</span>
              <el-date-picker
                size="small"
                v-model="formData.updateTime"
                type="datetime"
                value-format="yyyy-MM-dd HH:mm:ss"
                placeholder="选择日期时间"
                @change="getList"
              ></el-date-picker>
            </el-col>

            <el-col :span="2">
              <el-button type="primary" size="small" @click="handleQuery">查询</el-button>
            </el-col>
            <el-col :span="2">
              <el-button type="primary" size="small" @click="reset">重置</el-button>
            </el-col>
          </el-row>
          <!-- 按钮组 -->
          <div>
            <el-button type="primary" @click="dialogVisible = true">新增</el-button>
            <el-button type="danger" :disabled="!selectList.length" @click="handleAllDelete">删除</el-button>
            <el-button type="info">导入</el-button>
          </div>
          <el-divider></el-divider>
          <!-- 表格 -->
          <div>
            <Table :tableData="tableList" @selection-change="handleSelectionChange">
              <template #selection>
                <el-table-column type="selection" width="55"></el-table-column>
              </template>
              <template>
                <el-table-column label="操作" width="150">
                  <template slot-scope="scope">
                    <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                    <el-button
                      size="mini"
                      type="danger"
                      @click="handleDelete(scope.$index, scope.row)"
                    >删除</el-button>
                  </template>
                </el-table-column>
              </template>
            </Table>
          </div>
        </el-col>
        <!-- top-right -->
        <el-col :span="8">
          <el-tabs v-model="activeName" type="card" :stretch="true" style="width: 100%">
            <el-tab-pane label="核心属性" name="first">
              核心属性
              <img :src="imgUrl" />
            </el-tab-pane>
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
          </div>-->
          <LeftTop :data="LeftTop"></LeftTop>
        </el-col>
        <el-col :span="12" style="position: relative; height: 100%">
          <RightTop :data="RightTop"></RightTop>
        </el-col>
      </el-row>
    </div>
    <el-dialog title="新增行政区划" :visible.sync="dialogVisible" width="60%" :before-close="handleClose">
      <h3 style="color:#000;font-weight:550">核心信息</h3>
      <el-divider></el-divider>
      <Form :model="addFormData" :rules="rules" ref="addDialog">
        <template #left>
          <el-form-item label="行政区划名称:" prop="administrativeDivisionName">
            <el-input v-model="addFormData.administrativeDivisionName" placeholder />
          </el-form-item>
          <el-form-item label="驻地地址:" prop="address">
            <el-input v-model="addFormData.address" placeholder />
          </el-form-item>
          <el-form-item label="邮政编码:" prop="postalCode">
            <el-input v-model="addFormData.postalCode" placeholder />
          </el-form-item>
          <el-form-item label="上一级区划名称:" prop="superiorsName">
            <el-input v-model="addFormData.superiorsName" placeholder />
          </el-form-item>
          <el-form-item label="单位网址:" prop="unitWebsite">
            <el-input v-model="addFormData.unitWebsite" placeholder />
          </el-form-item>
          <!-- <el-form-item label="展示图片:" prop="photo">
            <el-upload
              action="https://jsonplaceholder.typicode.com/posts/"
              list-type="picture-card"
              :on-preview="handlePictureCardPreview"
              :on-remove="handleRemove"
            >
              <i class="el-icon-plus"></i>
            </el-upload>
            <el-dialog :visible.sync="dialogVisible1">
              <img width="100%" :src="dialogImageUrl" alt />
            </el-dialog>
          </el-form-item>-->
        </template>
        <template #right>
          <el-form-item label="行政区划代码:" prop="administrativeDivisionCode">
            <el-input v-model="addFormData.administrativeDivisionCode" placeholder />
          </el-form-item>
          <el-form-item label="面积(km²):" prop="area">
            <el-input v-model="addFormData.area" placeholder />
          </el-form-item>
          <el-form-item label="行政级别:" prop="administrativeLevel">
            <el-input v-model="addFormData.administrativeLevel" placeholder />
          </el-form-item>
          <el-form-item label="上一级区划代码:" prop="superiorsCode">
            <el-input v-model="addFormData.superiorsCode" placeholder />
          </el-form-item>
          <el-form-item label="联系电话:" prop="phoneNum">
            <el-input v-model="addFormData.phoneNum" placeholder />
          </el-form-item>
        </template>
      </Form>
      <h3 style="color:#000;font-weight:600">相关附件</h3>
      <el-divider style="color:#000;"></el-divider>
      <Form :model="addFormData">
        <template #left>
          <el-form-item label="多媒体照片:" prop="attachments">
            <el-upload
              action="https://jsonplaceholder.typicode.com/posts/"
              list-type="picture-card"
              :on-preview="handlePictureCardPreview"
              :on-remove="handleRemove"
            >
              <i class="el-icon-plus"></i>
            </el-upload>
            <el-dialog :visible.sync="dialogVisible1">
              <img width="100%" :src="dialogImageUrl" alt />
            </el-dialog>
          </el-form-item>
          <el-form-item label="原读音:" prop="originalPronunciation">
            <el-upload
              class="upload-demo"
              action="https://jsonplaceholder.typicode.com/posts/"
              :on-preview="handlePreview"
              :on-remove="handleRemove"
              :before-remove="beforeRemove"
              multiple
              :limit="3"
              :on-exceed="handleExceed"
              :file-list="fileList"
            >
              <el-button size="small" type="primary">上传</el-button>
            </el-upload>
          </el-form-item>
        </template>
        <template #right>
          <el-form-item label="多媒体视频:" prop="multimediaVideo">
            <el-upload
              action="https://jsonplaceholder.typicode.com/posts/"
              list-type="picture-card"
              :on-preview="handlePictureCardPreview"
              :on-remove="handleRemove"
            >
              <i class="el-icon-plus"></i>
            </el-upload>
            <el-dialog :visible.sync="dialogVisible1">
              <img width="100%" :src="dialogImageUrl" alt />
            </el-dialog>
          </el-form-item>
          <el-form-item label="其他附件:" prop="otherAccessories">
            <el-upload
              class="upload-demo"
              action="https://jsonplaceholder.typicode.com/posts/"
              :on-preview="handlePreview"
              :on-remove="handleRemove"
              :before-remove="beforeRemove"
              multiple
              :limit="3"
              :on-exceed="handleExceed"
              :file-list="fileList"
            >
              <el-button size="small" type="primary">上传</el-button>
            </el-upload>
          </el-form-item>
        </template>
      </Form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addSubmit">提交</el-button>
        <el-button @click="handleClose">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 新增弹窗 -->
    <!-- <AddDialog :addVisible.sync="addVisible" /> -->
    <DialogDelete :data="dialogData" />
  </div>
</template>
<script>
import LeftTop from "@/components/ManageLayout/LeftTop.vue";
import RightTop from "@/components/ManageLayout/RightTop.vue";
import Table from "@/components/Table/index.vue";
import Form from "@/components/form/index.vue";
import DialogDelete from "@/components/DialogDelete/index.vue";
// import AddDialog from "./components/addDialog.vue";
import * as echarts from "echarts";
import Axios from "axios";
import {
  listDIVISION,
  mapStatistics,
  levelTypes,
  delDIVISION,
  selLevel,
  aelArea,
  optionsList,
  addDivision
} from "@/api/government/DIVISION";
export default {
  components: { Table, Form, DialogDelete, LeftTop, RightTop },
  data() {
    return {
      optionslist: [
        { label: "乡级", value: "乡级" },
        { label: "县级", value: "县级" },
        { label: "市级", value: "市级" }
      ],
      selectList: "",
      ids: "",
      imgUrl:
        "http://api.tianditu.gov.cn/staticimage?center=116.40,39.93&width=400&height=300&zoom=12&layers=vec_c,eva_c&markers=116.39127,39.90712&markerStyles=-1,A,&tk=525ecf8803a6268acc612ba1ae3e3065",
      LeftTop: {
        title: "按级别统计"
      },
      RightTop: {
        title: "按面积统计"
      },
      dialogData: {
        dialogVisible: false
      },
      formData: {
        administrativeDivisionName: "", //行政区划
        administrativeLevel: "", //行政级别
        updateTime: "" //更新时间
      },
      addFormData: {
        address: "",
        administrativeDivisionCode: "",
        administrativeDivisionName: "",
        administrativeLevel: "",
        area: "",
        attachments: "",
        beginDate: "",
        contactNumber: "",
        createBy: "",
        createTime: "",
        endDate: "",
        geographicalpositionMsg: "",
        id: 0,
        multimediaVideo: "",
        originalPronunciation: "",
        otherAccessories: "",
        postalCode: "",
        superiorsCode: "",
        superiorsName: "",
        unitWebsite: ""
      },
      rules: {
        address: {
          required: true,
          message: "请完善",
          trigger: "change"
        },
        administrativeDivisionCode: {
          required: true,
          message: "请完善",
          trigger: "change"
        },
        administrativeDivisionName: {
          required: true,
          message: "请完善",
          trigger: "change"
        },
        administrativeLevel: {
          required: true,
          message: "请完善",
          trigger: "change"
        },
        area: {
          required: true,
          message: "请完善",
          trigger: "change"
        },
        attachments: {
          required: true,
          message: "请完善",
          trigger: "change"
        },
        contactNumber: {
          required: true,
          message: "请完善",
          trigger: "change"
        },
        id: 0,
        postalCode: {
          required: true,
          message: "请完善",
          trigger: "change"
        },
        superiorsCode: {
          required: true,
          message: "请完善",
          trigger: "change"
        },
        superiorsName: {
          required: true,
          message: "请完善",
          trigger: "change"
        }
        // unitWebsite: "www.ss.com",
      },
      dialogVisible: false,
      // addVisible: false,
      mapList: "",
      tableList: {
        data: [],
        dataLength: 200,
        column: [
          {
            prop: "administrativeDivisionName",
            label: "行政区划名称",
            width: "180"
          },
          {
            prop: "administrativeDivisionCode",
            label: "行政区划代码",
            width: "180"
          },
          {
            prop: "address",
            label: "驻地地址"
            // width: "180",
          },
          {
            prop: "area",
            label: "面积（km²）",
            width: "80"
          },
          {
            prop: "postalCode",
            label: "邮政编码"
            // width: "180",
          },
          {
            prop: "administrativeLevel",
            label: "行政级别"
            // width: "180",
          },
          {
            prop: "createTime",
            label: "创建时间"
            // width: "180",
          }
        ]
      },
      activeName: "first",
      value1: "",
      options: "",
      dialogImageUrl: "",
      dialogVisible1: false
    };
  },
  mounted() {
    this.SetChart("main");
    this.SetChart("main22");
    // const m=Axios.get('http://api.tianditu.gov.cn/staticimage?center=116.40,39.93&width=400&height=300&zoom=10&tk=4b6523449387afc9631764aa057b6e97').then((res)=>{
    //   // this.imgUrl=res.data
    //   console.log(res,'测试地图')
    // }
    // );
    const m =
      "http://api.tianditu.gov.cn/staticimage?center=116.40,39.93&width=400&height=300&zoom=10&layers=vec_c,eva_c&tk=525ecf8803a6268acc612ba1ae3e3065";
    Axios.get(m).then(res => {
      // console.log(res);
    });
    // this.getmapList();
  },
  created() {
    this.getList();
    this.getoptionlist();
  },
  methods: {
    // 行政区划列表
    async getList() {
      const {
        code,
        data: { list, total }
      } = await listDIVISION(this.formData);
      console.log(code, "code");
      if (code !== 200) {
        this.tableList.data = [];
      } else {
        this.tableList.data = list;
        this.tableList.dataLength = total;
      }

      // this.tabList.dataLength = total;
      // console.log(list, total, "列表++++++++++++++++++++++");
    },
    // 获取行政级别下拉框
    async getoptionlist() {
      const { data } = await optionsList();
      console.log(data, "行政级别列表");
    },
    // 导出面积统计
    async exportmapList() {
      const res = await mapStatistics();
      console.log(res, "面积统计");
    },
    // // 删除行政区域
    // async delDIVISION() {},
    // 筛选重置按钮
    reset() {
      this.formData = {
        administrativeDivisionName: null, //行政区划
        administrativeLevel: null, //行政级别
        beginDate: null, //开始时间
        endDate: null //结束时间
      };
      this.getList();
    },
    // 搜索按钮
    handleQuery() {
      this.getList();
      this.formData = {};
    },
    handleSelectionChange(val) {
      this.selectList = val;
      // console.log(val);
    },
    handleEdit(index, row) {
      console.log(index, row);
    },
    // 删除行政区域
    handleDelete(index, row) {
      this.$confirm("是否确认删除当前项", "删除确认", {
        confirmButtonText: "删除",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(async () => {
          const res = await delDIVISION(row.id);
          this.$message({
            type: "success",
            message: "删除成功!"
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
      this.getList();
      console.log(this.dialogData);
    },
    // 批量删除
    handleAllDelete() {
      this.ids = this.selectList.map(item => item.id);
      console.log(this.ids, "选中id");
      this.$confirm("是否确定删除已选中的项", "批量删除", {
        confirmButtonText: "删除",
        cancelButtonText: "取消",
        type: "waring"
      })
        .then(async () => {
          const res = await delDIVISION(this.ids);
          this.$message({
            type: "success",
            message: "删除成功!"
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
      this.getList();
    },
    SetChart(value) {
      var chartDom = document.getElementById(value);
      var myChart = echarts.init(chartDom);
      var option;
      option = {
        xAxis: {
          type: "category",
          data: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"]
        },
        yAxis: {
          type: "value"
        },
        series: [
          {
            data: [120, 200, 150, 80, 70, 110, 130],
            type: "bar"
          }
        ]
      };
      myChart.setOption(option);
    },
    //新增
    handAdd() {
      this.dialogVisible = true;
    },
    //文件导出
    handleExport() {},
    // handleClose(done) {
    //   this.$confirm("确认关闭？")
    //     .then(_ => {
    //       done();
    //     })
    //     .catch(_ => {});
    // },
    // 关闭弹窗
    handleClose() {
      this.$confirm("确认关闭？", {
        confirmButtonText: "确认",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.dialogVisible = false;
        })
        .catch(() => {
          this.dialogVisible = true;
        });
    },
    // 确认新增文件
    async addSubmit(addDialog) {
      // if (this.addFormData.some(item => item == "")) {
      //   alert("请填写信息");
      //   return;
      // }
      const res = await addDivision(this.addFormData);
      if (res.code === 200) {
        this.$message({
          message: "添加成功",
          type: "success",
          duration: "2000"
        });
      }
      console.log(res, "新增文件");
      this.dialogVisible = false;
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    }
  }
};
</script>
<style scoped lang="scss">
.dialog-footer {
  display: flex;
  justify-content: center;
  align-items: center;
}
::v-deep {
  .el-dialog {
    .el-dialog__header {
      border-bottom: 1px solid #333;
    }
  }
}
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
.text-ident {
  margin-right: 5px;
}
</style>
