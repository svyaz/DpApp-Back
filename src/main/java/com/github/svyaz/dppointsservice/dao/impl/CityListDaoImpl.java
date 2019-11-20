package com.github.svyaz.dppointsservice.dao.impl;

import com.github.svyaz.dppointsservice.dao.CityListDao;
import com.github.svyaz.dppointsservice.model.City;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CityListDaoImpl implements CityListDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<City> getList(long countryId, String filter) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<City> cq = cb.createQuery(City.class);
        Root<City> root = cq.from(City.class);

        Predicate predicate = cb.and(
                cb.equal(
                        root.get("country").get("id"),
                        countryId),
                cb.like(
                        cb.lower(root.get("name")),
                        '%' + filter.toLowerCase() + '%')
        );

        cq.where(predicate);
        CriteriaQuery<City> select = cq.select(root);
        return entityManager.createQuery(select).getResultList();

        /* JPQL variant */
        /*String query = "SELECT c FROM City c WHERE c.country.id = :countryId AND " +
                "lower(c.name) LIKE lower(concat('%', :filter, '%'))";

        return entityManager.createQuery(query, City.class)
                .setParameter("countryId", countryId)
                .setParameter("filter", filter)
                .getResultList();*/
    }
}
