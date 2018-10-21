package com.xcc.shop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ProductInfo {
    public String photo_x;
    public double price_yh;
    public int num;
    public String brand;
    public String name;
    public String pro_number;
    public String cat_name;
    public List<ProductBanner> img_arr;
}
