package com.shawn.sell.enums;

import lombok.Data;
import lombok.Getter;

/**
 * 商品状态
 *
 * @Author: Shawn
 * @Date: 2019/2/11 14:26
 */
@Getter
public enum ProductStatusEnum  implements CodeEnum {

    UP(0, "在架"),
    DOWN(1, "下架");
    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
