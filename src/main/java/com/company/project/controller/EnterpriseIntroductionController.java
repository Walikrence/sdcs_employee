package com.company.project.controller;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.EnterpriseIntroduction;
import com.company.project.service.EnterpriseIntroductionService;
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
@RequestMapping("enterpriseIntroduction")
public class EnterpriseIntroductionController {
    @Resource
    private EnterpriseIntroductionService enterpriseIntroductionService;

    @PostMapping("/add")
    public Result add( EnterpriseIntroduction enterpriseIntroduction) {
        //检查是否指定id
        if (null != enterpriseIntroduction.getId()) {
            //id是否已存在
            Condition condition = new Condition(EnterpriseIntroduction.class);
            Example.Criteria criteria = condition.createCriteria();
            criteria.andEqualTo("id", enterpriseIntroduction.getId());
            List<EnterpriseIntroduction> list = enterpriseIntroductionService.findByCondition(condition);
            if (!list.isEmpty()) {
                return ResultGenerator.genFailResult("id已存在");
            }
        }
        //没有指定id
        if(enterpriseIntroductionService.save(enterpriseIntroduction)){
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("失败");
        }
    }

    @PostMapping("/addMany")
    public Result addMany(List<EnterpriseIntroduction> enterpriseIntroductions) {
        if (enterpriseIntroductionService.save(enterpriseIntroductions)>0) {
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
        if (enterpriseIntroductionService.deleteById(id)) {
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
        if (enterpriseIntroductionService.deleteByIds(ids)>0) {
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("无可删除数据");
        }
    }

    @PatchMapping("/update")
    public Result update(EnterpriseIntroduction enterpriseIntroduction) {
        if (enterpriseIntroduction.getId()==null){
            return ResultGenerator.genFailResult("id为空");
        }
        if (enterpriseIntroductionService.update(enterpriseIntroduction)) {
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
        EnterpriseIntroduction enterpriseIntroduction = enterpriseIntroductionService.findById(id);
        return ResultGenerator.genSuccessResult(enterpriseIntroduction);
    }

    @GetMapping("/list")
    public Result<PageInfo<EnterpriseIntroduction>> list(@RequestParam(defaultValue = "0") Integer page,
                                                         @RequestParam(defaultValue = "10") Integer size,
                                                         String name) {
        PageHelper.startPage(page, size);
        Condition condition = new Condition(EnterpriseIntroduction.class);
        Example.Criteria criteria = condition.createCriteria();
        if (StringUtils.isNotEmpty(name)) {
            criteria.andLike("name", "%" + name + "%");
        }
        condition.setOrderByClause("id desc");
        List<EnterpriseIntroduction> list = enterpriseIntroductionService.findByCondition(condition);
        PageInfo<EnterpriseIntroduction> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
