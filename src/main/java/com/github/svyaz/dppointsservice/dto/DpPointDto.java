package com.github.svyaz.dppointsservice.dto;

import com.github.svyaz.dppointsservice.model.Bank;
import com.github.svyaz.dppointsservice.model.City;
import com.github.svyaz.dppointsservice.model.DpService;

import java.util.Set;

public class DpPointDto {
    private Long id;
    private City city;
    private Bank bank;
    private Set<DpService> dpServices;
    private String name;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Set<DpService> getDpServices() {
        return dpServices;
    }

    public void setDpServices(Set<DpService> dpServices) {
        this.dpServices = dpServices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
