package com.github.svyaz.dppointsservice.converter;

import com.github.svyaz.dppointsservice.dto.DpPointDto;
import com.github.svyaz.dppointsservice.model.DpPoint;
import org.springframework.stereotype.Component;

@Component
public class DpPointToDpPointDtoConverter extends AbstractConverter<DpPoint, DpPointDto> {
    @Override
    public DpPointDto convert(DpPoint dpPoint) {
        return null;
    }
}
