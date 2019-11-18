package com.github.svyaz.dppointsservice.dao.impl;

import com.github.svyaz.dppointsservice.dao.CountryListDao;
import com.github.svyaz.dppointsservice.model.Country;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CountryListDaoImpl implements CountryListDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    @Transactional
    public List<Country> getList(String filter) {
        String query = "SELECT c FROM Country c WHERE lower(c.name) " +
                "LIKE lower(concat('%', :filter, '%'))";

        return entityManager
                .createQuery(query, Country.class)
                .setParameter("filter", filter)
                .getResultList();
    }
}
