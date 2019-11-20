package com.github.svyaz.dppointsservice.dao.impl;

import com.github.svyaz.dppointsservice.dao.DpPointDao;
import com.github.svyaz.dppointsservice.model.DpPoint;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DpPointDaoImpl implements DpPointDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<DpPoint> getPoints(long cityId, long[] serviceIds) {
        return new ArrayList<>();
    }
}
