package com.github.svyaz.dppointsservice.service.impl;

import com.github.svyaz.dppointsservice.dao.DpServiceDao;
import com.github.svyaz.dppointsservice.model.DpService;
import com.github.svyaz.dppointsservice.service.DpServiceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DpServiceServiceImpl implements DpServiceService {

    private DpServiceDao dpServiceDao;

    public DpServiceServiceImpl(DpServiceDao dpServiceDao) {
        this.dpServiceDao = dpServiceDao;
    }

    @Override
    @Transactional
    public List<DpService> getServices() {
        return dpServiceDao.getList();
    }
}
