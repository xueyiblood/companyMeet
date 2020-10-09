package com.yuanch.common.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MonitorTypeEnum {

    ANTIDEMOLITIONCLEAR(1, "基站防拆报警解除"),
    ANTIDEMOLITION(2, "基站防拆报警"),
    BASESHOCKCLEAR(3, "基站震动报警解除"),
    BASESHOCK(4, "基站震动报警"),
    OFFLINECLEAR(5, "腕带离线报警解除"),
    OFFLINE(6, "腕带离线报警"),
    LOWPOWER(7, "腕带低电量报警"),
    WRISTBANDANTI(8, "腕带防拆报警"),
    APPOFFLINE(9, "APP离线报警"),
    SIGNABNORMAL(10, "签到异常"),
    MONITOREXPIRE(11, "监视居住到期预警");


    private final Integer value;
    private final String lable;

    MonitorTypeEnum(Integer value, String lable)
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
        MonitorTypeEnum[] monitorTypes = values();
        for (MonitorTypeEnum monitorType : monitorTypes) {
            if (monitorType.lable.equals(lable)) {
                return monitorType.value;
            }
        }
        return null;
    }

    public static String getlable(Integer value) {
        MonitorTypeEnum[] monitorTypes = values();
        for (MonitorTypeEnum monitorType : monitorTypes) {
            if (monitorType.value.equals(value)) {
                return monitorType.lable;
            }
        }
        return null;
    }
}
