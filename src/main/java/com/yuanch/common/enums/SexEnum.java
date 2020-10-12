package com.yuanch.common.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SexEnum {
    /**
     * 性别女
     */
    F("F", "女"),
    /**
     * 性别男
     */
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
