package com.company.project.service.impl;

import com.company.project.dao.ApplyPlaceMapper;
import com.company.project.model.ApplyPlace;
import com.company.project.service.ApplyPlaceService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by walikrence on 2019/12/06.
 */
@Service
@Transactional
public class ApplyPlaceServiceImpl extends AbstractService<ApplyPlace> implements ApplyPlaceService {
    @Resource
    private ApplyPlaceMapper applyPlaceMapper;

}
