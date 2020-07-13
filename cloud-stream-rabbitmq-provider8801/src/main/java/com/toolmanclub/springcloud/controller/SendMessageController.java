package com.toolmanclub.springcloud.controller;

import com.toolmanclub.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Yujie Wang
 * @date 2020/7/13 20:42
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        messageProvider.send();
        return null;
    }
}
