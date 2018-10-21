package com.xcc.shop.mapper;

import com.xcc.shop.model.ImgUrls;
import com.xcc.shop.model.ProductData;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexMapper {
    @Select("SELECT * FROM ProductData")
    List<ProductData> selecAllProductData();

    @Select("SELECT * FROM ImgUrls")
    List<ImgUrls> selecAllImgUrls();
}
