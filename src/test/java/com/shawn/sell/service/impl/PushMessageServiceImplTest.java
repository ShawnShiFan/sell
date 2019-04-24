package com.shawn.sell.service.impl;

import com.shawn.sell.dto.OrderDTO;
import com.shawn.sell.service.OrderService;
import com.shawn.sell.service.PushMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Shawn
 * @Date: 2019/4/24 15:03
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageServiceImpl pushMessageService;
    @Autowired
    private OrderService orderService;

    @Test
    public void orderStatus() {
        OrderDTO orderDTO =orderService.findById("1555307834877807733");
        pushMessageService.orderStatus(orderDTO);

    }
}