package com.company.project.controller;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.SchoolEnterpriseCooperateProject;
import com.company.project.service.SchoolEnterpriseCooperateProjectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by walikrence on 2019/12/06.
*/
@RestController
@RequestMapping("schoolEnterpriseCooperateProject")
public class SchoolEnterpriseCooperateProjectController {
    @Resource
    private SchoolEnterpriseCooperateProjectService schoolEnterpriseCooperateProjectService;

    @PostMapping("/add")
    public Result add( SchoolEnterpriseCooperateProject schoolEnterpriseCooperateProject) {
        //检查是否指定id
        if (null != schoolEnterpriseCooperateProject.getId()) {
            //id是否已存在
            Condition condition = new Condition(SchoolEnterpriseCooperateProject.class);
            Example.Criteria criteria = condition.createCriteria();
            criteria.andEqualTo("id", schoolEnterpriseCooperateProject.getId());
            List<SchoolEnterpriseCooperateProject> list = schoolEnterpriseCooperateProjectService.findByCondition(condition);
            if (!list.isEmpty()) {
                return ResultGenerator.genFailResult("id已存在");
            }
        }
        //没有指定id
        if(schoolEnterpriseCooperateProjectService.save(schoolEnterpriseCooperateProject)){
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("失败");
        }
    }

    @PostMapping("/addMany")
    public Result addMany(List<SchoolEnterpriseCooperateProject> schoolEnterpriseCooperateProjects) {
        if (schoolEnterpriseCooperateProjectService.save(schoolEnterpriseCooperateProjects)>0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("失败");
        }
    }

    @DeleteMapping("/del")
    public Result delete(Integer id) {
        if (id==null){
            return ResultGenerator.genFailResult("id为空");
        }
        if (schoolEnterpriseCooperateProjectService.deleteById(id)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("失败");
        }
    }
    @DeleteMapping("/deleteMany")
    public Result deleteByIds(String ids) {
        if (StringUtils.isEmpty(ids)){
            return ResultGenerator.genFailResult("缺少ids");
        }
        if (schoolEnterpriseCooperateProjectService.deleteByIds(ids)>0) {
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("无可删除数据");
        }
    }

    @PatchMapping("/update")
    public Result update(SchoolEnterpriseCooperateProject schoolEnterpriseCooperateProject) {
        if (schoolEnterpriseCooperateProject.getId()==null){
            return ResultGenerator.genFailResult("id为空");
        }
        if (schoolEnterpriseCooperateProjectService.update(schoolEnterpriseCooperateProject)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("失败");
        }
    }

    @GetMapping("/detail")
    public Result detail(Integer id) {
        if (id==null){
            return ResultGenerator.genFailResult("id为空");
        }
        SchoolEnterpriseCooperateProject schoolEnterpriseCooperateProject = schoolEnterpriseCooperateProjectService.findById(id);
        return ResultGenerator.genSuccessResult(schoolEnterpriseCooperateProject);
    }

    @GetMapping("/list")
    public Result<PageInfo<SchoolEnterpriseCooperateProject>> list(@RequestParam(defaultValue = "0") Integer page,
                                                         @RequestParam(defaultValue = "10") Integer size,
                                                         String name) {
        PageHelper.startPage(page, size);
        Condition condition = new Condition(SchoolEnterpriseCooperateProject.class);
        Example.Criteria criteria = condition.createCriteria();
        if (StringUtils.isNotEmpty(name)) {
            criteria.andLike("name", "%" + name + "%");
        }
        condition.setOrderByClause("id desc");
        List<SchoolEnterpriseCooperateProject> list = schoolEnterpriseCooperateProjectService.findByCondition(condition);
        PageInfo<SchoolEnterpriseCooperateProject> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
