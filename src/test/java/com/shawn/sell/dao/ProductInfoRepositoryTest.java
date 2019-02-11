package com.shawn.sell.dao;

import com.shawn.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Shawn
 * @Date: 2019/2/11 13:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
   @Autowired
   private ProductInfoRepository repository;

   @Test
   public void saveTest(){
       ProductInfo productInfo = new ProductInfo();
       productInfo.setProductId("12");
       productInfo.setProductName("粥");
       productInfo.setProductPrice(new BigDecimal(6));
       productInfo.setProductStock(100);
       productInfo.setProductDescription("很好喝的");
       productInfo.setProductIcon("https://baike.baidu.com/pic/%E7%B2%A5/363413/0/bd3eb13533fa828b91b4c77af71f4134960a5a97?fr=lemma&ct=single#aid=0&pic=bd3eb13533fa828b91b4c77af71f4134960a5a97");
       productInfo.setProductStatus(0);
       productInfo.setCategoryType(3);

       ProductInfo result = repository.save(productInfo);
   }
    @Test
    public void findByProductStatus() {
     List<ProductInfo> productInfoList = repository.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfoList.size());

   }
}