package com.toolmanclub.springcloud.seata.service.impl;

import com.toolmanclub.springcloud.seata.dao.OrderDao;
import com.toolmanclub.springcloud.seata.domain.Order;
import com.toolmanclub.springcloud.seata.service.AccountService;
import com.toolmanclub.springcloud.seata.service.OrderService;
import com.toolmanclub.springcloud.seata.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Yujie Wang
 * @date 2020/7/16 1:41
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao       orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public void createOrder(Order order) {

        // 1、新建订单
        log.info("---->开始新建订单");
        orderDao.createOrder(order);

        // 2、扣减库存
        log.info("---->订单微服务开始调用库存,开始扣减操作Count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("---->订单微服务开始调用库存,扣减end");

        // 3、扣减余额
        log.info("---->订单微服务开始调用账户,开始扣减操作Money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("---->订单微服务开始调用账户,扣减end");

        // 4、修改订单状态
        log.info("---->开始修改订单状态");
        orderDao.updateOrder(order.getUserId(), 0);
        log.info("---->修改订单状态end");

        log.info("下单结束");
    }
}
