package com.yuanch.project.dto;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.yuanch.common.enums.RelationEnum;
import com.yuanch.common.enums.SexEnum;
import lombok.Data;

import java.util.Date;

@Data
public class VisitDTO {

    private String name;

    @EnumValue
    private SexEnum sex;

    private String nation;

    private Date birthday;

    private String address;

    private String idCard;

    private String phone;

    @EnumValue
    private RelationEnum relation;

    private Long suspectId;



}
