package com.cloud.consumer.controller;

import com.cloud.consumer.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
//配置全局降级
@DefaultProperties(defaultFallback = "instance_glo")
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/consumer/payment/ok/{id}")
    @HystrixCommand
    public String instance_ok(@PathVariable(value = "id") Integer id){

        int a=10/0;
        return orderService.instance_ok(id);
    }

    @GetMapping("/consumer/payment/timeOut/{id}")
    @HystrixCommand(fallbackMethod = "instance_timeOutFall",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value ="3500")
    })
    public String instance_timeOut(@PathVariable(value = "id") Integer id){

        return orderService.instance_timeOut(id);
    }
    public String instance_timeOutFall(@PathVariable(value = "id") Integer id){
        return "服务超时降级生效";
    }

    public String instance_glo(){
        return "全局降级生效，可能出现异常";
    }
}
