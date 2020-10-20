package com.yuanch.project.vo;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yuanch.common.enums.RelationEnum;
import com.yuanch.common.enums.SexEnum;
import com.yuanch.project.entity.VisitInfo;
import lombok.Data;

import java.util.Date;

@Data
public class VisitVO{

    private Long id;

    private String name;

    @EnumValue
    private SexEnum sex;

    private String nation;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    private String address;

    private String idCard;

    private String phone;

    @EnumValue
    private RelationEnum relation;

    private Long deleteStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String suspectId;

}
