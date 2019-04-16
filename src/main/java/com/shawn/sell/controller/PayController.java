package com.shawn.sell.controller;

import com.shawn.sell.dto.OrderDTO;
import com.shawn.sell.enums.PayStatusEnum;
import com.shawn.sell.enums.ResultEnum;
import com.shawn.sell.exception.SellException;
import com.shawn.sell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 支付
 * @Author: Shawn
 * @Date: 2019/4/2 21:51
 */
@RestController
@RequestMapping("/pay")
public class PayController {
   @Autowired
   private OrderService orderService;
    @PostMapping("/create")
    public String create(@RequestParam("orderId") String orderId){
        //1.查询订单
         OrderDTO orderDTO = orderService.findById(orderId);
        if (orderDTO == null){
            return ResultEnum.ORDER_NOT_EXIST.getMessage();
        }
         orderService.paid(orderDTO);
        return PayStatusEnum.SUCCESS.getMessage();
    }

}
