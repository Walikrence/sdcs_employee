package com.company.project.service.impl;

import com.company.project.dao.JobOfferInfomationMapper;
import com.company.project.model.JobOfferInfomation;
import com.company.project.service.JobOfferInfomationService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by walikrence on 2019/12/06.
 */
@Service
@Transactional
public class JobOfferInfomationServiceImpl extends AbstractService<JobOfferInfomation> implements JobOfferInfomationService {
    @Resource
    private JobOfferInfomationMapper jobOfferInfomationMapper;

}
