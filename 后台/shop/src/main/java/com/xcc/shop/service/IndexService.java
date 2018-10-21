package com.xcc.shop.service;

import com.xcc.shop.mapper.IndexMapper;
import com.xcc.shop.model.ImgUrls;
import com.xcc.shop.model.ProductData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {

    @Autowired
    IndexMapper indexMapper;

    public List<ProductData> selecAllProductData() {
        return indexMapper.selecAllProductData();
    }
    public List<ImgUrls> selecAllImgUrls() {
        return indexMapper.selecAllImgUrls();
    }

}