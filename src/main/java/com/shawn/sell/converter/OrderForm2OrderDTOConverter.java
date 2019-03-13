package com.shawn.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shawn.sell.dataobject.OrderDetail;
import com.shawn.sell.dto.OrderDTO;
import com.shawn.sell.enums.ResultEnum;
import com.shawn.sell.exception.SellException;
import com.shawn.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Shawn
 * @Date: 2019/3/13 21:38
 */
@Slf4j
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();  //谷歌的工具转json
        // （因为后面orderForm里面的item是个字符，而传进的是个json）

         OrderDTO orderDTO = new OrderDTO();

         orderDTO.setBuyerName(orderForm.getName());
         orderDTO.setBuyerPhone(orderForm.getPhone());
         orderDTO.setBuyerAddress(orderForm.getAddress());
         orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try{
            orderDetailList =  gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("【对象转换】错误，string={}",orderForm.getItems());
            throw  new SellException(ResultEnum.PARAM_ERROR);
        }
         orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
