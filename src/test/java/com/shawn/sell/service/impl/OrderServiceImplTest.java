package com.shawn.sell.service.impl;

import com.shawn.sell.dao.OrderMasterRepository;
import com.shawn.sell.dataobject.OrderDetail;
import com.shawn.sell.dataobject.OrderMaster;
import com.shawn.sell.dto.OrderDTO;
import com.shawn.sell.enums.OrderStatusEnum;
import com.shawn.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Shawn
 * @Date: 2019/2/18 20:38
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;


  private final String BUYER_OPENID ="110110110";
  private final String ORDER_ID = "1552713200732894641";
    @Test
    public void create() {
       OrderDTO orderDTO = new OrderDTO();
       orderDTO.setBuyerName("施凡测试2");
       orderDTO.setBuyerAddress("江苏科技");
       orderDTO.setBuyerPhone("13400000000");
       orderDTO.setBuyerOpenid(BUYER_OPENID);


       //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123456");   //商品id必须是数据库中已经存在的
        o1.setProductQuantity(1);
        orderDetailList.add(o1);

        orderDTO.setOrderDetailList(orderDetailList);
        //将返回的orderDTO压入result
        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】result={}",result);

    }

    @Test
    public void findById() {
      OrderDTO result = orderService.findById(ORDER_ID);
      log.info("【查询订单】 result={} " ,result);
      Assert.assertEquals(ORDER_ID,result.getOrderId());
    }

    @Test
    public void findList() {
        PageRequest request = PageRequest.of(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID,request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
            OrderDTO orderDTO = orderService.findById(ORDER_ID);
            OrderDTO result = orderService.cancel(orderDTO);
            Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());

    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findById(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findById(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getPayStatus());
    }
}