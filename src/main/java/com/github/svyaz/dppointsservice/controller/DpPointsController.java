package com.github.svyaz.dppointsservice.controller;

import com.github.svyaz.dppointsservice.constant.DpPointType;
import com.github.svyaz.dppointsservice.converter.CityToCityDtoConverter;
import com.github.svyaz.dppointsservice.converter.CountryToCountryDtoConverter;
import com.github.svyaz.dppointsservice.converter.DpServiceToDpServiceDtoConverter;
import com.github.svyaz.dppointsservice.dto.CityDto;
import com.github.svyaz.dppointsservice.dto.CountryDto;
import com.github.svyaz.dppointsservice.dto.DpServiceDto;
import com.github.svyaz.dppointsservice.service.DpPointsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class DpPointsController {

    private final DpPointsService service;
    private final CountryToCountryDtoConverter countryToCountryDtoConverter;
    private final CityToCityDtoConverter cityToCityDtoConverter;
    private final DpServiceToDpServiceDtoConverter dpServiceToDpServiceDtoConverter;

    public DpPointsController(DpPointsService dpPointsService,
                              CountryToCountryDtoConverter countryToCountryDtoConverter,
                              CityToCityDtoConverter cityToCityDtoConverter,
                              DpServiceToDpServiceDtoConverter dpServiceToDpServiceDtoConverter) {
        this.service = dpPointsService;
        this.countryToCountryDtoConverter = countryToCountryDtoConverter;
        this.cityToCityDtoConverter = cityToCityDtoConverter;
        this.dpServiceToDpServiceDtoConverter = dpServiceToDpServiceDtoConverter;
    }

    @GetMapping(value = "/countries")
    @ResponseBody
    public ResponseEntity<List<CountryDto>> getCountriesList(
            @RequestParam(value = "filter", required = false) String filterString) {
        List<CountryDto> countryDtoList = countryToCountryDtoConverter.convert(service.getCountriesList(filterString));
        return ResponseEntity.ok(countryDtoList);
    }

    @GetMapping(value = "/countries/{countryId}/cities")
    @ResponseBody
    // TODO:  @Pattern(regexp = "^[0-9]{1,3}$", message = "Неверный идентификатор страны")
    public ResponseEntity<List<CityDto>> getCitiesList(
            @PathVariable(name = "countryId") int countryId,
            @RequestParam(value = "filter", required = false) String filterString) {
        List<CityDto> cityDtoList = cityToCityDtoConverter.convert(service.getCitiesList(countryId, filterString));
        return ResponseEntity.ok(cityDtoList);
    }

    @GetMapping(value = "/services")
    @ResponseBody
    public ResponseEntity<List<DpServiceDto>> getServicesList() {
        List<DpServiceDto> dpServiceListDto = dpServiceToDpServiceDtoConverter.convert(service.getServicesList());
        return ResponseEntity.ok(dpServiceListDto);
    }

    @GetMapping(value = "/points")
    @ResponseBody
    // TODO: валидацию параметров
    public String getPoints(
            @RequestParam(value = "cityId") int cityId,
            @RequestParam(value = "type") DpPointType dpPointType) {

        return String.format("Points for cityId=%s, type=%s",
                cityId, dpPointType);
    }
}
