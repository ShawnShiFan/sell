package com.shawn.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: Shawn
 * @Date: 2019/3/23 15:53
 * @Version 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {
    /**微信appid.*/
    private String mpAppId;

    /**微信appSecret.*/
    private String mpAppSecret;

    /**开放平台id*/
    private String openAppId;

    /**开放平台密钥*/

    private String openAppSecret;
    /**商户id.*/
    private String mchId;

    /**商户key.*/
    private String mchKey;

    /**证书存放路径.*/
    private String keyPath;

    /** 微信支付异步通知地址*/
    private String notifyUrl;

    /** 微信模板id*/
    private Map<String,String> templateId;

}
