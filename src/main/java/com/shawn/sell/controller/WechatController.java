package com.shawn.sell.controller;

import com.shawn.sell.enums.ResultEnum;
import com.shawn.sell.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;

/**
 * @Author: Shawn
 * @Date: 2019/3/23 15:41
 * @Version 1.0
 */
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl){

        //微信API的Service （实现借助api获取code和access_token）
        //1.配置
        //2/调用方法
        String url ="www.shawnshifan.xyz:8080/sell/wechat/userInfo";
        String redirectUrl =  wxMpService.oauth2buildAuthorizationUrl(url,WxConsts.OAuth2Scope.SNSAPI_USERINFO, URLEncoder.encode(returnUrl));
        return "redirect" +redirectUrl;

    }

    @GetMapping("/userInfo")
    public  String userInfo(@RequestParam("code") String code,
                            @RequestParam("state") String returnUrl){
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken =  new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken =  wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【微信网页授权】 {}",e);
            throw  new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(),e.getError().getErrorMsg());
        }

        String openid = wxMpOAuth2AccessToken.getOpenId();

        return "redirect" +returnUrl+"?openid="+openid;

    }

}
