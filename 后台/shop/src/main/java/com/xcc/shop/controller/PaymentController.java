package com.xcc.shop.controller;

import com.xcc.shop.model.Address;
import com.xcc.shop.model.BigBean;
import com.xcc.shop.model.PayBean;
import com.xcc.shop.model.ProductData;
import com.xcc.shop.service.PaymentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PaymentController {
    private Logger logger = Logger.getLogger(this.getClass());
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping(value = "/Api/Payment/buy_cart", method = RequestMethod.POST)
    public BigBean add(PayBean payBean) {
        BigBean bigBean = new BigBean();
        try {
            payBean.cart_id = payBean.cart_id.substring(0, payBean.cart_id.length() - 1);
            List<ProductData> prolist = new ArrayList<ProductData>();
            String[] split = payBean.cart_id.split(",");
            double totalPrice = 0;
            for (String cart_id : split) {
                payBean.cart_id = cart_id;
                ProductData productData = paymentService.selectAllProductData(payBean);
                totalPrice += productData.num * productData.price_yh;
                prolist.add(productData);
            }
            bigBean.totalPrice = totalPrice;
            bigBean.prolist = prolist;
            Address address = paymentService.selectAddress(payBean.uid);
            if (address != null) {
                bigBean.addr = address;
                bigBean.addemt = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigBean;
    }
}
