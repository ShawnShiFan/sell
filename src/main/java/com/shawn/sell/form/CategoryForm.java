package com.shawn.sell.form;

import lombok.Data;

import java.util.Date;

/**
 * @Author: Shawn
 * @Date: 2019/4/8 15:56
 * @Version 1.0
 */
@Data
public class CategoryForm {
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
