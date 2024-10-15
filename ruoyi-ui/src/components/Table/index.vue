<template>
  <div>
    <el-table :data="tableData.data || ''" style="width: 100%">
      <el-table-column
        v-for="item in tableData.column"
        :key="item.prop"
        :prop="item.prop"
        :label="item.label"
        :width="item.width"
      >
      </el-table-column>
      <slot></slot>
    </el-table>
    <Pagination :total="tableData.dataLength" />
  </div>
</template>
<script>
import Pagination from "@/components/Pagination/index.vue";
export default {
  components: { Pagination },
  props: ["tableData"],
  data() {
    return {};
  },
  mounted() {
    console.log(this.$props);
  },
  methods: {},
};
</script>
