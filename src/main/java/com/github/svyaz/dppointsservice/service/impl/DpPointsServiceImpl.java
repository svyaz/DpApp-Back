package com.github.svyaz.dppointsservice.service.impl;

import com.github.svyaz.dppointsservice.dao.DpPointDao;
import com.github.svyaz.dppointsservice.model.DpPoint;
import com.github.svyaz.dppointsservice.service.DpPointsService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DpPointsServiceImpl implements DpPointsService {

    private final DpPointDao dpPointDao;

    public DpPointsServiceImpl(DpPointDao dpPointDao) {
        this.dpPointDao = dpPointDao;
    }

    @Override
    public List<DpPoint> getDpPoints(long cityId, long[] servicesIds) {
        return dpPointDao.getPoints(cityId, servicesIds);
    }
}
