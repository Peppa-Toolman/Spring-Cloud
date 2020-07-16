package com.toolmanclub.springcloud.seata.controller;


import com.toolmanclub.springcloud.seata.domain.CommonResult;
import com.toolmanclub.springcloud.seata.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 帐户控制器
 *
 * @author Yujie Wang
 * @date 2020-07-16 15:26
 */
@RestController
public class AccountController {


    @Resource
    AccountService accountService;

    /**
     * 扣减账户余额
     */
    @RequestMapping("/account/decrease")
    public CommonResult<Object> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult<>(200, "扣减账户余额成功！");
    }
}
