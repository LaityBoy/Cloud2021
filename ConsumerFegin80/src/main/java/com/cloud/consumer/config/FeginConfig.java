package com.cloud.consumer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeginConfig {

    @Bean
    Logger.Level level(){
        return Logger.Level.FULL;
    }
}
