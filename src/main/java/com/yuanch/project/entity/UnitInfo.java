package com.yuanch.project.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @Author: mary
 * @Date: 2020/8/5 0005 17:51
 */
@Data
@TableName("unit_info")
public class UnitInfo {
    @TableId("id")
    private Long id;

    @TableField("parent_unitno")
    private String parentUnitNo;

    @TableField("unitno")
    private String unitNo;

    @TableField("unitname")
    private String unitName;

    @TableField("fullname")
    private String fullName;

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
}
