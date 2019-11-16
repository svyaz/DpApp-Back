package com.github.svyaz.dppointsservice.service.impl;

import com.github.svyaz.dppointsservice.model.City;
import com.github.svyaz.dppointsservice.model.Country;
import com.github.svyaz.dppointsservice.model.DpService;
import com.github.svyaz.dppointsservice.service.DpPointsService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DpPointsServiceImpl implements DpPointsService {

    //TODO: debug
    private List<Country> countries = new ArrayList<>();

    DpPointsServiceImpl() {
        countries.add(new Country((long) 1, "Россия"));
        countries.add(new Country((long) 2, "Таджикистан"));
        countries.add(new Country((long) 3, "Киргизия"));
    }

    @Override
    public Set<Country> getCountries(String filterString) {
        return new HashSet<>(countries);
    }

    @Override
    public Set<City> getCities(Long countryId, String filterString) {
        Set<City> set = new HashSet<>();

        set.add(new City((long) 1, countries.get(1), "Москва"));
        set.add(new City((long) 2, countries.get(1), "Новосибирск"));
        set.add(new City((long) 3, countries.get(1), "Кемерово"));

        set.add(new City((long) 4, countries.get(2), "Душанбе"));
        set.add(new City((long) 5, countries.get(2), "Истаравшан"));

        set.add(new City((long) 6, countries.get(3), "Бишкек"));
        set.add(new City((long) 7, countries.get(3), "Кант"));
        set.add(new City((long) 8, countries.get(3), "Ош"));
        set.add(new City((long) 9, countries.get(3), "Манас"));

        return set;
    }

    @Override
    public Set<DpService> getServices() {
        Set<DpService> set = new HashSet<>();
        set.add(new DpService((long) 1, "Прием денежного перевода"));
        set.add(new DpService((long) 2, "Выдача денежного перевода"));
        set.add(new DpService((long) 3, "Гашение кредитов"));
        set.add(new DpService((long) 4, "Выдача переводов от юрлиц"));
        return set;
    }
}
