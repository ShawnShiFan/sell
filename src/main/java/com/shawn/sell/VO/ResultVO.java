package com.shawn.sell.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * @Author: Shawn
 * @Date: 2019/2/11 15:19
 */
@Data
public class ResultVO<T> {

    /**错误码. */
    private  Integer code;

    /**提示信息. */
    private String msg;

    /**具体信息. */
    private  T data;
}
