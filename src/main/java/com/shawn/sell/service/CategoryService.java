package com.shawn.sell.service;

import com.shawn.sell.dataobject.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Shawn
 * @Date: 2019/2/6 22:05
 */
@Service
public interface CategoryService {
   ProductCategory findById(Integer categoryId);

   List<ProductCategory> findAll();

   List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

   ProductCategory save(ProductCategory productCategory);

}
