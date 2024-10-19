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
      <el-form-item label="预审编号" prop="toponym">
        <el-input
          v-model="queryParams.TOPONYM"
          placeholder="请输入预审地名名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="预审名称" prop="submitDepa">
        <el-input
          v-model="queryParams.submitDepa"
          placeholder="请输入报送单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系人" prop="contacts">
        <el-input
          v-model="queryParams.CONTACTS"
          placeholder="请输入联系人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="提交时间" prop="SubmitDate">
        <el-date-picker
          v-model="queryParams.SubmitDate"
          type="datetimerange"
          range-separator="至"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item label="审批状态" prop="application">
        <el-select v-model="value" placeholder="请选择">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          >
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="审批时间" prop="Approval">
        <el-date-picker
          v-model="queryParams.ApprovalDate"
          type="datetimerange"
          range-separator="至"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        >
        </el-date-picker>
      </el-form-item>

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
          v-hasPermi="['government:INQUIRY:add']"
          >新增</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['government:INQUIRY:edit']"
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
          v-hasPermi="['government:INQUIRY:remove']"
          >删除</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['government:INQUIRY:export']"
          >导出</el-button
        >
      </el-col>
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table
      v-loading="false"
      :data="INQUIRYList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键预审ID" align="center" prop="inquiryId" />
      <el-table-column label="预审地名名称" align="center" prop="TOPONYM" />
      <el-table-column label="报送单位" align="center" prop="submitDepa" />
      <el-table-column label="联系人" align="center" prop="CONTACTS" />
      <el-table-column label="联系人电话" align="center" prop="contactsPhone" />
      <el-table-column label="申请书" align="center" prop="application" />
      <el-table-column label="附件" align="center" prop="attachment" />
      <el-table-column label="预审备注" align="center" prop="inquiryRemark" />
      <el-table-column label="状态" align="center" prop="status" />
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
      <el-table-column label="预审状态" align="center" prop="inquiryStatus" />
      <el-table-column label="地名编码" align="center" prop="code" />
      <el-table-column label="地名标志" align="center" prop="toponymSign" />
      <el-table-column
        label="报送时间"
        align="center"
        prop="submitTime"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.submitTime, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="申请时间"
        align="center"
        prop="applyIme"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.applyIme, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column label="工程名称" align="center" prop="projectName" />
      <el-table-column label="工程地点" align="center" prop="projectPlace" />
      <el-table-column label="工程性质" align="center" prop="projectType" />
      <el-table-column label="建筑面积" align="center" prop="areaStructure" />
      <el-table-column
        label="建设内容与功能分区"
        align="center"
        prop="constructionDescribe"
      >
      </el-table-column>
      <el-table-column
        label="地名类型(地点，路线，区域)"
        align="center"
        prop="toponymType"
      />
      <el-table-column
        label="地图经纬度集合"
        align="center"
        prop="longitudeLatitude"
      />
      <el-table-column
        label="操作"
        align="center"
        fixed="right"
        class-name="small-padding fixed-width"
      >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleSee(scope.row)"
            >查看</el-button
          >
          <!-- <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['government:INQUIRY:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['government:INQUIRY:remove']"
            >删除</el-button
          > -->
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

    <!-- 添加或修改地名预审格对话框 -->
    <el-dialog :title="title" class="add_form" :visible.sync="open" width="40%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="预审地名名称" prop="TOPONYM">
          <el-input v-model="form.toponym" placeholder="请输入预审地名名称" />
        </el-form-item>
        <el-form-item label="报送单位" prop="submitDepa">
          <el-input v-model="form.submitDepa" placeholder="请输入报送单位" />
        </el-form-item>
        <el-form-item label="联系人" prop="CONTACTS">
          <el-input v-model="form.contacts" placeholder="请输入联系人" />
        </el-form-item>
        <el-form-item label="联系人电话" prop="contactsPhone">
          <el-input
            v-model="form.contactsPhone"
            placeholder="请输入联系人电话"
          />
        </el-form-item>
        <el-form-item label="申请书" prop="APPLICATION">
          <!-- <el-input v-model="form.APPLICATION" placeholder="请输入申请书" /> -->
          <FileUpload/>
          <el-input v-model="form.application" placeholder="请输入申请书" />
        </el-form-item>
        <el-form-item label="附件" prop="attachment">
          <el-input v-model="form.attachment" placeholder="请输入附件" />
        <el-form-item label="其他附件" prop="ATTACHMENT">
          <!-- <el-input v-model="form.ATTACHMENT" placeholder="请输入附件" /> -->
          <FileUpload/>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
        <!-- <el-form-item label="地名编码" prop="CODE">
          <el-input v-model="form.CODE" placeholder="请输入地名编码" />
        <el-form-item label="地名编码" prop="CODE">
          <el-input v-model="form.code" placeholder="请输入地名编码" />
        </el-form-item>
        <el-form-item label="地名标志" prop="toponymSign">
          <el-input v-model="form.toponymSign" placeholder="请输入地名标志" />
        </el-form-item>
        <el-form-item label="报送时间" prop="submitTime">
          <el-date-picker
            clearable
            v-model="form.submitTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择报送时间"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="申请时间" prop="applyIme">
          <el-date-picker
            clearable
            v-model="form.applyIme"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择申请时间"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="工程名称" prop="projectName">
          <el-input v-model="form.projectName" placeholder="请输入工程名称" />
        </el-form-item>
        <el-form-item label="工程地点" prop="projectPlace">
          <el-input v-model="form.projectPlace" placeholder="请输入工程地点" />
        </el-form-item>
        <el-form-item label="建筑面积" prop="areaStructure">
          <el-input v-model="form.areaStructure" placeholder="请输入建筑面积" />
        </el-form-item>
        <el-form-item label="建设内容与功能分区" prop="constructionDescribe">
          <el-input
            v-model="form.constructionDescribe"
            placeholder="请输入建设内容与功能分区"
          />
        </el-form-item> -->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <Details :data="dialogData" />
  </div>
</template>

<script>
import {
  listINQUIRY,
  getINQUIRY,
  delINQUIRY,
  addINQUIRY,
  updateINQUIRY,
} from "@/api/government/INQUIRY";
import Details from "./details.vue";
import { flowRecord } from "@/api/flowable/finished";
import FileUpload from "@/components/FileUpload/index.vue";
export default {
  components: { Details,FileUpload },
  name: "INQUIRY",
  data() {
    return {
      dialogData: {
        dialogVisible: false,
      },
      // 遮罩层
      loading: false,
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
      // 地名预审格表格数据
      INQUIRYList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
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
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        toponym: null,
        submitDepa: null,
        CONTACTS: null,
        contactsPhone: null,
        APPLICATION: null,
        ATTACHMENT: null,
        application: null,
        attachment: null,
        inquiryRemark: null,
        status: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
        inquiryStatus: null,
        code: null,
        toponymSign: null,
        submitTime: null,
        applyIme: null,
        projectName: null,
        projectPlace: null,
        projectType: null,
        areaStructure: null,
        constructionDescribe: null,
        toponymType: null,
        longitudeLatitude: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        inquiryId: [
          { required: true, message: "主键预审ID不能为空", trigger: "blur" },
        ],
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    // 查看
    handleSee(val) {
      const params = { procInsId: "55001", deployId: "50001" };
      flowRecord(params)
        .then((res) => {
          console.log(res)
          this.dialogData = {
            flowRecordList: res.data.flowList,
            dialogVisible: true,
            // deployId: "10041",
            // procInsId: "42501",
          };
        })
        .catch((res) => {
          this.goBack();
        });
    },
    /** 查询地名预审格列表 */
    getList() {
      this.loading = true;
      listINQUIRY;
      listINQUIRY(this.queryParams).then((response) => {
        this.INQUIRYList = response.rows;
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
        inquiryId: null,
        toponym: null,
        submitDepa: null,
        contacts: null,
        contactsPhone: null,
        application: null,
        attachment: null,
        inquiryRemark: null,
        status: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
        inquiryStatus: null,
        code: null,
        toponymSign: null,
        submitTime: null,
        applyIme: null,
        projectName: null,
        projectPlace: null,
        projectType: null,
        areaStructure: null,
        constructionDescribe: null,
        toponymType: null,
        longitudeLatitude: null,
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
      this.ids = selection.map((item) => item.inquiryId);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加地名预审格";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const inquiryId = row.inquiryId || this.ids;
      getINQUIRY(inquiryId).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改地名预审格";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.inquiryId != null) {
            updateINQUIRY(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addINQUIRY(this.form).then((response) => {
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
      const inquiryIds = row.inquiryId || this.ids;
      this.$modal
        .confirm('是否确认删除地名预审格编号为"' + inquiryIds + '"的数据项？')
        .then(function () {
          return delINQUIRY(inquiryIds);
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
        "government/INQUIRY/export",
        {
          ...this.queryParams,
        },
        `INQUIRY_${new Date().getTime()}.xlsx`
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
.add_form{
.el-form{
  width: 90%;
  margin: 0 auto;
}
}

</style>
