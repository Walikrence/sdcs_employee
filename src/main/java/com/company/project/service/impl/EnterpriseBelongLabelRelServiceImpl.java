package com.company.project.service.impl;

import com.company.project.dao.EnterpriseBelongLabelRelMapper;
import com.company.project.model.EnterpriseBelongLabelRel;
import com.company.project.service.EnterpriseBelongLabelRelService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by walikrence on 2019/12/06.
 */
@Service
@Transactional
public class EnterpriseBelongLabelRelServiceImpl extends AbstractService<EnterpriseBelongLabelRel> implements EnterpriseBelongLabelRelService {
    @Resource
    private EnterpriseBelongLabelRelMapper enterpriseBelongLabelRelMapper;

}
