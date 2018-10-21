package com.xcc.shop.service;

import com.xcc.shop.mapper.AddressMapper;
import com.xcc.shop.model.Address;
import com.xcc.shop.model.Area;
import com.xcc.shop.model.City;
import com.xcc.shop.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressMapper addressMapper;


    public List<Province> selectProvince() {
        return addressMapper.selectProvince();
    }

    public String selectInfo(City city) {
        return addressMapper.selectInfo(city);
    }

    public List<City> selectProvinceCity(City city) {
        return addressMapper.selectProvinceCity(city);
    }

    public List<Area> selectProvinceCityArea(City city) {
        return addressMapper.selectProvinceCityArea(city);
    }

    public List<Address> selectAddressAll(Address address) {
        return addressMapper.selectAddressAll(address);
    }

    public void saveAddress(Address address) {
        addressMapper.saveAddress(address);
    }

    public void updateAll(Address address) {
        addressMapper.updateAll(address);
    }

    public void updateAddressDefault(Address address) {
        addressMapper.updateAddressDefault(address);
    }

    public void deleteAddress(Address address) {
        addressMapper.deleteAddress(address);
    }

}