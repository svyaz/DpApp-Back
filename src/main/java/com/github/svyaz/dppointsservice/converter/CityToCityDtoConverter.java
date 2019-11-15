package com.github.svyaz.dppointsservice.converter;

import com.github.svyaz.dppointsservice.dto.CityDto;
import com.github.svyaz.dppointsservice.model.City;
import org.springframework.stereotype.Component;

@Component
public class CityToCityDtoConverter extends AbstractConverter<City, CityDto> {
    @Override
    public CityDto convert(City city) {
        CityDto cityDto = new CityDto();
        cityDto.setId(city.getId());
        cityDto.setName(city.getName());
        return cityDto;
    }
}
