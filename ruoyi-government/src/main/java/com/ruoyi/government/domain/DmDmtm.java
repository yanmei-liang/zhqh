package com.ruoyi.government.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 通名管理对象 DM_DMTM
 *
 * @author ruoyi
 * @date 2024-10-22
 */
public class DmDmtm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    private Integer id;

    /** 通名 */
    @Excel(name = "通名")
    private String name;

    /** 类别代码 */
    @Excel(name = "类别代码")
    private String dmlbCode;

    /** 地名类别 */
    @Excel(name = "地名类别")
    private String dmlbName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDmlbCode(String dmlbCode)
    {
        this.dmlbCode = dmlbCode;
    }

    public String getDmlbCode()
    {
        return dmlbCode;
    }
    public void setDmlbName(String dmlbName)
    {
        this.dmlbName = dmlbName;
    }

    public String getDmlbName()
    {
        return dmlbName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("Id", getId())
            .append("name", getName())
            .append("dmlbCode", getDmlbCode())
            .append("dmlbName", getDmlbName())
            .toString();
    }
}
