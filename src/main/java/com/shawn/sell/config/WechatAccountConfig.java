package com.shawn.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

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
}
