package com.company.project.service.impl;

import com.company.project.dao.SchoolEnterpriseCooperateProjectMapper;
import com.company.project.model.SchoolEnterpriseCooperateProject;
import com.company.project.service.SchoolEnterpriseCooperateProjectService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by walikrence on 2019/12/06.
 */
@Service
@Transactional
public class SchoolEnterpriseCooperateProjectServiceImpl extends AbstractService<SchoolEnterpriseCooperateProject> implements SchoolEnterpriseCooperateProjectService {
    @Resource
    private SchoolEnterpriseCooperateProjectMapper schoolEnterpriseCooperateProjectMapper;

}
