package com.github.svyaz.dppointsservice.dao;

import com.github.svyaz.dppointsservice.model.Country;

import java.util.List;

public interface CountryListDao {
    List<Country> getList(String filter);
}
