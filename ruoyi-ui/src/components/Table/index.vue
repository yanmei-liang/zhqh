<template>
  <div>
    <el-table
      :data="tableData.data || ''"
      style="width: 100%"
      size="mini"
      v-loading="false"
      @row-click="handRowClick"
      @selection-change="handSelect"
    >
      <slot name="selection"></slot>
      <el-table-column type="selection" width="55" v-if="tableData.selection || false"></el-table-column>
      <el-table-column label="序号"></el-table-column>
      <el-table-column
        v-for="item in tableData.column"
        :key="item.prop"
        :prop="item.prop"
        :label="item.label"
        :width="item.width"
      ></el-table-column>
      <slot></slot>
    </el-table>
    <Pagination :total="tableData.data.length" />
    <DialogDelete :data="dialogData" />
  </div>
</template>
<script>
import DialogDelete from "@/components/DialogDelete/index.vue";
import Pagination from "@/components/Pagination/index.vue";
export default {
  components: { Pagination, DialogDelete },
  props: ["tableData", "dialogData"],
  data() {
    return {};
  },
  mounted() {
    // console.log(this.$props);
  },
  methods: {
    handRowClick(row) {
      console.log(row);
      this.$emit("rowClick", row);
    },
    handSelect(row) {
      console.log(row);
      this.$emit("selection-change", row);
    }
  }
};
</script>
