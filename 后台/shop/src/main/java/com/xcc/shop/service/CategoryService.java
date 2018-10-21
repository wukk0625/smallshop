package com.xcc.shop.service;

import com.xcc.shop.mapper.CategoryMapper;
import com.xcc.shop.model.TypeTree;
import com.xcc.shop.model.Types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    public List<Types> selecAllTypes() {
        return categoryMapper.selecAllTypes();
    }
    public List<TypeTree> selecAllTypeTree(Integer currType) {
        return categoryMapper.selecAllTypeTree(currType);
    }

}