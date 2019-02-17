package com.shawn.sell.enums;

import lombok.Getter;

/**
 * @Author: Shawn
 * @Date: 2019/2/17 22:19
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(10,"商品不存在"),

    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
