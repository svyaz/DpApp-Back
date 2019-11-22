package com.github.svyaz.dppointsservice.converter;

import com.github.svyaz.dppointsservice.dto.DpPointDto;
import com.github.svyaz.dppointsservice.model.DpPoint;
import org.springframework.stereotype.Component;

@Component
public class DpPointToDpPointDtoConverter extends AbstractConverter<DpPoint, DpPointDto> {
    @Override
    public DpPointDto convert(DpPoint dpPoint) {
        DpPointDto dpPointDto = new DpPointDto();
        dpPointDto.setId(dpPoint.getId());
        dpPointDto.setName(dpPoint.getName());
        dpPointDto.setAddress(dpPoint.getAddress());
        dpPointDto.setBank(dpPoint.getBank());
        dpPointDto.setCity(dpPoint.getCity());
        dpPointDto.setDpServices(dpPoint.getDpServices());
        return dpPointDto;
    }
}
