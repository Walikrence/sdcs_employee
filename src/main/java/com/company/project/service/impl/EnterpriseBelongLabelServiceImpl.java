package com.company.project.service.impl;

import com.company.project.dao.EnterpriseBelongLabelMapper;
import com.company.project.model.EnterpriseBelongLabel;
import com.company.project.service.EnterpriseBelongLabelService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by walikrence on 2019/12/06.
 */
@Service
@Transactional
public class EnterpriseBelongLabelServiceImpl extends AbstractService<EnterpriseBelongLabel> implements EnterpriseBelongLabelService {
    @Resource
    private EnterpriseBelongLabelMapper enterpriseBelongLabelMapper;

}
