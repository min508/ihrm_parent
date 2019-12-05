package com.ihrm.company.service;

import com.ihrm.common.service.BaseService;
import com.ihrm.common.utils.IdWorker;
import com.ihrm.company.dao.DepartmentDao;
import com.ihrm.domain.company.Department;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentService extends BaseService {

    @Resource
    private DepartmentDao departmentDao;

    @Resource
    private IdWorker idWorker;

    /**
     * 1、保存部门
     */
    public void save(Department department){
        //设置主键的值
        String id = idWorker.nextId()+"";
        department.setId(id);
        departmentDao.save(department);
    }

    /**
     * 2、更新部门
     */
    public void update(Department department){
        // 1、根据id查询部门
        Department depart = departmentDao.findById(department.getId()).get();
        depart.setCode(department.getCode());
        depart.setIntroduce(department.getIntroduce());
        depart.setName(department.getName());
        departmentDao.save(depart);
    }

    /**
     * 3、根据ID查询部门
     */
    public Department findById(String id){
        return departmentDao.findById(id).get();
    }

    /**
     * 4、查询全部部门列表
     */
    public List<Department> findAll(String companyId){
        return departmentDao.findAll(getSpec(companyId));
    }

    /**
     * 5、根据id删除部门
     */
    public void deleteById(String id){
        departmentDao.deleteById(id);
    }
}
