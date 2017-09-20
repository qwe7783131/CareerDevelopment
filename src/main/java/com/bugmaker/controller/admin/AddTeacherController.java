package com.bugmaker.controller.admin;

import com.bugmaker.bean.User;
import com.bugmaker.service.AddTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class AddTeacherController {

    @Autowired
    @Qualifier("teaService")
    AddTeacherService teacherService;
    public User test(){
        User user = new User();
        user.setId("201424133221");
        user.setAge(12);
        return user;
    }

    /**
     *添加单个教师的控制器
     * @param user 请求正文参数封装为student对象
     * @return 返回前台结果
     */
    @RequestMapping(value = "addOneTea.do", method = RequestMethod.POST)
    @ResponseBody
    public String addOneTea(@RequestBody User user){

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
}
