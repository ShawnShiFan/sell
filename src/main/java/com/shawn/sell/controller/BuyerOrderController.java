package com.shawn.sell.controller;

import com.shawn.sell.VO.ResultVO;
import com.shawn.sell.converter.OrderForm2OrderDTOConverter;
import com.shawn.sell.dto.OrderDTO;
import com.shawn.sell.enums.ResultEnum;
import com.shawn.sell.exception.SellException;
import com.shawn.sell.form.OrderForm;
import com.shawn.sell.service.OrderService;
import com.shawn.sell.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Shawn
 * @Date: 2019/3/13 17:34
 * @Version 1.0
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;
    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>>create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确，orderFrom={}",orderForm);
            throw  new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        //判断是否为空
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车不能为空");
            throw  new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult =  orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",createResult.getOrderId());
        return ResultVOUtil.success(map);

    }

    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page",defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size){
                if (StringUtils.isEmpty(openid)){
                    log.error("【查询订单列表】openid为空");
                    throw  new SellException(ResultEnum.PARAM_ERROR);
                }

                PageRequest request =PageRequest.of(page,size);
                Page<OrderDTO> orderDTOPage =    orderService.findList(openid,request);

           return ResultVOUtil.success(orderDTOPage.getContent());

    /*        ResultVO resultVO = new ResultVO();
            resultVO.setCode(0);
            return resultVO;*/

    }


    //订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId){
        //TODO
        /*安全性问题 待改进*/
       OrderDTO orderDTO =  orderService.findById(orderId);
        return ResultVOUtil.success(orderDTO);

    }

    //取消订单


}
