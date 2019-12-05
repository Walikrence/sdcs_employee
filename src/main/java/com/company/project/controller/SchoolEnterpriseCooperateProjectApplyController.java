package com.company.project.controller;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.SchoolEnterpriseCooperateProjectApply;
import com.company.project.service.SchoolEnterpriseCooperateProjectApplyService;
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
@RequestMapping("schoolEnterpriseCooperateProjectApply")
public class SchoolEnterpriseCooperateProjectApplyController {
    @Resource
    private SchoolEnterpriseCooperateProjectApplyService schoolEnterpriseCooperateProjectApplyService;

    @PostMapping("/add")
    public Result add( SchoolEnterpriseCooperateProjectApply schoolEnterpriseCooperateProjectApply) {
        //检查是否指定id
        if (null != schoolEnterpriseCooperateProjectApply.getId()) {
            //id是否已存在
            Condition condition = new Condition(SchoolEnterpriseCooperateProjectApply.class);
            Example.Criteria criteria = condition.createCriteria();
            criteria.andEqualTo("id", schoolEnterpriseCooperateProjectApply.getId());
            List<SchoolEnterpriseCooperateProjectApply> list = schoolEnterpriseCooperateProjectApplyService.findByCondition(condition);
            if (!list.isEmpty()) {
                return ResultGenerator.genFailResult("id已存在");
            }
        }
        //没有指定id
        if(schoolEnterpriseCooperateProjectApplyService.save(schoolEnterpriseCooperateProjectApply)){
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("失败");
        }
    }

    @PostMapping("/addMany")
    public Result addMany(List<SchoolEnterpriseCooperateProjectApply> schoolEnterpriseCooperateProjectApplys) {
        if (schoolEnterpriseCooperateProjectApplyService.save(schoolEnterpriseCooperateProjectApplys)>0) {
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
        if (schoolEnterpriseCooperateProjectApplyService.deleteById(id)) {
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
        if (schoolEnterpriseCooperateProjectApplyService.deleteByIds(ids)>0) {
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("无可删除数据");
        }
    }

    @PatchMapping("/update")
    public Result update(SchoolEnterpriseCooperateProjectApply schoolEnterpriseCooperateProjectApply) {
        if (schoolEnterpriseCooperateProjectApply.getId()==null){
            return ResultGenerator.genFailResult("id为空");
        }
        if (schoolEnterpriseCooperateProjectApplyService.update(schoolEnterpriseCooperateProjectApply)) {
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
        SchoolEnterpriseCooperateProjectApply schoolEnterpriseCooperateProjectApply = schoolEnterpriseCooperateProjectApplyService.findById(id);
        return ResultGenerator.genSuccessResult(schoolEnterpriseCooperateProjectApply);
    }

    @GetMapping("/list")
    public Result<PageInfo<SchoolEnterpriseCooperateProjectApply>> list(@RequestParam(defaultValue = "0") Integer page,
                                                         @RequestParam(defaultValue = "10") Integer size,
                                                         String name) {
        PageHelper.startPage(page, size);
        Condition condition = new Condition(SchoolEnterpriseCooperateProjectApply.class);
        Example.Criteria criteria = condition.createCriteria();
        if (StringUtils.isNotEmpty(name)) {
            criteria.andLike("name", "%" + name + "%");
        }
        condition.setOrderByClause("id desc");
        List<SchoolEnterpriseCooperateProjectApply> list = schoolEnterpriseCooperateProjectApplyService.findByCondition(condition);
        PageInfo<SchoolEnterpriseCooperateProjectApply> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
