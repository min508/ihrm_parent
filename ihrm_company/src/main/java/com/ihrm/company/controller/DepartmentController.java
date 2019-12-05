package com.ihrm.company.controller;

import com.ihrm.common.controller.BaseController;
import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.company.service.CompanyService;
import com.ihrm.company.service.DepartmentService;
import com.ihrm.domain.company.Company;
import com.ihrm.domain.company.Department;
import com.ihrm.domain.company.response.DeptListResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//解决跨域
//生命RestController
//设置父路径
@CrossOrigin
@RestController
@RequestMapping(value = "/company")  // company/department
public class DepartmentController extends BaseController {

    @Resource
    private DepartmentService departmentService;

    @Resource
    private CompanyService companyService;

    /**
     * 保存
     */
    @RequestMapping(value = "/department", method = RequestMethod.POST)
    public Result save(@RequestBody Department department){
        // 1、设置保存的企业id
        department.setCompanyId(companyId);
        // 2、调用service完成保存企业
        departmentService.save(department);
        // 3、构造返回结果
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 查询企业的部门列表
     * 指定企业的ID
     * @return Result
     */
    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public Result findAll(){
        Company company = companyService.findById(companyId);
        List<Department> list = departmentService.findAll(companyId);
        DeptListResult deptListResult = new DeptListResult(company,list);
        return new Result(ResultCode.SUCCESS, deptListResult);
    }

    /**
     * 根据ID查询
     */
    @RequestMapping(value = "/department/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable(value = "id") String id){
        Department department = departmentService.findById(id);
        return new Result(ResultCode.SUCCESS, department);
    }

    /**
     * 修改Department
     */
    @RequestMapping(value = "/department/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable(value = "id")String id, @RequestBody Department department){
        // 1、调用修改部门ID
        department.setId(id);
        // 2、调用service更新
        departmentService.update(department);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 根据id删除
     */
    @RequestMapping(value = "/department/{id}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable(value = "id") String id){
        departmentService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }
}
