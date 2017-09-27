package com.bugmaker.service;

import com.bugmaker.bean.Company;
import com.bugmaker.bean.Dept;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

//企业管理service
public interface CompanyService {

    //查询所有company跳转到companyManage
    public ModelAndView companyManageView(String currentPage);

    //查询所有企业
    public List<Company> selectAllCompany();

    //修改企业
    public String modifyCompany(String company,String id) throws IOException;

    //添加企业
    public String addCompany(String companyString) throws IOException;

    //删除企业
    public int deleteCompany(String id);

    //模糊查询
    public ModelAndView selectByName(String name,String currentPage);
}
