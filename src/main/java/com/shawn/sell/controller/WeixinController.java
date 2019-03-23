package com.shawn.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Shawn
 * @Date: 2019/3/21 20:54
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {
    @GetMapping("/auth")
    public void auth(@RequestParam("code")String code){
        log.info("进入auth方法。。");
        log.info("code={}",code);

        String url ="https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx2feaada02fb55b5f&secret=3627038c9661f48e4bcb288594ab74d5&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
         String response = restTemplate.getForObject(url,String.class);
        log.info("response={}",response);

    }

}
