package com.xcc.shop.service;

import com.xcc.shop.mapper.PaymentMapper;
import com.xcc.shop.model.Address;
import com.xcc.shop.model.PayBean;
import com.xcc.shop.model.ProductData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentMapper paymentMapper;

    public Address selectAddress(Integer user_id) {
        return paymentMapper.selectAddress(user_id);
    }

    public ProductData selectAllProductData(PayBean payBean) {
        return paymentMapper.selectAllProductData(payBean);
    }

}