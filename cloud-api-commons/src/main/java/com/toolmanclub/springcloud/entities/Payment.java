package com.toolmanclub.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单
 *
 * @author Yujie Wang
 * @date 2020/7/8 1:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private Integer id;
    private String  serial;
}
