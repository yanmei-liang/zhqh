<template>
  <div class="container">
    <el-dialog
      title="查看地名预审"
      :visible.sync="dialogVisible"
      width="50%"
      style="margin-top: 15vh"
      :before-close="handleClose"
    >
      <div style="margin: 20px">
        <el-row :gutter="20" style="display:flex">
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
          <el-col class="line" :span="7" style="max-height:500px">
            <h4 style="font-weight: 1000">审批流程</h4>
            <div>
              <el-timeline>
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
              </el-timeline>
            </div>
          </el-col>
        </el-row>
      </div>

      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogVisible = false"
          >确 定</el-button
        >
      </span>
    </el-dialog>
  </div>
</template>
<script>
export default {
  data() {
    return {
      dialogVisible: true,
      activities: [{
          content: '支持使用图标',
          timestamp: '2018-04-12 20:46',
        //   size: 'large',
        //   type: 'primary',
         color: '#0bbd87',
        //   icon: 'el-icon-success'
        }, {
          content: '支持自定义颜色',
          timestamp: '2018-04-03 20:46',
          color: '#0bbd87',
          size: 'large',
          icon: 'el-icon-circle-check'
        }, {
          content: '支持自定义尺寸',
          timestamp: '2018-04-03 20:46',
          size: 'large'
        }, {
          content: '默认样式的节点',
          timestamp: '2018-04-03 20:46'
        }]
    };
  },
  methods: {
    handleClose(done) {
      this.$confirm("确认关闭？")
        .then((_) => {
          done();
        })
        .catch((_) => {});
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
