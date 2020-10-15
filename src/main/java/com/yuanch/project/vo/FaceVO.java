package com.yuanch.project.vo;

import lombok.Data;

@Data
public class FaceVO {
    /**
     * 身份证照片base64
     */
    private String cardPicture;
    /**
     * 人脸照片base64
     */
    private String facePicture;


}
