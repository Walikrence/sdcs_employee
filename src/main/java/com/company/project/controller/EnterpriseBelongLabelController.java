package com.company.project.controller;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.EnterpriseBelongLabel;
import com.company.project.service.EnterpriseBelongLabelService;
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
@RequestMapping("enterpriseBelongLabel")
public class EnterpriseBelongLabelController {
    @Resource
    private EnterpriseBelongLabelService enterpriseBelongLabelService;

    @PostMapping("/add")
    public Result add( EnterpriseBelongLabel enterpriseBelongLabel) {
        //检查是否指定id
        if (null != enterpriseBelongLabel.getId()) {
            //id是否已存在
            Condition condition = new Condition(EnterpriseBelongLabel.class);
            Example.Criteria criteria = condition.createCriteria();
            criteria.andEqualTo("id", enterpriseBelongLabel.getId());
            List<EnterpriseBelongLabel> list = enterpriseBelongLabelService.findByCondition(condition);
            if (!list.isEmpty()) {
                return ResultGenerator.genFailResult("id已存在");
            }
        }
        //没有指定id
        if(enterpriseBelongLabelService.save(enterpriseBelongLabel)){
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("失败");
        }
    }

    @PostMapping("/addMany")
    public Result addMany(List<EnterpriseBelongLabel> enterpriseBelongLabels) {
        if (enterpriseBelongLabelService.save(enterpriseBelongLabels)>0) {
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
        if (enterpriseBelongLabelService.deleteById(id)) {
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
        if (enterpriseBelongLabelService.deleteByIds(ids)>0) {
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("无可删除数据");
        }
    }

    @PatchMapping("/update")
    public Result update(EnterpriseBelongLabel enterpriseBelongLabel) {
        if (enterpriseBelongLabel.getId()==null){
            return ResultGenerator.genFailResult("id为空");
        }
        if (enterpriseBelongLabelService.update(enterpriseBelongLabel)) {
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
        EnterpriseBelongLabel enterpriseBelongLabel = enterpriseBelongLabelService.findById(id);
        return ResultGenerator.genSuccessResult(enterpriseBelongLabel);
    }

    @GetMapping("/list")
    public Result<PageInfo<EnterpriseBelongLabel>> list(@RequestParam(defaultValue = "0") Integer page,
                                                         @RequestParam(defaultValue = "10") Integer size,
                                                         String name) {
        PageHelper.startPage(page, size);
        Condition condition = new Condition(EnterpriseBelongLabel.class);
        Example.Criteria criteria = condition.createCriteria();
        if (StringUtils.isNotEmpty(name)) {
            criteria.andLike("name", "%" + name + "%");
        }
        condition.setOrderByClause("id desc");
        List<EnterpriseBelongLabel> list = enterpriseBelongLabelService.findByCondition(condition);
        PageInfo<EnterpriseBelongLabel> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
