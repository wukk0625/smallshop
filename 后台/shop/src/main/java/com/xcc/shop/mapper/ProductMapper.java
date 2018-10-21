package com.xcc.shop.mapper;

import com.xcc.shop.model.*;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {

    @Select("SELECT * FROM productdata where id=#{pro_id}")
    ProductData selecProductData(Integer pro_id);

    @Select("SELECT * FROM productbanner where product_id=#{pro_id}")
    List<ProductBanner> selecProductBanner(Integer pro_id);

    @Select("SELECT * FROM productdata where typetreeid=#{cat_id}")
    List<ListDetail> selecProductTypeTrees(Integer cat_id);

    @Select("SELECT * FROM typetree where id=#{typetreeid}")
    TypeTree selecTypeTree(Integer typetreeid);

    @Select("SELECT * FROM types where id=#{types_id}")
    Types selecTypes(Integer types_id);
}
