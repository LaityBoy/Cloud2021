package com.cloud.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.consumer.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate template;

    String service_url="http://cloudalibaba-provider-payment/";

    @GetMapping("/getId/{id}")
    @SentinelResource(value = "fallback",fallback = "fallbackHander",blockHandler = "blockHandler")
    //fallback管运行时异常
    //blockHandler管sentinel配置
    public String getId(@PathVariable(value = "id") Integer id){
        String ids = template.getForObject(service_url + "/getId/" + id, String.class);

        if(id==4){
            throw new IllegalArgumentException("参数异常\t id为:"+id);
        }

        if(id>4){
            throw new NullPointerException("结果集为空\t id为:"+id);
        }

        return ids;
    }

    public String fallbackHander(@PathVariable(value = "id") Integer id,Throwable throwable){
        return "运行时异常\t fallbackHander";
    }




    //===============openFegin==============//

    @Resource
    private OrderService orderService;

    @GetMapping("/getIdFegin/{id}")
    @SentinelResource(value = "fegin",blockHandler = "blockHandler")
    public String getIdFegin(@PathVariable(value = "id") Integer id){
        return orderService.getId(id);
    }

    public String blockHandler(@PathVariable(value = "id") Integer id, BlockException blockException){
        return "sentinel限流\t blockHandler";
    }
}
