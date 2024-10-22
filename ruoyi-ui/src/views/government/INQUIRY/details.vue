<template>
  <div class="container">
    <el-dialog
      title="查看地名预审"
      :visible.sync="data.dialogVisible"
      width="50%"
      :before-close="handleClose"
    >
      <div style="margin: 20px">
        <el-row :gutter="20" style="display: flex">
          <el-col :span="17">
            <div class="line flex" style="height: 40px; margin-bottom: 10px">
              <p>提交人：张立强</p>
              <p>提交单位：XXXX单位</p>
              <p>提交时间：2024.6.2 15:37:31</p>
            </div>
            <div class="line" style="padding: 20px">
              <el-row>
                <el-col :span="12"><p>预审地名名称： 万达小区</p></el-col>
                <el-col :span="12"><p>报送单位：XXXX单位</p></el-col>
              </el-row>
              <el-row>
                <el-col :span="12"><p>联系人：周华</p></el-col>
                <el-col :span="12"><p>联系电话：18888888888</p></el-col>
              </el-row>
              <div style="display: flex">
                <p>申请书：</p>
                <div style="display: flex">
                  <p>xxx</p>
                  <p>xxx</p>
                  <p>xxx</p>
                </div>
              </div>
              <div style="display: flex">
                <p>其他附件：</p>
                <div style="display: flex">
                  <p>xxx</p>
                  <p>xxx</p>
                  <p>xxx</p>
                </div>
              </div>
              <div style="display: flex; flex-direction: row">
                <p
                  style="
                    font-weight: bold;
                    display: inline-block;
                    white-space: nowrap;
                  "
                >
                  备注：
                </p>
                <p>
                  地名预审是确保地名命名或更名符合相关规定和标准的重要环节。进行地名预审，旨在避免地名重复、减少歧义，同时确保地名符合当地文化、历史和地理特征。通过预审，可以及时发现并纠正地名命名中可能存在的问题，如名称不恰当、含义不清或可能引起误解等。这不仅有助于维护地名的准确性和规范性，还能更好地服务于社会经济发展，方便人民群众的生产生活。因此，地名预审是地名管理工作不可或缺的一部分，对于提升地名管理水平、促进地名文化保护具有重要意义。
                </p>
              </div>
            </div>
          </el-col>
          <el-col class="line" :span="7" style="max-height: 500px">
            <h4 style="font-weight: 1000">审批流程</h4>
            <div>
              <el-col :span="20" :offset="2">
                <div class="block">
                  <el-timeline>
                    <el-timeline-item
                      v-for="(item, index) in data.flowRecordList"
                      :key="index"
                      :icon="setIcon(item.finishTime)"
                      :color="setColor(item.finishTime)"
                    >
                      <p style="font-weight: 1000">{{ item.taskName }}</p>
                      <span style="font-size:12px">111</span>
                      <span>1111</span>
                      <!-- <el-card :body-style="{ padding: '10px' }">
                        <el-descriptions
                          class="margin-top"
                          :column="1"
                          size="small"
                          border
                        >
                          <el-descriptions-item
                            v-if="item.assigneeName"
                            label-class-name="my-label"
                          >
                            <template slot="label"
                              ><i class="el-icon-user"></i>办理人</template
                            >
                            {{ item.assigneeName }}
                            <el-tag type="info" size="mini">{{
                              item.deptName
                            }}</el-tag>
                          </el-descriptions-item>
                          <el-descriptions-item
                            v-if="item.candidate"
                            label-class-name="my-label"
                          >
                            <template slot="label"
                              ><i class="el-icon-user"></i>候选办理</template
                            >
                            {{ item.candidate }}
                          </el-descriptions-item>
                          <el-descriptions-item label-class-name="my-label">
                            <template slot="label"
                              ><i class="el-icon-date"></i>接收时间</template
                            >
                            {{ item.createTime }}
                          </el-descriptions-item>
                          <el-descriptions-item
                            v-if="item.finishTime"
                            label-class-name="my-label"
                          >
                            <template slot="label"
                              ><i class="el-icon-date"></i>处理时间</template
                            >
                            {{ item.finishTime }}
                          </el-descriptions-item>
                          <el-descriptions-item
                            v-if="item.duration"
                            label-class-name="my-label"
                          >
                            <template slot="label"
                              ><i class="el-icon-time"></i>耗时</template
                            >
                            {{ item.duration }}
                          </el-descriptions-item>
                          <el-descriptions-item
                            v-if="item.comment"
                            label-class-name="my-label"
                          >
                            <template slot="label"
                              ><i class="el-icon-tickets"></i>处理意见</template
                            >
                            {{ item.comment.comment }}
                          </el-descriptions-item>
                        </el-descriptions>
                      </el-card> -->
                    </el-timeline-item>
                  </el-timeline>
                </div>
              </el-col>
              <!-- <el-timeline>
                <el-timeline-item
                  v-for="(activity, index) in activities"
                  :key="index"
                  :icon="activity.icon"
                  :type="activity.type"
                  :color="activity.color"
                  :size="activity.size"
                  :timestamp="activity.timestamp"
                >
                  {{ activity.content }}
                </el-timeline-item>
              </el-timeline> -->
            </div>
          </el-col>
        </el-row>
      </div>

      <span slot="footer" class="dialog-footer">
        <el-button @click="data.dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="data.dialogVisible = false"
          >确 定</el-button
        >
      </span>
    </el-dialog>
  </div>
</template>
<script>
export default {
  props: ["data"],
  data() {
    return {
      flowRecordList: [], // 流程流转数据
      dialogVisible: false,
      activities: [
        {
          content: "支持使用图标",
          timestamp: "2018-04-12 20:46",
          //   size: 'large',
          //   type: 'primary',
          color: "#0bbd87",
          //   icon: 'el-icon-success'
        },
        {
          content: "支持自定义颜色",
          timestamp: "2018-04-03 20:46",
          color: "#0bbd87",
          size: "large",
          icon: "el-icon-circle-check",
        },
        {
          content: "支持自定义尺寸",
          timestamp: "2018-04-03 20:46",
          size: "large",
        },
        {
          content: "默认样式的节点",
          timestamp: "2018-04-03 20:46",
        },
      ],
    };
  },
  created() {
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
    handleClose(done) {
      this.$props.data.dialogVisible = false
      // this.$confirm("确认关闭？")
      //   .then((_) => {
      //     done();
      //   })
      //   .catch((_) => {});
    },
  },
};
</script>
<style scoped>
::v-deep .el-dialog__header {
  border-bottom: 1px solid black;
}
::v-deep .el-dialog__body {
  max-height: 500px;
}
.line {
  border: 1px solid black;
}
.flex {
  display: flex;
  justify-content: space-around;
  align-items: center;
}
p {
  font-size: 13px;
}
</style>
