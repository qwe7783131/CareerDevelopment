package com.bugmaker.controller.student;

import com.bugmaker.bean.StuLog;
import com.bugmaker.service.StuLogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentLogController {

    @Resource
    private StuLogService stuLogService;

    @RequestMapping("logInfo.do")
    public ModelAndView stuLogInfoView(Model model){

        String stuId = "aaaa";
        List<StuLog> stuLogs = stuLogService.getAllByParam(stuId);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("stuLogs", stuLogs);

        return new ModelAndView("student/stuLogInfo", "map", map);
    }

    @RequestMapping("addLog.do")
    @ResponseBody
    public boolean addLog(String content){
        String stuId = "aaaa";
        return stuLogService.addLogByStudent(stuId, content);
    }
}
