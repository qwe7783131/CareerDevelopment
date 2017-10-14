package com.bugmaker.controller.admin;

import com.bugmaker.service.OutTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("admin")
public class OutteacherController {

    @Autowired
    @Qualifier("outteacherService")
    OutTeacherService outTeacherService;

    //获取数据跳转到outteacherManage(所有公司，所有数据)
    @RequestMapping("toOutteacherManage.do")
    public ModelAndView toOutteacherManage(@RequestParam(defaultValue = "1") String currentPage){
        return outTeacherService.toOutteacherManage(currentPage);
    }

    //跳转到添加企业教师
    @RequestMapping("toAddOutteacher.do")
    public ModelAndView toAddOutteacher(){
        return outTeacherService.toAddOutteacher();
    }

    //添加企业教师
    @RequestMapping("addOutteacher.do")
    @ResponseBody
    public String addOutteacher(@RequestBody String userInfo) throws IOException {
        return outTeacherService.addOutteacher(userInfo);
    }

    //跳转到修改企业教师
    @RequestMapping("toUpdateOutteacher.do")
    public ModelAndView toUpdateOutteacher(String id,String companyid,String name,String sex,String age,String phone,String email) throws UnsupportedEncodingException {
        return outTeacherService.toModifyOutteacher(id,companyid,name,sex,age,phone,email);
    }

    //修改企业教师
    @RequestMapping("updateOutteacher.do")
    @ResponseBody
    public String updateOutteacher(@RequestBody String userInfo,String id) throws IOException {
        return outTeacherService.modifyOutteacher(userInfo,id);
    }

    //删除企业教师
    @ResponseBody
    @RequestMapping("deleteOutteacher.do")
    public String deleteOutteacher(@RequestBody String id){
        return outTeacherService.deleteOutteacher(id);
    }

    //模糊搜索企业教师（公司名，企业教师名）
    @RequestMapping("selectAllOutteacherByParam.do")
    public ModelAndView selectAllOutteacherByParam(String company,String name,@RequestParam(defaultValue="1") String currentPage){
        return outTeacherService.selectOutTeacherByParams(company,name,currentPage);
    }
}
