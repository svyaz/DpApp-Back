package com.github.svyaz.dppointsservice.service.impl;

import com.github.svyaz.dppointsservice.dao.CountryListDao;
import com.github.svyaz.dppointsservice.model.Country;
import com.github.svyaz.dppointsservice.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private CountryListDao countryDao;

    public CountryServiceImpl(CountryListDao dao) {
        this.countryDao = dao;
    }

    @Override
    public List<Country> getCountries(String filter) {
        String f = filter == null ? "" : filter;
        return countryDao.getList(f);
    }
}
