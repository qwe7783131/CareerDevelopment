package com.bugmaker.mapper;

import java.util.List;

import com.bugmaker.bean.Company;

public interface CompanyMapper {

    /**
     * 添加公司
     * @param company
     * @return
     */
    int insertCompany(Company company);
    
    public List<Company> getAllCompany();
}
