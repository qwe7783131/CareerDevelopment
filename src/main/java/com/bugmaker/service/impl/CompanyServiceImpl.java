package com.bugmaker.service.impl;

import com.bugmaker.bean.Company;
import com.bugmaker.bean.User;
import com.bugmaker.mapper.CompanyMapper;
import com.bugmaker.service.CompanyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//企业管理实现类
@Service("companyService")
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    @Qualifier("companyService")
    CompanyService companyService;

    @Autowired
    private CompanyMapper companyMapper;

    public void setCompanyMapper(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }

    //查询所有company跳转到companyManage
    @Override
    public ModelAndView companyManageView(String currentPage) {
        Map<String ,Object> map = new HashMap<String, Object>();
        Integer currPage = Integer.valueOf(currentPage);
        PageHelper.startPage(currPage, 6);
        List<Company> companyList = companyService.selectAllCompany();
        PageInfo<Company> page = new PageInfo<>(companyList);
        map.put("page",page);
        return new ModelAndView("/admin/companyManage","map",map);
    }

    //查询所有企业
    @Override
    public List<Company> selectAllCompany() {
        List<Company> companyList = companyMapper.selectAllCompany();
        return companyList;
    }

    //修改企业
    @Override
    public String modifyCompany(String companyString,String id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map userMap = mapper.readValue(companyString, Map.class);
        Company company = new Company();
        company.setId(id);
        company.setName(userMap.get("name").toString());
        company.setAddress(userMap.get("address").toString());
        company.setPhone(userMap.get("phone").toString());
        company.setAdvisor(userMap.get("advisor").toString());
        return String.valueOf(companyMapper.updateCompanyById(company));
    }

    //添加企业
    @Override
    public String addCompany(String companyString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map userMap = mapper.readValue(companyString, Map.class);
        Company company = new Company();
        company.setId(userMap.get("id").toString());
        company.setName(userMap.get("name").toString());
        company.setAddress(userMap.get("address").toString());
        company.setPhone(userMap.get("phone").toString());
        company.setAdvisor(userMap.get("advisor").toString());
        company.setEnable(1);
        return String.valueOf(companyMapper.insertCompany(company));
    }

    //删除企业
    @Override
    public int deleteCompany(String id){
//        System.out.println(id);
        return companyMapper.deleteCompanyById(id.substring(3));
    }

    //模糊查询
    public ModelAndView selectByName(String name,String currentPage){
        Map<String,Object> map = new HashMap<String,Object>();
        Company company = new Company();
        company.setName(name);
        Integer currPage = Integer.valueOf(currentPage);
        PageHelper.startPage(currPage, 6);
        List<Company> companyList = companyMapper.selectByName(company);
        PageInfo<Company> page = new PageInfo<>(companyList);
        map.put("page",page);
        if(name.equals("")){
            return new ModelAndView("redirect:/admin/companyManage.do","map",map);
        }
        else {
            return new ModelAndView("/admin/companyManage","map",map);
        }
    }
}
