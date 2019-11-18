package com.github.svyaz.dppointsservice.service;

import com.github.svyaz.dppointsservice.model.City;
import com.github.svyaz.dppointsservice.model.DpService;

import java.util.List;

public interface DpPointsService {
    List<City> getCities(Long countryId, String filterString);

    List<DpService> getServices();
}
