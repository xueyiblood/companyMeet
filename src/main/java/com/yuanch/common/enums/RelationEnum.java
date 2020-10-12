package com.yuanch.common.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RelationEnum {
    /**
     * 关系枚举
     */
    HUSBAND("HUSBAND", "丈夫"),

    WIFE("WIFE", "妻子"),

    SON("SON", "儿子"),

    DAUGHTER("DAUGHTER", "女儿"),

    SONINLAW("SONINLAW", "女婿"),

    DAUGHTERINLAW("DAUGHTERINLAW", "儿媳"),

    GRANDSON("GRANDSON", "孙子"),

    GRANDDAUGHTER("GRANDDAUGHTER", "孙女"),

    FATHER("FATHER", "父亲"),

    MOTHER("MOTHER", "母亲"),

    FATHERINLAE("FATHERINLAE", "公公"),

    MOTHERINLAW("MOTHERINLAW", "婆婆"),

    OTHER("OTHER", "其他");

    private final String code;
    private final String info;

    RelationEnum(String code, String info)
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
