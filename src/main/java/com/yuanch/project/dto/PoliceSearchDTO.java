package com.yuanch.project.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PoliceSearchDTO extends SearchDTO{
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("警察编号")
    private String policeCode;
    @ApiModelProperty("电话")
    private String phone;


}
