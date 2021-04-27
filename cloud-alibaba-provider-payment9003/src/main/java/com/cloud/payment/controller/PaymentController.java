package com.cloud.payment.controller;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class PaymentController {

    private static Map<Integer,String> map=new HashMap<>();

    static{
        map.put(1, IdUtil.randomUUID());
        map.put(2, IdUtil.randomUUID());
        map.put(3, IdUtil.randomUUID());
    }
    @Value("${server.port}")
    private String port;

    @GetMapping("/getId/{id}")
    public String getId(@PathVariable(value = "id") Integer id){
        return "端口号:\t"+port+"\t唯一id为:"+map.get(id);
    }
}
