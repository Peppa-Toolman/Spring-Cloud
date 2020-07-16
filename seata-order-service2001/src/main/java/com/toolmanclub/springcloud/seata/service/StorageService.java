package com.toolmanclub.springcloud.seata.service;

import com.toolmanclub.springcloud.seata.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Yujie Wang
 * @date 2020/7/16 1:43
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    /**
     * 扣减订单
     *
     * @param productId 产品id
     * @param count     数
     * @return {@link CommonResult <Object>}
     */
    @PostMapping(value = "/storage/decrease")
    CommonResult<Object> decrease(@RequestParam("productId") Long productId,
                                  @RequestParam("count") Integer count);
}
