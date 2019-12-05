package com.company.project.controller;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.JobOfferInfomation;
import com.company.project.service.JobOfferInfomationService;
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
@RequestMapping("jobOfferInfomation")
public class JobOfferInfomationController {
    @Resource
    private JobOfferInfomationService jobOfferInfomationService;

    @PostMapping("/add")
    public Result add( JobOfferInfomation jobOfferInfomation) {
        //检查是否指定id
        if (null != jobOfferInfomation.getId()) {
            //id是否已存在
            Condition condition = new Condition(JobOfferInfomation.class);
            Example.Criteria criteria = condition.createCriteria();
            criteria.andEqualTo("id", jobOfferInfomation.getId());
            List<JobOfferInfomation> list = jobOfferInfomationService.findByCondition(condition);
            if (!list.isEmpty()) {
                return ResultGenerator.genFailResult("id已存在");
            }
        }
        //没有指定id
        if(jobOfferInfomationService.save(jobOfferInfomation)){
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("失败");
        }
    }

    @PostMapping("/addMany")
    public Result addMany(List<JobOfferInfomation> jobOfferInfomations) {
        if (jobOfferInfomationService.save(jobOfferInfomations)>0) {
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
        if (jobOfferInfomationService.deleteById(id)) {
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
        if (jobOfferInfomationService.deleteByIds(ids)>0) {
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("无可删除数据");
        }
    }

    @PatchMapping("/update")
    public Result update(JobOfferInfomation jobOfferInfomation) {
        if (jobOfferInfomation.getId()==null){
            return ResultGenerator.genFailResult("id为空");
        }
        if (jobOfferInfomationService.update(jobOfferInfomation)) {
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
        JobOfferInfomation jobOfferInfomation = jobOfferInfomationService.findById(id);
        return ResultGenerator.genSuccessResult(jobOfferInfomation);
    }

    @GetMapping("/list")
    public Result<PageInfo<JobOfferInfomation>> list(@RequestParam(defaultValue = "0") Integer page,
                                                         @RequestParam(defaultValue = "10") Integer size,
                                                         String name) {
        PageHelper.startPage(page, size);
        Condition condition = new Condition(JobOfferInfomation.class);
        Example.Criteria criteria = condition.createCriteria();
        if (StringUtils.isNotEmpty(name)) {
            criteria.andLike("name", "%" + name + "%");
        }
        condition.setOrderByClause("id desc");
        List<JobOfferInfomation> list = jobOfferInfomationService.findByCondition(condition);
        PageInfo<JobOfferInfomation> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
