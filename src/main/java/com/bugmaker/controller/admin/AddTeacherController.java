package com.bugmaker.controller.admin;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.User;
import com.bugmaker.service.AddTeacherService;
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
//    public User test(){
//        User user1 = new User();
//        user1.setId("201424133221");
//        user1.setAge(12);
//        return user1;
//    }

    /**
     *添加单个教师的控制器

     * @return 返回前台结果
     */
    @RequestMapping(value = "addOneTea.do", method = RequestMethod.POST)
    @ResponseBody
    public String addOneTea(@RequestBody  String userString) throws IOException{
        System.out.println(userString);

        ObjectMapper mapper = new ObjectMapper();
        Map userMap = mapper.readValue(userString, Map.class);
        System.out.println(userMap);
        Dept dept = new Dept();
        dept.setId(userMap.get("dept").toString());
        User user = new User();
        user.setId(userMap.get("id").toString());
        user.setUsername(userMap.get("username").toString());
        user.setPassword(userMap.get("password").toString());
        user.setSex(userMap.get("sex").toString());
        user.setAge(Integer.valueOf(userMap.get("age").toString()));
        user.setPhone(userMap.get("phone").toString());
        user.setEmail(userMap.get("email").toString());
        user.setDept(dept);
        user.setCreatTime(new Date());
        user.setEnable(1);
        user.setType(2);

        return "" + teacherService.addOneTea(user);
    }

    /**
     * 导入表格添加教师控制器
     * @param request 请求
     * @return 返回前台结果
     * @throws IOException
     */
    @RequestMapping(value = "addMulTea.do", method = RequestMethod.POST)
    @ResponseBody
    public String addMulTea(HttpServletRequest request) throws IOException {
        return "" + teacherService.addMulTea(request);
    }


    /**
     * 获取学院
     */
    @RequestMapping("/admin/selectDept.do")
    public  String selectDept(ModelMap model){
        List<Dept> selectAllDept = teacherService.selectAllDept();
        model.put("selectAllDept",selectAllDept);
        return "admin/addTeacher";
    }

}
