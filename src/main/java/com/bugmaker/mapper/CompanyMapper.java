package com.bugmaker.mapper;

import com.bugmaker.bean.Company;

import java.util.List;

public interface CompanyMapper {

    /**
     * 添加公司
     * @param company
     * @return
     */
    int insertCompany(Company company);

    /**
     * 查询所有公司
     * @return
             */
    List<Company> selectAllCompany();

    //修改公司
    int updateCompanyById(Company company);

    //删除公司
    int deleteCompanyById(String id);

    //模糊查询
    List<Company> selectByName(Company company);
}
