package com.xcc.shop.controller;

import com.xcc.shop.model.BigBean;
import com.xcc.shop.service.IndexService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    private Logger logger = Logger.getLogger(this.getClass());

    private final IndexService indexService;

    @Autowired
    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @RequestMapping("/Api/Index/index")
    public BigBean selectAllProductData() {
        BigBean bigBean = new BigBean();
        bigBean.prolist=indexService.selecAllProductData();
        bigBean.ggtop=indexService.selecAllImgUrls();
        return bigBean;
    }
}
