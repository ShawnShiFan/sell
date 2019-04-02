package com.shawn.sell.service;

import com.shawn.sell.dto.OrderDTO;

/**
 * 支付
 * @Author: Shawn
 * @Date: 2019/4/2 21:57
 */
public interface PayService {
    void create(OrderDTO orderDTO);

}
