package com.shawn.sell.dao;

import com.shawn.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author: Shawn
 * @Date: 2019/2/17 19:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "110110";

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("Strive");
        orderMaster.setBuyerPhone("18816283730");
        orderMaster.setBuyerAddress("苏州江科大");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));


        OrderMaster result = repository.save(orderMaster);

        Assert.assertNotNull(result);

    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest request = PageRequest.of(0, 2);

        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, request);
        System.out.println(result.getTotalElements());
    }
}