package com.ruoyi.government.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 地名预审格对象 GOVERNMENT_INQUIRY
 * 
 * @author ruoyi
 * @date 2024-10-15
 */
public class GovernmentInquiry extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键预审ID */
    private Long inquiryId;

    /** 预审地名名称 */
    @Excel(name = "预审地名名称")
    private String TOPONYM;

    /** 报送单位 */
    @Excel(name = "报送单位")
    private String submitDepa;

    /** 联系人 */
    @Excel(name = "联系人")
    private String CONTACTS;

    /** 联系人电话 */
    @Excel(name = "联系人电话")
    private String contactsPhone;

    /** 申请书 */
    @Excel(name = "申请书")
    private String APPLICATION;

    /** 附件 */
    @Excel(name = "附件")
    private String ATTACHMENT;

    /** 预审备注 */
    @Excel(name = "预审备注")
    private String inquiryRemark;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String STATUS;

    /** 预审状态（待提交，已提交，审批中，已完成） */
    @Excel(name = "预审状态", readConverterExp = "待=提交，已提交，审批中，已完成")
    private String inquiryStatus;

    /** 地名编码 */
    @Excel(name = "地名编码")
    private String CODE;

    /** 地名标志 */
    @Excel(name = "地名标志")
    private String toponymSign;

    /** 报送时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报送时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date submitTime;

    /** 申请时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applyIme;

    /** 工程名称 */
    @Excel(name = "工程名称")
    private String projectName;

    /** 工程地点 */
    @Excel(name = "工程地点")
    private String projectPlace;

    /** 工程性质 */
    @Excel(name = "工程性质")
    private String projectType;

    /** 建筑面积 */
    @Excel(name = "建筑面积")
    private Double areaStructure;

    /** 建设内容与功能分区 */
    @Excel(name = "建设内容与功能分区")
    private String constructionDescribe;

    /** 地名类型(地点，路线，区域) */
    @Excel(name = "地名类型(地点，路线，区域)")
    private String toponymType;

    /** 地图经纬度集合 */
    @Excel(name = "地图经纬度集合")
    private String longitudeLatitude;

    public void setInquiryId(Long inquiryId) 
    {
        this.inquiryId = inquiryId;
    }

    public Long getInquiryId() 
    {
        return inquiryId;
    }
    public void setTOPONYM(String TOPONYM) 
    {
        this.TOPONYM = TOPONYM;
    }

    public String getTOPONYM() 
    {
        return TOPONYM;
    }
    public void setSubmitDepa(String submitDepa) 
    {
        this.submitDepa = submitDepa;
    }

    public String getSubmitDepa() 
    {
        return submitDepa;
    }
    public void setCONTACTS(String CONTACTS) 
    {
        this.CONTACTS = CONTACTS;
    }

    public String getCONTACTS() 
    {
        return CONTACTS;
    }
    public void setContactsPhone(String contactsPhone) 
    {
        this.contactsPhone = contactsPhone;
    }

    public String getContactsPhone() 
    {
        return contactsPhone;
    }
    public void setAPPLICATION(String APPLICATION) 
    {
        this.APPLICATION = APPLICATION;
    }

    public String getAPPLICATION() 
    {
        return APPLICATION;
    }
    public void setATTACHMENT(String ATTACHMENT) 
    {
        this.ATTACHMENT = ATTACHMENT;
    }

    public String getATTACHMENT() 
    {
        return ATTACHMENT;
    }
    public void setInquiryRemark(String inquiryRemark) 
    {
        this.inquiryRemark = inquiryRemark;
    }

    public String getInquiryRemark() 
    {
        return inquiryRemark;
    }
    public void setSTATUS(String STATUS) 
    {
        this.STATUS = STATUS;
    }

    public String getSTATUS() 
    {
        return STATUS;
    }
    public void setInquiryStatus(String inquiryStatus) 
    {
        this.inquiryStatus = inquiryStatus;
    }

    public String getInquiryStatus() 
    {
        return inquiryStatus;
    }
    public void setCODE(String CODE) 
    {
        this.CODE = CODE;
    }

    public String getCODE() 
    {
        return CODE;
    }
    public void setToponymSign(String toponymSign) 
    {
        this.toponymSign = toponymSign;
    }

    public String getToponymSign() 
    {
        return toponymSign;
    }
    public void setSubmitTime(Date submitTime) 
    {
        this.submitTime = submitTime;
    }

    public Date getSubmitTime() 
    {
        return submitTime;
    }
    public void setApplyIme(Date applyIme) 
    {
        this.applyIme = applyIme;
    }

    public Date getApplyIme() 
    {
        return applyIme;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setProjectPlace(String projectPlace) 
    {
        this.projectPlace = projectPlace;
    }

    public String getProjectPlace() 
    {
        return projectPlace;
    }
    public void setProjectType(String projectType) 
    {
        this.projectType = projectType;
    }

    public String getProjectType() 
    {
        return projectType;
    }
    public void setAreaStructure(Double areaStructure) 
    {
        this.areaStructure = areaStructure;
    }

    public Double getAreaStructure() 
    {
        return areaStructure;
    }
    public void setConstructionDescribe(String constructionDescribe) 
    {
        this.constructionDescribe = constructionDescribe;
    }

    public String getConstructionDescribe() 
    {
        return constructionDescribe;
    }
    public void setToponymType(String toponymType) 
    {
        this.toponymType = toponymType;
    }

    public String getToponymType() 
    {
        return toponymType;
    }
    public void setLongitudeLatitude(String longitudeLatitude) 
    {
        this.longitudeLatitude = longitudeLatitude;
    }

    public String getLongitudeLatitude() 
    {
        return longitudeLatitude;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("inquiryId", getInquiryId())
            .append("TOPONYM", getTOPONYM())
            .append("submitDepa", getSubmitDepa())
            .append("CONTACTS", getCONTACTS())
            .append("contactsPhone", getContactsPhone())
            .append("APPLICATION", getAPPLICATION())
            .append("ATTACHMENT", getATTACHMENT())
            .append("inquiryRemark", getInquiryRemark())
            .append("STATUS", getSTATUS())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("REMARK", getRemark())
            .append("inquiryStatus", getInquiryStatus())
            .append("CODE", getCODE())
            .append("toponymSign", getToponymSign())
            .append("submitTime", getSubmitTime())
            .append("applyIme", getApplyIme())
            .append("projectName", getProjectName())
            .append("projectPlace", getProjectPlace())
            .append("projectType", getProjectType())
            .append("areaStructure", getAreaStructure())
            .append("constructionDescribe", getConstructionDescribe())
            .append("toponymType", getToponymType())
            .append("longitudeLatitude", getLongitudeLatitude())
            .toString();
    }
}
