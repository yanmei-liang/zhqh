package com.ruoyi.government.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 推送记录对象 DM_TSJL
 * 
 * @author ruoyi
 * @date 2024-10-24
 */
public class DmTsjl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    private Integer tsjlId;

    /** 推送名称 */
    @Excel(name = "推送名称")
    private String tsName;

    /** 类型 */
    @Excel(name = "类型")
    private String tsType;

    /** 所在区 */
    @Excel(name = "所在区")
    private String tsRegion;

    /** 所在街道 */
    @Excel(name = "所在街道")
    private String tsStreet;

    /** 发起部门 */
    @Excel(name = "发起部门")
    private String initiatingDepartment;

    /** 推送的发起部门 */
    @Excel(name = "推送的发起部门")
    private String tsDepartment;

    /** 推送时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "推送时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date pushTime;

    /** 审核结果 */
    @Excel(name = "审核结果")
    private String reviewStatus;

    public void setTsjlId(Integer tsjlId) 
    {
        this.tsjlId = tsjlId;
    }

    public Integer getTsjlId() 
    {
        return tsjlId;
    }
    public void setTsName(String tsName) 
    {
        this.tsName = tsName;
    }

    public String getTsName() 
    {
        return tsName;
    }
    public void setTsType(String tsType) 
    {
        this.tsType = tsType;
    }

    public String getTsType() 
    {
        return tsType;
    }
    public void setTsRegion(String tsRegion) 
    {
        this.tsRegion = tsRegion;
    }

    public String getTsRegion() 
    {
        return tsRegion;
    }
    public void setTsStreet(String tsStreet) 
    {
        this.tsStreet = tsStreet;
    }

    public String getTsStreet() 
    {
        return tsStreet;
    }
    public void setInitiatingDepartment(String initiatingDepartment) 
    {
        this.initiatingDepartment = initiatingDepartment;
    }

    public String getInitiatingDepartment() 
    {
        return initiatingDepartment;
    }
    public void setTsDepartment(String tsDepartment) 
    {
        this.tsDepartment = tsDepartment;
    }

    public String getTsDepartment() 
    {
        return tsDepartment;
    }
    public void setPushTime(Date pushTime) 
    {
        this.pushTime = pushTime;
    }

    public Date getPushTime() 
    {
        return pushTime;
    }
    public void setReviewStatus(String reviewStatus) 
    {
        this.reviewStatus = reviewStatus;
    }

    public String getReviewStatus() 
    {
        return reviewStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tsjlId", getTsjlId())
            .append("tsName", getTsName())
            .append("tsType", getTsType())
            .append("tsRegion", getTsRegion())
            .append("tsStreet", getTsStreet())
            .append("initiatingDepartment", getInitiatingDepartment())
            .append("tsDepartment", getTsDepartment())
            .append("pushTime", getPushTime())
            .append("reviewStatus", getReviewStatus())
            .toString();
    }
}
