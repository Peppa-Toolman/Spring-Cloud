package com.toolmanclub.springcloud.seata.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yujie Wang
 * @date 2020/7/16 14:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage {

    private Long    id;
    private Long    productId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
