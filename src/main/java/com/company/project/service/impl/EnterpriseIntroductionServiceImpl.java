package com.company.project.service.impl;

import com.company.project.dao.EnterpriseIntroductionMapper;
import com.company.project.model.EnterpriseIntroduction;
import com.company.project.service.EnterpriseIntroductionService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by walikrence on 2019/12/06.
 */
@Service
@Transactional
public class EnterpriseIntroductionServiceImpl extends AbstractService<EnterpriseIntroduction> implements EnterpriseIntroductionService {
    @Resource
    private EnterpriseIntroductionMapper enterpriseIntroductionMapper;

}
