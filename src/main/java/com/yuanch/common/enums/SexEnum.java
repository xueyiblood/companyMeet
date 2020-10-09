package com.yuanch.common.enums;

public enum SexEnum {

    F("F", "女"),
    M("M", "男");

    private final String code;
    private final String info;

    SexEnum(String code, String info)
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
