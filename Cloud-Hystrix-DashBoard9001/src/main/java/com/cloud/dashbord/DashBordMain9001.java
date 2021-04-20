package com.cloud.dashbord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard//断路器监控
public class DashBordMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(DashBordMain9001.class,args);
    }
}
