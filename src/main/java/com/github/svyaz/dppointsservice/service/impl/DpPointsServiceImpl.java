package com.github.svyaz.dppointsservice.service.impl;

import com.github.svyaz.dppointsservice.model.City;
import com.github.svyaz.dppointsservice.model.Country;
import com.github.svyaz.dppointsservice.service.DpPointsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DpPointsServiceImpl implements DpPointsService {

    @Override
    public List<Country> getCountriesList(String filterString) {
        List<Country> list = new ArrayList<>();
        list.add(new Country(1, "Россия"));
        list.add(new Country(2, "Таджикистан"));
        list.add(new Country(3, "Киргизия"));
        return list;
    }

    @Override
    public List<City> getCitiesList(int countryId, String filterString) {
        List<City> list = new ArrayList<>();

        list.add(new City(1,1, "Москва"));
        list.add(new City(2,1, "Новосибирск"));
        list.add(new City(3,1, "Кемерово"));

        list.add(new City(4,2, "Душанбе"));
        list.add(new City(5,2, "Истаравшан"));

        list.add(new City(6,3, "Бишкек"));
        list.add(new City(7,3, "Кант"));
        list.add(new City(8,3, "Ош"));
        list.add(new City(9,3, "Манас"));

        return list;
    }
}
