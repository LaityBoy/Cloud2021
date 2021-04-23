package com.cloud.config.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@Slf4j
public class ConfigController {
    @Value("${config.info}")
    private String config_info;

    @GetMapping("/config/getConfig")
    public String getConfig(){
        return "配置中心注册成功:\t"+config_info;
    }
}
