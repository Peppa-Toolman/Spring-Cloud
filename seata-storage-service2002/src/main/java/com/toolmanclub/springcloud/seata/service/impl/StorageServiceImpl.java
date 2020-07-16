package com.toolmanclub.springcloud.seata.service.impl;

import com.toolmanclub.springcloud.seata.dao.StorageDao;
import com.toolmanclub.springcloud.seata.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Yujie Wang
 * @date 2020/7/16 14:54
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("StorageService 开始扣减库存");
        storageDao.decrease(productId, count);
        log.info("StorageService 扣减库存结束");

    }
}
