package com.ruoyi.government.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
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
@Data
public class GovernmentInquiry extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键预审ID */
    private Long inquiryId;

    /** 预审地名名称 */
    @Excel(name = "预审地名名称")
    private String toponym;

    /** 报送单位 */
    @Excel(name = "报送单位")
    private String submitDepa;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contacts;

    /** 联系人电话 */
    @Excel(name = "联系人电话")
    private String contactsPhone;

    /** 申请书 */
    @Excel(name = "申请书")
    private String application;

    /** 附件 */
    @Excel(name = "附件")
    private String attachment;

    /** 预审备注 */
    @Excel(name = "预审备注")
    private String inquiryRemark;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 预审状态（待提交，已提交，审批中，已完成） */
    @Excel(name = "预审状态", readConverterExp = "待=提交，已提交，审批中，已完成")
    private String inquiryStatus;

    /** 地名编码 */
    @Excel(name = "地名编码")
    private String code;

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

    /** 地图经纬度集合 */
    @Excel(name = "流程实例ID")
    private String procInsId;

}
