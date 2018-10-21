package com.xcc.shop.service;

import com.xcc.shop.mapper.ShopMapper;
import com.xcc.shop.model.PayBean;
import com.xcc.shop.model.ShopCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    @Autowired
    ShopMapper shopMapper;

    public Object selectShopCart(ShopCart shopCart) {
        return shopMapper.selectShopCart(shopCart);
    }

    public void insertShopCart(ShopCart shopCart) {
        shopMapper.insertShopCart(shopCart);
    }

    public void deleteCart(PayBean payBean) {
        shopMapper.deleteCart(payBean);
    }

    public void updateShopCart(ShopCart shopCart) {
        shopMapper.updateShopCart(shopCart);
    }

    public void updateCart(ShopCart shopCart) {
        shopMapper.updateCart(shopCart);
    }

    public List<ShopCart> selectAllCart(Integer user_id) {
        return shopMapper.selectAllCart(user_id);
    }

}