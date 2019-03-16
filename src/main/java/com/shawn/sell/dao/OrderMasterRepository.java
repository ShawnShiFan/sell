package com.shawn.sell.dao;

import com.shawn.sell.dataobject.OrderDetail;
import com.shawn.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Shawn
 * @Date: 2019/2/17 19:26
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

   //按分页来查
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);

}
