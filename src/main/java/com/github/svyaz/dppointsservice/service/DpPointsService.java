package com.github.svyaz.dppointsservice.service;

import com.github.svyaz.dppointsservice.model.City;
import com.github.svyaz.dppointsservice.model.Country;
import com.github.svyaz.dppointsservice.model.DpService;

import java.util.Set;

public interface DpPointsService {
    Set<Country> getCountries(String filterString);

    Set<City> getCities(Long countryId, String filterString);

    Set<DpService> getServices();
}
