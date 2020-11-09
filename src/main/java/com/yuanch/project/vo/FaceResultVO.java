package com.yuanch.project.vo;

import lombok.Data;

@Data
public class FaceResultVO {

    private String face_image_uri;

    private Double similarity;

    private String person_id;

    private String name;

    private Integer gender;

    private Integer nation;

    private Integer born_year;



}
