package com.shawn.sell.service.impl;

import com.shawn.sell.dao.OrderDetailRepository;
import com.shawn.sell.dao.OrderMasterRepository;
import com.shawn.sell.dataobject.OrderDetail;
import com.shawn.sell.dataobject.ProductInfo;
import com.shawn.sell.dto.OrderDTO;
import com.shawn.sell.enums.ResultEnum;
import com.shawn.sell.exception.SellException;
import com.shawn.sell.service.OrderService;
import com.shawn.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @Author: Shawn
 * @Date: 2019/2/17 21:39
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderDetailRepository repository;


    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

            // 1.查询商品（数量，价格）
        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()){
            ProductInfo productInfo = productService.findById(orderDetail.getProductId());
            if (productInfo == null){
                throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            //2.计算总价
           orderAmount = orderDetail.getProductPrice()
                   .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                   .add(orderAmount);

            //订单详情入库
            repository.save(orderDetail);

        }

            //3.写入订单数据库(orderMaster和orderDetail)
            //4.扣库存
        return null;
    }

    @Override
    public OrderDTO findById(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO Cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO Finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO Paid(OrderDTO orderDTO) {
        return null;
    }
}
