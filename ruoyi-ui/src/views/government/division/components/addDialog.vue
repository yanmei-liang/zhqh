<template>
  <el-dialog
    class="addDialog"
    title="新增行政区划"
    :visible.sync="addVisible"
    width="60%"
    :before-close="handleClose"
  >
    <h3 style="color:#000">核心信息</h3>
    <el-divider></el-divider>
    <Form :model="formData" :rules="rules">
      <template #left>
        <el-form-item label="行政区划名称:" prop="name">
          <el-input v-model="formData.name" placeholder />
        </el-form-item>
        <el-form-item label="驻地地址:" prop="address">
          <el-input v-model="formData.address" placeholder />
        </el-form-item>
        <el-form-item label="邮政编码:" prop="code">
          <el-input v-model="formData.code" placeholder />
        </el-form-item>
        <el-form-item label="上一级区划名称:" prop="previous">
          <el-input v-model="formData.previous" placeholder />
        </el-form-item>
        <el-form-item label="单位网址:" prop="unit">
          <el-input v-model="formData.unit" placeholder />
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
            <img width="100%" :src="dialogImageUrl" alt />
          </el-dialog>
        </el-form-item>
      </template>
      <template #right>
        <el-form-item label="行政区划代码:" prop="nameNum">
          <el-input v-model="formData.nameNum" placeholder />
        </el-form-item>
        <el-form-item label="面积(km²):" prop="area">
          <el-input v-model="formData.area" placeholder />
        </el-form-item>
        <el-form-item label="面积(km²):" prop="administrative">
          <el-input v-model="formData.administrative" placeholder />
        </el-form-item>
        <el-form-item label="上一级区划代码:" prop="previousNum">
          <el-input v-model="formData.area" placeholder />
        </el-form-item>
        <el-form-item label="联系电话:" prop="phoneNum">
          <el-input v-model="formData.phoneNum" placeholder />
        </el-form-item>
      </template>
    </Form>
    <h3 style="color:#000">相关附件</h3>
    <el-divider></el-divider>
    <div slot="footer">
      <el-button @click="handleClose">取 消</el-button>
      <el-button type="primary" @click="submit">提交</el-button>
    </div>
  </el-dialog>
</template>

<script>
export default {
  props: {
    addVisible: {
      type: Boolean
    }
  },
  data() {
    return {
      formData: ""
    };
  },
  methods: {
    handleClose() {
      this.$emit("update:addVisible", false);
    },
    sunmit() {
      this.$emit("update:addVisible", false);
    }
  }
};
</script>

<style lang='scss' scoped>
.addDialog {
  .dialog {
    .el-dialog__footer {
      display: flex;
      justify-content: center;
      align-items: center;
    }
  }
}
</style>