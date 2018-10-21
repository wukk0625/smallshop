package com.xcc.shop.mapper;

import com.xcc.shop.model.TypeTree;
import com.xcc.shop.model.Types;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {
    @Select("SELECT * FROM Types")
    List<Types> selecAllTypes();

    @Select("SELECT * FROM TypeTree where types_id=#{currType}")
    List<TypeTree> selecAllTypeTree(Integer currType);
}
