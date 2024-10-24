<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
<!--      <el-form-item label="id" prop="tsjlId">-->
<!--        <el-input-->
<!--          v-model="queryParams.tsjlId"-->
<!--          placeholder="请输入id"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="推送名称" prop="tsName">-->
<!--        <el-input-->
<!--          v-model="queryParams.tsName"-->
<!--          placeholder="请输入推送名称"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="类型" prop="tsType">
        <el-select v-model="queryParams.tsType" placeholder="请选择类型" clearable>
          <el-option
            v-for="dict in dict.type.sys_ts_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="所在区" prop="tsRegion">
        <el-input
          v-model="queryParams.tsRegion"
          placeholder="请输入所在区"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="所在街道" prop="tsStreet">-->
<!--        <el-input-->
<!--          v-model="queryParams.tsStreet"-->
<!--          placeholder="请输入所在街道"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="发起部门" prop="initiatingDepartment">-->
<!--        <el-input-->
<!--          v-model="queryParams.initiatingDepartment"-->
<!--          placeholder="请输入发起部门"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="推送的发起部门" prop="tsDepartment">-->
<!--        <el-input-->
<!--          v-model="queryParams.tsDepartment"-->
<!--          placeholder="请输入推送的发起部门"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="推送时间" prop="pushTime">-->
<!--        <el-date-picker clearable-->
<!--                        v-model="queryParams.pushTime"-->
<!--                        type="date"-->
<!--                        value-format="yyyy-MM-dd"-->
<!--                        placeholder="请选择推送时间">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="审核结果" prop="reviewStatus">-->
<!--        <el-select v-model="queryParams.reviewStatus" placeholder="请选择审核结果" clearable>-->
<!--          <el-option-->
<!--            v-for="dict in dict.type.review_status"-->
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
          v-hasPermi="['government:TSJL:add']"
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
          v-hasPermi="['government:TSJL:edit']"
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
          v-hasPermi="['government:TSJL:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['government:TSJL:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="TSJLList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="id" align="center" prop="tsjlId" />-->
      <el-table-column label="推送名称" align="center" prop="tsName" />
      <el-table-column label="类型" align="center" prop="tsType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_ts_type" :value="scope.row.tsType"/>
        </template>
      </el-table-column>
      <el-table-column label="所在区" align="center" prop="tsRegion" />
      <el-table-column label="所在街道" align="center" prop="tsStreet" />
      <el-table-column label="发起部门" align="center" prop="initiatingDepartment" />
<!--      <el-table-column label="推送的发起部门" align="center" prop="tsDepartment" />-->
      <el-table-column label="推送时间" align="center" prop="pushTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.pushTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="审核结果" align="center" prop="reviewStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.review_status" :value="scope.row.reviewStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['government:TSJL:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['government:TSJL:remove']"
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

    <!-- 添加或修改推送记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
<!--        <el-form-item label="id" prop="tsjlId">-->
<!--          <el-input v-model="form.tsjlId" placeholder="请输入id" />-->
<!--        </el-form-item>-->
        <el-form-item label="推送名称" prop="tsName">
          <el-input v-model="form.tsName" placeholder="请输入推送名称" />
        </el-form-item>
        <el-form-item label="类型" prop="tsType">
          <el-select v-model="form.tsType" placeholder="请选择类型">
            <el-option
              v-for="dict in dict.type.sys_ts_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="所在区" prop="tsRegion">
          <el-input v-model="form.tsRegion" placeholder="请输入所在区" />
        </el-form-item>
        <el-form-item label="所在街道" prop="tsStreet">
          <el-input v-model="form.tsStreet" placeholder="请输入所在街道" />
        </el-form-item>
        <el-form-item label="发起部门" prop="initiatingDepartment">
          <el-input v-model="form.initiatingDepartment" placeholder="请输入发起部门" />
        </el-form-item>
<!--        <el-form-item label="推送的发起部门" prop="tsDepartment">-->
<!--          <el-input v-model="form.tsDepartment" placeholder="请输入推送的发起部门" />-->
<!--        </el-form-item>-->
        <el-form-item label="推送时间" prop="pushTime">
          <el-date-picker clearable
                          v-model="form.pushTime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择推送时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="审核结果" prop="reviewStatus">
          <el-select v-model="form.reviewStatus" placeholder="请选择审核结果">
            <el-option
              v-for="dict in dict.type.review_status"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
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
import { listTSJL, getTSJL, delTSJL, addTSJL, updateTSJL } from "@/api/government/TSJL";

export default {
  name: "TSJL",
  dicts: ['review_status', 'sys_ts_type'],
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
      // 推送记录表格数据
      TSJLList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        tsjlId: null,
        tsName: null,
        tsType: null,
        tsRegion: null,
        tsStreet: null,
        initiatingDepartment: null,
        tsDepartment: null,
        pushTime: null,
        reviewStatus: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询推送记录列表 */
    getList() {
      this.loading = true;
      listTSJL(this.queryParams).then(response => {
        this.TSJLList = response.rows;
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
        tsjlId: null,
        tsName: null,
        tsType: null,
        tsRegion: null,
        tsStreet: null,
        initiatingDepartment: null,
        tsDepartment: null,
        pushTime: null,
        reviewStatus: null
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
      this.ids = selection.map(item => item.tsjlId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加推送记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const tsjlId = row.tsjlId || this.ids
      getTSJL(tsjlId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改推送记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.tsjlId != null) {
            updateTSJL(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTSJL(this.form).then(response => {
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
      const tsjlIds = row.tsjlId || this.ids;
      this.$modal.confirm('是否确认删除推送记录编号为"' + tsjlIds + '"的数据项？').then(function() {
        return delTSJL(tsjlIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('government/TSJL/export', {
        ...this.queryParams
      }, `TSJL_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
