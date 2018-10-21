package com.xcc.shop.controller;

import com.xcc.shop.model.BigBean;
import com.xcc.shop.service.CategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    private Logger logger = Logger.getLogger(this.getClass());

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/Api/Category/index", method = RequestMethod.POST)
    public BigBean selectAllProductData(Integer currType) {
        BigBean bigBean = new BigBean();
        try {
            bigBean.list = categoryService.selecAllTypes();
            bigBean.catList = categoryService.selecAllTypeTree(currType);
            bigBean.status = "1";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigBean;
    }
}
