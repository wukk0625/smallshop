package com.xcc.shop.mapper;

import com.xcc.shop.model.KeyList;
import com.xcc.shop.model.ProductData;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchMapper {


    @Select("SELECT * FROM `hotKeyList`\n" +
            "ORDER BY count DESC\n" +
            "limit 0,3;")
    List<KeyList> selecHotKeyList();

    @Select("SELECT * FROM `productdata` where name like CONCAT('%',#{keyword},'%');")
    List<ProductData> selecAllProductDataByKeyWord(KeyList keyList);

    @Select("SELECT * FROM `historyKeyList` where uid=#{uid} \n" +
            "ORDER BY id DESC\n" +
            "LIMIT 0,3;")
    List<KeyList> selecHistoryKeyList(KeyList keyList);

    @Select("SELECT count(*)  FROM `hotKeyList` where keyword=#{keyword};")
    int selectKeyWord(KeyList keyList);

    @Select("SELECT count(*)  FROM `historyKeyList` where uid=#{uid} and keyword=#{keyword};")
    int selectHistoryKeyWord(KeyList keyList);

    @Select("SELECT * FROM `historyKeyList` WHERE uid=#{uid} ORDER BY id desc LIMIT 3 ,1")
    KeyList selecHistoryKeyListCount(KeyList keyList);


    @Insert("INSERT INTO `hotKeyList` (keyword,count) VALUES (#{keyword},1);")
    void insertKeyWord(KeyList keyList);

    @Insert("INSERT INTO `historyKeyList` (uid,keyword) VALUES (#{uid},#{keyword});")
    void insertHistoryKeyWord(KeyList keyList);

    @Delete("delete FROM `historyKeyList` where uid=#{uid} and id<=#{id}")
    void deleteHistoryKeyList(KeyList keyList);

    @Update("UPDATE `hotKeyList` set count=count+1 WHERE keyword=#{keyword};")
    void updateKeyWord(KeyList keyList);
}
