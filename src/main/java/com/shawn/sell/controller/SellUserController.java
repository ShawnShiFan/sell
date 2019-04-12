package com.shawn.sell.controller;


import com.shawn.sell.dataobject.SellerInfo;
import com.shawn.sell.enums.ResultEnum;
import com.shawn.sell.exception.SellException;
import com.shawn.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.Map;

/**
 * @Author: Shawn
 * @Date: 2019/4/8 17:55
 * @Version 1.0
 */
@Controller
@RequestMapping("/seller/login")
public class SellUserController {
   @Autowired
   private SellerService sellerService;

    @GetMapping("/index")
    public ModelAndView login(@RequestParam("userName") String userName,
                              @RequestParam("passWord") String passWord,
                              Map<String , Object> map){
        SellerInfo sellerInfo = sellerService.findSellerInfoByUsername(userName);
       if (sellerInfo==null){
//           throw new SellException(ResultEnum.SELLER_NOT_EXIST);
           map.put("msg", "卖家账户不存在");
           map.put("url", "http://localhost:8080/sell");
           return new ModelAndView("common/error", map);
       }
       if (sellerInfo.getPassword().equals(DigestUtils.md5DigestAsHex(passWord.getBytes()))){
           map.put("sellerInfo",sellerInfo);
           map.put("msg", ResultEnum.SELLER_LOGIN_SUCCESS.getMessage());
           map.put("url", "http://localhost:8080/sell/seller/order/list");
           return new ModelAndView("common/success", map);
       }else
           map.put("msg", ResultEnum.SELLER_LOGIN_FAIL.getMessage());
           map.put("url", "http://localhost:8080/sell");
           return new ModelAndView("common/error", map);

    }



}
