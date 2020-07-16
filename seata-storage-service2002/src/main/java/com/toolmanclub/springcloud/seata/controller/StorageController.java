package com.toolmanclub.springcloud.seata.controller;

import com.toolmanclub.springcloud.seata.domain.CommonResult;
import com.toolmanclub.springcloud.seata.service.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Yujie Wang
 * @date 2020/7/16 14:56
 */
@RequestMapping("storage")
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @RequestMapping("/decrease")
    public CommonResult<Object> decrease(@RequestParam("productId") Long productId,
                                         @RequestParam("count") Integer count) {

        storageService.decrease(productId, count);
        return new CommonResult<>(200, "扣减库存成功");
    }
}
