package com.shawn.sell.service.impl;

import com.shawn.sell.dao.SellerInfoRepository;
import com.shawn.sell.dataobject.SellerInfo;
import com.shawn.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Shawn
 * @Date: 2019/4/8 17:15
 * @Version 1.0
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }

    @Override
    public SellerInfo findSellerInfoByUsername(String username) {
        return repository.findByUsername(username);
    }
}
