package com.xcc.shop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShopCart {
    public int id;
    public int uid;
    public int pid;
    public int num;
    public String pro_name;
    public String photo_x;
    public int price;
}
