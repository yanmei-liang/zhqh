package com.ruoyi.government.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 地名申报对象 GOVERNMENT_DECLARE
 * 
 * @author ruoyi
 * @date 2024-10-15
 */
public class GovernmentDeclare extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键申报ID */
    private Long declareId;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String Status;

    /** 申报状态（待提交，已提交，审批中，已完成） */
    @Excel(name = "申报状态", readConverterExp = "待提交，已提交，审批中，已完成")
    private String declareStatus;

    /** 地名名称 */
    @Excel(name = "地名名称")
    private String toponym;

    /** 地名标志 */
    @Excel(name = "地名标志")
    private String toponymSign;

    /** 地名编码 */
    @Excel(name = "地名编码")
    private String Code;

    /** 地名预审ID */
    @Excel(name = "地名预审ID")
    private Long inquiryId;

    /** 地图经纬度集合 */
    @Excel(name = "地图经纬度集合")
    private String longitudeLatitude;

    /** 申报编号 */
    @Excel(name = "申报编号")
    private String declareCode;

    /** 流程实例ID */
    @Excel(name = "流程实例ID")
    private String procInsId;

    public String getProcInsId() {
        return procInsId;
    }

    public void setProcInsId(String procInsId) {
        this.procInsId = procInsId;
    }

    public void setDeclareId(Long declareId)
    {
        this.declareId = declareId;
    }

    public Long getDeclareId() 
    {
        return declareId;
    }
    public void setStatus(String Status) 
    {
        this.Status = Status;
    }

    public String getStatus() 
    {
        return Status;
    }
    public void setDeclareStatus(String declareStatus) 
    {
        this.declareStatus = declareStatus;
    }

    public String getDeclareStatus() 
    {
        return declareStatus;
    }
    public void setToponym(String toponym) 
    {
        this.toponym = toponym;
    }

    public String getToponym() 
    {
        return toponym;
    }
    public void setToponymSign(String toponymSign) 
    {
        this.toponymSign = toponymSign;
    }

    public String getToponymSign() 
    {
        return toponymSign;
    }
    public void setCode(String Code) 
    {
        this.Code = Code;
    }

    public String getCode() 
    {
        return Code;
    }
    public void setInquiryId(Long inquiryId) 
    {
        this.inquiryId = inquiryId;
    }

    public Long getInquiryId() 
    {
        return inquiryId;
    }
    public void setLongitudeLatitude(String longitudeLatitude) 
    {
        this.longitudeLatitude = longitudeLatitude;
    }

    public String getLongitudeLatitude() 
    {
        return longitudeLatitude;
    }
    public void setDeclareCode(String declareCode) 
    {
        this.declareCode = declareCode;
    }

    public String getDeclareCode() 
    {
        return declareCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("declareId", getDeclareId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("Status", getStatus())
            .append("declareStatus", getDeclareStatus())
            .append("toponym", getToponym())
            .append("toponymSign", getToponymSign())
            .append("Code", getCode())
            .append("inquiryId", getInquiryId())
            .append("longitudeLatitude", getLongitudeLatitude())
            .append("declareCode", getDeclareCode())
            .append("procInsId", getProcInsId())
            .toString();
    }
}
