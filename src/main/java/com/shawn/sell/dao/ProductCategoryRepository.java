package com.shawn.sell.dao;

import com.shawn.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Shawn
 * @Date: 2019/1/25 19:27
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    //泛型参数中T代表实体类型，ID则是实体中id的类型。

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
