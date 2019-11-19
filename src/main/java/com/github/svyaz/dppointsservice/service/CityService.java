package com.github.svyaz.dppointsservice.service;

import com.github.svyaz.dppointsservice.model.City;

import java.util.List;

public interface CityService {
    List<City> getCities(long countryId, String filter);
}
