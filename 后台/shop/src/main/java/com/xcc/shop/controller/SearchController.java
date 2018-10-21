package com.xcc.shop.controller;

import com.xcc.shop.model.BigBean;
import com.xcc.shop.model.KeyList;
import com.xcc.shop.service.SearchService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {
    private Logger logger = Logger.getLogger(this.getClass());
    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @RequestMapping(value = "/Api/Search/index", method = RequestMethod.POST)
    public BigBean index(KeyList keyList) {
        BigBean bigBean = new BigBean();
        try {
//            查找关键字
            List<KeyList> remen = searchService.selecHotKeyList();

            KeyList key = searchService.selecHistoryKeyListCount(keyList);
            if (key != null) {
                searchService.deleteHistoryKeyList(key);
            }

            List<KeyList> history = searchService.selecHistoryKeyList(keyList);
            bigBean.remen = remen;
            bigBean.history = history;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigBean;
    }

    @RequestMapping(value = "/Api/Search/searches", method = RequestMethod.POST)
    public BigBean searches(KeyList keyList) {
        BigBean bigBean = new BigBean();
        try {
//           热搜
            int count = searchService.selectKeyWord(keyList);
            if (count == 0) {
                searchService.insertKeyWord(keyList);
            } else {
                searchService.updateKeyWord(keyList);
            }

            int countHistory = searchService.selectHistoryKeyWord(keyList);
            System.out.println(countHistory);
            if (countHistory == 0) {
                searchService.insertHistoryKeyWord(keyList);
            }
            bigBean.prolist = searchService.selecAllProductDataByKeyWord(keyList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigBean;
    }
}
