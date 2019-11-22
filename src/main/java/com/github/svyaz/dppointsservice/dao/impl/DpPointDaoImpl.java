package com.github.svyaz.dppointsservice.dao.impl;

import com.github.svyaz.dppointsservice.dao.DpPointDao;
import com.github.svyaz.dppointsservice.model.DpPoint;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DpPointDaoImpl implements DpPointDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<DpPoint> getPoints(long cityId, long[] serviceIds) {

        List<Long> servicesList = Arrays.stream(serviceIds)
                .boxed()
                .collect(Collectors.toList());

        String query = "SELECT DISTINCT p FROM DpPoint p " +
                "JOIN p.dpServices s " +
                "WHERE p.city.id = :cityId " +
                "AND s.id IN :serviceIds";

        return entityManager.createQuery(query, DpPoint.class)
                .setParameter("cityId", cityId)
                .setParameter("serviceIds", servicesList)
                .getResultList();
    }
}
