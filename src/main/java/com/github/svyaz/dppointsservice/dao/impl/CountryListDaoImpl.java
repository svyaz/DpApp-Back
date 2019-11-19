package com.github.svyaz.dppointsservice.dao.impl;

import com.github.svyaz.dppointsservice.dao.CountryListDao;
import com.github.svyaz.dppointsservice.model.Country;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CountryListDaoImpl implements CountryListDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    @Transactional
    public List<Country> getList(String filter) {
        //TODO: Русские символы в фильтре приводят к исключениям

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> cq = cb.createQuery(Country.class);
        Root<Country> root = cq.from(Country.class);

        Predicate predicate = cb.like(
                cb.lower(root.get("name")),
                '%' + filter.toLowerCase() + '%');

        cq.where(predicate);
        CriteriaQuery<Country> select = cq.select(root);
        return entityManager.createQuery(select).getResultList();

        /*String query = "SELECT c FROM Country c " +
                "WHERE lower(c.name) LIKE lower(concat('%', :filter, '%'))";

        return entityManager
                .createQuery(query, Country.class)
                .setParameter("filter", filter)
                .getResultList();*/
    }
}
