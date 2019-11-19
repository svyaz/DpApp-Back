package com.github.svyaz.dppointsservice.service.impl;

import com.github.svyaz.dppointsservice.dao.CityListDao;
import com.github.svyaz.dppointsservice.model.City;
import com.github.svyaz.dppointsservice.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    private CityListDao cityDao;

    public CityServiceImpl(CityListDao dao) {
        this.cityDao = dao;
    }

    @Override
    public List<City> getCities(long countryId, String filter) {
        String f = filter == null ? "" : filter;
        return cityDao.getList(countryId, f);
    }
}
