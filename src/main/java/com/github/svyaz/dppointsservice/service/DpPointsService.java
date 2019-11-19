package com.github.svyaz.dppointsservice.service;

import com.github.svyaz.dppointsservice.model.City;

import java.util.List;

public interface DpPointsService {
    List<City> getCities(Long countryId, String filterString);
}
