package com.shawn.sell.controller;

import com.shawn.sell.dto.OrderDTO;
import com.shawn.sell.enums.ResultEnum;
import com.shawn.sell.exception.SellException;
import com.shawn.sell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 支付
 * @Author: Shawn
 * @Date: 2019/4/2 21:51
 */
@Controller
@RequestMapping("/pay")
public class PayController {
   @Autowired
   private OrderService orderService;
    @GetMapping("/create")
    public void create(@RequestParam("orderId") String orderId,
                        @RequestParam("returnUrl") String returnUrl){
        //1.查询订单
         OrderDTO orderDTO = orderService.findById(orderId);
        if (orderDTO == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //2.发起支付
    }

}
