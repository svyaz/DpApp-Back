package com.github.svyaz.dppointsservice.controller;

import com.github.svyaz.dppointsservice.converter.*;
import com.github.svyaz.dppointsservice.dto.*;
import com.github.svyaz.dppointsservice.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class DpPointsController {

    private final CountryService countryService;
    private final CityService cityService;
    private final DpServiceService dpServiceService;
    private final DpPointsService dpPointsService;

    private final CountryToCountryDtoConverter countryToCountryDtoConverter;
    private final CityToCityDtoConverter cityToCityDtoConverter;
    private final DpServiceToDpServiceDtoConverter dpServiceToDpServiceDtoConverter;
    private final DpPointToDpPointDtoConverter dpPointToDpPointDtoConverter;

    public DpPointsController(CountryService countryService,
                              CityService cityService,
                              DpServiceService dpServiceService,
                              DpPointsService dpPointsService,
                              CountryToCountryDtoConverter countryToCountryDtoConverter,
                              CityToCityDtoConverter cityToCityDtoConverter,
                              DpServiceToDpServiceDtoConverter dpServiceToDpServiceDtoConverter,
                              DpPointToDpPointDtoConverter dpPointToDpPointDtoConverter) {

        this.countryService = countryService;
        this.cityService = cityService;
        this.dpServiceService = dpServiceService;
        this.dpPointsService = dpPointsService;

        this.countryToCountryDtoConverter = countryToCountryDtoConverter;
        this.cityToCityDtoConverter = cityToCityDtoConverter;
        this.dpServiceToDpServiceDtoConverter = dpServiceToDpServiceDtoConverter;
        this.dpPointToDpPointDtoConverter = dpPointToDpPointDtoConverter;
    }

    @GetMapping(value = "/countries")
    @ResponseBody
    public ResponseEntity<List<CountryDto>> getCountries(
            @RequestParam(name = "filter", required = false) String filterString) {
        List<CountryDto> countryDtoList = countryToCountryDtoConverter.convert(countryService.getCountries(filterString));
        return ResponseEntity.ok(countryDtoList);
    }

    @GetMapping(value = "/countries/{countryId}/cities")
    @ResponseBody
    // TODO:  @Pattern(regexp = "^[0-9]{1,3}$", message = "Неверный идентификатор страны")
    public ResponseEntity<List<CityDto>> getCities(
            @PathVariable(name = "countryId") long countryId,
            @RequestParam(name = "filter", required = false) String filterString) {
        List<CityDto> cityDtoList = cityToCityDtoConverter.convert(cityService.getCities(countryId, filterString));
        return ResponseEntity.ok(cityDtoList);
    }

    @GetMapping(value = "/services")
    @ResponseBody
    public ResponseEntity<List<DpServiceDto>> getServices() {
        List<DpServiceDto> dpServiceDtoList = dpServiceToDpServiceDtoConverter.convert(dpServiceService.getServices());
        return ResponseEntity.ok(dpServiceDtoList);
    }

    @GetMapping(value = "/points")
    @ResponseBody
    // TODO: валидацию параметров
    public ResponseEntity<List<DpPointDto>> getPoints(
            @RequestParam(name = "cityId") long cityId,
            @RequestParam(name = "s") long[] serviceIds) {
        List<DpPointDto> dpPointDtoList = dpPointToDpPointDtoConverter.convert(dpPointsService.getDpPoints(cityId, serviceIds));
        return ResponseEntity.ok(dpPointDtoList);
    }
}
