package com.ruoyi.government.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 地名标志对象 DM_DMBZ
 * 
 * @author ruoyi
 * @date 2024-10-14
 */
public class DmDmbz extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long dmbzId;

    /** 标准名称 */
    @Excel(name = "标准名称")
    @Schema(description="标准名称",example="string")
    private String standardName;

    /** 设置单位 */
    @Excel(name = "设置单位")
    private String setUnit;

    /** 设立年份 */
    @Excel(name = "设立年份")
    @Schema(description="设置年份",example="2020-01-01")
    private String establishmentYear;

    /** 数据来源：字典；平台录入、市级推送、县级推送、其他 */
    @Excel(name = "数据来源：字典；平台录入、市级推送、县级推送、其他")
    private String dataSource;

    /** 标志代码 */
    @Excel(name = "标志代码")
    private String flagCode;

    /** 空间数据标识码 */
    @Excel(name = "空间数据标识码")
    private String kjCode;

    /** 地名标志代码 */
    @Excel(name = "地名标志代码")
    private String dmbzCode;

    /** 罗马字母拼写 */
    @Excel(name = "罗马字母拼写")
    private String TMLMZMPX;

    /** 行政区划名称 */
    @Excel(name = "行政区划名称")
    private String xzqhName;

    /** 行政区划代码 */
    @Excel(name = "行政区划代码")
    private String xzqhCode;

    /** 民族文字 */
    @Excel(name = "民族文字")
    private String nationalScript;

    /** 所在（跨）行政区 */
    @Excel(name = "所在", readConverterExp = "跨=")
    private String szkxzqhName;

    /** 东经 */
    @Excel(name = "东经")
    private String eastLongitude;

    /** 北纬 */
    @Excel(name = "北纬")
    private String northLatitude;

    /** 设置时间 */
    @Excel(name = "设置时间")
    private String setTime;

    /** 生产厂家 */
    @Excel(name = "生产厂家")
    private String MANUFACTURER;

    /** 材质 */
    @Excel(name = "材质")
    private String MATERIAL;

    /** 规格 */
    @Excel(name = "规格")
    private String SPECIFICATION;

    /** 标志照片文件名 */
    @Excel(name = "标志照片文件名")
    private String fileName;

    /** 登记时间 */
    @Excel(name = "登记时间")
    private String signinTime;

    /** 登记人 */
    @Excel(name = "登记人")
    private String REGISTRANT;

    /** 登记单位 */
    @Excel(name = "登记单位")
    private String registrationUnit;

    /** 审核人 */
    @Excel(name = "审核人")
    private String AUDITOR;


    /** 开始时间yyyy-MM-dd */
    @Schema(description="开始时间yyyy-MM-dd",example="2020-10-01")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;

    /** 结束时间yyyy-MM-dd */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description="结束时间yyyy-MM-dd",example="2020-10-30")
    private Date endDate;

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setDmbzId(Long dmbzId) 
    {
        this.dmbzId = dmbzId;
    }

    public Long getDmbzId() 
    {
        return dmbzId;
    }
    public void setStandardName(String standardName) 
    {
        this.standardName = standardName;
    }

    public String getStandardName() 
    {
        return standardName;
    }
    public void setSetUnit(String setUnit) 
    {
        this.setUnit = setUnit;
    }

    public String getSetUnit() 
    {
        return setUnit;
    }
    public void setEstablishmentYear(String establishmentYear) 
    {
        this.establishmentYear = establishmentYear;
    }

    public String getEstablishmentYear() 
    {
        return establishmentYear;
    }
    public void setDataSource(String dataSource) 
    {
        this.dataSource = dataSource;
    }

    public String getDataSource() 
    {
        return dataSource;
    }
    public void setFlagCode(String flagCode) 
    {
        this.flagCode = flagCode;
    }

    public String getFlagCode() 
    {
        return flagCode;
    }
    public void setKjCode(String kjCode) 
    {
        this.kjCode = kjCode;
    }

    public String getKjCode() 
    {
        return kjCode;
    }
    public void setDmbzCode(String dmbzCode) 
    {
        this.dmbzCode = dmbzCode;
    }

    public String getDmbzCode() 
    {
        return dmbzCode;
    }
    public void setTMLMZMPX(String TMLMZMPX) 
    {
        this.TMLMZMPX = TMLMZMPX;
    }

    public String getTMLMZMPX() 
    {
        return TMLMZMPX;
    }
    public void setXzqhName(String xzqhName) 
    {
        this.xzqhName = xzqhName;
    }

    public String getXzqhName() 
    {
        return xzqhName;
    }
    public void setXzqhCode(String xzqhCode) 
    {
        this.xzqhCode = xzqhCode;
    }

    public String getXzqhCode() 
    {
        return xzqhCode;
    }
    public void setNationalScript(String nationalScript) 
    {
        this.nationalScript = nationalScript;
    }

    public String getNationalScript() 
    {
        return nationalScript;
    }
    public void setSzkxzqhName(String szkxzqhName) 
    {
        this.szkxzqhName = szkxzqhName;
    }

    public String getSzkxzqhName() 
    {
        return szkxzqhName;
    }
    public void setEastLongitude(String eastLongitude) 
    {
        this.eastLongitude = eastLongitude;
    }

    public String getEastLongitude() 
    {
        return eastLongitude;
    }
    public void setNorthLatitude(String northLatitude) 
    {
        this.northLatitude = northLatitude;
    }

    public String getNorthLatitude() 
    {
        return northLatitude;
    }
    public void setSetTime(String setTime)
    {
        this.setTime = setTime;
    }

    public String getSetTime()
    {
        return setTime;
    }
    public void setMANUFACTURER(String MANUFACTURER)
    {
        this.MANUFACTURER = MANUFACTURER;
    }

    public String getMANUFACTURER() 
    {
        return MANUFACTURER;
    }
    public void setMATERIAL(String MATERIAL) 
    {
        this.MATERIAL = MATERIAL;
    }

    public String getMATERIAL() 
    {
        return MATERIAL;
    }
    public void setSPECIFICATION(String SPECIFICATION) 
    {
        this.SPECIFICATION = SPECIFICATION;
    }

    public String getSPECIFICATION() 
    {
        return SPECIFICATION;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setSigninTime(String signinTime) 
    {
        this.signinTime = signinTime;
    }

    public String getSigninTime() 
    {
        return signinTime;
    }
    public void setREGISTRANT(String REGISTRANT) 
    {
        this.REGISTRANT = REGISTRANT;
    }

    public String getREGISTRANT() 
    {
        return REGISTRANT;
    }
    public void setRegistrationUnit(String registrationUnit) 
    {
        this.registrationUnit = registrationUnit;
    }

    public String getRegistrationUnit() 
    {
        return registrationUnit;
    }
    public void setAUDITOR(String AUDITOR) 
    {
        this.AUDITOR = AUDITOR;
    }

    public String getAUDITOR() 
    {
        return AUDITOR;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dmbzId", getDmbzId())
            .append("standardName", getStandardName())
            .append("setUnit", getSetUnit())
            .append("establishmentYear", getEstablishmentYear())
            .append("dataSource", getDataSource())
            .append("flagCode", getFlagCode())
            .append("kjCode", getKjCode())
            .append("dmbzCode", getDmbzCode())
            .append("TMLMZMPX", getTMLMZMPX())
            .append("xzqhName", getXzqhName())
            .append("xzqhCode", getXzqhCode())
            .append("nationalScript", getNationalScript())
            .append("szkxzqhName", getSzkxzqhName())
            .append("eastLongitude", getEastLongitude())
            .append("northLatitude", getNorthLatitude())
            .append("setTime", getSetTime())
            .append("MANUFACTURER", getMANUFACTURER())
            .append("MATERIAL", getMATERIAL())
            .append("SPECIFICATION", getSPECIFICATION())
            .append("fileName", getFileName())
            .append("signinTime", getSigninTime())
            .append("REGISTRANT", getREGISTRANT())
            .append("registrationUnit", getRegistrationUnit())
            .append("AUDITOR", getAUDITOR())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("REMARK", getRemark())
            .toString();
    }
}
