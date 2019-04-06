package com.shawn.sell.utils;

import com.shawn.sell.enums.CodeEnum;

/**
 * @Author: Shawn
 * @Date: 2019/4/6 15:33
 */
public class EnumUtil {
    public static<T extends CodeEnum> T getByCode(Integer code,Class<T> enumClass){
        for(T each:enumClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
