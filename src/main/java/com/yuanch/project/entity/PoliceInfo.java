package com.yuanch.project.entity;

import lombok.Data;

import java.util.Date;

@Data
public class PoliceInfo {

    private Long id;

    private Integer deleteStatus;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private String name;

    private String policeCode;

    private String phone;

    private String deptCode;

    private String password;

    private String deptName;

}
