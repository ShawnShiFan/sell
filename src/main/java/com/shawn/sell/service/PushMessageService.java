package com.shawn.sell.service;

import com.shawn.sell.dto.OrderDTO;

/**
 * 消息推送
 * @Author: Shawn
 * @Date: 2019/4/24 14:48
 * @Version 1.0
 */
public interface PushMessageService {
    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
