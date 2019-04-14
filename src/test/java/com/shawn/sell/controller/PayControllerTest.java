package com.shawn.sell.controller;

import com.shawn.sell.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author: Shawn
 * @Date: 2019/4/14 13:44
 * @Version 1.0
 */
public class PayControllerTest {

    @Autowired
    private PayController payController;

    private  final String orderId = "1552716505178906013";


    @Test
    public void create() {
       Assert.assertEquals(PayStatusEnum.SUCCESS.getMessage(), payController.create("1552716505178906013"));

    }
}