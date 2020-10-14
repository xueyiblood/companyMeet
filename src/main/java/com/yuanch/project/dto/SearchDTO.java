package com.yuanch.project.dto;

import lombok.Data;

@Data
public class SearchDTO {

    private Integer pageNum = 1;

    private Integer pageSize = 10;
    /**
     * asc desc
     */
    private String sort;
    /**
     * 排序字段
     */
    private String sortProperty;


}
