package com.toolmanclub.springcloud.seata.service;

/**
 * @author Yujie Wang
 * @date 2020/7/16 14:51
 */
public interface StorageService {

    void decrease(Long productId, Integer count);
}
