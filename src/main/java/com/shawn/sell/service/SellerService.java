package com.shawn.sell.service;

import com.shawn.sell.dataobject.SellerInfo;

/**
 * @Author: Shawn
 * @Date: 2019/4/8 17:13
 * @Version 1.0
 */
public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
    SellerInfo findSellerInfoByUsername(String username);
}
