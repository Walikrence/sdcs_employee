package com.company.project.service.impl;

import com.company.project.dao.EnterpriseCertificateMapper;
import com.company.project.model.EnterpriseCertificate;
import com.company.project.service.EnterpriseCertificateService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by walikrence on 2019/12/06.
 */
@Service
@Transactional
public class EnterpriseCertificateServiceImpl extends AbstractService<EnterpriseCertificate> implements EnterpriseCertificateService {
    @Resource
    private EnterpriseCertificateMapper enterpriseCertificateMapper;

}
