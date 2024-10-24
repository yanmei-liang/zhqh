package com.ruoyi.government.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 标准地名对象 DM_BASE
 * 
 * @author ruoyi
 * @date 2024-10-14
 */
public class DmBase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 地名代码 */
    @Excel(name = "地名代码")
    @Schema(description="地名代码",example="string")
    private String code;

    /** 标准名称 */
    @Excel(name = "标准名称")
    @Schema(description="标准名称",example="string")
    private String name;

    /** 别名 */
    @Excel(name = "别名")
    @Schema(description="别名",example="string")
    private String alias;

    /** 简称 */
    @Excel(name = "简称")
    @Schema(description="简称",example="string")
    private String simpleName;

    /** 曾用名 */
    @Excel(name = "曾用名")
    @Schema(description="曾用名",example="string")
    private String historyName;

    /** 汉子书写 */
    @Excel(name = "汉子书写")
    @Schema(description="汉子书写",example="string")
    private String chineseName;

    /** 少数民族语言书写 */
    @Excel(name = "少数民族语言书写")
    @Schema(description="少数民族语言书写",example="string")
    private String ssmzyy;

    /** 地名原读音(读音文件名) */
    @Excel(name = "地名原读音(读音文件名)")
    @Schema(description="地名原读音",example="string")
    private String dmydy;

    /** 汉语普通话读音(读音文件名) */
    @Excel(name = "汉语普通话读音(读音文件名)")
    @Schema(description="汉语普通话读音",example="string")
    private String hypthdy;

    /** 罗马字母拼写 */
    @Excel(name = "罗马字母拼写")
    @Schema(description="罗马字母拼写",example="string")
    private String lmzmpx;

    /** 地名语种 */
    @Excel(name = "地名语种")
    @Schema(description="地名语种",example="string")
    private String dmyz;

    /** 地名类别 */
    @Excel(name = "地名类别")
    @Schema(description="地名类别",example="string")
    private String dmlb;

    /** 东经(格式：_°_′_″ 第三段“秒”预留两位小数) */
    @Excel(name = "东经(格式：_°_′_″ 第三段“秒”预留两位小数)")
    @Schema(description="东经",example="string")
    private String eastLongitude;

    /** 至东经(格式：_°_′_″ 第三段“秒”预留两位小数) */
    @Excel(name = "至东经(格式：_°_′_″ 第三段“秒”预留两位小数)")
    @Schema(description="至东经",example="string")
    private String toEastLongitude;

    /** 北纬(格式：_°_′_″ 第三段“秒”预留两位小数) */
    @Excel(name = "北纬(格式：_°_′_″ 第三段“秒”预留两位小数)")
    @Schema(description="北纬",example="string")
    private String northLatitude;

    /** 至北纬(格式：_°_′_″ 第三段“秒”预留两位小数) */
    @Excel(name = "至北纬(格式：_°_′_″ 第三段“秒”预留两位小数)")
    @Schema(description="至北纬",example="string")
    private String toNorthLatitude;

    /** 地名普查状态 */
    @Excel(name = "地名普查状态")
    @Schema(description="地名普查状态",example="string")
    private String dmpczt;

    /** 原图名称-填写该地名在地图上的名称 */
    @Excel(name = "原图名称-填写该地名在地图上的名称")
    @Schema(description="原图名称",example="string")
    private String ytmc;

    /** 图号-所在图幅的图名、图号 */
    @Excel(name = "图号-所在图幅的图名、图号")
    @Schema(description="图号",example="string")
    private String th;

    /** 比例尺 */
    @Excel(name = "比例尺")
    @Schema(description="比例尺",example="string")
    private String scale;

    /** 使用时间 */
    @Excel(name = "使用时间")
    @Schema(description="使用时间",example="string")
    private String useTime;

    /** 地名的来历 */
    @Excel(name = "地名的来历")
    @Schema(description="地名的来历",example="string")
    private String dmll;

    /** 地名的含义 */
    @Excel(name = "地名的含义")
    @Schema(description="地名的含义",example="string")
    private String dmhy;

    /** 地名的历史沿革 */
    @Excel(name = "地名的历史沿革")
    @Schema(description="地名的历史沿革",example="string")
    private String dmlsyg;

    /** 地名典故 */
    @Excel(name = "地名典故")
    @Schema(description="地名典故",example="string")
    private String dmdg;

    /** 密级 */
    @Excel(name = "密级")
    @Schema(description="密级",example="string")
    private String mj;

    /** 坐标系-为2000国家大地坐标系 */
    @Excel(name = "坐标系-为2000国家大地坐标系")
    @Schema(description="坐标系",example="string")
    private String zbx;

    /** 测量方法 */
    @Excel(name = "测量方法")
    @Schema(description="测量方法",example="string")
    private String clff;

    /** 地理实体概况 */
    @Excel(name = "地理实体概况")
    @Schema(description="地理实体概况",example="string")
    private String dlstgk;

    /** 资料来源 */
    @Excel(name = "资料来源")
    @Schema(description="资料来源",example="string")
    private String zlly;

    /** 登记时间-格式yyyy-MM-dd */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "登记时间-格式yyyy-MM-dd", width = 30, dateFormat = "yyyy-MM-dd")
    @Schema(description="登记时间",example="2021-12-12")
    private Date registerDate;

    /** 登记人 */
    @Excel(name = "登记人")
    @Schema(description="登记人",example="string")
    private String registerName;

    /** 登记单位 */
    @Excel(name = "登记单位")
    @Schema(description="登记单位",example="string")
    private String registerUnit;

    /** 通名罗马字母拼写 */
    @Excel(name = "通名罗马字母拼写")
    @Schema(description="通名罗马字母拼写",example="string")
    private String tmlmzmpx;

    /** 设立年份 */
    @Excel(name = "设立年份")
    @Schema(description="设立年份",example="string")
    private String slnf;

    /** 废止年份 */
    @Excel(name = "废止年份")
    @Schema(description="废止年份",example="string")
    private String fznf;

    /** 是否公开 */
    @Excel(name = "是否公开")
    @Schema(description="是否公开",example="string")
    private String sfgk;

    /** 多媒体信息 */
    @Excel(name = "多媒体信息")
    @Schema(description="多媒体信息",example="string")
    private String dmtxx;

    /** 行政区划 */
    @Excel(name = "行政区划")
    @Schema(description="行政区划",example="string")
    private String xzqh;

    /** 命名时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "命名时间", width = 30, dateFormat = "yyyy-MM-dd")
    @Schema(description="命名时间",example="2020-10-12")
    private Date mmsj;

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

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setAlias(String alias) 
    {
        this.alias = alias;
    }

    public String getAlias() 
    {
        return alias;
    }
    public void setSimpleName(String simpleName) 
    {
        this.simpleName = simpleName;
    }

    public String getSimpleName() 
    {
        return simpleName;
    }
    public void setHistoryName(String historyName) 
    {
        this.historyName = historyName;
    }

    public String getHistoryName() 
    {
        return historyName;
    }
    public void setChineseName(String chineseName) 
    {
        this.chineseName = chineseName;
    }

    public String getChineseName() 
    {
        return chineseName;
    }
    public void setSsmzyy(String ssmzyy) 
    {
        this.ssmzyy = ssmzyy;
    }

    public String getSsmzyy() 
    {
        return ssmzyy;
    }
    public void setDmydy(String dmydy) 
    {
        this.dmydy = dmydy;
    }

    public String getDmydy() 
    {
        return dmydy;
    }
    public void setHypthdy(String hypthdy) 
    {
        this.hypthdy = hypthdy;
    }

    public String getHypthdy() 
    {
        return hypthdy;
    }
    public void setLmzmpx(String lmzmpx) 
    {
        this.lmzmpx = lmzmpx;
    }

    public String getLmzmpx() 
    {
        return lmzmpx;
    }
    public void setDmyz(String dmyz) 
    {
        this.dmyz = dmyz;
    }

    public String getDmyz() 
    {
        return dmyz;
    }
    public void setDmlb(String dmlb) 
    {
        this.dmlb = dmlb;
    }

    public String getDmlb() 
    {
        return dmlb;
    }
    public void setEastLongitude(String eastLongitude) 
    {
        this.eastLongitude = eastLongitude;
    }

    public String getEastLongitude() 
    {
        return eastLongitude;
    }
    public void setToEastLongitude(String toEastLongitude) 
    {
        this.toEastLongitude = toEastLongitude;
    }

    public String getToEastLongitude() 
    {
        return toEastLongitude;
    }
    public void setNorthLatitude(String northLatitude) 
    {
        this.northLatitude = northLatitude;
    }

    public String getNorthLatitude() 
    {
        return northLatitude;
    }
    public void setToNorthLatitude(String toNorthLatitude) 
    {
        this.toNorthLatitude = toNorthLatitude;
    }

    public String getToNorthLatitude() 
    {
        return toNorthLatitude;
    }
    public void setDmpczt(String dmpczt) 
    {
        this.dmpczt = dmpczt;
    }

    public String getDmpczt() 
    {
        return dmpczt;
    }
    public void setYtmc(String ytmc) 
    {
        this.ytmc = ytmc;
    }

    public String getYtmc() 
    {
        return ytmc;
    }
    public void setTh(String th) 
    {
        this.th = th;
    }

    public String getTh() 
    {
        return th;
    }
    public void setScale(String scale) 
    {
        this.scale = scale;
    }

    public String getScale() 
    {
        return scale;
    }
    public void setUseTime(String useTime) 
    {
        this.useTime = useTime;
    }

    public String getUseTime() 
    {
        return useTime;
    }
    public void setDmll(String dmll) 
    {
        this.dmll = dmll;
    }

    public String getDmll() 
    {
        return dmll;
    }
    public void setDmhy(String dmhy) 
    {
        this.dmhy = dmhy;
    }

    public String getDmhy() 
    {
        return dmhy;
    }
    public void setDmlsyg(String dmlsyg) 
    {
        this.dmlsyg = dmlsyg;
    }

    public String getDmlsyg() 
    {
        return dmlsyg;
    }
    public void setDmdg(String dmdg) 
    {
        this.dmdg = dmdg;
    }

    public String getDmdg() 
    {
        return dmdg;
    }
    public void setMj(String mj) 
    {
        this.mj = mj;
    }

    public String getMj() 
    {
        return mj;
    }
    public void setZbx(String zbx) 
    {
        this.zbx = zbx;
    }

    public String getZbx() 
    {
        return zbx;
    }
    public void setClff(String clff) 
    {
        this.clff = clff;
    }

    public String getClff() 
    {
        return clff;
    }
    public void setDlstgk(String dlstgk) 
    {
        this.dlstgk = dlstgk;
    }

    public String getDlstgk() 
    {
        return dlstgk;
    }
    public void setZlly(String zlly) 
    {
        this.zlly = zlly;
    }

    public String getZlly() 
    {
        return zlly;
    }
    public void setRegisterDate(Date registerDate) 
    {
        this.registerDate = registerDate;
    }

    public Date getRegisterDate() 
    {
        return registerDate;
    }
    public void setRegisterName(String registerName) 
    {
        this.registerName = registerName;
    }

    public String getRegisterName() 
    {
        return registerName;
    }
    public void setRegisterUnit(String registerUnit) 
    {
        this.registerUnit = registerUnit;
    }

    public String getRegisterUnit() 
    {
        return registerUnit;
    }
    public void setTmlmzmpx(String tmlmzmpx) 
    {
        this.tmlmzmpx = tmlmzmpx;
    }

    public String getTmlmzmpx() 
    {
        return tmlmzmpx;
    }
    public void setSlnf(String slnf) 
    {
        this.slnf = slnf;
    }

    public String getSlnf() 
    {
        return slnf;
    }
    public void setFznf(String fznf) 
    {
        this.fznf = fznf;
    }

    public String getFznf() 
    {
        return fznf;
    }
    public void setSfgk(String sfgk) 
    {
        this.sfgk = sfgk;
    }

    public String getSfgk() 
    {
        return sfgk;
    }
    public void setDmtxx(String dmtxx) 
    {
        this.dmtxx = dmtxx;
    }

    public String getDmtxx() 
    {
        return dmtxx;
    }
    public void setXzqh(String xzqh) 
    {
        this.xzqh = xzqh;
    }

    public String getXzqh() 
    {
        return xzqh;
    }
    public void setMmsj(Date mmsj) 
    {
        this.mmsj = mmsj;
    }

    public Date getMmsj() 
    {
        return mmsj;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("name", getName())
            .append("alias", getAlias())
            .append("simpleName", getSimpleName())
            .append("historyName", getHistoryName())
            .append("chineseName", getChineseName())
            .append("ssmzyy", getSsmzyy())
            .append("dmydy", getDmydy())
            .append("hypthdy", getHypthdy())
            .append("lmzmpx", getLmzmpx())
            .append("dmyz", getDmyz())
            .append("dmlb", getDmlb())
            .append("eastLongitude", getEastLongitude())
            .append("toEastLongitude", getToEastLongitude())
            .append("northLatitude", getNorthLatitude())
            .append("toNorthLatitude", getToNorthLatitude())
            .append("dmpczt", getDmpczt())
            .append("ytmc", getYtmc())
            .append("th", getTh())
            .append("scale", getScale())
            .append("useTime", getUseTime())
            .append("dmll", getDmll())
            .append("dmhy", getDmhy())
            .append("dmlsyg", getDmlsyg())
            .append("dmdg", getDmdg())
            .append("mj", getMj())
            .append("zbx", getZbx())
            .append("clff", getClff())
            .append("dlstgk", getDlstgk())
            .append("zlly", getZlly())
            .append("remark", getRemark())
            .append("registerDate", getRegisterDate())
            .append("registerName", getRegisterName())
            .append("registerUnit", getRegisterUnit())
            .append("tmlmzmpx", getTmlmzmpx())
            .append("slnf", getSlnf())
            .append("fznf", getFznf())
            .append("sfgk", getSfgk())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("dmtxx", getDmtxx())
            .append("xzqh", getXzqh())
            .append("mmsj", getMmsj())
            .toString();
    }
}
