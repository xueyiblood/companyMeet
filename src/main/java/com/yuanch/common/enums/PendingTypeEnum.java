package com.yuanch.common.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PendingTypeEnum {

    OUTLINE(1, "出界报警"),
    APPOFFLINE(2, "APP离线报警"),
    SIGNABNORMAL(3, "签到异常"),
    PEDINGEXPIRE(4, "取保候审到期预警"),
    REALCHECK(5, "实质性侦查预警");

    private final Integer value;
    private final String lable;

    PendingTypeEnum(Integer value, String lable)
    {
        this.value = value;
        this.lable = lable;
    }

    public Integer getValue()
    {
        return value;
    }

    public String getLable()
    {
        return lable;
    }


    public static Integer getValue(String lable) {
        PendingTypeEnum[] carTypeEnums = values();
        for (PendingTypeEnum carTypeEnum : carTypeEnums) {
            if (carTypeEnum.lable.equals(lable)) {
                return carTypeEnum.value;
            }
        }
        return null;
    }

    public static String getlable(Integer value) {
        PendingTypeEnum[] carTypeEnums = values();
        for (PendingTypeEnum carTypeEnum : carTypeEnums) {
            if (carTypeEnum.value.equals(value)) {
                return carTypeEnum.lable;
            }
        }
        return null;
    }
}
