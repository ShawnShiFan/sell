package com.shawn.sell.service;

import com.shawn.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Author: Shawn
 * @Date: 2019/2/17 21:27
 */
@Service
public interface OrderService {
    /** 创建订单*/
    OrderDTO create(OrderDTO orderDTO);

    /** 查询单个订单*/
    OrderDTO findById(String orderId);
    /** 查询订单列表*/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /** 取消订单*/
    OrderDTO cancel(OrderDTO orderDTO);

    /** 完结订单*/
    OrderDTO finish(OrderDTO orderDTO);


    /** 支付订单*/
    OrderDTO paid(OrderDTO orderDTO);

}
