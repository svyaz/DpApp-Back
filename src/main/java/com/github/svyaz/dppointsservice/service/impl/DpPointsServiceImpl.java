package com.github.svyaz.dppointsservice.service.impl;

import com.github.svyaz.dppointsservice.model.City;
import com.github.svyaz.dppointsservice.model.DpService;
import com.github.svyaz.dppointsservice.service.DpPointsService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DpPointsServiceImpl implements DpPointsService {

    @Override
    public List<City> getCities(Long countryId, String filterString) {
        return null;
    }

}
