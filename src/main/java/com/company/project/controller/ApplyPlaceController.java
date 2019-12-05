package com.company.project.controller;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.ApplyPlace;
import com.company.project.service.ApplyPlaceService;
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
@RequestMapping("applyPlace")
public class ApplyPlaceController {
    @Resource
    private ApplyPlaceService applyPlaceService;

    @PostMapping("/add")
    public Result add( ApplyPlace applyPlace) {
        //检查是否指定id
        if (null != applyPlace.getId()) {
            //id是否已存在
            Condition condition = new Condition(ApplyPlace.class);
            Example.Criteria criteria = condition.createCriteria();
            criteria.andEqualTo("id", applyPlace.getId());
            List<ApplyPlace> list = applyPlaceService.findByCondition(condition);
            if (!list.isEmpty()) {
                return ResultGenerator.genFailResult("id已存在");
            }
        }
        //没有指定id
        if(applyPlaceService.save(applyPlace)){
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("失败");
        }
    }

    @PostMapping("/addMany")
    public Result addMany(List<ApplyPlace> applyPlaces) {
        if (applyPlaceService.save(applyPlaces)>0) {
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
        if (applyPlaceService.deleteById(id)) {
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
        if (applyPlaceService.deleteByIds(ids)>0) {
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("无可删除数据");
        }
    }

    @PatchMapping("/update")
    public Result update(ApplyPlace applyPlace) {
        if (applyPlace.getId()==null){
            return ResultGenerator.genFailResult("id为空");
        }
        if (applyPlaceService.update(applyPlace)) {
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
        ApplyPlace applyPlace = applyPlaceService.findById(id);
        return ResultGenerator.genSuccessResult(applyPlace);
    }

    @GetMapping("/list")
    public Result<PageInfo<ApplyPlace>> list(@RequestParam(defaultValue = "0") Integer page,
                                                         @RequestParam(defaultValue = "10") Integer size,
                                                         String name) {
        PageHelper.startPage(page, size);
        Condition condition = new Condition(ApplyPlace.class);
        Example.Criteria criteria = condition.createCriteria();
        if (StringUtils.isNotEmpty(name)) {
            criteria.andLike("name", "%" + name + "%");
        }
        condition.setOrderByClause("id desc");
        List<ApplyPlace> list = applyPlaceService.findByCondition(condition);
        PageInfo<ApplyPlace> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
