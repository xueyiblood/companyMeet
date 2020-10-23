package com.yuanch.project.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 用户
 */
@Data
@TableName("police_info")
public class PoliceInfo {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("delete_status")
    private Integer deleteStatus;
    @TableField("create_time")
    private Date createTime;
    @TableField("create_by")
    private String createBy;
    @TableField("update_time")
    private Date updateTime;
    @TableField("update_by")
    private String updateBy;
    @TableField("name")
    private String name;
    @TableField("police_code")
    private String policeCode;
    @TableField("phone")
    private String phone;
    @TableField("dept_code")
    private String deptCode;
    @TableField("password")
    private String password;
    @TableField("dept_name")
    private String deptName;

}
