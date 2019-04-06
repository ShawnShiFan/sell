package com.shawn.sell.enums;

import lombok.Getter;

/**
 * @Author: Shawn
 * @Date: 2019/2/17 16:13
 */
@Getter
public enum PayStatusEnum implements CodeEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功");

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
