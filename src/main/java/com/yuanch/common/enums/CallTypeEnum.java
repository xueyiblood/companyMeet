package com.yuanch.common.enums;

public enum CallTypeEnum {

    MONITOR("MONITOR", "监视居住"),
    PENDING("PENDING", "取保候审");

    private final String value;
    private final String lable;

    CallTypeEnum(String value, String lable)
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
