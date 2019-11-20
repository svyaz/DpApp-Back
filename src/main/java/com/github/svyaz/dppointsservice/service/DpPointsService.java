package com.github.svyaz.dppointsservice.service;

import com.github.svyaz.dppointsservice.model.DpPoint;

import java.util.List;

public interface DpPointsService {
    List<DpPoint> getDpPoints(long cityId, long[] serviceIds);
}
