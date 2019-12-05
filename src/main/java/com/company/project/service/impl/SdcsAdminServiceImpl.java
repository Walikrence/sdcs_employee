package com.company.project.service.impl;

import com.company.project.dao.SdcsAdminMapper;
import com.company.project.model.SdcsAdmin;
import com.company.project.service.SdcsAdminService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by walikrence on 2019/12/06.
 */
@Service
@Transactional
public class SdcsAdminServiceImpl extends AbstractService<SdcsAdmin> implements SdcsAdminService {
    @Resource
    private SdcsAdminMapper sdcsAdminMapper;

}
