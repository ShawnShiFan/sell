package com.shawn.sell.dao;

import com.shawn.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Shawn
 * @Date: 2019/2/17 21:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {

        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setDetailId("12345");
        orderDetail.setOrderId("123456");
        orderDetail.setProductId("123456");
        orderDetail.setProductName("皮蛋瘦肉粥2");
        orderDetail.setProductPrice(new BigDecimal(3.2));
        orderDetail.setProductQuantity(1);
        orderDetail.setProductIcon("fr=lemma&ct=single#aid=0&pic=bd3eb13533fa828b91b4c77af71f4134960a5a97");

        OrderDetail result = repository.save(orderDetail);

        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("123456");
        Assert.assertNotEquals(0, orderDetailList.size());
    }
}