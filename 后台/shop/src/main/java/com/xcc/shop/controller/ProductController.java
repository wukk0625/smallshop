package com.xcc.shop.controller;

import com.xcc.shop.model.*;
import com.xcc.shop.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private Logger logger = Logger.getLogger(this.getClass());

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/Api/Product/index", method = RequestMethod.POST)
    public BigBean selectProductInfo(Integer pro_id) {
        BigBean bigBean = new BigBean();
        ProductInfo productInfo = new ProductInfo();
        try {
            ProductData productData = productService.selecProductData(pro_id);
            TypeTree typeTree = productService.selecTypeTree(productData.typetreeid);
            Types type = productService.selecTypes(typeTree.types_id);
            List<ProductBanner> productBanners = productService.selecProductBanner(pro_id);

            productInfo.photo_x = productData.photo_x;
            productInfo.price_yh = productData.price_yh;
            productInfo.num = productData.shiyong;
            productInfo.brand = typeTree.name;
            productInfo.name = productData.name;
            productInfo.pro_number = productData.pro_number;
            productInfo.cat_name = type.name;
            productInfo.img_arr = productBanners;

            bigBean.status = "1";
            bigBean.pro = productInfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigBean;
    }

    @RequestMapping(value = "/Api/Product/lists", method = RequestMethod.POST)
    public BigBean selectShopList(Integer cat_id) {
        BigBean bigBean = new BigBean();
        try {
            List<ListDetail> shopList = productService.selecProductTypeTrees(cat_id);
            bigBean.shopList = shopList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigBean;
    }
}
