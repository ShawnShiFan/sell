package com.shawn.sell.dao;

import com.shawn.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @Author: Shawn
 * @Date: 2019/4/8 16:54
 * @Version 1.0
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {
    SellerInfo findByOpenid(String openid);
}
