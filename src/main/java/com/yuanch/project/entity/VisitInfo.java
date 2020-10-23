package com.yuanch.project.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.yuanch.common.enums.RelationEnum;
import com.yuanch.common.enums.SexEnum;
import lombok.Data;

import java.util.Date;

/**
 * 来访人员实体
 */
@Data
@TableName("visit_info")
public class VisitInfo {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("name")
    private String name;

    @EnumValue
    @TableField("sex")
    private SexEnum sex;
    @TableField("nation")
    private String nation;
    @TableField("birthday")
    private Date birthday;
    @TableField("address")
    private String address;
    @TableField("id_card")
    private String idCard;
    @TableField("phone")
    private String phone;

    @EnumValue
    @TableField("relation")
    private RelationEnum relation;
    @TableField("delete_status")
    private Integer deleteStatus;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
    @TableField("suspect_id")
    private String suspectId;
    @TableField("picture")
    private String picture;
    @TableField("unit_code")
    private String unitCode;
}
