package com.bugmaker.controller.admin;

import com.bugmaker.service.DormitoryServiceAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("admin")
public class DormitoryController {

    @Autowired
    @Qualifier("dormitoryServiceAdmin")
    DormitoryServiceAdmin dormitoryServiceAdmin;

    @RequestMapping("toDormitoryManage.do")
    @ResponseBody
    public ModelAndView toDormitoryManage(@RequestParam(defaultValue = "1") String curr){
        return dormitoryServiceAdmin.toDormitoryManage(curr);
    }

    @RequestMapping("toAddDormitory.do")
    @ResponseBody
    public ModelAndView toAddDormitory(){
        return dormitoryServiceAdmin.toAddDormitory();
    }

    @RequestMapping("addDormitory.do")
    @ResponseBody
    public String addDormitory(@RequestBody String dormitoryString) throws IOException {
        dormitoryServiceAdmin.addDormitory(dormitoryString);
        return "1";
    }

    @RequestMapping("toModifyDormitory.do")
    public ModelAndView toModifyDormitory(String id,String companyName,String total,String personNum){
        return dormitoryServiceAdmin.toModifyDormitory(id,companyName,total,personNum);
    }

    @RequestMapping("modifyDormitory.do")
    @ResponseBody
    public String modifyDormitory(@RequestBody String dormitoryString) throws IOException {
        return String.valueOf(dormitoryServiceAdmin.modifyDormitory(dormitoryString));
    }

    @RequestMapping("deleteDormitory.do")
    @ResponseBody
    public String deleteDormitory(@RequestBody String id){
        return String.valueOf(dormitoryServiceAdmin.deleteDormitory(id));
    }

    @RequestMapping("getDormByCompany")
    public ModelAndView getDormByCompany(String company,@RequestParam(defaultValue = "1") String curr){
        return dormitoryServiceAdmin.getDormByCompany(company,curr);
    }
}
