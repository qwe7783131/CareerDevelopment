package com.bugmaker.controller.leader;

import com.bugmaker.bean.Enroll;
import com.bugmaker.service.VolunteerInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;


/**
 * 系领导的分班相关模块
 */
@Controller
@RequestMapping("/leader")
public class DivideClassController {

    @Resource
    private VolunteerInfoService volunteerInfoService;
    /**
     * 分班
     * @param direct_id 方向id
     * @param class_num 分班个数
     * @return
     */
    @RequestMapping("divideClass.do")
    @ResponseBody
    public boolean divideClass(String direct_id, Integer class_num){

        System.out.println("方向id:" + direct_id + "分班个数" + class_num);
        // 1.在专业方向的班级表插入班级id

        // 2.在学生表中插入方向班级id

        // 3.返回操作状态
        return true;
    }

    /**
     * 跳转到分班页面
     */
    @RequestMapping("toDivideClass.do")
    public String divideClassView(){
        return "leader/divideClass";
    }

    /**
     * 查看志愿填报
     * @param pcClassId 专业班级id
     * @param directId 志愿方向id
     * @param statusId 审核状态
     * @return
     */
    @RequestMapping("toVolunteerInfo.do")
    public ModelAndView volunteerInfoView(Model model,
                                          @RequestParam(defaultValue="1") String currentPage,
                                          String pcClassId, String directId, Integer statusId) {

//        Integer currPage = Integer.valueOf(currentPage);
//        PageHelper.startPage(currPage, 5);
        // 根据传入的专业id和专业方向id来查询相对应的学生填报情况
//        List<Student> students = studentService.selectAllStudent();
//        //System.out.println(students);
//        PageInfo page = new PageInfo(students, 5);
//        page.getNavigatePages();
//        model.addAttribute("page",page);
        return volunteerInfoService.toVolunteerPage(pcClassId,directId,statusId, currentPage);
    }

    // 文件导入导出的例子：http://blog.csdn.net/hsf15768615284/article/details/73136029
    @RequestMapping("exportVolunteer.do")
    @ResponseBody
    public void exportVolunteerInfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
        OutputStream output;
        try {
            output = response.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            bufferedOutPut.flush();
//            workbook.write(bufferedOutPut);
            bufferedOutPut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("toDivideInfo.do")
    public ModelAndView divideInfoView(Model model,
                                       @RequestParam(defaultValue="1") String currentPage,
                                       String deptId, String directId, String classId){

        return volunteerInfoService.toDividePage(directId, classId, currentPage);
    }

    /**
     * 设置志愿状态并填入理由
     * @param enrollId 志愿id
     * @param status 审核状态
     * @return 执行结果
     */
    @ResponseBody
    @RequestMapping("modifyEnrollStatus.do")
    public boolean modifyEnrollState(String enrollId, Integer status, String reason){
//        System.out.println("aaaa");
//        System.out.println(enrollId + "" + status + "" + reason);
        return volunteerInfoService.modifyEnrollStatus(enrollId, status, reason);
    }

}
