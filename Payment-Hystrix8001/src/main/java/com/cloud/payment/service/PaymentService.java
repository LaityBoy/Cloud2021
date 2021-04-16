package com.cloud.payment.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String instance_ok(Integer id){
        String result="线程名为:"+Thread.currentThread().getName()+"\t id:"+id+"\t 访问ok";
        return result;
    }


    @HystrixCommand(fallbackMethod = "instance_timeOutFall",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String instance_timeOut(Integer id){
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result="线程名为:"+Thread.currentThread().getName()+"\t id:"+id+"\t 访问超时";
        return result;
    }

    public String instance_timeOutFall(Integer id){
        return "服务提供者超时异常或宕机";
    }
}
