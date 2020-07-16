package com.toolmanclub.springcloud.seata.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Yujie Wang
 * @date 2020/7/16 14:41
 */
@Mapper
public interface StorageDao {

    /**
     * 扣减库存
     *
     * @param productId 产品id
     * @param count     数量
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
