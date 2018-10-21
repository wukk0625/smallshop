package com.xcc.shop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {
    public int id;
    public String name;
    public String tel;
    public String is_default;
    public String user_id;
    public String receiver;
    public String code;
}
