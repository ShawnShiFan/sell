package com.shawn.sell.converter;

import com.shawn.sell.dataobject.OrderMaster;
import com.shawn.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Shawn
 * @Date: 2019/2/19 22:21
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;

    }

    //lambda 返回一个list给orderDto
    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(
                e -> convert(e))
                .collect(Collectors.toList());
    }
}
