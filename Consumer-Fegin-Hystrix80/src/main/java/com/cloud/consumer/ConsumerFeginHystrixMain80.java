package com.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class ConsumerFeginHystrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeginHystrixMain80.class,args);
    }
}
