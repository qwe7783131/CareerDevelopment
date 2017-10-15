package com.bugmaker.controller.admin;

import com.bugmaker.bean.Dept;
import com.bugmaker.service.AddTeacherService;
import com.bugmaker.service.LeaderService;
import com.bugmaker.service.ProfessteacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProfessteacherControllerAdmin {

    @Autowired
    @Qualifier("teaService")
    AddTeacherService teacherService;

    @Autowired
    @Qualifier("professteacherImpl")
    ProfessteacherService professteacherService;

    //获取数据跳转到leaderManage
    @RequestMapping("/professteacherManage.do")
    public ModelAndView professteacherManageView(@RequestParam(defaultValue="1") String currentPage) {
        return professteacherService.professteacherManageView(currentPage);
    }


    // 添加单个系领导的控制器
    @ResponseBody
    @RequestMapping(value = "addOneProfessteacher.do", method = RequestMethod.POST)
    public String addOneProfessteacher(@RequestBody String userString) throws IOException {
//        System.out.println(userString);
        return professteacherService.addOneProfessteacher(userString);
    }


    //跳转到modifyCounselor
    @RequestMapping("/modifyProfessteacher.do")
    public ModelAndView modifyProfessteacher(){
        return null;
    }

    //修改系领导信息
    @RequestMapping(value = "/modifyProfessteacherImpl.do", method = RequestMethod.POST)
    @ResponseBody
    public String modifyProfessteacherImpl(@RequestBody String userString,String id) throws IOException {
//        System.out.println(userString);
        return professteacherService.updateProfessteacher(userString,id);
    }

    /**
     * 获取学院（添加时用）
     */
    @RequestMapping("/professteacherSelectDept.do")
    public  String selectDept(ModelMap model){
        List<Dept> selectAllDept = professteacherService.selectAllDept();
        model.put("selectAllDept",selectAllDept);
        return "admin/addProfessteacher";
    }

    /**
     * 获取学院（修改系领导时)
     */
    @RequestMapping("/professteacherSelectDept2.do")
    public  String selectDept2(ModelMap model,String id,String sex,String age,String phone,String email,String username,String dept) throws UnsupportedEncodingException {
        List<Dept> selectAllDept = professteacherService.selectAllDept();
        model.put("selectAllDept",selectAllDept);
        model.put("id",id);
        model.put("sex",sex);
        model.put("age",age);
        model.put("phone",phone);
        model.put("email",email);
        model.put("dept1",new String(dept.getBytes("iso8859-1"), "utf-8"));
        model.put("username",new String(username.getBytes("iso8859-1"), "utf-8"));
        return "admin/modifyProfessteacher";
    }

    // 删除系领导
    @RequestMapping(value = "/deleteProfessteacher.do", method = RequestMethod.POST)
    @ResponseBody
    public String deleteProfessteacher(@RequestBody String id) {
        return String.valueOf(professteacherService.deleteProfessteacher(id.substring(3)));
    }

    //模糊查询
    @RequestMapping("/professteacherSelect.do")
    public ModelAndView LeaderSelect(String id,String username ,String dept,@RequestParam(defaultValue="1") String currentPage){
        return professteacherService.selectProfessteacherByParams(id,username,dept,currentPage);
    }
}
