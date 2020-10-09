package com.yuanch.common.enums;

/**
 * @Description:
 * @Author: mary
 * @Date: 2020/8/20 0020 20:48
 */
public enum MessageTypeEnum {
    USERMESSAGE(0, "用户消息"),
    SYSTEMMESSAGE(1, "系统消息"),
    WARNINGMESSAGE(2, "预警消息");


    private final Integer value;
    private final String lable;

    MessageTypeEnum(Integer value, String lable)
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
        MessageTypeEnum[] messageTypes = values();
        for (MessageTypeEnum messageType : messageTypes) {
            if (messageType.lable.equals(lable)) {
                return messageType.value;
            }
        }
        return null;
    }

    public static String getlable(Integer value) {
        MessageTypeEnum[] messageTypes = values();
        for (MessageTypeEnum messageType : messageTypes) {
            if (messageType.value.equals(value)) {
                return messageType.lable;
            }
        }
        return null;
    }
}
