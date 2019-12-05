package com.company.project.service.impl;

import com.company.project.dao.EnterpriseHrMapper;
import com.company.project.model.EnterpriseHr;
import com.company.project.service.EnterpriseHrService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by walikrence on 2019/12/06.
 */
@Service
@Transactional
public class EnterpriseHrServiceImpl extends AbstractService<EnterpriseHr> implements EnterpriseHrService {
    @Resource
    private EnterpriseHrMapper enterpriseHrMapper;

}
