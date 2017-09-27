package com.bugmaker.controller.admin;

import com.bugmaker.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class CompanyController {

    @Autowired
    @Qualifier("companyService")
    CompanyService companyService;

    //跳转到companyManage.html
    @RequestMapping("companyManage.do")
    public ModelAndView companyManage(@RequestParam(defaultValue="1") String currentPage){
        return companyService.companyManageView(currentPage);
    }

    //跳转到addCompany
    @RequestMapping("addCompany.do")
    public String addCompany(){
        return "admin/addCompany";
    }

    //跳转到modifyCompany
    @RequestMapping("modifyCompany.do")
    public ModelAndView modifyCompany(String id){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",id);
        return new ModelAndView("admin/modifyCompany","map",map);
    }

    //修改company
    @RequestMapping(value = "updateCompany.do",method = RequestMethod.POST)
    @ResponseBody
    public String updateCompany(@RequestBody String companyString,String id) throws IOException {
        return companyService.modifyCompany(companyString,id);
    }

    //添加company
    @RequestMapping(value = "insertCompany.do",method = RequestMethod.POST)
    @ResponseBody
    public String insertCompany(@RequestBody String companyString,String id) throws IOException {
        return companyService.addCompany(companyString);
    }

    //删除company
    @RequestMapping(value = "deleteCompany.do")
    @ResponseBody
    public String deleteCompany(@RequestBody String id){
        return String.valueOf(companyService.deleteCompany(id));
    }

    //模糊查询
    @RequestMapping("selectCompanyByName.do")
    public ModelAndView selectByName(String name,@RequestParam(defaultValue = "1") String currentPage){
//        System.out.println(name);
        return companyService.selectByName(name,currentPage);
    }
}
