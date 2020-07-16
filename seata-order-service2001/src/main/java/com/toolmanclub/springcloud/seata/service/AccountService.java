package com.toolmanclub.springcloud.seata.service;

import com.toolmanclub.springcloud.seata.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author Yujie Wang
 * @date 2020/7/16 17:09
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    /**
     * 减少
     *
     * @param userId 用户id
     * @param money  钱
     * @return {@link CommonResult<Object>}
     */
    @PostMapping(value = "/account/decrease")
    CommonResult<Object> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
