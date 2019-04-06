package com.shawn.sell.enums;

import lombok.Getter;

/**
 * @Author: Shawn
 * @Date: 2019/2/17 16:09
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{
    NEW(0, "新下单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),
    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
