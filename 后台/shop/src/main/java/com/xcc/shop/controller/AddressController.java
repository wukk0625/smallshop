package com.xcc.shop.controller;

import com.xcc.shop.model.*;
import com.xcc.shop.service.AddressService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {
    private Logger logger = Logger.getLogger(this.getClass());
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(value = "/Api/Address/get_province", method = RequestMethod.POST)
    public BigBean get_province() {
        BigBean bigBean = new BigBean();
        try {
            List<Province> provinces = addressService.selectProvince();
            bigBean.listProvince = provinces;
            bigBean.status = "1";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigBean;
    }

    @RequestMapping(value = "/Api/Address/get_city", method = RequestMethod.POST)
    public BigBean get_city(City city) {
        BigBean bigBean = new BigBean();
        try {
            List<City> citys = addressService.selectProvinceCity(city);
            bigBean.city_list = citys;
            bigBean.sheng = city.sheng;
            bigBean.status = "1";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigBean;
    }

    @RequestMapping(value = "/Api/Address/get_area", method = RequestMethod.POST)
    public BigBean get_area(City city) {
        BigBean bigBean = new BigBean();
        try {
            List<Area> areas = addressService.selectProvinceCityArea(city);
            bigBean.area_list = areas;
            bigBean.city = city.city;
            bigBean.status = "1";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigBean;
    }

    @RequestMapping(value = "/Api/Address/get_code", method = RequestMethod.POST)
    public BigBean get_code(City city) {
        BigBean bigBean = new BigBean();
        try {
            bigBean.area = city.quyu;
            bigBean.code = city.sheng + "-" + city.city + "-" + city.quyu;
            bigBean.status = "1";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigBean;
    }

    @RequestMapping(value = "/Api/Address/index", method = RequestMethod.POST)
    public BigBean index(Address address) {
        BigBean bigBean = new BigBean();
        try {
            List<Address> addresses = addressService.selectAddressAll(address);
            bigBean.adds = addresses;
            bigBean.status = "1";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigBean;
    }

    @RequestMapping(value = "/Api/Address/set_default", method = RequestMethod.POST)
    public BigBean set_default(Address address) {
        BigBean bigBean = new BigBean();
        addressService.updateAll(address);
        addressService.updateAddressDefault(address);
        bigBean.status = "1";
        return bigBean;
    }

    @RequestMapping(value = "/Api/Address/del_adds", method = RequestMethod.POST)
    public BigBean del_adds(Address address) {
        BigBean bigBean = new BigBean();
        try {
            addressService.deleteAddress(address);
            bigBean.status = "1";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigBean;
    }

    @RequestMapping(value = "/Api/Address/add_adds", method = RequestMethod.POST)
    public BigBean add_adds(Address address) {
        BigBean bigBean = new BigBean();
        try {
            String code = address.code;
            String[] split = code.split("-");
            City city = new City();
            city.sheng = Integer.parseInt(split[0]);
            city.city = Integer.parseInt(split[1]);
            city.quyu = Integer.parseInt(split[2]);
            String info = addressService.selectInfo(city);
            address.name = info + address.name;
            addressService.saveAddress(address);
            bigBean.status = "1";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigBean;
    }
}
