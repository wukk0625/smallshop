package com.xcc.shop.controller;

import com.xcc.shop.model.BigBean;
import com.xcc.shop.model.PayBean;
import com.xcc.shop.model.ShopCart;
import com.xcc.shop.service.ShopService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopController {
    private Logger logger = Logger.getLogger(this.getClass());
    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @RequestMapping(value = "/Api/Shopping/add", method = RequestMethod.POST)
    public BigBean add(ShopCart shopCart) {
        logger.info(shopCart.toString());
        BigBean bigBean = new BigBean();
        try {
            Object num = null;
            num = shopService.selectShopCart(shopCart);
            if (num == null) {
                shopService.insertShopCart(shopCart);
            } else {
                shopService.updateShopCart(shopCart);
            }
            bigBean.status = "1";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigBean;
    }
    @RequestMapping(value = "/Api/Shopping/delete", method = RequestMethod.POST)
    public BigBean delete(PayBean payBean) {
        BigBean bigBean = new BigBean();
        try {
            shopService.deleteCart(payBean);
            bigBean.status = "1";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigBean;
    }

    @RequestMapping(value = "/Api/Shopping/index", method = RequestMethod.POST)
    public BigBean index(Integer user_id) {
        BigBean bigBean = new BigBean();
        try {
            List<ShopCart> shopCarts = shopService.selectAllCart(user_id);
            System.out.println(shopCarts);
            bigBean.cart = shopCarts;
            bigBean.status = "1";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigBean;
    }

    @RequestMapping(value = "/Api/Shopping/up_cart", method = RequestMethod.POST)
    public BigBean up_cart(Integer num, Integer user_id, Integer cart_id) {
        BigBean bigBean = new BigBean();
        try {
            System.out.println(user_id);
            System.out.println(num);
            System.out.println(cart_id);
            ShopCart shopCart = new ShopCart();
            shopCart.num = num;
            shopCart.pid = cart_id;
            shopCart.uid = user_id;
            shopService.updateCart(shopCart);
            bigBean.status = "1";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigBean;
    }
}
