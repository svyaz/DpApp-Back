package com.github.svyaz.dppointsservice.service;

import com.github.svyaz.dppointsservice.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> getCountries(String filter);
}
