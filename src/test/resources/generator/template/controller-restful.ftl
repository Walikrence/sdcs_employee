package ${basePackage}.controller;

import ${basePackage}.core.Result;
import ${basePackage}.core.ResultGenerator;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by ${author} on ${date}.
*/
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {
    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping("/add")
    public Result add( ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        if(${modelNameLowerCamel}Service.save(${modelNameLowerCamel})){
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("失败");
        }
    }

    @PostMapping("/addMany")
    public Result addMany(List<${modelNameUpperCamel}> ${modelNameLowerCamel}s) {
        if (${modelNameLowerCamel}Service.save(${modelNameLowerCamel}s)>0) {
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
        if (${modelNameLowerCamel}Service.deleteById(id)) {
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
        if (${modelNameLowerCamel}Service.deleteByIds(ids)>0) {
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("无可删除数据");
        }
    }

    @PatchMapping("/update")
    public Result update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        if (${modelNameLowerCamel}.getId()==null){
            return ResultGenerator.genFailResult("id为空");
        }
        if (${modelNameLowerCamel}Service.update(${modelNameLowerCamel})) {
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
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        return ResultGenerator.genSuccessResult(${modelNameLowerCamel});
    }

    @GetMapping("/list")
    public Result<PageInfo<${modelNameUpperCamel}>> list(@RequestParam(defaultValue = "0") Integer page,
                                                         @RequestParam(defaultValue = "10") Integer size,
                                                         String name) {
        PageHelper.startPage(page, size);
        Condition condition = new Condition(${modelNameUpperCamel}.class);
        Example.Criteria criteria = condition.createCriteria();
        if (StringUtils.isNotEmpty(name)) {
            criteria.andLike("name", "%" + name + "%");
        }
        condition.setOrderByClause("id desc");
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findByCondition(condition);
        PageInfo<${modelNameUpperCamel}> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
