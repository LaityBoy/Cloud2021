package com.cloud.payment8001.controller;

import com.cloud.common.entitys.CommonResult;
import com.cloud.common.entitys.Order;
import com.cloud.payment8001.service.OrderService;
import com.netflix.appinfo.InstanceInfo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${server.port}")
    private String serverPort;

    //可以用来查询注册中心的微服务的各种详细信息
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Order order){
        int i = orderService.create(order);
        if(i>0){
            return new CommonResult(200,"成功,serverPort:  "+serverPort,i);
        }
        else{
            return new CommonResult(444,"失败",null);
        }
    }
    @GetMapping(value = "/find/{id}")
    public CommonResult<Order> find(@PathVariable(value = "id") Long id){
        Order order = orderService.find(id);
        if(order !=null){
            return new CommonResult(200,"成功,serverPort:  "+serverPort, order);
        }
        else{
            return new CommonResult(444,"失败",null);
        }
    }

    @GetMapping("/discovery")
    public DiscoveryClient discovery(){
        List<ServiceInstance> payment = discoveryClient.getInstances("PAYMENT");
        for(ServiceInstance instance:payment){
            log.info("port:"+instance.getPort()+"\t"+"instanceId:"+instance.getInstanceId());
        }
        return discoveryClient;
    }
}
