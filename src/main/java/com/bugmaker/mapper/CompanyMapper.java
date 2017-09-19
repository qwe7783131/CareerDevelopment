package com.bugmaker.mapper;

import com.bugmaker.bean.Company;

public interface CompanyMapper {

    /**
     * 添加公司
     * @param company
     * @return
     */
    int insertCompany(Company company);
}
