package com.github.svyaz.dppointsservice.dao;

import com.github.svyaz.dppointsservice.model.DpPoint;

import java.util.List;

public interface DpPointDao {
    List<DpPoint> getPoints(long cityId, long[] serviceIds);
}
