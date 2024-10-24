package com.ruoyi.government.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 地名备案对象 GOVERNMENT_RECORD
 * 
 * @author ruoyi
 * @date 2024-10-15
 */
public class GovernmentRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键备案ID */
    private Long recordId;

    /** 申报ID */
    @Excel(name = "申报ID")
    private Long declareId;

    /** 备案编号 */
    @Excel(name = "备案编号")
    private String recordCode;

    /** 备案标题 */
    @Excel(name = "备案标题")
    private String recordName;

    /** 批文号 */
    @Excel(name = "批文号")
    private String approvalNumber;

    /** 批准日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "批准日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date approvalTime;

    /** 批准机关 */
    @Excel(name = "批准机关")
    private String approvalDepa;

    /** 备案报告 */
    @Excel(name = "备案报告")
    private String recordReport;

    /** 批复文件 */
    @Excel(name = "批复文件")
    private String approvalDocument;

    /** 命名申请书 */
    @Excel(name = "命名申请书")
    private String application;

    /** 附件 */
    @Excel(name = "附件")
    private String attachment;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 地图经纬度集合 */
    @Excel(name = "地图经纬度集合")
    private String longitudeLatitude;

    /** 备案状态（待提交，已提交，审批中，已完成） */
    @Excel(name = "备案状态", readConverterExp = "待=提交，已提交，审批中，已完成")
    private String recordStatus;

    /** 是否公告 */
    @Excel(name = "是否公告")
    private String affiche;

    /** 新增矢量地名 */
    @Excel(name = "新增矢量地名")
    private String vectorPlaceName;

    /** 流程实例ID */
    @Excel(name = "流程实例ID")
    private String procInsId;

    public String getProcInsId() {
        return procInsId;
    }

    public void setProcInsId(String procInsId) {
        this.procInsId = procInsId;
    }

    public void setRecordId(Long recordId)
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
    }
    public void setDeclareId(Long declareId) 
    {
        this.declareId = declareId;
    }

    public Long getDeclareId() 
    {
        return declareId;
    }
    public void setRecordCode(String recordCode) 
    {
        this.recordCode = recordCode;
    }

    public String getRecordCode() 
    {
        return recordCode;
    }
    public void setRecordName(String recordName) 
    {
        this.recordName = recordName;
    }

    public String getRecordName() 
    {
        return recordName;
    }
    public void setApprovalNumber(String approvalNumber) 
    {
        this.approvalNumber = approvalNumber;
    }

    public String getApprovalNumber() 
    {
        return approvalNumber;
    }
    public void setApprovalTime(Date approvalTime) 
    {
        this.approvalTime = approvalTime;
    }

    public Date getApprovalTime() 
    {
        return approvalTime;
    }
    public void setApprovalDepa(String approvalDepa) 
    {
        this.approvalDepa = approvalDepa;
    }

    public String getApprovalDepa() 
    {
        return approvalDepa;
    }
    public void setRecordReport(String recordReport) 
    {
        this.recordReport = recordReport;
    }

    public String getRecordReport() 
    {
        return recordReport;
    }
    public void setApprovalDocument(String approvalDocument) 
    {
        this.approvalDocument = approvalDocument;
    }

    public String getApprovalDocument() 
    {
        return approvalDocument;
    }
    public void setApplication(String application) 
    {
        this.application = application;
    }

    public String getApplication() 
    {
        return application;
    }
    public void setAttachment(String attachment) 
    {
        this.attachment = attachment;
    }

    public String getAttachment() 
    {
        return attachment;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setLongitudeLatitude(String longitudeLatitude) 
    {
        this.longitudeLatitude = longitudeLatitude;
    }

    public String getLongitudeLatitude() 
    {
        return longitudeLatitude;
    }
    public void setRecordStatus(String recordStatus) 
    {
        this.recordStatus = recordStatus;
    }

    public String getRecordStatus() 
    {
        return recordStatus;
    }
    public void setAffiche(String affiche) 
    {
        this.affiche = affiche;
    }

    public String getAffiche() 
    {
        return affiche;
    }
    public void setVectorPlaceName(String vectorPlaceName) 
    {
        this.vectorPlaceName = vectorPlaceName;
    }

    public String getVectorPlaceName() 
    {
        return vectorPlaceName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recordId", getRecordId())
            .append("declareId", getDeclareId())
            .append("recordCode", getRecordCode())
            .append("recordName", getRecordName())
            .append("approvalNumber", getApprovalNumber())
            .append("approvalTime", getApprovalTime())
            .append("approvalDepa", getApprovalDepa())
            .append("recordReport", getRecordReport())
            .append("approvalDocument", getApprovalDocument())
            .append("application", getApplication())
            .append("attachment", getAttachment())
            .append("status", getStatus())
            .append("longitudeLatitude", getLongitudeLatitude())
            .append("recordStatus", getRecordStatus())
            .append("affiche", getAffiche())
            .append("vectorPlaceName", getVectorPlaceName())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("procInsId", getProcInsId())
            .toString();
    }
}
