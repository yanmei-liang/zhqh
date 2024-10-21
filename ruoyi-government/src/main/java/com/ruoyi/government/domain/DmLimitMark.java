package com.ruoyi.government.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 界桩对象 DM_LIMIT_MARK
 * 
 * @author ruoyi
 * @date 2024-10-21
 */
public class DmLimitMark extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long limitId;

    /** 界桩编号 */
    @Excel(name = "界桩编号")
    private String boundarypostNo;

    /** 界桩代码 */
    @Excel(name = "界桩代码")
    private String boundarypostCode;

    /** 空间数据标识码 */
    @Excel(name = "空间数据标识码")
    private String spatialdataCode;

    /** 界桩名称 */
    @Excel(name = "界桩名称")
    private String boundarypostName;

    /** 界桩等级(字典，省级、市级、县级、乡级、村级) */
    @Excel(name = "界桩等级(字典，省级、市级、县级、乡级、村级)")
    private String boundarypostLv;

    /** 界桩类型(单立双面性、单立三面型) */
    @Excel(name = "界桩类型(单立双面性、单立三面型)")
    private String boundarypostType;

    /** 界桩类型(物联网界桩、非物联网界桩) */
    @Excel(name = "界桩类型(物联网界桩、非物联网界桩)")
    private String boundarypostTypeTwo;

    /** 界桩材质 */
    @Excel(name = "界桩材质")
    private String boundarypostMaterial;

    /** 数据类型 */
    @Excel(name = "数据类型")
    private String informationType;

    /** 界限代码 ---    关联界限 */
    @Excel(name = "界限代码 ---    关联界限")
    private String limitCode;

    /** 是否公开 */
    @Excel(name = "是否公开")
    private Integer whetherPublicity;

    /** 界线标志区划代码-关联行政区划 */
    @Excel(name = "界线标志区划代码-关联行政区划")
    private String boundarymarkerCode;

    /** 高程 */
    @Excel(name = "高程")
    private String ELEVATION;

    /** 一号方位物理位置/名称 */
    @Excel(name = "一号方位物理位置/名称")
    private String onePhysicalposition;

    /** 一号方位物坐标方位角 */
    @Excel(name = "一号方位物坐标方位角")
    private String oneAzimuthangle;

    /** 一号方位物距离 */
    @Excel(name = "一号方位物距离")
    private String oneAzimuthDistance;

    /** 二号方位物理位置/名称 */
    @Excel(name = "二号方位物理位置/名称")
    private String twoPhysicalposition;

    /** 二号方位物坐标方位角 */
    @Excel(name = "二号方位物坐标方位角")
    private String twoAzimuthangle;

    /** 二号方位物距离 */
    @Excel(name = "二号方位物距离")
    private String twoAzimuthDistance;

    /** 三号方位物理位置/名称 */
    @Excel(name = "三号方位物理位置/名称")
    private String threePhysicalposition;

    /** 三号方位物坐标方位角 */
    @Excel(name = "三号方位物坐标方位角")
    private String threeAzimuthangle;

    /** 三号方位物距离 */
    @Excel(name = "三号方位物距离")
    private String threeAzimuthDistance;

    /** 界桩变更历史记录 */
    @Excel(name = "界桩变更历史记录")
    private String boundarypostHistoricalrecord;

    /** 界桩成果表 */
    @Excel(name = "界桩成果表")
    private String boundarypostTable;

    /** 位置描述 */
    @Excel(name = "位置描述")
    private String positionDescription;

    /** 所在地1 */
    @Excel(name = "所在地1")
    private String oneLocation;

    /** 所在地2 */
    @Excel(name = "所在地2")
    private String twoLocation;

    /** 所在地3 */
    @Excel(name = "所在地3")
    private String threeLocation;

    /** 技术负责1 */
    @Excel(name = "技术负责1")
    private String oneTechnicalresponsibility;

    /** 技术负责2 */
    @Excel(name = "技术负责2")
    private String twoTechnicalresponsibility;

    /** 技术负责3 */
    @Excel(name = "技术负责3")
    private String threeTechnicalresponsibility;

    /** 等级时间1 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "等级时间1", width = 30, dateFormat = "yyyy-MM-dd")
    private Date oneGradetime;

    /** 等级时间2 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "等级时间2", width = 30, dateFormat = "yyyy-MM-dd")
    private Date twoGradetime;

    /** 等级时间3 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "等级时间3", width = 30, dateFormat = "yyyy-MM-dd")
    private Date threeGradetime;

    /** 行政区1 */
    @Excel(name = "行政区1")
    private String oneAdministrativeregion;

    /** 行政区2 */
    @Excel(name = "行政区2")
    private String twoAdministrativeregion;

    /** 行政区3 */
    @Excel(name = "行政区3")
    private String threeAdministrativeregion;

    /** 纵坐标 */
    @Excel(name = "纵坐标")
    private String ordinate;

    /** 横坐标 */
    @Excel(name = "横坐标")
    private String abscissa;

    /** 经度 */
    @Excel(name = "经度")
    private String longitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private String latitude;

    /** 物联网设备编号 */
    @Excel(name = "物联网设备编号")
    private String equipmentNo;

    /** 物联网设备名称 */
    @Excel(name = "物联网设备名称")
    private String equipmentName;

    /** 设备状态	离线、在线 */
    @Excel(name = "设备状态	离线、在线")
    private Integer equipmentState;

    /** 最新报文时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最新报文时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastmessageTime;

    /** 是否倾斜 */
    @Excel(name = "是否倾斜")
    private Integer tiltNot;

    /** 是否低电量 */
    @Excel(name = "是否低电量")
    private Integer notPowerfailure;

    /** 漂移距离 */
    @Excel(name = "漂移距离")
    private Double driftDistance;

    /** 提示位置 */
    @Excel(name = "提示位置")
    private String promptLocation;

    /** 是否托管 */
    @Excel(name = "是否托管")
    private Integer notTrusteeship;

    /** 托管单位 */
    @Excel(name = "托管单位")
    private String trusteeshipUnit;

    /** 界桩位置略图 */
    @Excel(name = "界桩位置略图")
    private String stakepositionPicture;

    /** 界桩登记表 */
    @Excel(name = "界桩登记表")
    private String boundarypostRegistrationform;

    /** 界桩照片 */
    @Excel(name = "界桩照片")
    private String boundarypostPicture;

    /** 界桩影像 */
    @Excel(name = "界桩影像")
    private String boundarypostVideo;

    /** 三交点协议 */
    @Excel(name = "三交点协议")
    private String threeIntersectionprotocol;

    /** 三交点图片 */
    @Excel(name = "三交点图片")
    private String threeIntersectionpicture;

    /** 三交点纪要 */
    @Excel(name = "三交点纪要")
    private String threeIntersectionminutes;

    /** A方技术人员签字 */
    @Excel(name = "A方技术人员签字")
    private String aTechnicalsignature;

    /** A方勘界办人员签字 */
    @Excel(name = "A方勘界办人员签字")
    private String aBoundarysettlement;

    /** A方签字时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "A方签字时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date aSignaturetime;

    /** B方技术人员签字 */
    @Excel(name = "B方技术人员签字")
    private String bTechnicalsignature;

    /** B方勘界办人员签字 */
    @Excel(name = "B方勘界办人员签字")
    private String bBoundarysettlement;

    /** B方签字时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "B方签字时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date bSignaturetime;

    /** C方技术人员签字 */
    @Excel(name = "C方技术人员签字")
    private String cTechnicalsignature;

    /** C方勘界办人员签字 */
    @Excel(name = "C方勘界办人员签字")
    private String cBoundarysettlement;

    /** C方签字时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "C方签字时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cSignaturetime;

    /** 其他附件 */
    @Excel(name = "其他附件")
    private String otherAccessories;

    /** 其他信息 */
    @Excel(name = "其他信息")
    private String otherInformation;


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

    public void setLimitId(Long limitId) 
    {
        this.limitId = limitId;
    }

    public Long getLimitId() 
    {
        return limitId;
    }
    public void setBoundarypostNo(String boundarypostNo) 
    {
        this.boundarypostNo = boundarypostNo;
    }

    public String getBoundarypostNo() 
    {
        return boundarypostNo;
    }
    public void setBoundarypostCode(String boundarypostCode) 
    {
        this.boundarypostCode = boundarypostCode;
    }

    public String getBoundarypostCode() 
    {
        return boundarypostCode;
    }
    public void setSpatialdataCode(String spatialdataCode) 
    {
        this.spatialdataCode = spatialdataCode;
    }

    public String getSpatialdataCode() 
    {
        return spatialdataCode;
    }
    public void setBoundarypostName(String boundarypostName) 
    {
        this.boundarypostName = boundarypostName;
    }

    public String getBoundarypostName() 
    {
        return boundarypostName;
    }
    public void setBoundarypostLv(String boundarypostLv) 
    {
        this.boundarypostLv = boundarypostLv;
    }

    public String getBoundarypostLv() 
    {
        return boundarypostLv;
    }
    public void setBoundarypostType(String boundarypostType) 
    {
        this.boundarypostType = boundarypostType;
    }

    public String getBoundarypostType() 
    {
        return boundarypostType;
    }
    public void setBoundarypostTypeTwo(String boundarypostTypeTwo) 
    {
        this.boundarypostTypeTwo = boundarypostTypeTwo;
    }

    public String getBoundarypostTypeTwo() 
    {
        return boundarypostTypeTwo;
    }
    public void setBoundarypostMaterial(String boundarypostMaterial) 
    {
        this.boundarypostMaterial = boundarypostMaterial;
    }

    public String getBoundarypostMaterial() 
    {
        return boundarypostMaterial;
    }
    public void setInformationType(String informationType) 
    {
        this.informationType = informationType;
    }

    public String getInformationType() 
    {
        return informationType;
    }
    public void setLimitCode(String limitCode) 
    {
        this.limitCode = limitCode;
    }

    public String getLimitCode() 
    {
        return limitCode;
    }
    public void setWhetherPublicity(Integer whetherPublicity) 
    {
        this.whetherPublicity = whetherPublicity;
    }

    public Integer getWhetherPublicity() 
    {
        return whetherPublicity;
    }
    public void setBoundarymarkerCode(String boundarymarkerCode) 
    {
        this.boundarymarkerCode = boundarymarkerCode;
    }

    public String getBoundarymarkerCode() 
    {
        return boundarymarkerCode;
    }
    public void setELEVATION(String ELEVATION) 
    {
        this.ELEVATION = ELEVATION;
    }

    public String getELEVATION() 
    {
        return ELEVATION;
    }
    public void setOnePhysicalposition(String onePhysicalposition) 
    {
        this.onePhysicalposition = onePhysicalposition;
    }

    public String getOnePhysicalposition() 
    {
        return onePhysicalposition;
    }
    public void setOneAzimuthangle(String oneAzimuthangle) 
    {
        this.oneAzimuthangle = oneAzimuthangle;
    }

    public String getOneAzimuthangle() 
    {
        return oneAzimuthangle;
    }
    public void setOneAzimuthDistance(String oneAzimuthDistance) 
    {
        this.oneAzimuthDistance = oneAzimuthDistance;
    }

    public String getOneAzimuthDistance() 
    {
        return oneAzimuthDistance;
    }
    public void setTwoPhysicalposition(String twoPhysicalposition) 
    {
        this.twoPhysicalposition = twoPhysicalposition;
    }

    public String getTwoPhysicalposition() 
    {
        return twoPhysicalposition;
    }
    public void setTwoAzimuthangle(String twoAzimuthangle) 
    {
        this.twoAzimuthangle = twoAzimuthangle;
    }

    public String getTwoAzimuthangle() 
    {
        return twoAzimuthangle;
    }
    public void setTwoAzimuthDistance(String twoAzimuthDistance) 
    {
        this.twoAzimuthDistance = twoAzimuthDistance;
    }

    public String getTwoAzimuthDistance() 
    {
        return twoAzimuthDistance;
    }
    public void setThreePhysicalposition(String threePhysicalposition) 
    {
        this.threePhysicalposition = threePhysicalposition;
    }

    public String getThreePhysicalposition() 
    {
        return threePhysicalposition;
    }
    public void setThreeAzimuthangle(String threeAzimuthangle) 
    {
        this.threeAzimuthangle = threeAzimuthangle;
    }

    public String getThreeAzimuthangle() 
    {
        return threeAzimuthangle;
    }
    public void setThreeAzimuthDistance(String threeAzimuthDistance) 
    {
        this.threeAzimuthDistance = threeAzimuthDistance;
    }

    public String getThreeAzimuthDistance() 
    {
        return threeAzimuthDistance;
    }
    public void setBoundarypostHistoricalrecord(String boundarypostHistoricalrecord) 
    {
        this.boundarypostHistoricalrecord = boundarypostHistoricalrecord;
    }

    public String getBoundarypostHistoricalrecord() 
    {
        return boundarypostHistoricalrecord;
    }
    public void setBoundarypostTable(String boundarypostTable) 
    {
        this.boundarypostTable = boundarypostTable;
    }

    public String getBoundarypostTable() 
    {
        return boundarypostTable;
    }
    public void setPositionDescription(String positionDescription) 
    {
        this.positionDescription = positionDescription;
    }

    public String getPositionDescription() 
    {
        return positionDescription;
    }
    public void setOneLocation(String oneLocation) 
    {
        this.oneLocation = oneLocation;
    }

    public String getOneLocation() 
    {
        return oneLocation;
    }
    public void setTwoLocation(String twoLocation) 
    {
        this.twoLocation = twoLocation;
    }

    public String getTwoLocation() 
    {
        return twoLocation;
    }
    public void setThreeLocation(String threeLocation) 
    {
        this.threeLocation = threeLocation;
    }

    public String getThreeLocation() 
    {
        return threeLocation;
    }
    public void setOneTechnicalresponsibility(String oneTechnicalresponsibility) 
    {
        this.oneTechnicalresponsibility = oneTechnicalresponsibility;
    }

    public String getOneTechnicalresponsibility() 
    {
        return oneTechnicalresponsibility;
    }
    public void setTwoTechnicalresponsibility(String twoTechnicalresponsibility) 
    {
        this.twoTechnicalresponsibility = twoTechnicalresponsibility;
    }

    public String getTwoTechnicalresponsibility() 
    {
        return twoTechnicalresponsibility;
    }
    public void setThreeTechnicalresponsibility(String threeTechnicalresponsibility) 
    {
        this.threeTechnicalresponsibility = threeTechnicalresponsibility;
    }

    public String getThreeTechnicalresponsibility() 
    {
        return threeTechnicalresponsibility;
    }
    public void setOneGradetime(Date oneGradetime) 
    {
        this.oneGradetime = oneGradetime;
    }

    public Date getOneGradetime() 
    {
        return oneGradetime;
    }
    public void setTwoGradetime(Date twoGradetime) 
    {
        this.twoGradetime = twoGradetime;
    }

    public Date getTwoGradetime() 
    {
        return twoGradetime;
    }
    public void setThreeGradetime(Date threeGradetime) 
    {
        this.threeGradetime = threeGradetime;
    }

    public Date getThreeGradetime() 
    {
        return threeGradetime;
    }
    public void setOneAdministrativeregion(String oneAdministrativeregion) 
    {
        this.oneAdministrativeregion = oneAdministrativeregion;
    }

    public String getOneAdministrativeregion() 
    {
        return oneAdministrativeregion;
    }
    public void setTwoAdministrativeregion(String twoAdministrativeregion) 
    {
        this.twoAdministrativeregion = twoAdministrativeregion;
    }

    public String getTwoAdministrativeregion() 
    {
        return twoAdministrativeregion;
    }
    public void setThreeAdministrativeregion(String threeAdministrativeregion) 
    {
        this.threeAdministrativeregion = threeAdministrativeregion;
    }

    public String getThreeAdministrativeregion() 
    {
        return threeAdministrativeregion;
    }
    public void setORDINATE(String ORDINATE) 
    {
        this.ordinate = ORDINATE;
    }

    public String getORDINATE() 
    {
        return ordinate;
    }
    public void setABSCISSA(String ABSCISSA) 
    {
        this.abscissa = ABSCISSA;
    }

    public String getABSCISSA() 
    {
        return abscissa;
    }
    public void setLONGITUDE(String LONGITUDE) 
    {
        this.longitude = LONGITUDE;
    }

    public String getLONGITUDE() 
    {
        return longitude;
    }
    public void setLATITUDE(String LATITUDE) 
    {
        this.latitude = LATITUDE;
    }

    public String getLATITUDE() 
    {
        return latitude;
    }
    public void setEquipmentNo(String equipmentNo) 
    {
        this.equipmentNo = equipmentNo;
    }

    public String getEquipmentNo() 
    {
        return equipmentNo;
    }
    public void setEquipmentName(String equipmentName) 
    {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentName() 
    {
        return equipmentName;
    }
    public void setEquipmentState(Integer equipmentState) 
    {
        this.equipmentState = equipmentState;
    }

    public Integer getEquipmentState() 
    {
        return equipmentState;
    }
    public void setLastmessageTime(Date lastmessageTime) 
    {
        this.lastmessageTime = lastmessageTime;
    }

    public Date getLastmessageTime() 
    {
        return lastmessageTime;
    }
    public void setTiltNot(Integer tiltNot) 
    {
        this.tiltNot = tiltNot;
    }

    public Integer getTiltNot() 
    {
        return tiltNot;
    }
    public void setNotPowerfailure(Integer notPowerfailure) 
    {
        this.notPowerfailure = notPowerfailure;
    }

    public Integer getNotPowerfailure() 
    {
        return notPowerfailure;
    }
    public void setDriftDistance(Double driftDistance) 
    {
        this.driftDistance = driftDistance;
    }

    public Double getDriftDistance() 
    {
        return driftDistance;
    }
    public void setPromptLocation(String promptLocation) 
    {
        this.promptLocation = promptLocation;
    }

    public String getPromptLocation() 
    {
        return promptLocation;
    }
    public void setNotTrusteeship(Integer notTrusteeship) 
    {
        this.notTrusteeship = notTrusteeship;
    }

    public Integer getNotTrusteeship() 
    {
        return notTrusteeship;
    }
    public void setTrusteeshipUnit(String trusteeshipUnit) 
    {
        this.trusteeshipUnit = trusteeshipUnit;
    }

    public String getTrusteeshipUnit() 
    {
        return trusteeshipUnit;
    }
    public void setStakepositionPicture(String stakepositionPicture) 
    {
        this.stakepositionPicture = stakepositionPicture;
    }

    public String getStakepositionPicture() 
    {
        return stakepositionPicture;
    }
    public void setBoundarypostRegistrationform(String boundarypostRegistrationform) 
    {
        this.boundarypostRegistrationform = boundarypostRegistrationform;
    }

    public String getBoundarypostRegistrationform() 
    {
        return boundarypostRegistrationform;
    }
    public void setBoundarypostPicture(String boundarypostPicture) 
    {
        this.boundarypostPicture = boundarypostPicture;
    }

    public String getBoundarypostPicture() 
    {
        return boundarypostPicture;
    }
    public void setBoundarypostVideo(String boundarypostVideo) 
    {
        this.boundarypostVideo = boundarypostVideo;
    }

    public String getBoundarypostVideo() 
    {
        return boundarypostVideo;
    }
    public void setThreeIntersectionprotocol(String threeIntersectionprotocol) 
    {
        this.threeIntersectionprotocol = threeIntersectionprotocol;
    }

    public String getThreeIntersectionprotocol() 
    {
        return threeIntersectionprotocol;
    }
    public void setThreeIntersectionpicture(String threeIntersectionpicture) 
    {
        this.threeIntersectionpicture = threeIntersectionpicture;
    }

    public String getThreeIntersectionpicture() 
    {
        return threeIntersectionpicture;
    }
    public void setThreeIntersectionminutes(String threeIntersectionminutes) 
    {
        this.threeIntersectionminutes = threeIntersectionminutes;
    }

    public String getThreeIntersectionminutes() 
    {
        return threeIntersectionminutes;
    }
    public void setaTechnicalsignature(String aTechnicalsignature) 
    {
        this.aTechnicalsignature = aTechnicalsignature;
    }

    public String getaTechnicalsignature() 
    {
        return aTechnicalsignature;
    }
    public void setaBoundarysettlement(String aBoundarysettlement) 
    {
        this.aBoundarysettlement = aBoundarysettlement;
    }

    public String getaBoundarysettlement() 
    {
        return aBoundarysettlement;
    }
    public void setaSignaturetime(Date aSignaturetime) 
    {
        this.aSignaturetime = aSignaturetime;
    }

    public Date getaSignaturetime() 
    {
        return aSignaturetime;
    }
    public void setbTechnicalsignature(String bTechnicalsignature) 
    {
        this.bTechnicalsignature = bTechnicalsignature;
    }

    public String getbTechnicalsignature() 
    {
        return bTechnicalsignature;
    }
    public void setbBoundarysettlement(String bBoundarysettlement) 
    {
        this.bBoundarysettlement = bBoundarysettlement;
    }

    public String getbBoundarysettlement() 
    {
        return bBoundarysettlement;
    }
    public void setbSignaturetime(Date bSignaturetime) 
    {
        this.bSignaturetime = bSignaturetime;
    }

    public Date getbSignaturetime() 
    {
        return bSignaturetime;
    }
    public void setcTechnicalsignature(String cTechnicalsignature) 
    {
        this.cTechnicalsignature = cTechnicalsignature;
    }

    public String getcTechnicalsignature() 
    {
        return cTechnicalsignature;
    }
    public void setcBoundarysettlement(String cBoundarysettlement) 
    {
        this.cBoundarysettlement = cBoundarysettlement;
    }

    public String getcBoundarysettlement() 
    {
        return cBoundarysettlement;
    }
    public void setcSignaturetime(Date cSignaturetime) 
    {
        this.cSignaturetime = cSignaturetime;
    }

    public Date getcSignaturetime() 
    {
        return cSignaturetime;
    }
    public void setOtherAccessories(String otherAccessories) 
    {
        this.otherAccessories = otherAccessories;
    }

    public String getOtherAccessories() 
    {
        return otherAccessories;
    }
    public void setOtherInformation(String otherInformation) 
    {
        this.otherInformation = otherInformation;
    }

    public String getOtherInformation() 
    {
        return otherInformation;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("limitId", getLimitId())
            .append("boundarypostNo", getBoundarypostNo())
            .append("boundarypostCode", getBoundarypostCode())
            .append("spatialdataCode", getSpatialdataCode())
            .append("boundarypostName", getBoundarypostName())
            .append("boundarypostLv", getBoundarypostLv())
            .append("boundarypostType", getBoundarypostType())
            .append("boundarypostTypeTwo", getBoundarypostTypeTwo())
            .append("boundarypostMaterial", getBoundarypostMaterial())
            .append("informationType", getInformationType())
            .append("limitCode", getLimitCode())
            .append("whetherPublicity", getWhetherPublicity())
            .append("boundarymarkerCode", getBoundarymarkerCode())
            .append("ELEVATION", getELEVATION())
            .append("onePhysicalposition", getOnePhysicalposition())
            .append("oneAzimuthangle", getOneAzimuthangle())
            .append("oneAzimuthDistance", getOneAzimuthDistance())
            .append("twoPhysicalposition", getTwoPhysicalposition())
            .append("twoAzimuthangle", getTwoAzimuthangle())
            .append("twoAzimuthDistance", getTwoAzimuthDistance())
            .append("threePhysicalposition", getThreePhysicalposition())
            .append("threeAzimuthangle", getThreeAzimuthangle())
            .append("threeAzimuthDistance", getThreeAzimuthDistance())
            .append("boundarypostHistoricalrecord", getBoundarypostHistoricalrecord())
            .append("boundarypostTable", getBoundarypostTable())
            .append("positionDescription", getPositionDescription())
            .append("oneLocation", getOneLocation())
            .append("twoLocation", getTwoLocation())
            .append("threeLocation", getThreeLocation())
            .append("oneTechnicalresponsibility", getOneTechnicalresponsibility())
            .append("twoTechnicalresponsibility", getTwoTechnicalresponsibility())
            .append("threeTechnicalresponsibility", getThreeTechnicalresponsibility())
            .append("oneGradetime", getOneGradetime())
            .append("twoGradetime", getTwoGradetime())
            .append("threeGradetime", getThreeGradetime())
            .append("oneAdministrativeregion", getOneAdministrativeregion())
            .append("twoAdministrativeregion", getTwoAdministrativeregion())
            .append("threeAdministrativeregion", getThreeAdministrativeregion())
            .append("ordinate", getORDINATE())
            .append("abscissa", getABSCISSA())
            .append("longitude", getLONGITUDE())
            .append("latitude", getLATITUDE())
            .append("equipmentNo", getEquipmentNo())
            .append("equipmentName", getEquipmentName())
            .append("equipmentState", getEquipmentState())
            .append("lastmessageTime", getLastmessageTime())
            .append("tiltNot", getTiltNot())
            .append("notPowerfailure", getNotPowerfailure())
            .append("driftDistance", getDriftDistance())
            .append("promptLocation", getPromptLocation())
            .append("notTrusteeship", getNotTrusteeship())
            .append("trusteeshipUnit", getTrusteeshipUnit())
            .append("stakepositionPicture", getStakepositionPicture())
            .append("boundarypostRegistrationform", getBoundarypostRegistrationform())
            .append("boundarypostPicture", getBoundarypostPicture())
            .append("boundarypostVideo", getBoundarypostVideo())
            .append("threeIntersectionprotocol", getThreeIntersectionprotocol())
            .append("threeIntersectionpicture", getThreeIntersectionpicture())
            .append("threeIntersectionminutes", getThreeIntersectionminutes())
            .append("aTechnicalsignature", getaTechnicalsignature())
            .append("aBoundarysettlement", getaBoundarysettlement())
            .append("aSignaturetime", getaSignaturetime())
            .append("bTechnicalsignature", getbTechnicalsignature())
            .append("bBoundarysettlement", getbBoundarysettlement())
            .append("bSignaturetime", getbSignaturetime())
            .append("cTechnicalsignature", getcTechnicalsignature())
            .append("cBoundarysettlement", getcBoundarysettlement())
            .append("cSignaturetime", getcSignaturetime())
            .append("otherAccessories", getOtherAccessories())
            .append("otherInformation", getOtherInformation())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
