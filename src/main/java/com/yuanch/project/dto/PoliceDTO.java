package com.yuanch.project.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PoliceDTO {
    private Long id;
    @NotBlank
    @ApiModelProperty("姓名")
    private String name;
    @NotBlank
    @ApiModelProperty("警察编号")
    private String policeCode;
    @NotBlank
    @ApiModelProperty("手机")
    private String phone;
    @NotBlank
    @ApiModelProperty("部门code")
    private String deptCode;
    @NotBlank
    @ApiModelProperty("密码")
    private String password;

}
