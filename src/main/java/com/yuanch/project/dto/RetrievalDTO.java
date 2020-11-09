package com.yuanch.project.dto;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class RetrievalDTO {

    private String picture_image_content_base64;

    private List<String> repository_ids ;

    private Double threshold = 0d;

    private Boolean fast = true;

    private Integer topk = 3;



}
