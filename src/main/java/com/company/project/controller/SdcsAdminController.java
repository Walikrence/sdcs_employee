package com.company.project.controller;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.SdcsAdmin;
import com.company.project.service.SdcsAdminService;
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
@RequestMapping("sdcsAdmin")
public class SdcsAdminController {
    @Resource
    private SdcsAdminService sdcsAdminService;

    @PostMapping("/add")
    public Result add( SdcsAdmin sdcsAdmin) {
        //检查是否指定id
        if (null != sdcsAdmin.getId()) {
            //id是否已存在
            Condition condition = new Condition(SdcsAdmin.class);
            Example.Criteria criteria = condition.createCriteria();
            criteria.andEqualTo("id", sdcsAdmin.getId());
            List<SdcsAdmin> list = sdcsAdminService.findByCondition(condition);
            if (!list.isEmpty()) {
                return ResultGenerator.genFailResult("id已存在");
            }
        }
        //没有指定id
        if(sdcsAdminService.save(sdcsAdmin)){
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("失败");
        }
    }

    @PostMapping("/addMany")
    public Result addMany(List<SdcsAdmin> sdcsAdmins) {
        if (sdcsAdminService.save(sdcsAdmins)>0) {
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
        if (sdcsAdminService.deleteById(id)) {
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
        if (sdcsAdminService.deleteByIds(ids)>0) {
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("无可删除数据");
        }
    }

    @PatchMapping("/update")
    public Result update(SdcsAdmin sdcsAdmin) {
        if (sdcsAdmin.getId()==null){
            return ResultGenerator.genFailResult("id为空");
        }
        if (sdcsAdminService.update(sdcsAdmin)) {
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
        SdcsAdmin sdcsAdmin = sdcsAdminService.findById(id);
        return ResultGenerator.genSuccessResult(sdcsAdmin);
    }

    @GetMapping("/list")
    public Result<PageInfo<SdcsAdmin>> list(@RequestParam(defaultValue = "0") Integer page,
                                                         @RequestParam(defaultValue = "10") Integer size,
                                                         String name) {
        PageHelper.startPage(page, size);
        Condition condition = new Condition(SdcsAdmin.class);
        Example.Criteria criteria = condition.createCriteria();
        if (StringUtils.isNotEmpty(name)) {
            criteria.andLike("name", "%" + name + "%");
        }
        condition.setOrderByClause("id desc");
        List<SdcsAdmin> list = sdcsAdminService.findByCondition(condition);
        PageInfo<SdcsAdmin> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
