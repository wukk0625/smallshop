package com.xcc.shop.service;

import com.xcc.shop.mapper.SearchMapper;
import com.xcc.shop.model.KeyList;
import com.xcc.shop.model.ProductData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    SearchMapper searchMapper;

    public List<KeyList> selecHotKeyList() {
        return searchMapper.selecHotKeyList();
    }

    public List<ProductData> selecAllProductDataByKeyWord(KeyList keyList) {
        return searchMapper.selecAllProductDataByKeyWord(keyList);
    }

    public List<KeyList> selecHistoryKeyList(KeyList keyList) {
        return searchMapper.selecHistoryKeyList(keyList);
    }

    public int selectKeyWord(KeyList keyList) {
        return searchMapper.selectKeyWord(keyList);
    }

    public KeyList selecHistoryKeyListCount(KeyList keyList) {
        return searchMapper.selecHistoryKeyListCount(keyList);
    }

    public int selectHistoryKeyWord(KeyList keyList) {
        return searchMapper.selectHistoryKeyWord(keyList);
    }

    public void insertKeyWord(KeyList keyList) {
        searchMapper.insertKeyWord(keyList);
    }

    public void insertHistoryKeyWord(KeyList keyList) {
        searchMapper.insertHistoryKeyWord(keyList);
    }

    public void deleteHistoryKeyList(KeyList keyList) {
        searchMapper.deleteHistoryKeyList(keyList);
    }

    public void updateKeyWord(KeyList keyList) {
        searchMapper.updateKeyWord(keyList);
    }
}