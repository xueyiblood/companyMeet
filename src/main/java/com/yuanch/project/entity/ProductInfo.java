package com.yuanch.project.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 携带物品
 */
@Data
@TableName("product_info")
public class ProductInfo {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("product_name")
    private String productName;
    @TableField("product_num")
    private Long productNum;
    @TableField("delete_status")
    private Integer deleteStatus;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
    @TableField("suspect_id")
    private String suspectId;
    @TableField("visit_id")
    private Long visitId;



}
