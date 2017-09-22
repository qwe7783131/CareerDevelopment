package com.bugmaker.controller.admin;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.Role;
import com.bugmaker.bean.User;
import com.bugmaker.bean.UserRole;
import com.bugmaker.service.AddTeacherService;
import com.bugmaker.service.TeacherService;
import com.bugmaker.utils.XslResolveUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    AddTeacherService teacherService3;

    @Autowired
    @Qualifier("selectTeaService")
    TeacherService teacherService;

    //获取数据跳转到teacherManage
    @RequestMapping("/admin/teacherManage.do")
    public String teacherManageView(ModelMap model) {
        List<User> selectAllTea = teacherService.selectAllTea();
        List<Dept> selectAllDept = teacherService3.selectAllDept();
        model.put("selectAllDept",selectAllDept);
        model.put("selectAllTea",selectAllTea);
        return "admin/teacherManage";
    }

    //模糊查询
    @RequestMapping("/admin/teacherManage2.do")
    public String teacherManage2View(ModelMap model,String username,String sex ,String dept){
        System.out.println("username"+username + "sex" + sex + "dept" + dept);
        User user = new User();
        user.setUsername(username);
        Dept dept1 = new Dept();
        dept1.setId(dept);
        user.setDept(dept1);
        user.setSex(sex);
        List<User> selectAllTea = teacherService.selectTeaByParams(user);
        List<Dept> selectAllDept = teacherService3.selectAllDept();
        model.put("selectAllDept",selectAllDept);
        model.put("selectAllTea",selectAllTea);
        return "admin/teacherManage";
    }

     //添加单个教师的控制器
    @RequestMapping(value = "addOneTea.do", method = RequestMethod.POST)
    @ResponseBody
    public String addOneTea(@RequestBody  String userString) throws IOException{
        //System.out.println(userString);
        ObjectMapper mapper = new ObjectMapper();
        Map userMap = mapper.readValue(userString, Map.class);
        //System.out.println(userMap);
        Dept dept = new Dept();
        dept.setId(userMap.get("dept").toString());
        User user = new User();
        user.setId(userMap.get("id").toString());
        user.setUsername(userMap.get("username").toString());
        user.setPassword((new Md5Hash(userMap.get("password").toString())).toString());
        user.setSex(userMap.get("sex").toString());
        user.setAge(Integer.valueOf(userMap.get("age").toString()));
        user.setPhone(userMap.get("phone").toString());
        user.setEmail(userMap.get("email").toString());
        user.setDept(dept);
        user.setCreatTime(new Date());
        user.setEnable(1);
        user.setType(2);
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        Role role = new Role();
        role.setId("2");
        userRole.setRole(role);
        teacherService.addTeaRole(userRole);
        return "" + teacherService3.addOneTea(user);
    }

    /**
     * 导入表格添加教师控制器
     */
    @RequestMapping(value = "addMulTea.do", method = RequestMethod.POST)
    @ResponseBody
    public String addMulTea(HttpServletRequest request) throws IOException {
        return "" + teacherService3.addMulTea(request);
    }


    /**
     * 获取学院
     */
    @RequestMapping("/admin/selectDept.do")
    public  String selectDept(ModelMap model){
        List<Dept> selectAllDept = teacherService3.selectAllDept();
        model.put("selectAllDept",selectAllDept);
        return "admin/addTeacher";
    }
    /**
     * 获取学院（修改教师时)
     */
    @RequestMapping("/admin/selectDept2.do")
    public  String selectDept2(ModelMap model){
        List<Dept> selectAllDept = teacherService3.selectAllDept();
        model.put("selectAllDept",selectAllDept);
        return "admin/modifyTeacher";
    }



    //修改教师信息
    @RequestMapping(value = "admin/modifyTeacherImpl.do", method = RequestMethod.POST)
    @ResponseBody
    public String modifyTeacherImpl(@RequestBody String userString) throws IOException {
        System.out.println("执行修改controller");
        System.out.println(userString);
        ObjectMapper mapper = new ObjectMapper();
        Map userMap = mapper.readValue(userString, Map.class);
        System.out.println(userMap);
        Dept dept = new Dept();
        dept.setId(userMap.get("dept").toString());
        com.bugmaker.bean.User user = new User();
        user.setId(userMap.get("id").toString());
        user.setUsername(userMap.get("username").toString());
        user.setPassword((new Md5Hash(userMap.get("password").toString())).toString());
        user.setSex(userMap.get("sex").toString());
        user.setAge(Integer.valueOf(userMap.get("age").toString()));
        user.setPhone(userMap.get("phone").toString());
        user.setEmail(userMap.get("email").toString());
        user.setDept(dept);
        user.setCreatTime(new Date());
        user.setEnable(Integer.parseInt(userMap.get("enable").toString()));
        user.setType(2);

        return "" + teacherService.updateTea(user);
    }

    // 删除教师
    @RequestMapping(value = "admin/deleteTeacher.do", method = RequestMethod.POST)
    @ResponseBody
    public String deleteTeacher(@RequestBody String id){
        //System.out.println("执行删除controller");
        //System.out.println(id.substring(3));
        teacherService.deleteTea(id.substring(3));

        return "123";
    }
}
