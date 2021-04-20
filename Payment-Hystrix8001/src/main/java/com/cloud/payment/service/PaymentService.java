package com.cloud.payment.service;

import cn.hutool.core.util.IdUtil;
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


    //=================服务熔断
    @HystrixCommand(fallbackMethod ="instance_fallBack",commandProperties ={
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//失败率达到多少后跳闸
    })
    public String instance_id(Integer id){
        if(id<0){
            throw new RuntimeException("id不能为复数");
        }

        String ids= IdUtil.randomUUID();
        return "数据返回成功 id为"+id+"\t"+ids;
    }

    public String instance_fallBack(Integer id){
        return "数据返回失败 id为"+id+"\t";
    }

}
