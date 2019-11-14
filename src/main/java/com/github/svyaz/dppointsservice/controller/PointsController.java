package com.github.svyaz.dppointsservice.controller;

import com.github.svyaz.dppointsservice.constant.DpPointType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/v1", produces = "application/json")
public class PointsController {

    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    @ResponseBody
    public String getCountriesList(
            @RequestParam(value = "filter", required = false) String filterString) {
        return "Countries: " + filterString;
    }

    @RequestMapping(value = "/countries/{countryId}/cities", method = RequestMethod.GET)
    @ResponseBody
    // TODO:  @Pattern(regexp = "^[0-9]{1,3}$", message = "Неверный идентификатор страны")
    public String getCitiesList(
            @PathVariable(name = "countryId") int countryId,
            @RequestParam(value = "filter", required = false) String filterString) {
        return "Cities: filterString=" + filterString + ", countryId=" + countryId;
    }

    @RequestMapping(value = "/points", method = RequestMethod.GET)
    @ResponseBody
    // TODO: валидацию параметров
    public String getPoints(
            @RequestParam(value = "countryId") int countryId,
            @RequestParam(value = "cityId") int cityId,
            @RequestParam(value = "type") DpPointType dpPointType) {

        return String.format("Points for countryId=%s, cityId=%s, type=%s",
                countryId, cityId, dpPointType);
    }
}
