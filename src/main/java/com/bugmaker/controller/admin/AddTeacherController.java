package com.bugmaker.controller.admin;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.Role;
import com.bugmaker.bean.User;
import com.bugmaker.bean.UserRole;
import com.bugmaker.service.AddTeacherService;
import com.bugmaker.service.TeacherService;
import com.bugmaker.utils.XslResolveUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class AddTeacherController {

    @Autowired
    @Qualifier("teaService")
    AddTeacherService teacherService;


    //获取数据跳转到teacherManage
    @RequestMapping("/admin/teacherManage.do")
    public ModelAndView teacherManageView(@RequestParam(defaultValue="1") String currentPage) {
        return teacherService.teacherManageView(currentPage);
    }

    //模糊查询
    @RequestMapping("/admin/teacherManage2.do")
    public ModelAndView teacherManage2View(String id,String username ,String dept,@RequestParam(defaultValue="1") String currentPage){
        return teacherService.selectTeaByParams(id,username,dept,currentPage);
    }

     //添加单个教师的控制器
    @RequestMapping(value = "addOneTea.do", method = RequestMethod.POST)
    @ResponseBody
    public String addOneTea(@RequestBody  String userString) throws IOException{
        return "" + teacherService.addOneTea(userString);
    }

    /**
     * 导入表格添加教师控制器
     */
    @RequestMapping(value = "addMulTea.do", method = RequestMethod.POST)
    @ResponseBody
    public String addMulTea(HttpServletRequest request) throws IOException {
        return "" + teacherService.addMulTea(request);
    }

    /**
     * 获取学院（添加时用）
     */
    @RequestMapping("/admin/selectDept.do")
    public  String selectDept(ModelMap model){
        List<Dept> selectAllDept = teacherService.selectAllDept();
        model.put("selectAllDept",selectAllDept);
        return "admin/addTeacher";
    }

    /**
     * 获取学院（修改教师时)
     */
    @RequestMapping("/admin/selectDept2.do")
    public  String selectDept2(ModelMap model){
        List<Dept> selectAllDept = teacherService.selectAllDept();
        model.put("selectAllDept",selectAllDept);
        return "admin/modifyTeacher";
    }

    //修改教师信息
    @RequestMapping(value = "admin/modifyTeacherImpl.do", method = RequestMethod.POST)
    @ResponseBody
    public String modifyTeacherImpl(@RequestBody String userString) throws IOException {
        return "" + teacherService.updateTea(userString);
    }

    // 删除教师
    @RequestMapping(value = "admin/deleteTeacher.do", method = RequestMethod.POST)
    @ResponseBody
    public String deleteTeacher(@RequestBody String id){
        return String.valueOf(teacherService.deleteTea(id.substring(3)));
    }
}
