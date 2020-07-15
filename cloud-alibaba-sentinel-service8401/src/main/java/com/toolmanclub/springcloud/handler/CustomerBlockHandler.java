package com.toolmanclub.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.toolmanclub.springcloud.entities.CommonResult;

/**
 * @author Yujie Wang
 * @date 2020/7/15 14:25
 */
public class CustomerBlockHandler {

    public static CommonResult<Object> handleException1(BlockException blockException) {
        return new CommonResult<>(444, "自定义global handlerException-----1");
    }

    public static CommonResult<Object> handleException2(BlockException blockException) {
        return new CommonResult<>(444, "自定义global handlerException-----2");
    }
}
