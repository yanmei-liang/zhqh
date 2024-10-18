<template>
  <div class="app-container">
    <div>
      <el-row class="row" :gutter="10">
        <el-col :span="7" class="flex"><p>审批中:1</p></el-col>
        <el-col :span="7" class="flex"><p>已通过:1</p></el-col>
        <el-col :span="7" class="flex"><p>已驳回:1</p></el-col>
      </el-row>
    </div>
    <el-form
      :model="queryParams"
      ref="queryForm"
      size="small"
      :inline="true"
      v-show="showSearch"
      label-width="68px"
    >
      <!-- <el-form-item label="申报ID" prop="declareId">
        <el-input
          v-model="queryParams.declareId"
          placeholder="请输入申报ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="备案编号" prop="recordCode">
        <el-input
          v-model="queryParams.recordCode"
          placeholder="请输入备案编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备案标题" prop="recordName">
        <el-input
          v-model="queryParams.recordName"
          placeholder="请输入备案标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="提交人" prop="approvalNumber">
        <el-input
          v-model="queryParams.approvalNumber"
          placeholder="请输入批文号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="提交日期" prop="approvalTime">
        <el-date-picker
          clearable
          v-model="queryParams.approvalTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择批准日期"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item label="审批状态" prop="approvalDepa">
        <el-select v-model="value" placeholder="请选择">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          >
          </el-option>
        </el-select>
        <!-- <el-input
          v-model="queryParams.approvalDepa"
          placeholder="请输入批准机关"
          clearable
          @keyup.enter.native="handleQuery"
        /> -->
      </el-form-item>
      <!-- <el-form-item label="备案报告" prop="recordReport">
        <el-input
          v-model="queryParams.recordReport"
          placeholder="请输入备案报告"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="批复文件" prop="approvalDocument">
        <el-input
          v-model="queryParams.approvalDocument"
          placeholder="请输入批复文件"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="命名申请书" prop="APPLICATION">
        <el-input
          v-model="queryParams.APPLICATION"
          placeholder="请输入命名申请书"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="附件" prop="ATTACHMENT">
        <el-input
          v-model="queryParams.ATTACHMENT"
          placeholder="请输入附件"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否公告" prop="AFFICHE">
        <el-input
          v-model="queryParams.AFFICHE"
          placeholder="请输入是否公告"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="新增矢量地名" prop="vectorPlaceName">
        <el-input
          v-model="queryParams.vectorPlaceName"
          placeholder="请输入新增矢量地名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建者" prop="createBy">
        <el-input
          v-model="queryParams.createBy"
          placeholder="请输入创建者"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建时间" prop="createTime">
        <el-date-picker
          clearable
          v-model="queryParams.createTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择创建时间"
        >
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
        <el-date-picker
          clearable
          v-model="queryParams.updateTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择更新时间"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item label="备注" prop="remark">
        <el-input
          v-model="queryParams.remark"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item>
        <el-button
          type="primary"
          icon="el-icon-search"
          size="mini"
          @click="handleQuery"
          >搜索</el-button
        >
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery"
          >重置</el-button
        >
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
          v-hasPermi="['government:RECORD:add']"
          >新增备案</el-button
        >
      </el-col>
      <!-- <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['government:RECORD:edit']"
          >修改</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['government:RECORD:remove']"
          >删除</el-button
        >
      </el-col> -->
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['government:RECORD:export']"
          >导出</el-button
        >
      </el-col>
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="RECORDList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键备案ID" align="center" prop="recordId" />
      <el-table-column label="申报ID" align="center" prop="declareId" />
      <el-table-column label="备案编号" align="center" prop="recordCode" />
      <el-table-column label="备案标题" align="center" prop="recordName" />
      <el-table-column label="批文号" align="center" prop="approvalNumber" />
      <el-table-column
        label="批准日期"
        align="center"
        prop="approvalTime"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.approvalTime, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column label="批准机关" align="center" prop="approvalDepa" />
      <el-table-column label="备案报告" align="center" prop="recordReport" />
      <el-table-column
        label="批复文件"
        align="center"
        prop="approvalDocument"
      />
      <el-table-column label="命名申请书" align="center" prop="APPLICATION" />
      <el-table-column label="附件" align="center" prop="ATTACHMENT" />
      <el-table-column label="状态" align="center" prop="STATUS" />
      <el-table-column
        label="地图经纬度集合"
        align="center"
        prop="longitudeLatitude"
      />
      <el-table-column label="备案状态" align="center" prop="recordStatus" />
      <el-table-column label="是否公告" align="center" prop="AFFICHE" />
      <el-table-column
        label="新增矢量地名"
        align="center"
        prop="vectorPlaceName"
      />
      <el-table-column label="创建者" align="center" prop="createBy" />
      <el-table-column
        label="创建时间"
        align="center"
        prop="createTime"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column label="更新者" align="center" prop="updateBy" />
      <el-table-column
        label="更新时间"
        align="center"
        prop="updateTime"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateTime, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column
        label="操作"
        align="center"
        class-name="small-padding fixed-width"
      >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['government:RECORD:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['government:RECORD:remove']"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改地名备案对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="70%" append-to-body>
      <!-- <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="申报ID" prop="declareId">
          <el-input v-model="form.declareId" placeholder="请输入申报ID" />
        </el-form-item>
        <el-form-item label="备案编号" prop="recordCode">
          <el-input v-model="form.recordCode" placeholder="请输入备案编号" />
        </el-form-item>
        <el-form-item label="备案标题" prop="recordName">
          <el-input v-model="form.recordName" placeholder="请输入备案标题" />
        </el-form-item>
        <el-form-item label="批文号" prop="approvalNumber">
          <el-input v-model="form.approvalNumber" placeholder="请输入批文号" />
        </el-form-item>
        <el-form-item label="批准日期" prop="approvalTime">
          <el-date-picker
            clearable
            v-model="form.approvalTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择批准日期"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="批准机关" prop="approvalDepa">
          <el-input v-model="form.approvalDepa" placeholder="请输入批准机关" />
        </el-form-item>
        <el-form-item label="备案报告" prop="recordReport">
          <el-input v-model="form.recordReport" placeholder="请输入备案报告" />
        </el-form-item>
        <el-form-item label="批复文件" prop="approvalDocument">
          <el-input
            v-model="form.approvalDocument"
            placeholder="请输入批复文件"
          />
        </el-form-item>
        <el-form-item label="命名申请书" prop="APPLICATION">
          <el-input v-model="form.APPLICATION" placeholder="请输入命名申请书" />
        </el-form-item>
        <el-form-item label="附件" prop="ATTACHMENT">
          <el-input v-model="form.ATTACHMENT" placeholder="请输入附件" />
        </el-form-item>
        <el-form-item label="是否公告" prop="AFFICHE">
          <el-input v-model="form.AFFICHE" placeholder="请输入是否公告" />
        </el-form-item>
        <el-form-item label="新增矢量地名" prop="vectorPlaceName">
          <el-input
            v-model="form.vectorPlaceName"
            placeholder="请输入新增矢量地名"
          />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
      </el-form> -->
      <Form :model="model" ref="model" :rules="rules">
        <template #left>
          <el-form-item label="备案标题:" prop="name11">
            <el-input v-model="model.name11"></el-input>
          </el-form-item>
          <el-form-item label="批准机关">
            <el-input v-model="model.name"></el-input>
          </el-form-item>
          <el-form-item label="备案报告"> 
            <FileUpload/>
          </el-form-item>
          <el-form-item label="命更名申请书"> 
            <FileUpload/>
          </el-form-item>
        </template>
        <template #right>
          <el-form-item label="批文号">
            <el-input v-model="model.name"></el-input>
          </el-form-item>
          <el-form-item label="批准日期">
            <el-input v-model="model.name"></el-input>
          </el-form-item>
           <el-form-item label="批复文件"> 
            <FileUpload/>
          </el-form-item>
           <el-form-item label="其他文件"> 
            <FileUpload/>
          </el-form-item>
        </template>
      </Form>
      <div style="display: flex; justify-content: space-between">
        <div><p>新增矢量地名</p></div>
        <div>
          <el-button size="mini" @click="innerVisible = true"
            >关联选择</el-button
          >
          <el-button size="mini">删除</el-button>
        </div>
      </div>
      <Table
        :tableData="tableList"
        @selection-change="handleSelectionChange"
      ></Table>
      <el-row style="margin-top: 20px">
        <el-col :span="1">
          <p>备注</p>
        </el-col>
        <el-col :span="23">
          <el-input
            type="textarea"
            placeholder="请输入内容"
            v-model="textarea"
            maxlength="300"
            show-word-limit
          >
          </el-input>
        </el-col>
      </el-row>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">提 交</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>

      <el-dialog
        width="30%"
        title="内层 Dialog"
        :visible.sync="innerVisible"
        append-to-body
      >
      </el-dialog>
    </el-dialog>
  </div>
</template>

<script>
import {
  listRECORD,
  getRECORD,
  delRECORD,
  addRECORD,
  updateRECORD,
} from "@/api/government/RECORD";
import Form from "@/components/form";
import Table from "@/components/Table";
import FileUpload from "@/components/FileUpload/index.vue";
export default {
  components: { Form, Table ,FileUpload},
  name: "RECORD",
  data() {
    return {
      textarea:'',
      innerVisible: false,
      rules:[{}],
      tableList: {
        data: [
          {
            date: "2016-05-03",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1518 弄",
          },
          {
            date: "2016-05-02",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1518 弄",
          },
          {
            date: "2016-05-04",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1518 弄",
          },
          {
            date: "2016-05-01",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1518 弄",
          },
          {
            date: "2016-05-08",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1518 弄",
          },
          {
            date: "2016-05-06",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1518 弄",
          },
          {
            date: "2016-05-07",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1518 弄",
          },
        ],
        selection: true,
        // dataLength: tableList.data.length,
        column: [
          {
            prop: "date",
            label: "日期",
            width: "180",
          },
          {
            prop: "name",
            label: "姓名",
            width: "180",
          },
          {
            prop: "address",
            label: "地址",
            // width: "180",
          },
        ],
      },
      model: { name: "" },
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
      // 地名备案表格数据
      RECORDList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        declareId: null,
        recordCode: null,
        recordName: null,
        approvalNumber: null,
        approvalTime: null,
        approvalDepa: null,
        recordReport: null,
        approvalDocument: null,
        APPLICATION: null,
        ATTACHMENT: null,
        STATUS: null,
        longitudeLatitude: null,
        recordStatus: null,
        AFFICHE: null,
        vectorPlaceName: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        name11:[{
          required:true,message: "备案标题不能为空",
        }],
        recordId: [
          { required: true, message: "主键备案ID不能为空", trigger: "blur" },
        ],
      },
      options: [
        {
          value: "选项1",
          label: "全部",
        },
        {
          value: "选项2",
          label: "审批中",
        },
        {
          value: "选项3",
          label: "已通过",
        },
        {
          value: "选项4",
          label: "已驳回",
        },
      ],
      value: "",
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询地名备案列表 */
    getList() {
      this.loading = true;
      listRECORD(this.queryParams).then((response) => {
        this.RECORDList = response.rows;
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
        recordId: null,
        declareId: null,
        recordCode: null,
        recordName: null,
        approvalNumber: null,
        approvalTime: null,
        approvalDepa: null,
        recordReport: null,
        approvalDocument: null,
        APPLICATION: null,
        ATTACHMENT: null,
        STATUS: null,
        longitudeLatitude: null,
        recordStatus: null,
        AFFICHE: null,
        vectorPlaceName: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
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
      this.ids = selection.map((item) => item.recordId);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "新增地名备案";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const recordId = row.recordId || this.ids;
      getRECORD(recordId).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改地名备案";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.recordId != null) {
            updateRECORD(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRECORD(this.form).then((response) => {
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
      const recordIds = row.recordId || this.ids;
      this.$modal
        .confirm('是否确认删除地名备案编号为"' + recordIds + '"的数据项？')
        .then(function () {
          return delRECORD(recordIds);
        })
        .then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        })
        .catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download(
        "government/RECORD/export",
        {
          ...this.queryParams,
        },
        `RECORD_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
<style scoped lang="scss">
.row {
  height: 80px;
  margin-bottom: 20px;
  display: flex;
  justify-content: space-between;
  // margin: 20px 0;
  & .el-col:nth-child(1) {
    background-color: #409eff;
    height: 100%;
  }
  & .el-col:nth-child(2) {
    background-color: #67c23a;
    height: 100%;
  }
  & .el-col:nth-child(3) {
    background-color: #f56c6c;
    height: 100%;
  }
  .flex {
    display: flex;
    justify-content: center;
    align-items: center;
  }
}
.el-input,
.el-input__inner,
.el-select {
  width: 70%;
}
.dialog-footer {
  display: flex;
  justify-content: center;
}
</style>
