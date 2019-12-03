package com.ihrm.company;

import com.ihrm.company.dao.CompanyDao;
import com.ihrm.domain.company.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Description: 公司接口测试
 * @Author: Mr.Min
 **/

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CompanyDaoTest {

    @Resource
    private CompanyDao companyDao;

    @Test
    public void test(){

        Company company = companyDao.findById("1").get();
        System.out.println(company);

    }

}
