package com.ihrm.company.controller;

import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.company.service.CompanyService;
import com.ihrm.domain.company.Company;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 公司控制层
 * @Author: Mr.Min
 **/

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Resource
    private CompanyService companyService;

    // 保存企业
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Result save(@RequestBody Company company){
        companyService.add(company);
        return new Result(ResultCode.SUCCESS);
    }

    // 根据id更新企业
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable(value = "id") String id, @RequestBody Company company){
        //业务操作
        company.setId(id);
        companyService.update(company);
        return new Result(ResultCode.SUCCESS);
    }

    // 根据id删除企业
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value = "id") String id){
        companyService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

    // 根据id查询企业
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable(value = "id") String id){
        companyService.findById(id);
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(result);
        return result;
    }

    // 查询全部企业列表

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result findAll(){
        List<Company> list = companyService.findAll();
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(list);
        return result;
    }

}
