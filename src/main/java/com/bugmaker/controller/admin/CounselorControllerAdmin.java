package com.bugmaker.controller.admin;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.User;
import com.bugmaker.service.AddTeacherService;
import com.bugmaker.service.CounselorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class CounselorControllerAdmin {

    @Autowired
    @Qualifier("counselorImpl")
    CounselorService counselorService ;

    @Autowired
    @Qualifier("teaService")
    AddTeacherService teacherService;

    //获取数据跳转到counselorManage
    @RequestMapping("/counselorManage.do")
    public ModelAndView counselorManageView(@RequestParam(defaultValue="1") String currentPage) {
        return counselorService.counselorManageView(currentPage);
    }


    // 添加单个辅导员的控制器
    @ResponseBody
    @RequestMapping(value = "addOneCoun.do", method = RequestMethod.POST)
    public String addOneCoun(@RequestBody String userString) throws IOException {
//        System.out.println(userString);
        return counselorService.addOneCounselor(userString);
    }


    //跳转到modifyCounselor
    @RequestMapping("/modifyCounselor.do")
    public ModelAndView modifyCounselor(){
        return null;
    }

    //修改辅导员信息
    @RequestMapping(value = "/modifyCounselorImpl.do", method = RequestMethod.POST)
    @ResponseBody
    public String modifyCounselorImpl(@RequestBody String userString,String id) throws IOException {
//        System.out.println(userString);
        return counselorService.updateCoun(userString,id);
    }

    /**
     * 获取学院（添加时用）
     */
    @RequestMapping("/counselorSelectDept.do")
    public  String selectDept(ModelMap model){
        List<Dept> selectAllDept = teacherService.selectAllDept();
        model.put("selectAllDept",selectAllDept);
        return "admin/addCounselor";
    }

    /**
     * 获取学院（修改辅导员时)
     */
    @RequestMapping("/counselorSelectDept2.do")
    public  String selectDept2(ModelMap model,String id,String sex,String age,String phone,String email,String username,String dept) throws UnsupportedEncodingException {
        System.out.println(id);
        List<Dept> selectAllDept = teacherService.selectAllDept();
        model.put("selectAllDept",selectAllDept);
        model.put("id",id);
        model.put("sex",sex);
        model.put("age",age);
        model.put("phone",phone);
        model.put("email",email);
        model.put("dept1",new String(dept.getBytes("iso8859-1"), "utf-8"));
        model.put("username",new String(username.getBytes("iso8859-1"), "utf-8"));
        return "admin/modifyCounselor";
    }

    // 删除辅导员
    @RequestMapping(value = "/deleteCoun.do", method = RequestMethod.POST)
    @ResponseBody
    public String deleteCoun(@RequestBody String id) {
        return String.valueOf(counselorService.deleteCoun(id.substring(3)));
    }

    //模糊查询
    @RequestMapping("/counselorSelect.do")
    public ModelAndView counselorSelect(String id,String username ,String dept,@RequestParam(defaultValue="1") String currentPage){
        return counselorService.selectCounByParams(id,username,dept,currentPage);
    }
}
