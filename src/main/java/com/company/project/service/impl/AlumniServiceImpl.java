package com.company.project.service.impl;

import com.company.project.dao.AlumniMapper;
import com.company.project.model.Alumni;
import com.company.project.service.AlumniService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by walikrence on 2019/12/06.
 */
@Service
@Transactional
public class AlumniServiceImpl extends AbstractService<Alumni> implements AlumniService {
    @Resource
    private AlumniMapper alumniMapper;

}
