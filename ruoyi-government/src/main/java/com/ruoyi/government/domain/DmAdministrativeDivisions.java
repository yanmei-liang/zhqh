package com.ruoyi.government.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 行政区划对象 DM_ADMINISTRATIVE_DIVISIONS
 * 
 * @author ruoyi
 * @date 2024-10-14
 */
public class DmAdministrativeDivisions extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long ID;

    /** 行政区划名称 */
    @Excel(name = "行政区划名称")
    @Schema(description="行政区划名称，模糊匹配",example="yuda0")
    private String administrativeDivisionName;

    /** 行政区划代码 */
    @Excel(name = "行政区划代码")
    @Schema(description="行政区划代码",example="420000")
    private String administrativeDivisionCode;

    /** 驻地地址 */
    @Excel(name = "驻地地址")
    @Schema(description="驻地地址",example="湖北省")
    private String address;

    /** 面积（km2） */
    @Excel(name = "面积", readConverterExp = "k=m2")
    @Schema(description="面积",example="42.1")
    private Double area;

    /** 邮政编码 */
    @Excel(name = "邮政编码")
    @Schema(description="邮政编码")
    private String postalCode;

    /** 行政级别(数据字典，地级市、区、县、乡、村) */
    @Excel(name = "行政级别(数据字典，地级市、区、县、乡、村)")
    @Schema(description="行政级别",example="地级市")
    private String administrativeLevel;

    /** 上一级区划名称 */
    @Excel(name = "上一级区划名称")
    @Schema(description="上一级区划名称")
    private String superiorsName;

    /** 上一级区划代码 */
    @Excel(name = "上一级区划代码")
    @Schema(description="上一级区划代码")
    private String superiorsCode;

    /** 单位网站 */
    @Excel(name = "单位网站")
    @Schema(description="单位网站",example="www.ss.com")
    private String unitWebsite;

    /** 联系电话 */
    @Excel(name = "联系电话")
    @Schema(description="联系电话",example="181xxxx0212")
    private String contactNumber;

    /** 附件，多媒体照片 */
    @Excel(name = "附件，多媒体照片")
    @Schema(description="附件，多媒体照片",example="181xxxx0212")
    private String attachments;

    /** 多媒体视频 */
    @Excel(name = "多媒体视频")
    @Schema(description="多媒体视频",example="181xxxx0212")
    private String multimediaVideo;

    /** 原读音 */
    @Excel(name = "原读音")
    @Schema(description="原读音",example="181xxxx0212")
    private String originalPronunciation;

    /** 其他附件 */
    @Excel(name = "其他附件")
    @Schema(description="其他附件",example="181xxxx0212")
    private String otherAccessories;

    /** 地理位置信息 */
    @Excel(name = "地理位置信息")
    @Schema(description="地理位置信息",example="181xxxx0212")
    private String geographicalpositionMsg;

    /** 开始时间yyyy-MM-dd */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description="开始时间yyyy-MM-dd",example="2020-10-01")
    private Date beginDate;

    /** 结束时间yyyy-MM-dd */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description="结束时间yyyy-MM-dd",example="2020-10-30")
    private Date endDate;

    public void setID(Long ID)
    {
        this.ID = ID;
    }

    public Long getID() 
    {
        return ID;
    }
    public void setAdministrativeDivisionName(String administrativeDivisionName) 
    {
        this.administrativeDivisionName = administrativeDivisionName;
    }

    public String getAdministrativeDivisionName() 
    {
        return administrativeDivisionName;
    }
    public void setAdministrativeDivisionCode(String administrativeDivisionCode) 
    {
        this.administrativeDivisionCode = administrativeDivisionCode;
    }

    public String getAdministrativeDivisionCode() 
    {
        return administrativeDivisionCode;
    }
    public void setADDRESS(String ADDRESS) 
    {
        this.address = ADDRESS;
    }

    public String getADDRESS() 
    {
        return address;
    }
    public void setAREA(Double AREA) 
    {
        this.area = AREA;
    }

    public Double getAREA() 
    {
        return area;
    }
    public void setPostalCode(String postalCode) 
    {
        this.postalCode = postalCode;
    }

    public String getPostalCode() 
    {
        return postalCode;
    }
    public void setAdministrativeLevel(String administrativeLevel) 
    {
        this.administrativeLevel = administrativeLevel;
    }

    public String getAdministrativeLevel() 
    {
        return administrativeLevel;
    }
    public void setSuperiorsName(String superiorsName) 
    {
        this.superiorsName = superiorsName;
    }

    public String getSuperiorsName() 
    {
        return superiorsName;
    }
    public void setSuperiorsCode(String superiorsCode) 
    {
        this.superiorsCode = superiorsCode;
    }

    public String getSuperiorsCode() 
    {
        return superiorsCode;
    }
    public void setUnitWebsite(String unitWebsite) 
    {
        this.unitWebsite = unitWebsite;
    }

    public String getUnitWebsite() 
    {
        return unitWebsite;
    }
    public void setContactNumber(String contactNumber) 
    {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber() 
    {
        return contactNumber;
    }
    public void setATTACHMENTS(String ATTACHMENTS) 
    {
        this.attachments = ATTACHMENTS;
    }

    public String getATTACHMENTS() 
    {
        return attachments;
    }
    public void setMultimediaVideo(String multimediaVideo) 
    {
        this.multimediaVideo = multimediaVideo;
    }

    public String getMultimediaVideo() 
    {
        return multimediaVideo;
    }
    public void setOriginalPronunciation(String originalPronunciation) 
    {
        this.originalPronunciation = originalPronunciation;
    }

    public String getOriginalPronunciation() 
    {
        return originalPronunciation;
    }
    public void setOtherAccessories(String otherAccessories) 
    {
        this.otherAccessories = otherAccessories;
    }

    public String getOtherAccessories() 
    {
        return otherAccessories;
    }
    public void setGeographicalpositionMsg(String geographicalpositionMsg) 
    {
        this.geographicalpositionMsg = geographicalpositionMsg;
    }

    public String getGeographicalpositionMsg() 
    {
        return geographicalpositionMsg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ID", getID())
            .append("administrativeDivisionName", getAdministrativeDivisionName())
            .append("administrativeDivisionCode", getAdministrativeDivisionCode())
            .append("ADDRESS", getADDRESS())
            .append("AREA", getAREA())
            .append("postalCode", getPostalCode())
            .append("administrativeLevel", getAdministrativeLevel())
            .append("superiorsName", getSuperiorsName())
            .append("superiorsCode", getSuperiorsCode())
            .append("unitWebsite", getUnitWebsite())
            .append("contactNumber", getContactNumber())
            .append("ATTACHMENTS", getATTACHMENTS())
            .append("multimediaVideo", getMultimediaVideo())
            .append("originalPronunciation", getOriginalPronunciation())
            .append("otherAccessories", getOtherAccessories())
            .append("geographicalpositionMsg", getGeographicalpositionMsg())
            .append("REMARK", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
