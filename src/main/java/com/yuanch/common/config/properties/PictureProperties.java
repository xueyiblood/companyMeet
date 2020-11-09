package com.yuanch.common.config.properties;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class PictureProperties {

    @Value("${picture.checkurl}")
    private String checkurl;

    @Value("${picture.serviceurl}")
    private String serviceurl;

    @Value("${picture.name}")
    private String name;

    @Value("${picture.password}")
    private String password;

    @Value("${picture.prictureurl}")
    private String prictureurl;
}
