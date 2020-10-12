package com.yuanch.project.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yuanch.common.enums.RelationEnum;
import com.yuanch.common.enums.SexEnum;
import lombok.Data;

import java.util.Date;

/**
 * 来访人员实体
 */
@Data

public class VisitInfo {

    private Long id;

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

    private Integer deleteStatus;

    private Date createTime;

    private Date updateTime;

    private Long suspectId;

}
