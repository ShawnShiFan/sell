package com.shawn.sell.dataobject;

import lombok.Data;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: Shawn
 * @Date: 2019/4/8 16:52
 * @Version 1.0
 */
@Data
@Entity
public class SellerInfo {
    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;
}
