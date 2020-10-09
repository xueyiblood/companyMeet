package com.yuanch.common.enums;

public enum ControlStatusEnum {

    PENDING(0,"取保候审中"),
    MOVINGCHECK(1,"移送审查"),
    RELIEVEPENDING(2,"解除取保候审"),
    ARREST(3,"逮捕"),
    CRIMINALDETENTION(4,"刑拘");

    private Integer value;
    private String text;

    ControlStatusEnum(Integer value, String text) {
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
