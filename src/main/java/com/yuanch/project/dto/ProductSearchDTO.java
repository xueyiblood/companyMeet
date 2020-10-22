package com.yuanch.project.dto;

import lombok.Data;

@Data
public class ProductSearchDTO extends SearchDTO{


    private String suspectId;

    private Long visitId;


}
