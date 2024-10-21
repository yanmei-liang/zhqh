package com.ruoyi.government.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 行政界线对象 DM_ADMINISTRATIVE_BOUNDARY
 * 
 * @author ruoyi
 * @date 2024-10-14
 */
public class DmAdministrativeBoundary extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long boundaryId;

    /** 空间数据标识码 */
    @Excel(name = "空间数据标识码")
    private String spatialdataCode;

    /** 界限名称 */
    @Schema(description="界限名称",example="name")
    @Excel(name = "界限名称")
    private String boundarylineName;

    /** 界限代码 */
    @Excel(name = "界限代码")
    @Schema(description="界限代码",example="1")
    private String boundarylineCode;

    /** 界限等级 */
    @Excel(name = "界限等级")
    @Schema(description="界限等级",example="乡级")
    private String boundarylineLv;

    /** 界线区划编码 */
    @Excel(name = "界线区划编码")
    private String boundaryzoningCode;

    /** 界线区划名称 */
    @Excel(name = "界线区划名称")
    private String boundaryzoningName;

    /** 界线长度（km） */
    @Excel(name = "界线长度", readConverterExp = "k=m")
    private Double boundaryLength;

    /** 地理位置信息 */
    @Excel(name = "地理位置信息")
    private String geographicalpositionMsg;

    /** 界线起点 */
    @Excel(name = "界线起点")
    private String boundarylineStart;

    /** 界限终点 */
    @Excel(name = "界限终点")
    private String boundarylineEnd;

    /** 上级对勘界方案批复(文件) */
    @Excel(name = "上级对勘界方案批复(文件)")
    private String superiorExamine;

    /** 上报联合勘界方案请示 */
    @Excel(name = "上报联合勘界方案请示")
    private String superiorInstructions;

    /** 联合勘界方案 */
    @Excel(name = "联合勘界方案")
    private String demarcationProgramme;

    /** 历次协商会议纪要 */
    @Excel(name = "历次协商会议纪要")
    private String meetingMinutes;

    /** 历次协商会议协议 */
    @Excel(name = "历次协商会议协议")
    private String meetingAgreement;

    /** 历次协商会议附图 */
    @Excel(name = "历次协商会议附图")
    private String meetingPicture;

    /** 勘界工作总结 */
    @Excel(name = "勘界工作总结")
    private String workSummary;

    /** 上级地协议书批复 */
    @Excel(name = "上级地协议书批复")
    private String superiorAgreementExamine;

    /** 双放报批协议书请示 */
    @Excel(name = "双放报批协议书请示")
    private String landagreementInstructions;

    /** 边界线协议书 */
    @Excel(name = "边界线协议书")
    private String boundaryAgreement;

    /** 报送协议书请示 */
    @Excel(name = "报送协议书请示")
    private String agreementApplyfor;

    /** 起草协议书说明 */
    @Excel(name = "起草协议书说明")
    private String agreementInstructions;

    /** 边界协议书附图 */
    @Excel(name = "边界协议书附图")
    private String agreementPicture;

    /** 界限变更历史记录 */
    @Excel(name = "界限变更历史记录")
    private String boundarychangeHistory;

    /** 设立时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "设立时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date setTime;

    /** 是否争议 */
    @Excel(name = "是否争议")
    private Integer disputeorNot;

    /** 数据状态 */
    @Excel(name = "数据状态")
    private Integer informationState;

    /** 字典，初始导入，市级推送，县级推送、其他 */
    @Excel(name = "字典，初始导入，市级推送，县级推送、其他")
    private String informationSource;

    /** 界桩颗数 */
    @Excel(name = "界桩颗数")
    private Integer boundarypostQuantity;

    /** 单立柱颗数 */
    @Excel(name = "单立柱颗数")
    private Integer singlecolumnQuantity;

    /** 双立柱颗数 */
    @Excel(name = "双立柱颗数")
    private Integer doublecolumnQuantity;

    /** 三立柱颗数 */
    @Excel(name = "三立柱颗数")
    private Integer threecolumnQuantity;

    /** 其他信息 */
    @Excel(name = "其他信息")
    private String otherInformation;

    /** 多媒体照片 */
    @Excel(name = "多媒体照片")
    private String multimediaPhoto;

    /** 多媒体视频 */
    @Excel(name = "多媒体视频")
    private String multimediaVideo;

    /** 边界协议书附件 */
    @Excel(name = "边界协议书附件")
    private String boundaryagreementDocument;

    /** 边界协议书附图 */
    @Excel(name = "边界协议书附图")
    private String boundaryagreementPicture;

    /** 界桩成果表 */
    @Excel(name = "界桩成果表")
    private String boundarypostTable;

    /** 年检联检报告 */
    @Excel(name = "年检联检报告")
    private String annualinspectionReport;

    /** 年检联检方案 */
    @Excel(name = "年检联检方案")
    private String annualinspectionPlan;

    /** 年检联检问题处理成果 */
    @Excel(name = "年检联检问题处理成果")
    private String processingResult;

    /** 年检联检成果 */
    @Excel(name = "年检联检成果")
    private String annualinspectionResult;

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

    public void setBoundaryId(Long boundaryId) 
    {
        this.boundaryId = boundaryId;
    }

    public Long getBoundaryId() 
    {
        return boundaryId;
    }
    public void setSpatialdataCode(String spatialdataCode) 
    {
        this.spatialdataCode = spatialdataCode;
    }

    public String getSpatialdataCode() 
    {
        return spatialdataCode;
    }
    public void setBoundarylineName(String boundarylineName) 
    {
        this.boundarylineName = boundarylineName;
    }

    public String getBoundarylineName() 
    {
        return boundarylineName;
    }
    public void setBoundarylineCode(String boundarylineCode) 
    {
        this.boundarylineCode = boundarylineCode;
    }

    public String getBoundarylineCode() 
    {
        return boundarylineCode;
    }
    public void setBoundarylineLv(String boundarylineLv) 
    {
        this.boundarylineLv = boundarylineLv;
    }

    public String getBoundarylineLv() 
    {
        return boundarylineLv;
    }
    public void setBoundaryzoningCode(String boundaryzoningCode) 
    {
        this.boundaryzoningCode = boundaryzoningCode;
    }

    public String getBoundaryzoningCode() 
    {
        return boundaryzoningCode;
    }
    public void setBoundaryzoningName(String boundaryzoningName) 
    {
        this.boundaryzoningName = boundaryzoningName;
    }

    public String getBoundaryzoningName() 
    {
        return boundaryzoningName;
    }
    public void setBoundaryLength(Double boundaryLength) 
    {
        this.boundaryLength = boundaryLength;
    }

    public Double getBoundaryLength() 
    {
        return boundaryLength;
    }
    public void setGeographicalpositionMsg(String geographicalpositionMsg) 
    {
        this.geographicalpositionMsg = geographicalpositionMsg;
    }

    public String getGeographicalpositionMsg() 
    {
        return geographicalpositionMsg;
    }
    public void setBoundarylineStart(String boundarylineStart) 
    {
        this.boundarylineStart = boundarylineStart;
    }

    public String getBoundarylineStart() 
    {
        return boundarylineStart;
    }
    public void setBoundarylineEnd(String boundarylineEnd) 
    {
        this.boundarylineEnd = boundarylineEnd;
    }

    public String getBoundarylineEnd() 
    {
        return boundarylineEnd;
    }
    public void setSuperiorExamine(String superiorExamine) 
    {
        this.superiorExamine = superiorExamine;
    }

    public String getSuperiorExamine() 
    {
        return superiorExamine;
    }
    public void setSuperiorInstructions(String superiorInstructions) 
    {
        this.superiorInstructions = superiorInstructions;
    }

    public String getSuperiorInstructions() 
    {
        return superiorInstructions;
    }
    public void setDemarcationProgramme(String demarcationProgramme) 
    {
        this.demarcationProgramme = demarcationProgramme;
    }

    public String getDemarcationProgramme() 
    {
        return demarcationProgramme;
    }
    public void setMeetingMinutes(String meetingMinutes) 
    {
        this.meetingMinutes = meetingMinutes;
    }

    public String getMeetingMinutes() 
    {
        return meetingMinutes;
    }
    public void setMeetingAgreement(String meetingAgreement) 
    {
        this.meetingAgreement = meetingAgreement;
    }

    public String getMeetingAgreement() 
    {
        return meetingAgreement;
    }
    public void setMeetingPicture(String meetingPicture) 
    {
        this.meetingPicture = meetingPicture;
    }

    public String getMeetingPicture() 
    {
        return meetingPicture;
    }
    public void setWorkSummary(String workSummary) 
    {
        this.workSummary = workSummary;
    }

    public String getWorkSummary() 
    {
        return workSummary;
    }
    public void setSuperiorAgreementExamine(String superiorAgreementExamine) 
    {
        this.superiorAgreementExamine = superiorAgreementExamine;
    }

    public String getSuperiorAgreementExamine() 
    {
        return superiorAgreementExamine;
    }
    public void setLandagreementInstructions(String landagreementInstructions) 
    {
        this.landagreementInstructions = landagreementInstructions;
    }

    public String getLandagreementInstructions() 
    {
        return landagreementInstructions;
    }
    public void setBoundaryAgreement(String boundaryAgreement) 
    {
        this.boundaryAgreement = boundaryAgreement;
    }

    public String getBoundaryAgreement() 
    {
        return boundaryAgreement;
    }
    public void setAgreementApplyfor(String agreementApplyfor) 
    {
        this.agreementApplyfor = agreementApplyfor;
    }

    public String getAgreementApplyfor() 
    {
        return agreementApplyfor;
    }
    public void setAgreementInstructions(String agreementInstructions) 
    {
        this.agreementInstructions = agreementInstructions;
    }

    public String getAgreementInstructions() 
    {
        return agreementInstructions;
    }
    public void setAgreementPicture(String agreementPicture) 
    {
        this.agreementPicture = agreementPicture;
    }

    public String getAgreementPicture() 
    {
        return agreementPicture;
    }
    public void setBoundarychangeHistory(String boundarychangeHistory) 
    {
        this.boundarychangeHistory = boundarychangeHistory;
    }

    public String getBoundarychangeHistory() 
    {
        return boundarychangeHistory;
    }
    public void setSetTime(Date setTime) 
    {
        this.setTime = setTime;
    }

    public Date getSetTime() 
    {
        return setTime;
    }
    public void setDisputeorNot(Integer disputeorNot) 
    {
        this.disputeorNot = disputeorNot;
    }

    public Integer getDisputeorNot() 
    {
        return disputeorNot;
    }
    public void setInformationState(Integer informationState) 
    {
        this.informationState = informationState;
    }

    public Integer getInformationState() 
    {
        return informationState;
    }
    public void setInformationSource(String informationSource) 
    {
        this.informationSource = informationSource;
    }

    public String getInformationSource() 
    {
        return informationSource;
    }
    public void setBoundarypostQuantity(Integer boundarypostQuantity) 
    {
        this.boundarypostQuantity = boundarypostQuantity;
    }

    public Integer getBoundarypostQuantity() 
    {
        return boundarypostQuantity;
    }
    public void setSinglecolumnQuantity(Integer singlecolumnQuantity) 
    {
        this.singlecolumnQuantity = singlecolumnQuantity;
    }

    public Integer getSinglecolumnQuantity() 
    {
        return singlecolumnQuantity;
    }
    public void setDoublecolumnQuantity(Integer doublecolumnQuantity) 
    {
        this.doublecolumnQuantity = doublecolumnQuantity;
    }

    public Integer getDoublecolumnQuantity() 
    {
        return doublecolumnQuantity;
    }
    public void setThreecolumnQuantity(Integer threecolumnQuantity) 
    {
        this.threecolumnQuantity = threecolumnQuantity;
    }

    public Integer getThreecolumnQuantity() 
    {
        return threecolumnQuantity;
    }
    public void setOtherInformation(String otherInformation) 
    {
        this.otherInformation = otherInformation;
    }

    public String getOtherInformation() 
    {
        return otherInformation;
    }
    public void setMultimediaPhoto(String multimediaPhoto) 
    {
        this.multimediaPhoto = multimediaPhoto;
    }

    public String getMultimediaPhoto() 
    {
        return multimediaPhoto;
    }
    public void setMultimediaVideo(String multimediaVideo) 
    {
        this.multimediaVideo = multimediaVideo;
    }

    public String getMultimediaVideo() 
    {
        return multimediaVideo;
    }
    public void setBoundaryagreementDocument(String boundaryagreementDocument) 
    {
        this.boundaryagreementDocument = boundaryagreementDocument;
    }

    public String getBoundaryagreementDocument() 
    {
        return boundaryagreementDocument;
    }
    public void setBoundaryagreementPicture(String boundaryagreementPicture) 
    {
        this.boundaryagreementPicture = boundaryagreementPicture;
    }

    public String getBoundaryagreementPicture() 
    {
        return boundaryagreementPicture;
    }
    public void setBoundarypostTable(String boundarypostTable) 
    {
        this.boundarypostTable = boundarypostTable;
    }

    public String getBoundarypostTable() 
    {
        return boundarypostTable;
    }
    public void setAnnualinspectionReport(String annualinspectionReport) 
    {
        this.annualinspectionReport = annualinspectionReport;
    }

    public String getAnnualinspectionReport() 
    {
        return annualinspectionReport;
    }
    public void setAnnualinspectionPlan(String annualinspectionPlan) 
    {
        this.annualinspectionPlan = annualinspectionPlan;
    }

    public String getAnnualinspectionPlan() 
    {
        return annualinspectionPlan;
    }
    public void setProcessingResult(String processingResult) 
    {
        this.processingResult = processingResult;
    }

    public String getProcessingResult() 
    {
        return processingResult;
    }
    public void setAnnualinspectionResult(String annualinspectionResult) 
    {
        this.annualinspectionResult = annualinspectionResult;
    }

    public String getAnnualinspectionResult() 
    {
        return annualinspectionResult;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("boundaryId", getBoundaryId())
            .append("spatialdataCode", getSpatialdataCode())
            .append("boundarylineName", getBoundarylineName())
            .append("boundarylineCode", getBoundarylineCode())
            .append("boundarylineLv", getBoundarylineLv())
            .append("boundaryzoningCode", getBoundaryzoningCode())
            .append("boundaryzoningName", getBoundaryzoningName())
            .append("boundaryLength", getBoundaryLength())
            .append("geographicalpositionMsg", getGeographicalpositionMsg())
            .append("boundarylineStart", getBoundarylineStart())
            .append("boundarylineEnd", getBoundarylineEnd())
            .append("superiorExamine", getSuperiorExamine())
            .append("superiorInstructions", getSuperiorInstructions())
            .append("demarcationProgramme", getDemarcationProgramme())
            .append("meetingMinutes", getMeetingMinutes())
            .append("meetingAgreement", getMeetingAgreement())
            .append("meetingPicture", getMeetingPicture())
            .append("workSummary", getWorkSummary())
            .append("superiorAgreementExamine", getSuperiorAgreementExamine())
            .append("landagreementInstructions", getLandagreementInstructions())
            .append("boundaryAgreement", getBoundaryAgreement())
            .append("agreementApplyfor", getAgreementApplyfor())
            .append("agreementInstructions", getAgreementInstructions())
            .append("agreementPicture", getAgreementPicture())
            .append("boundarychangeHistory", getBoundarychangeHistory())
            .append("setTime", getSetTime())
            .append("disputeorNot", getDisputeorNot())
            .append("informationState", getInformationState())
            .append("informationSource", getInformationSource())
            .append("boundarypostQuantity", getBoundarypostQuantity())
            .append("singlecolumnQuantity", getSinglecolumnQuantity())
            .append("doublecolumnQuantity", getDoublecolumnQuantity())
            .append("threecolumnQuantity", getThreecolumnQuantity())
            .append("otherInformation", getOtherInformation())
            .append("multimediaPhoto", getMultimediaPhoto())
            .append("multimediaVideo", getMultimediaVideo())
            .append("boundaryagreementDocument", getBoundaryagreementDocument())
            .append("boundaryagreementPicture", getBoundaryagreementPicture())
            .append("boundarypostTable", getBoundarypostTable())
            .append("annualinspectionReport", getAnnualinspectionReport())
            .append("annualinspectionPlan", getAnnualinspectionPlan())
            .append("processingResult", getProcessingResult())
            .append("annualinspectionResult", getAnnualinspectionResult())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("REMARK", getRemark())
            .toString();
    }
}
