package com.company.project.service.impl;

import com.company.project.dao.SchoolEnterpriseCooperateProjectApplyMapper;
import com.company.project.model.SchoolEnterpriseCooperateProjectApply;
import com.company.project.service.SchoolEnterpriseCooperateProjectApplyService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by walikrence on 2019/12/06.
 */
@Service
@Transactional
public class SchoolEnterpriseCooperateProjectApplyServiceImpl extends AbstractService<SchoolEnterpriseCooperateProjectApply> implements SchoolEnterpriseCooperateProjectApplyService {
    @Resource
    private SchoolEnterpriseCooperateProjectApplyMapper schoolEnterpriseCooperateProjectApplyMapper;

}
