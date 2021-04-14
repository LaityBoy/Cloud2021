package com.cloud.payment8002.controller;

import com.cloud.common.entitys.CommonResult;
import com.cloud.common.entitys.Order;
import com.cloud.payment8002.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${server.port}")
    private String serverPort;

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
            int a=10/2;
            return new CommonResult(200,"成功,serverPort:  "+serverPort, order);
        }
        else{
            return new CommonResult(444,"失败",null);
        }
    }
}
