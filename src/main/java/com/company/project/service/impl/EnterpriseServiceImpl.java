package com.company.project.service.impl;

import com.company.project.dao.EnterpriseMapper;
import com.company.project.model.Enterprise;
import com.company.project.service.EnterpriseService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by walikrence on 2019/12/06.
 */
@Service
@Transactional
public class EnterpriseServiceImpl extends AbstractService<Enterprise> implements EnterpriseService {
    @Resource
    private EnterpriseMapper enterpriseMapper;

}
