package com.ruoyi.common.enums;

public enum FlowableStatus {
    AWAIT("0", "待审批"), PASS("1", "已通过"), REJECT("2", "已驳回");

    private final String code;
    private final String info;

    FlowableStatus(String code, String info)
    {
        this.code = code;
        this.info = info;
    }

    public String getCode()
    {
        return code;
    }

    public String getInfo()
    {
        return info;
    }
}
