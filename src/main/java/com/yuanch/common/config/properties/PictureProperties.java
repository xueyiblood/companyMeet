package com.yuanch.common.config.properties;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class PictureProperties {

    @Value("${picture.checkurl}")
    private String checkurl;





}
