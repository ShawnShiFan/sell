package com.shawn.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 基于隐私等方面考虑，所以新建了一个前端需要的ProductInfoList
 * @Author: Shawn
 * @Date: 2019/2/11 15:36
 */
@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private  String productId;

    @JsonProperty("name")
    private  String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private  String productDescription;

    @JsonProperty("icon")
    private  String productIcon;


}

