package com.github.svyaz.dppointsservice.converter;

import com.github.svyaz.dppointsservice.dto.CountryDto;
import com.github.svyaz.dppointsservice.model.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryToCountryDtoConverter extends AbstractConverter<Country, CountryDto> {
    @Override
    public CountryDto convert(Country country) {
        CountryDto countryDto = new CountryDto();
        countryDto.setId(country.getId());
        countryDto.setName(country.getName());
        return countryDto;
    }
}
