package com.bugmaker.service.impl;

import com.bugmaker.bean.Company;
import com.bugmaker.bean.Dormitory;
import com.bugmaker.bean.Outteacher;
import com.bugmaker.mapper.DormitoryMapper;
import com.bugmaker.service.CompanyService;
import com.bugmaker.service.DormitoryServiceAdmin;
import com.bugmaker.service.OutTeacherService;
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

@Service("dormitoryServiceAdmin")
public class DormitoryServiceAdminImpl implements DormitoryServiceAdmin {

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Autowired
    @Qualifier("companyService")
    CompanyService companyService;

    //跳转到宿舍管理页面
    @Override
    public ModelAndView toDormitoryManage(String curr) {
        Map<String,Object> map = new HashMap<>();
        int nowPage = Integer.valueOf(curr);
        PageHelper.startPage(nowPage, 6);
        List<Dormitory> dormitoryList = dormitoryMapper.getAllDorm();
        for(Dormitory dormitory:dormitoryList){
            System.out.println(dormitory);
        }
        PageInfo<Dormitory> page = new PageInfo<>(dormitoryList);
        List<Company> companyList = companyService.selectAllCompany();
        map.put("page",page);
        map.put("companyList",companyList);
        return new ModelAndView("admin/dormitoryManage", "map", map);
    }

    @Override
    public ModelAndView toAddDormitory() {
        Map<String,Object> map = new HashMap<>();
        List<Company> companyList = companyService.selectAllCompany();
        map.put("companyList",companyList);
        return new ModelAndView("admin/addDormitory", "map", map);
    }

    @Override
    public int addDormitory(String dormitoryString) throws IOException {
//        System.out.println(dormitoryString);
        ObjectMapper mapper = new ObjectMapper();
        Map userMap = mapper.readValue(dormitoryString, Map.class);
        Dormitory dormitory = new Dormitory();
        Company company = new Company();
        dormitory.setId(userMap.get("id").toString());
        dormitory.setTotal(Integer.parseInt(userMap.get("total").toString()));
        dormitory.setPersonNum(Integer.parseInt(userMap.get("person_num").toString()));
        company.setId(userMap.get("company").toString());
        dormitory.setCompany(company);
//        System.out.println(dormitory);
        return dormitoryMapper.addDormitory(dormitory);
    }

    @Override
    public ModelAndView toModifyDormitory(String id,String companyName,String total,String personNum) {
//        System.out.println("id="+id+"  company="+companyName+"  total="+total+"  personNum="+personNum);
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("company",companyName);
        map.put("total",total);
        map.put("personNum",personNum);
        List<Company> companyList = companyService.selectAllCompany();
        map.put("companyList",companyList);
        return new ModelAndView("admin/modifyDormitory","map",map);
    }

    public int modifyDormitory(String dormitoryString) throws IOException {
//        System.out.println(dormitoryString);
        ObjectMapper mapper = new ObjectMapper();
        Map userMap = mapper.readValue(dormitoryString, Map.class);
        Dormitory dormitory = new Dormitory();
        Company company = new Company();
        dormitory.setId(userMap.get("name").toString());
        dormitory.setTotal(Integer.parseInt(userMap.get("total").toString()));
        dormitory.setPersonNum(Integer.parseInt(userMap.get("personNum").toString()));
        company.setId(userMap.get("company").toString());
        dormitory.setCompany(company);
        return dormitoryMapper.modifyDormitory(dormitory);
    }

    @Override
    public int deleteDormitory(String id) {
//        System.out.println(id);
        int i = dormitoryMapper.deleteDormitory(id.substring(3));
//        System.out.println(i);
        return i;
    }

    @Override
    public ModelAndView getDormByCompany(String company, String curr) {
//        System.out.println(company+curr);
        List<Dormitory> dormitoryList;
        Map<String,Object> map = new HashMap<>();
        int nowPage = Integer.valueOf(curr);
        PageHelper.startPage(nowPage, 6);
        if(company!=null&&company!="") {
            dormitoryList = dormitoryMapper.getDormByCompany(company);
        }
        else{
            dormitoryList = dormitoryMapper.getAllDorm();
        }
//        for(Dormitory dormitory:dormitoryList){
//            System.out.println(dormitory);
//        }
        PageInfo<Dormitory> page = new PageInfo<>(dormitoryList);
        List<Company> companyList = companyService.selectAllCompany();
        map.put("page",page);
        map.put("companyList",companyList);
        return new ModelAndView("admin/dormitoryManage", "map", map);
    }
}
