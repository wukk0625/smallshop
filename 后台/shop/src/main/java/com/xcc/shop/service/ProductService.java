package com.xcc.shop.service;

import com.xcc.shop.mapper.ProductMapper;
import com.xcc.shop.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;

    public ProductData selecProductData(Integer pro_id) {
        return productMapper.selecProductData(pro_id);
    }

    public List<ProductBanner> selecProductBanner(Integer pro_id) {
        return productMapper.selecProductBanner(pro_id);
    }
    public List<ListDetail> selecProductTypeTrees(Integer cat_id) {
        return productMapper.selecProductTypeTrees(cat_id);
    }

    public TypeTree selecTypeTree(Integer typetreeid) {
        return productMapper.selecTypeTree(typetreeid);
    }

    public Types selecTypes(Integer types_id) {
        return productMapper.selecTypes(types_id);
    }

}