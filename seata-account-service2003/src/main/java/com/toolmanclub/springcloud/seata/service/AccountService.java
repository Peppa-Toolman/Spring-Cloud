package com.toolmanclub.springcloud.seata.service;

import java.math.BigDecimal;

/**
 * @author Yujie Wang
 * @date 2020/7/16 17:09
 */
public interface AccountService {

    /**
     * 减少
     *
     * @param userId 用户id
     * @param money  钱
     */
    void decrease(Long userId, BigDecimal money);

}
