package com.yuanch.project.entity;

import lombok.Data;

import java.util.Date;

/**
 * 携带物品
 */
@Data
public class ProductInfo {

    private Long id;

    private String productName;

    private Long productNum;

    private Integer deleteStatus;

    private Date createTime;

    private Date updateTime;

    private String suspectId;

    private Long visitId;



}
