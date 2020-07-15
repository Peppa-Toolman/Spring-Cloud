package com.toolmanclub.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Yujie Wang
 * @date 2020/7/14 23:11
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "-------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "-------testB";
    }

    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "-------testD";
    }

    /**
     * 测试热键
     * blockHandler 指定限流后的兜底方法(如果不使用,则发生限流之后会前台会打印报错信息)
     *
     * @param p0 p0
     * @param p1 p1
     * @return {@link String}
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")
    public String testHotKey(@RequestParam(value = "p0", required = false) String p0,
                             @RequestParam(value = "p1", required = false) String p1) {
        return "------testHotKey";
    }

    /**
     * 服务降低兜底方案
     *
     * @param e  e
     * @param p0 p0
     * @param p1 p1
     * @return {@link String}
     */
    public String dealTestHotKey(String p0, String p1, BlockException e) {
        return "------dealTestHotKey";
    }
}