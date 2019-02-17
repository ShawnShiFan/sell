package com.shawn.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: Shawn
 * @Date: 2019/2/17 17:26
 */
@Entity
@Data
public class OrderDetail {


    @Id
    private String detailId;

    /**订单id */
    private String orderId;

    /**商品id */
    private String productId;

    /**商品名称 */
    private String productName;

    /**商品当前价格，单位分 */
    private BigDecimal productPrice;

    /**商品数量 */
    private Integer productQuantity;

    /**商品小图 */
    private String productIcon;



}
