package com.cloud.sentinel.hander;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CommonGlobalException {

    public static String testDException1(BlockException exception){
        return "....testDException1";
    }

    public static String testDException2(BlockException exception){
        return "....testDException2";
    }
}
