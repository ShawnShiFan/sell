package com.shawn.sell.dao;

import com.shawn.sell.dataobject.ProductCategory;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


/**
 * @Author: Shawn
 * @Date: 2019/1/25 19:47
 */
@Data
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findById(1).get();
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生最爱11");
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest() {   //需要一个对应的无参构造方法
        List<Integer> list = Arrays.asList(2, 3, 4);

        List<ProductCategory> result = repository.findByCategoryTypeIn(list);

        Assert.assertNotEquals(0, result.size());


    }
}