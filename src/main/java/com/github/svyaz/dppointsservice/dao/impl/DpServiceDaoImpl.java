package com.github.svyaz.dppointsservice.dao.impl;

import com.github.svyaz.dppointsservice.dao.DpServiceDao;
import com.github.svyaz.dppointsservice.model.DpService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class DpServiceDaoImpl implements DpServiceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<DpService> getList() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<DpService> cq = cb.createQuery(DpService.class);

        Root<DpService> root = cq.from(DpService.class);
        CriteriaQuery<DpService> select = cq.select(root);

        return entityManager.createQuery(select).getResultList();
        //TODO: хм... расписать запрос!
    }
}
