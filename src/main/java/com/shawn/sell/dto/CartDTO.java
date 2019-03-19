package com.shawn.sell.dto;

import lombok.Data;


/**
 * 购物车
 *
 * @Author: Shawn
 * @Date: 2019/2/18 20:06
 */

@Data
public class CartDTO {
    /**
     * 商品id
     */
    private String productId;
    /**
     * 数量
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
