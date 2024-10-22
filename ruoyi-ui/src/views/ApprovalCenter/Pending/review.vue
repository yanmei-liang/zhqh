<template>
  <div class="container">
    <div style="padding: 20px 0 0 20px">
      <i class="el-icon-arrow-left" style="font-size:20px">业务审批</i>
    </div>
    <el-divider></el-divider>
    <div style="display: flex">
      <div
        style="margin: 0 20px; width: 70%; min-height: 300px; max-height: 80vh"
      >
        <div>
          <p style="font-weight: 800">基本信息</p>
          <el-row style="margin-left: 60px">
            <el-col :span="8" class="flex">
              <span>业务标题：</span>
              <p>地名预审</p>
            </el-col>
            <el-col :span="8" class="flex">
              <span>业务标题：</span>
              <p>地名预审</p>
            </el-col>
            <el-col :span="8" class="flex">
              <span>业务标题：</span>
              <p>地名预审</p>
            </el-col>
            <el-col :span="8" class="flex">
              <span>业务标题：</span>
              <p>地名预审</p>
            </el-col>
            <el-col :span="8" class="flex">
              <span>业务标题：</span>
              <p>地名预审</p>
            </el-col>
            <el-col :span="8" class="flex">
              <span>业务标题：</span>
              <p>地名预审</p>
            </el-col>
          </el-row>
        </div>
        <p style="font-weight: 800">审批信息</p>
        <div style="margin-left: 60px">
          <el-row class="row">
            <el-col :span="6">预审地名名称：</el-col>
            <el-col :span="6">报送单位：</el-col>
            <el-col :span="6">联系人：</el-col>
            <el-col :span="6">联系电话：</el-col>
          </el-row>
          <div class="row" style="display: flex">
            <div style="width: 80px">
              <p style="margin: 0">申 请 书：</p>
            </div>

            <div class="href">
              <div v-for="item in 4" :key="item">
                <a href="">xxxxxxxx</a>
                <i class="el-icon-download"></i>
              </div>
            </div>
          </div>
          <div class="row" style="display: flex">
            <div style="width: 80px">
              <p style="margin: 0">其他附件：</p>
            </div>

            <div class="href">
              <div v-for="item in 4" :key="item">
                <a href="">xxxxxxxx</a>
                <i class="el-icon-download"></i>
              </div>
            </div>
          </div>
          
          <div style="display: flex">
            <p style="white-space: nowrap">备注：</p>
            <p>
              地名预审是确保地名命名或更名符合相关规定和标准的重要环节。
              进行地名预审，旨在避免地名重复、减少歧义，
              同时确保地名符合当地文化、历史和地理特征。
              通过预审，可以及时发现并纠正地名命名中可能存在的问题，
              如名称不恰当、含义不清或可能引起误解等。这不仅有助于维护地名的准确性和规范性，
              还能更好地服务于社会经济发展，方便人民群众的生产生活。因此，地名预审是地名管理工作不可或缺的一部分，
              对于提升地名管理水平、促进地名文化保护具有重要意义。
            </p>
          </div>
        </div>
      </div>
      <div class="approval">
        <h4 style="font-weight: 1000">审批流程</h4>
        <el-row>
          <el-col :span="20" :offset="2">
            <div class="block">
              <el-timeline>
                <el-timeline-item
                  v-for="(item, index) in flowRecordList"
                  :key="index"
                  :icon="setIcon(item.finishTime)"
                  :color="setColor(item.finishTime)"
                >
                  <p style="font-weight: 1000">{{ item.taskName }}</p>
                  <span style="font-size: 12px">111</span>
                  <span>1111</span>
                </el-timeline-item>
              </el-timeline>
            </div>
          </el-col>
        </el-row>
      </div>
    </div>
    <div class="flex footer">
      <div class="btn">
        <el-button type="success">通过</el-button>
        <el-button type="danger">驳回</el-button>
      </div>
    </div>
  </div>
</template>
<script>
import { flowRecord } from "@/api/flowable/finished";
export default {
  props: ["dataList"],
  data() {
    return {
      flowRecordList: null,
    };
  },
  mounted() {
    const params = { procInsId: "55001", deployId: "50001" };
    flowRecord(params)
      .then(
        (res) =>
          // this.dialogData = {
          (this.flowRecordList = res.data.flowList)
        //   dialogVisible: true,
        // deployId: "10041",
        // procInsId: "42501",
        // };
      )
      .catch((res) => {
        this.goBack();
      });
  },
  methods: {
    setIcon(val) {
      if (val) {
        return "el-icon-check";
      } else {
        return "el-icon-time";
      }
    },
    setColor(val) {
      if (val) {
        return "#2bc418";
      } else {
        return "#b3bdbb";
      }
    },
  },
};
</script>
<style scoped lang="scss">
.container {
  margin: 0 20px;
}
.flex {
  display: flex;
  align-items: center;
}
i {
  margin-left: 10px;
  cursor: pointer;
}
.row {
  margin: 20px 0;
}
p {
  //   font-size: 12px;
}
span {
  color: #7f7f7f;
}
.btn {
  width: 100%;
  height: calc(10vh - 10px);
  margin: 10px;
  background-color: #ffffff;
  border-radius: 5px;
  display: flex;
  justify-content: space-around;
  align-items: center;
  .el-button {
    width: 5vw;
    height: 2.5vw;
  }
}
.footer {
  width: 100%;
  height: 10vh;
  margin-top: 2%;
  background-color: rgb(115 106 116 / 46%);
  //   position: absolute;
  //   bottom: 2%;
}
a {
  text-decoration: underline;
}
.href {
  color: rgb(117, 81, 224);
  margin-left: 40px;
  font-size: 20px;
}
.approval {
  width: 30%;
  border: 1px solid black;
  min-height: 300px;
  max-height: 80vh;
}
</style>
