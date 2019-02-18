package com.shawn.sell.dto;

import com.shawn.sell.dataobject.OrderDetail;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 数据传输对象（给想要显示的内容）
 * @Author: Shawn
 * @Date: 2019/2/17 21:33
 */
@Data
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
    private Date createTime;
    /** 更新时间*/
    private  Date updateTime;

    List<OrderDetail> orderDetailList ;


}
