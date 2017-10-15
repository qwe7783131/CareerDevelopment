package com.bugmaker.controller.outteacher;

import com.bugmaker.bean.StuLog;
import com.bugmaker.bean.User;
import com.bugmaker.service.StuLogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/outteacher")
public class OutTeacherStuLogController {

    @Resource
    private StuLogService stuLogService;
    /**
     * 查看和完成顶岗实习手册
     * @return
     */
    @RequestMapping("selectOutJobBook.do")
    public ModelAndView selectOutJobBookView(Model model, HttpServletRequest request){

        User user = (User)request.getSession().getAttribute("user");
        String teaId = user.getId();
        List<StuLog> stuLogs = stuLogService.getAllByOutId(teaId);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("stuLogs", stuLogs);

        return new ModelAndView("outteacher/selectOutJobBook", "map", map);
    }

    @ResponseBody
    @RequestMapping("writeBackOutLog.do")
    public boolean writeBackOutLog(HttpServletRequest request, String stuLogId, String content){
        User user = (User)request.getSession().getAttribute("user");
        String teaId = user.getId();
        return stuLogService.addOutTeacherWriteBack(stuLogId, content);
    }
}
