package com.xcc.shop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductData {
    public int id;
    public String name;
    public double price_yh;
    public double price;
    public int shiyong;
    public String photo_x;
    public String pro_number;
    public int typetreeid;
    public int num;
}
