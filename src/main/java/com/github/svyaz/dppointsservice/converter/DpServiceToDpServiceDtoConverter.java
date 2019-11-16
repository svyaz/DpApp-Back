package com.github.svyaz.dppointsservice.converter;

import com.github.svyaz.dppointsservice.dto.DpServiceDto;
import com.github.svyaz.dppointsservice.model.DpService;
import org.springframework.stereotype.Component;

@Component
public class DpServiceToDpServiceDtoConverter extends AbstractConverter<DpService, DpServiceDto> {
    @Override
    public DpServiceDto convert(DpService dpService) {
        DpServiceDto dpServiceDto = new DpServiceDto();
        dpServiceDto.setId(dpService.getId());
        dpServiceDto.setName(dpService.getName());
        return dpServiceDto;
    }
}
