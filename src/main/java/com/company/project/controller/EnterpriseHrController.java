package com.company.project.controller;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.EnterpriseHr;
import com.company.project.service.EnterpriseHrService;
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
@RequestMapping("enterpriseHr")
public class EnterpriseHrController {
    @Resource
    private EnterpriseHrService enterpriseHrService;

    @PostMapping("/add")
    public Result add( EnterpriseHr enterpriseHr) {
        //检查是否指定id
        if (null != enterpriseHr.getId()) {
            //id是否已存在
            Condition condition = new Condition(EnterpriseHr.class);
            Example.Criteria criteria = condition.createCriteria();
            criteria.andEqualTo("id", enterpriseHr.getId());
            List<EnterpriseHr> list = enterpriseHrService.findByCondition(condition);
            if (!list.isEmpty()) {
                return ResultGenerator.genFailResult("id已存在");
            }
        }
        //没有指定id
        if(enterpriseHrService.save(enterpriseHr)){
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("失败");
        }
    }

    @PostMapping("/addMany")
    public Result addMany(List<EnterpriseHr> enterpriseHrs) {
        if (enterpriseHrService.save(enterpriseHrs)>0) {
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
        if (enterpriseHrService.deleteById(id)) {
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
        if (enterpriseHrService.deleteByIds(ids)>0) {
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("无可删除数据");
        }
    }

    @PatchMapping("/update")
    public Result update(EnterpriseHr enterpriseHr) {
        if (enterpriseHr.getId()==null){
            return ResultGenerator.genFailResult("id为空");
        }
        if (enterpriseHrService.update(enterpriseHr)) {
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
        EnterpriseHr enterpriseHr = enterpriseHrService.findById(id);
        return ResultGenerator.genSuccessResult(enterpriseHr);
    }

    @GetMapping("/list")
    public Result<PageInfo<EnterpriseHr>> list(@RequestParam(defaultValue = "0") Integer page,
                                                         @RequestParam(defaultValue = "10") Integer size,
                                                         String name) {
        PageHelper.startPage(page, size);
        Condition condition = new Condition(EnterpriseHr.class);
        Example.Criteria criteria = condition.createCriteria();
        if (StringUtils.isNotEmpty(name)) {
            criteria.andLike("name", "%" + name + "%");
        }
        condition.setOrderByClause("id desc");
        List<EnterpriseHr> list = enterpriseHrService.findByCondition(condition);
        PageInfo<EnterpriseHr> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
