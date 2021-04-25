package com.cloud.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.sentinel.hander.CommonGlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "...testA";
    }


    @GetMapping("/testB")
    public String testB(){
        log.info("线程:\t"+Thread.currentThread().getName()+"\t正在处理");
        return "...testB";
    }

    @GetMapping("/testC")
    @SentinelResource(value = "testC",blockHandler = "deal_testC")
    public String testC(@RequestParam(value = "p1",required = false) String p1,
                        @RequestParam(value = "p2",required = false) String p2){
        return "...testC";
    }

    public String deal_testC(String p1, String p2, BlockException e){
        return "...deal_testC";
    }

    @GetMapping("/testD")
    @SentinelResource(value = "testD",blockHandlerClass = CommonGlobalException.class,blockHandler = "testDException2")
    public String testD(){
        return "...testD";
    }
}
