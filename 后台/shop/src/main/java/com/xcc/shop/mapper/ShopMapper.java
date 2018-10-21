package com.xcc.shop.mapper;

import com.xcc.shop.model.PayBean;
import com.xcc.shop.model.ShopCart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopMapper {

    @Select("select num from shopcart where uid= #{uid} and pid=#{pid}")
    Object selectShopCart(ShopCart shopCart);

    @Update("update ShopCart set num=num+#{num} where uid= #{uid} and pid=#{pid}")
    void updateShopCart(ShopCart shopCart);

    @Update("update ShopCart set num=#{num} where uid= #{uid} and pid=#{pid}")
    void updateCart(ShopCart shopCart);

    @Delete("delete from ShopCart where uid= #{uid} and pid=#{cart_id}")
    void deleteCart(PayBean payBean);

    @Insert("insert into ShopCart (uid,pid,num) values (#{uid},#{pid},#{num})")
    void insertShopCart(ShopCart shopCart);

    @Select("select p.name pro_name,p.photo_x,s.num,p.price_yh price,s.pid id from shopcart s,productdata p where s.pid=p.id and uid= #{user_id}")
    List<ShopCart> selectAllCart(Integer user_id);
}
