package com.toolmanclub.springcloud.seata.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yujie Wang
 * @date 2020/7/16 1:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String  message;
    private T       data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
