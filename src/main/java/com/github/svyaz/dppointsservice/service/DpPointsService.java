package com.github.svyaz.dppointsservice.service;

import com.github.svyaz.dppointsservice.model.City;
import com.github.svyaz.dppointsservice.model.Country;
import com.github.svyaz.dppointsservice.model.DpService;

import java.util.List;

public interface DpPointsService {
    List<Country> getCountriesList(String filterString);

    List<City> getCitiesList(int countryId, String filterString);

    List<DpService> getServicesList();
}
