package com.shawn.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目
 * @Author: Shawn
 * @Date: 2019/1/25 19:18
 * product_category
 */
@Entity
@DynamicUpdate  //动态更新
@Data
public class ProductCategory {
    //命名表中类名是下划线对应驼峰命名规则
    /**类目id */
    @Id
    @GeneratedValue
    private  Integer categoryId;
   /** 类目名字*/
    private  String categoryName;
   /** 类目编号*/
    private Integer categoryType;


    public  ProductCategory(String categoryName,Integer categoryType){
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

}
