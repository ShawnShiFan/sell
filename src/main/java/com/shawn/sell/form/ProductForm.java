package com.shawn.sell.form;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: Shawn
 * @Date: 2019/4/8 14:31
 * @Version 1.0
 */
@Data
public class ProductForm {

    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 类目编号. */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

}
