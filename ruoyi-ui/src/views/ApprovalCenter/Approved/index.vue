<template>
  <div>
    <Review :dataList="dataList" />
    <AgreeDialog :dialogData="false" :dialogVisible="false"/>
  </div>
</template>
<script>
import Review from "../Pending/review.vue";
import AgreeDialog from "../Pending/AgreeDialog.vue";
export default {
  components: { Review ,AgreeDialog},
  data() {
    return {
      dataList: [
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
};
</script>
