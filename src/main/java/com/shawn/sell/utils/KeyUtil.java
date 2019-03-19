package com.shawn.sell.utils;

import java.util.Random;

/**
 * @Author: Shawn
 * @Date: 2019/2/18 19:11
 */
public class KeyUtil {
    /**
     * 生成唯一主键
     * 格式：时间+随机数
     */

    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
