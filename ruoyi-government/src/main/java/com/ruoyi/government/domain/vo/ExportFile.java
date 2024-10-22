package com.ruoyi.government.domain.vo;

import com.ruoyi.common.annotation.Excel;

public class ExportFile {

    @Excel(name = "名称")
    private String level;

    @Excel(name = "数量")
    private Integer count;

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

    @Override
    public String toString() {
        return "ExportFile{" +
                "level='" + level + '\'' +
                ", count=" + count +
                '}';
    }
}
