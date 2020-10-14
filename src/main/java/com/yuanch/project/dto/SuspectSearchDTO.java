package com.yuanch.project.dto;

import lombok.Data;

@Data
public class SuspectSearchDTO extends SearchDTO{

    private String personCode;

    private String name;

    private String idCard;


}
