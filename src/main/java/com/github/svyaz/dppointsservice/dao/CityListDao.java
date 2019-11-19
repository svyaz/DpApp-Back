package com.github.svyaz.dppointsservice.dao;

import com.github.svyaz.dppointsservice.model.City;

import java.util.List;

public interface CityListDao {
    List<City> getList(long countryId, String filter);
}
