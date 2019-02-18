package com.shawn.sell.service.impl;

import com.shawn.sell.dao.OrderDetailRepository;
import com.shawn.sell.dao.OrderMasterRepository;
import com.shawn.sell.dataobject.OrderDetail;
import com.shawn.sell.dataobject.OrderMaster;
import com.shawn.sell.dataobject.ProductInfo;
import com.shawn.sell.dto.CartDTO;
import com.shawn.sell.dto.OrderDTO;
import com.shawn.sell.enums.OrderStatusEnum;
import com.shawn.sell.enums.PayStatusEnum;
import com.shawn.sell.enums.ResultEnum;
import com.shawn.sell.exception.SellException;
import com.shawn.sell.service.OrderService;
import com.shawn.sell.service.ProductService;
import com.shawn.sell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Shawn
 * @Date: 2019/2/17 21:39
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
// 方法1       List<CartDTO> cartDTOList = new ArrayList<>();
            // 1.查询商品（数量，价格）
        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()){
            ProductInfo productInfo = productService.findById(orderDetail.getProductId());
            if (productInfo == null){
                throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            //2.计算订单总价
           orderAmount = productInfo.getProductPrice()
                   .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                   .add(orderAmount);

            //订单详情入库
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
              //对象属性拷贝
            BeanUtils.copyProperties(productInfo , orderDetail);
            orderDetailRepository.save(orderDetail);

//1            CartDTO cartDTO = new CartDTO(orderDetail.getProductId(),orderDetail.getProductQuantity());
 // 1          cartDTOList.add(cartDTO);


        }

            //3.写入订单数据库(orderMaster和orderDetail)
            OrderMaster orderMaster = new OrderMaster();
            BeanUtils.copyProperties(orderDTO , orderMaster);
            orderMaster.setOrderId(orderId);
            orderMaster.setOrderAmount(orderAmount);
            orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
            orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
            orderMasterRepository.save(orderMaster);
            //4.扣库存
        //两种方法，一种是直接写在上面for循环中，另一种是单独拿出来用lambda的方法
            List<CartDTO> cartDTOList =  orderDTO.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(), e.getProductQuantity())
                ).collect(Collectors.toList());
            productService.decreaseStock(cartDTOList);

        return orderDTO;
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
