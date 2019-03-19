package com.shawn.sell.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shawn.sell.dataobject.OrderDetail;
import com.shawn.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 数据传输对象（给想要显示的内容）
 * @Author: Shawn
 * @Date: 2019/2/17 21:33
 */
@Data
/*@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)*/
/*
@JsonInclude(JsonInclude.Include.NON_NULL)  //新方法，当返回给前端多余的且为NULL的时候，可以使用此方法
*/
public class OrderDTO {
    private String orderId;

    /**买家名字 */
    private String buyerName;

    /**买家手机号 */
    private String buyerPhone;

    /**买家地址*/
    private  String buyerAddress;

    /**买家微信Openid */
    private String buyerOpenid;

    /**订单总金额 */
    private BigDecimal orderAmount;
    /**订单状态 默认为新下单*/
    private Integer orderStatus;

    /**付款状态 */
    private Integer payStatus;

    /** 创建时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    /** 更新时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private  Date updateTime;

    List<OrderDetail> orderDetailList;


}
