package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.Company;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by guan on 2017/9/21.
 */
public class CompanyMapperTest extends BaseTest {
    @Autowired
    CompanyMapper companyMapper;

    @Test
    public void selectAllCompany() {
        List<Company> companies = companyMapper.selectAllCompany();
        for (Company company :
                companies) {
            System.out.println(company);
        }

    }
}
