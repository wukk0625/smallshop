package com.xcc.shop.mapper;

import com.xcc.shop.model.Address;
import com.xcc.shop.model.Area;
import com.xcc.shop.model.City;
import com.xcc.shop.model.Province;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressMapper {
    @Select("select * from province")
    List<Province> selectProvince();

    @Select("select concat(p.name,c.name,a.name) from province p,city c,area a \n" +
            "where p.id=c.sheng and c.id=a.city and c.sheng=#{sheng} and c.city=#{city} and a.quyu=#{quyu}")
    String selectInfo(City city);

    @Select("select * from city where sheng=#{sheng}")
    List<City> selectProvinceCity(City city);

    @Select("SELECT\n" +
            "\t*\n" +
            "FROM\n" +
            "\tarea\n" +
            "WHERE\n" +
            "\tcity = (select id from city where sheng=#{sheng} and city=#{city})")
    List<Area> selectProvinceCityArea(City city);

    @Select("select * from address where user_id= #{user_id}")
    List<Address> selectAddressAll(Address address);

    @Insert("insert into address (name,tel,user_id,code,receiver) values (#{name},#{tel},#{user_id},#{code},#{receiver})")
    void saveAddress(Address address);

    @Update("update address set is_default='0' where user_id= #{user_id}")
    void updateAll(Address address);

    @Update("update address set is_default='1' where user_id= #{user_id} and id=#{id}")
    void updateAddressDefault(Address address);

    @Delete("delete from address  where user_id= #{user_id} and id=#{id}")
    void deleteAddress(Address address);
}
