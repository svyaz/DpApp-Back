package com.github.svyaz.dppointsservice.dao.impl;

import com.github.svyaz.dppointsservice.dao.CityListDao;
import com.github.svyaz.dppointsservice.model.City;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CityListDaoImpl implements CityListDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<City> getList(long countryId, String filter) {

        String query = "SELECT c FROM City c WHERE c.country.id = :countryId AND " +
                "lower(c.name) LIKE lower(concat('%', :filter, '%'))";

        return entityManager.createQuery(query, City.class)
                .setParameter("countryId", countryId)
                .setParameter("filter", filter)
                .getResultList();
    }
}
