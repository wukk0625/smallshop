package com.xcc.shop.mapper;

import com.xcc.shop.model.Address;
import com.xcc.shop.model.PayBean;
import com.xcc.shop.model.ProductData;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMapper {
    @Select("SELECT * FROM address a where a.user_id=#{user_id} and a.is_default='1';")
    Address selectAddress(Integer user_id);

    @Select("SELECT * FROM `shopcart` s, productdata p where s.uid=#{uid} and s.pid=p.id and s.pid in (#{cart_id});")
    ProductData selectAllProductData(PayBean payBean);
}
