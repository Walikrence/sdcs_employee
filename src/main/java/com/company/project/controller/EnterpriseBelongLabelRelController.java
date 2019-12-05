package com.company.project.controller;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.EnterpriseBelongLabelRel;
import com.company.project.service.EnterpriseBelongLabelRelService;
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
@RequestMapping("enterpriseBelongLabelRel")
public class EnterpriseBelongLabelRelController {
    @Resource
    private EnterpriseBelongLabelRelService enterpriseBelongLabelRelService;

    @PostMapping("/add")
    public Result add( EnterpriseBelongLabelRel enterpriseBelongLabelRel) {
        //检查是否指定id
        if (null != enterpriseBelongLabelRel.getId()) {
            //id是否已存在
            Condition condition = new Condition(EnterpriseBelongLabelRel.class);
            Example.Criteria criteria = condition.createCriteria();
            criteria.andEqualTo("id", enterpriseBelongLabelRel.getId());
            List<EnterpriseBelongLabelRel> list = enterpriseBelongLabelRelService.findByCondition(condition);
            if (!list.isEmpty()) {
                return ResultGenerator.genFailResult("id已存在");
            }
        }
        //没有指定id
        if(enterpriseBelongLabelRelService.save(enterpriseBelongLabelRel)){
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("失败");
        }
    }

    @PostMapping("/addMany")
    public Result addMany(List<EnterpriseBelongLabelRel> enterpriseBelongLabelRels) {
        if (enterpriseBelongLabelRelService.save(enterpriseBelongLabelRels)>0) {
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
        if (enterpriseBelongLabelRelService.deleteById(id)) {
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
        if (enterpriseBelongLabelRelService.deleteByIds(ids)>0) {
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("无可删除数据");
        }
    }

    @PatchMapping("/update")
    public Result update(EnterpriseBelongLabelRel enterpriseBelongLabelRel) {
        if (enterpriseBelongLabelRel.getId()==null){
            return ResultGenerator.genFailResult("id为空");
        }
        if (enterpriseBelongLabelRelService.update(enterpriseBelongLabelRel)) {
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
        EnterpriseBelongLabelRel enterpriseBelongLabelRel = enterpriseBelongLabelRelService.findById(id);
        return ResultGenerator.genSuccessResult(enterpriseBelongLabelRel);
    }

    @GetMapping("/list")
    public Result<PageInfo<EnterpriseBelongLabelRel>> list(@RequestParam(defaultValue = "0") Integer page,
                                                         @RequestParam(defaultValue = "10") Integer size,
                                                         String name) {
        PageHelper.startPage(page, size);
        Condition condition = new Condition(EnterpriseBelongLabelRel.class);
        Example.Criteria criteria = condition.createCriteria();
        if (StringUtils.isNotEmpty(name)) {
            criteria.andLike("name", "%" + name + "%");
        }
        condition.setOrderByClause("id desc");
        List<EnterpriseBelongLabelRel> list = enterpriseBelongLabelRelService.findByCondition(condition);
        PageInfo<EnterpriseBelongLabelRel> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
