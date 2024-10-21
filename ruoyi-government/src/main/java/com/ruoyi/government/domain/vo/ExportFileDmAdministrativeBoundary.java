package com.ruoyi.government.domain.vo;

import com.ruoyi.common.annotation.Excel;

public class ExportFileDmAdministrativeBoundary {

    @Excel(name = "名称")
    private String level;

    @Excel(name = "数量")
    private Integer count;

    @Excel(name = "长度")
    private Integer boundaryLength;

    @Excel(name = "界桩数量")
    private Integer boundarypostQuantity;

    @Override
    public String toString() {
        return "DmAdministrativeBoundary{" +
                "level='" + level + '\'' +
                ", count=" + count +
                ", boundaryLength=" + boundaryLength +
                ", boundarypostQuantity=" + boundarypostQuantity +
                '}';
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getBoundaryLength() {
        return boundaryLength;
    }

    public void setBoundaryLength(Integer boundaryLength) {
        this.boundaryLength = boundaryLength;
    }

    public Integer getBoundarypostQuantity() {
        return boundarypostQuantity;
    }

    public void setBoundarypostQuantity(Integer boundarypostQuantity) {
        this.boundarypostQuantity = boundarypostQuantity;
    }
}
