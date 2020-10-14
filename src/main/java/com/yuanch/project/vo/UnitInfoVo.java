package com.yuanch.project.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: mary
 * @Date: 2020/8/5 0005 17:50
 */
@Data
public class UnitInfoVo {
    private Long id;

    private String parentUnitNo;

    @NotBlank
    private String unitNo;

    private String unitName;

    private String fullName;

    private Integer deleteStatus;

    private List<UnitInfoVo> children = new ArrayList<>();
}
