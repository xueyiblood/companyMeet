package com.yuanch.project.vo;

import lombok.Data;

import java.util.List;

@Data
public class FindFaceVO {
    private Double rtn;

    private String message;

    private String retrieval_query_id;

    private List<FaceResultVO> results;

    private Integer total;



}
