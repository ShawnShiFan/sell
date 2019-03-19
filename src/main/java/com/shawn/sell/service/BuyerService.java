package com.shawn.sell.service;

import com.shawn.sell.dto.OrderDTO;

/**
 * @Author: Shawn
 * @Date: 2019/3/19 21:27
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);
    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
