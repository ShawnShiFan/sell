package com.shawn.sell.service;

import com.shawn.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品
 * @Author: Shawn
 * @Date: 2019/2/11 13:52
 */
@Service
public interface ProductService {
    ProductInfo findById(String productId);

    /**
     * 查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();
    //查询所有
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存


    //减库存
}
