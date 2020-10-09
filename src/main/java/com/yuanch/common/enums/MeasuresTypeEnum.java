package com.yuanch.common.enums;

public enum MeasuresTypeEnum {

    MONITOR(0,"监视居住"),
    PENDING(1,"取保候审");

    private Integer value;
    private String text;

     MeasuresTypeEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
