package com.yuanch.common.enums;

public enum DealStatusEnum {

    UNDEAL("UNDEAL", "未处理"),
    DEAL("DEAL", "已处理");

    private final String value;
    private final String lable;

    DealStatusEnum(String value, String lable)
    {
        this.value = value;
        this.lable = lable;
    }

    public String getValue()
    {
        return value;
    }

    public String getLable()
    {
        return lable;
    }
}
