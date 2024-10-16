<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="创建者" prop="createBy">
        <el-input
          v-model="queryParams.createBy"
          placeholder="请输入创建者"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建时间" prop="createTime">
        <el-date-picker clearable
          v-model="queryParams.createTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择创建时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="更新者" prop="updateBy">
        <el-input
          v-model="queryParams.updateBy"
          placeholder="请输入更新者"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="更新时间" prop="updateTime">
        <el-date-picker clearable
          v-model="queryParams.updateTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择更新时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="备注" prop="remark">
        <el-input
          v-model="queryParams.remark"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地名名称" prop="TOPONYM">
        <el-input
          v-model="queryParams.TOPONYM"
          placeholder="请输入地名名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地名标志" prop="toponymSign">
        <el-input
          v-model="queryParams.toponymSign"
          placeholder="请输入地名标志"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地名编码" prop="CODE">
        <el-input
          v-model="queryParams.CODE"
          placeholder="请输入地名编码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地名预审ID" prop="inquiryId">
        <el-input
          v-model="queryParams.inquiryId"
          placeholder="请输入地名预审ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="申报编号" prop="declareCode">
        <el-input
          v-model="queryParams.declareCode"
          placeholder="请输入申报编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
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
          v-hasPermi="['government:DECLARE:add']"
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
          v-hasPermi="['government:DECLARE:edit']"
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
          v-hasPermi="['government:DECLARE:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['government:DECLARE:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="DECLAREList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键申报ID" align="center" prop="declareId" />
      <el-table-column label="创建者" align="center" prop="createBy" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="更新者" align="center" prop="updateBy" />
      <el-table-column label="更新时间" align="center" prop="updateTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="状态" align="center" prop="STATUS" />
      <el-table-column label="申报状态" align="center" prop="declareStatus" />
      <el-table-column label="地名名称" align="center" prop="TOPONYM" />
      <el-table-column label="地名标志" align="center" prop="toponymSign" />
      <el-table-column label="地名编码" align="center" prop="CODE" />
      <el-table-column label="地名预审ID" align="center" prop="inquiryId" />
      <el-table-column label="地图经纬度集合" align="center" prop="longitudeLatitude" />
      <el-table-column label="申报编号" align="center" prop="declareCode" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['government:DECLARE:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['government:DECLARE:remove']"
          >删除</el-button>
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

    <!-- 添加或修改地名申报对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="地名名称" prop="TOPONYM">
          <el-input v-model="form.TOPONYM" placeholder="请输入地名名称" />
        </el-form-item>
        <el-form-item label="地名标志" prop="toponymSign">
          <el-input v-model="form.toponymSign" placeholder="请输入地名标志" />
        </el-form-item>
        <el-form-item label="地名编码" prop="CODE">
          <el-input v-model="form.CODE" placeholder="请输入地名编码" />
        </el-form-item>
        <el-form-item label="地名预审ID" prop="inquiryId">
          <el-input v-model="form.inquiryId" placeholder="请输入地名预审ID" />
        </el-form-item>
        <el-form-item label="申报编号" prop="declareCode">
          <el-input v-model="form.declareCode" placeholder="请输入申报编号" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listDECLARE, getDECLARE, delDECLARE, addDECLARE, updateDECLARE } from "@/api/government/DECLARE";

export default {
  name: "DECLARE",
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
      // 地名申报表格数据
      DECLAREList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
        STATUS: null,
        declareStatus: null,
        TOPONYM: null,
        toponymSign: null,
        CODE: null,
        inquiryId: null,
        longitudeLatitude: null,
        declareCode: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        declareId: [
          { required: true, message: "主键申报ID不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询地名申报列表 */
    getList() {
      this.loading = true;
      listDECLARE(this.queryParams).then(response => {
        this.DECLAREList = response.rows;
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
        declareId: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
        STATUS: null,
        declareStatus: null,
        TOPONYM: null,
        toponymSign: null,
        CODE: null,
        inquiryId: null,
        longitudeLatitude: null,
        declareCode: null
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
      this.ids = selection.map(item => item.declareId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加地名申报";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const declareId = row.declareId || this.ids
      getDECLARE(declareId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改地名申报";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.declareId != null) {
            updateDECLARE(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDECLARE(this.form).then(response => {
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
      const declareIds = row.declareId || this.ids;
      this.$modal.confirm('是否确认删除地名申报编号为"' + declareIds + '"的数据项？').then(function() {
        return delDECLARE(declareIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('government/DECLARE/export', {
        ...this.queryParams
      }, `DECLARE_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
