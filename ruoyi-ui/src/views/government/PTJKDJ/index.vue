<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="接口地址" prop="URL">
        <el-input
          v-model="queryParams.URL"
          placeholder="请输入接口地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="请求方式" prop="requestMethod">
        <el-input
          v-model="queryParams.requestMethod"
          placeholder="请输入请求方式"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="同步状态" prop="syncStatus">-->
<!--        <el-select v-model="queryParams.syncStatus" placeholder="请选择同步状态" clearable>-->
<!--          <el-option-->
<!--            v-for="dict in dict.type.sys_sync_status"-->
<!--            :key="dict.value"-->
<!--            :label="dict.label"-->
<!--            :value="dict.value"-->
<!--          />-->
<!--        </el-select>-->
<!--      </el-form-item>-->
      <el-form-item label="接口类型" prop="interfaceType">
        <el-select v-model="queryParams.interfaceType" placeholder="请选择接口类型" clearable>
          <el-option
            v-for="dict in dict.type.sys_interface_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
<!--      <el-form-item label="是否删除" prop="deleteMark">-->
<!--        <el-select v-model="queryParams.deleteMark" placeholder="请选择是否删除" clearable>-->
<!--          <el-option-->
<!--            v-for="dict in dict.type.sys_delete_mark"-->
<!--            :key="dict.value"-->
<!--            :label="dict.label"-->
<!--            :value="dict.value"-->
<!--          />-->
<!--        </el-select>-->
<!--      </el-form-item>-->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['government:PTJKDJ:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['government:PTJKDJ:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['government:PTJKDJ:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-refresh"
          size="mini"
          :disabled="multiple"
          @click="handleSynchDb"
          v-hasPermi="['government:PTJKDJ:remove']"
        >同步</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['government:PTJKDJ:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="PTJKDJList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="id" align="center" prop="id" />-->
      <el-table-column label="接口地址" align="center" prop="url" />
      <el-table-column label="请求方式" align="center" prop="requestMethod" />
<!--      <el-table-column label="参数说明" align="center" prop="parameters" />-->
<!--      <el-table-column label="返回示例" align="center" prop="expectedResponse" />-->
<!--      <el-table-column label="同步状态" align="center" prop="syncStatus">-->
<!--        <template slot-scope="scope">-->
<!--          <dict-tag :options="dict.type.sys_sync_status" :value="scope.row.syncStatus"/>-->
<!--        </template>-->
<!--      </el-table-column>-->
      <el-table-column label="接口类型" align="center" prop="interfaceType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_interface_type" :value="scope.row.interfaceType"/>
        </template>
      </el-table-column>
<!--      <el-table-column label="是否删除" align="center" prop="deleteMark">-->
<!--        <template slot-scope="scope">-->
<!--          <dict-tag :options="dict.type.sys_delete_mark" :value="scope.row.deleteMark"/>-->
<!--        </template>-->
<!--      </el-table-column>-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['government:PTJKDJ:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['government:PTJKDJ:remove']"
          >删除</el-button>
          <el-button
            type="text"
            size="small"
            icon="el-icon-refresh"
            @click="handleSynchDb(scope.row)"
            v-hasPermi="['government:PTJKDJ:gen:edit']"
          >同步</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改平台接口对接模块对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="接口地址" prop="url">
          <el-input v-model="form.url" placeholder="请输入接口地址" />
        </el-form-item>
        <el-form-item label="请求方式" prop="requestMethod">
          <el-input v-model="form.requestMethod" placeholder="请输入请求方式" />
        </el-form-item>
        <el-form-item label="参数说明" prop="parameters">
          <el-input v-model="form.parameters" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="返回示例" prop="expectedResponse">
          <el-input v-model="form.expectedResponse" type="textarea" placeholder="请输入内容" />
        </el-form-item>
<!--        <el-form-item label="同步状态" prop="syncStatus">-->
<!--          <el-radio-group v-model="form.syncStatus">-->
<!--            <el-radio-->
<!--              v-for="dict in dict.type.sys_sync_status"-->
<!--              :key="dict.value"-->
<!--              :label="dict.value"-->
<!--            >{{dict.label}}</el-radio>-->
<!--          </el-radio-group>-->
<!--        </el-form-item>-->
        <el-form-item label="接口类型" prop="interfaceType">
          <el-select v-model="form.interfaceType" placeholder="请选择接口类型">
            <el-option
              v-for="dict in dict.type.sys_interface_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
<!--        <el-form-item label="是否删除" prop="deleteMark">-->
<!--          <el-radio-group v-model="form.deleteMark">-->
<!--            <el-radio-->
<!--              v-for="dict in dict.type.sys_delete_mark"-->
<!--              :key="dict.value"-->
<!--              :label="parseInt(dict.value)"-->
<!--            >{{dict.label}}</el-radio>-->
<!--          </el-radio-group>-->
<!--        </el-form-item>-->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listPTJKDJ, getPTJKDJ, delPTJKDJ, addPTJKDJ, updatePTJKDJ } from "@/api/government/PTJKDJ";

export default {
  name: "PTJKDJ",
  dicts: ['sys_sync_status', 'sys_interface_type', 'sys_delete_mark'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 平台接口对接模块表格数据
      PTJKDJList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        URL: null,
        requestMethod: null,
        PARAMETERS: null,
        expectedResponse: null,
        syncStatus: null,
        interfaceType: null,
        deleteMark: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        URL: [
          { required: true, message: "接口地址不能为空", trigger: "blur" }
        ],
        requestMethod: [
          { required: true, message: "请求方式不能为空", trigger: "blur" }
        ],
        // syncStatus: [
        //   { required: true, message: "同步状态不能为空", trigger: "change" }
        // ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询平台接口对接模块列表 */
    getList() {
      this.loading = true;
      listPTJKDJ(this.queryParams).then(response => {
        this.PTJKDJList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        url: null,
        requestMethod: null,
        parameters: null,
        expectedResponse: null,
        syncStatus: null,
        interfaceType: null,
        deleteMark: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加平台接口对接模块";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const ID = row.id || this.ids
      getPTJKDJ(ID).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改平台接口对接模块";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePTJKDJ(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPTJKDJ(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const IDs = row.id || this.ids;
      this.$modal.confirm('是否确认删除平台接口对接模块编号为"' + IDs + '"的数据项？').then(function() {
        return delPTJKDJ(IDs);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 同步按钮操作 */
    handleSynchDb(row) {
      /**  什么也没干 */
      const IDs = row.id || this.ids;
      this.$modal.confirm('是否确认同步平台接口对接模块编号为"' + IDs + '"的数据项？').then(function () {
        /**  同步 */
        return null
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("同步成功");
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('government/PTJKDJ/export', {
        ...this.queryParams
      }, `PTJKDJ_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
