package com.bugmaker.controller.leader;

import com.bugmaker.bean.*;
import com.bugmaker.service.DirectionClassManagerService;
import com.bugmaker.service.VolunteerInfoService;
import com.bugmaker.utils.MyUtil;
import com.bugmaker.utils.RequestUtil;
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
import java.util.*;


/**
 * 系领导的分班相关模块
 */
@Controller
@RequestMapping("/leader")
public class DivideClassController {

    @Resource
    private VolunteerInfoService volunteerInfoService;


    @Resource
    private DirectionClassManagerService directionClassManagerService;
    /**
     * 分班
     * @param directId 方向id
     * @param classNum 分班个数
     * @return
     */
    @RequestMapping("divideClass.do")
    @ResponseBody
    public boolean divideClass(String directId, String directName, Integer count, Integer classNum){

        // 接收一组数据 [专业方向id，专业方向名字， 人数，分班个数]
        System.out.println("方向id:" + directId + "分班个数" + classNum);
        System.out.println(directName + count);

        List<DirectionClass> directionClasses = new ArrayList<DirectionClass>();

        if(count < classNum){
            return false;
        }

        Direction direction = new Direction();
        direction.setId(directId);
        List<String> dcIdList = new ArrayList<String>();
        for(int i = 1; i <= classNum; i++){
            DirectionClass directionClass = new DirectionClass();
            String randomId = UUID.randomUUID().toString().replace("-", "");
            dcIdList.add(randomId);
            directionClass.setId(randomId);
            directionClass.setName(directName + i + "班");
            directionClass.setDirection(direction);

            directionClasses.add(directionClass);
        }

        //用到的表 student，directionClass，
        // 1.在专业方向的班级表插入班级id
        directionClassManagerService.mutiAddDirectinClass(directionClasses);
        // 2.找出所有选了这个方向的学生志愿
        List<Enroll> enrolls = volunteerInfoService.selectAllEnrollByDirectId(directId);
        // 3.在学生表中更新方向班级id
        // update student ()
        // 4.返回操作状态

        List<List<Enroll>> lists = MyUtil.averageAssign(enrolls, classNum);

        System.out.println(lists.size());
        int i = 0;
        for (List<Enroll> list : lists){
            System.out.println("==" +list.size());
            System.out.println(list);
            volunteerInfoService.batchUpdateStudentByEnroll(dcIdList.get(i), list);
            i++;
        }
        return true;
    }

    /**
     * 跳转到分班页面
     */
    @RequestMapping("toDivideClass.do")
    public ModelAndView divideClassView(){

        Map<String, Object> map = new HashMap<String, Object>();
        User user = RequestUtil.getCurrentUser();
        String deptId = user.getDept().getId();
        List<Direction> directions = null;
        directions = volunteerInfoService.selectDirectionByDeptId(deptId);
        // 用到的表， enroll,direction
        List<Map> infoMap = volunteerInfoService.getAllVolunteerInfo(deptId);

        map.put("directions", directions);
        map.put("infoMap", infoMap);
        // 根据deptId来
        return new ModelAndView("leader/divideClass", "map", map);
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
                                          @RequestParam(defaultValue="1") String curr,
                                          String pcClassId, String directId, Integer statusId) {

//        Integer currPage = Integer.valueOf(currentPage);
//        PageHelper.startPage(currPage, 5);
        // 根据传入的专业id和专业方向id来查询相对应的学生填报情况
//        List<Student> students = studentService.selectAllStudent();
//        //System.out.println(students);
//        PageInfo page = new PageInfo(students, 5);
//        page.getNavigatePages();
//        model.addAttribute("page",page);
        return volunteerInfoService.toVolunteerPage(pcClassId,directId,statusId, curr);
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
                                       @RequestParam(defaultValue="1") String curr,
                                       String directId, String classId){

        return volunteerInfoService.toDividePage(directId, classId, curr);
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
