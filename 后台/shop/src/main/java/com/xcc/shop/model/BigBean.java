package com.xcc.shop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class BigBean {
    public List<ProductData> prolist;
    public List<ImgUrls> ggtop;
    public List<Types> list;
    public List<TypeTree> catList;
    public String status;
    public ProductInfo pro;
    public List<ShopCart> cart;
    public List<ListDetail> shopList;
    public List<KeyList> remen;
    public List<KeyList> history;
    public double totalPrice;
    public List<Address> adds;
    public List<Province> listProvince;
    public List<City> city_list;
    public List<Area> area_list;
    public Integer sheng;
    public Integer city;
    public Integer area;
    public String code;
    public Address addr;
    public Integer addemt;
}
