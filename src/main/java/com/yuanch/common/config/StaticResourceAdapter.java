package com.yuanch.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description:
 * @Author: mary
 * @Date: 2020/8/19 0019 17:43
 */
@Configuration
public class StaticResourceAdapter extends WebMvcConfigurerAdapter {

    @Value("${yuanch.profile}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/profile/**").addResourceLocations(
                "file:" + getUploadPath());
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }
}
