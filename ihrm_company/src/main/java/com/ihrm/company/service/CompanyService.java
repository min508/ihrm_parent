package com.ihrm.company.service;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.company.dao.CompanyDao;
import com.ihrm.domain.company.Company;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 公司业务层
 * @Author: Mr.Min
 **/

@Service
public class CompanyService {

    @Resource
    private CompanyDao companyDao;

    @Resource
    private IdWorker idWorker;

    /**
    * @Description: 保存企业
     * 1、配置idwork到工程
     * 2、在service中注入idwork
     * 3、通过idwork生成id
     * 4、保存企业
    **/

    public void add(Company company){
        // 基本属性的设置
        String id = idWorker.nextId() + "";
        company.setId(id);
        //默认状态
        company.setAuditState("1"); // 0:未审核 1：已审核
        company.setState(1); // 0:未审核 1：已审核
        companyDao.save(company);
    }

    /**
    * @Description: 更新企业
     * 1、参数：Ccompany
     * 2、根据ID查询出企业对象
     * 3、设置修改的属性
     * 4、调用dao完成更新
    **/
    public void update(Company company){
        Company temp = companyDao.findById(company.getId()).get();
        temp.setName(company.getName());
        temp.setCompanyPhone(company.getCompanyPhone());
        companyDao.save(temp);
    }

    /**
    * @Description: 删除企业
    **/
    public void deleteById(String id){
        companyDao.deleteById(id);
    }

    /**
    * @Description: 根据id查询企业
    **/
    public Company findById(String id){
        return companyDao.findById(id).get();

    }

    /**
    * @Description: 查询全部企业列表
    **/
    public List<Company> findAll(){
        return companyDao.findAll();
    }
}
