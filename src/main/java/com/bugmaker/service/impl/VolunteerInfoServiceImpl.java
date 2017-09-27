package com.bugmaker.service.impl;

import com.bugmaker.bean.*;
import com.bugmaker.mapper.*;
import com.bugmaker.service.VolunteerInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;

@Service
public class VolunteerInfoServiceImpl implements VolunteerInfoService{

    @Resource
    private DeptMapper deptMapper;
    @Resource
    private DirectionMapper directionMapper;
    @Resource
    private ProfessionClassMapper professionClassMapper;
    @Resource
    private EnrollMapper enrollMapper;
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private DirectionClassMapper directionClassMapper;

    @Override
    public ModelAndView toVolunteerPage(String pcClassId, String directId, Integer status, String curr) {
        /**
         * status最后再查
         * 如果有pcClassId 查出所有该dept的direct
         *
         * 都没有就最后查询
         */
        System.out.println(pcClassId);
        int nowPage = Integer.valueOf(curr);
        Map<String, Object> map = new HashMap<String, Object>();
//        List<Dept> depts = deptMapper.selectAllDept();
        String deptId = "e2c3cc8ba07a11e7b4d800163e083221";
        List<ProfessionClass> professionClassList = professionClassMapper.getProfessClassByDeptId(deptId);

        List<Direction> directions = null;
        if(pcClassId != null && !pcClassId.equals("")){
            System.out.println("有dept");
            Dept dept = new Dept();
            dept.setId(deptId);
            directions = directionMapper.selectDirectionByDept(dept);
            if(directId != null && !directId.equals("")){
                System.out.println("有direct");
                map.put("directId", directId);
            }
            map.put("pcClassId", pcClassId);

        }else{
            System.out.println("没有pcClass");
            if(directId != null && !directId.equals("")){
                System.out.println("有direct");
                map.put("directId", directId);
                Direction direction = directionMapper.selectDirectionById(directId);
                deptId = direction.getDept().getId();
//                map.put("deptId", deptId);
            }else {
                // 这里应该要查询全部志愿方向
//                directions = directionMapper.selectDirectionByDept(null);
            }
        }

//        List<Enroll> enrolls = wuEnrollMapper.selectByParam(deptId, directId, status);
        PageHelper.startPage(nowPage, 5);
        System.out.println("deptId:"+deptId);
        System.out.println("directId:"+directId+ directId == null);
        System.out.println("pcClassId:"+pcClassId);
        List<Enroll> enrolls = enrollMapper.selectByParam(deptId,directId,pcClassId,status);
        PageInfo<Enroll> page = new PageInfo<>(enrolls);

        System.out.println("pageSize" + page.getPageSize());
        map.put("professionClassList", professionClassList);
        map.put("directions", directions);
        map.put("status", status);
        System.out.println("status"+ status);
        map.put("page", page);
        return new ModelAndView("leader/volunteerInfo", "map", map);
    }


    @Override
    public ModelAndView toDividePage(String directId, String classId, String curr) {
        /**
         *
         * 如果有deptid 查出所有该dept的direct
         * 没有depteId但是有directId就要先查到该专业方向对应的学院，班级
         * 没有deptId和directId但是有班级
         * 都没有就最后查询
         */
        int nowPage = Integer.valueOf(curr);
        Map<String, Object> map = new HashMap<String, Object>();
//        List<Dept> depts = deptMapper.selectAllDept();
        //从session取出deptid
        String deptId = "e2c3cc8ba07a11e7b4d800163e083221";
        List<Direction> directions = null;
        List<DirectionClass> directionClassList = null;
        map.put("classId", classId);
        if(deptId != null && !deptId.equals("")){
            System.out.println("有dept");
            Dept dept = new Dept();
            dept.setId(deptId);
            directions = directionMapper.selectDirectionByDept(dept);
            System.out.println("----" + directions.size());
            if(directId != null && !directId.equals("")){
                System.out.println("有direct");
                map.put("directId", directId);
                // 查看该专业方向下的班级
                directionClassList = directionClassMapper.selectDirectionClassByDirectId(directId);


            }else{
                directionClassList = directionClassMapper.selectDirectionClassByDeptId(deptId);
            }
//            map.put("deptId", deptId);

        }
//        else{
//            System.out.println("没有dept");
//            if(directId != null && !directId.equals("")){
//                System.out.println("有direct");
//                map.put("directId", directId);
//                Direction direction = directionMapper.selectDirectionById(directId);
//                deptId = direction.getDept().getId();
//                map.put("deptId", deptId);
//            }else {
//                // 这里应该要查询全部志愿方向
////              directions = directionMapper.selectDirectionByDept(null);
//            }
//        }


        // 先模拟生成一个列表
//        List<Enroll> enrolls = new ArrayList<Enroll>();
//        Student student = new Student();
//        User user = new User();
//        user.setId("111111111");
//        user.setUsername("吴仁杰");
//        student.setUser(user);
//        Direction direction = new Direction();
//        Dept dept = new Dept();
//        dept.setDeptName("学院");
//        direction.setName("asasas");
//        direction.setDept(dept);
//        for(int i = 0; i < 10; i++){
//            Enroll enroll = new Enroll();
//            enroll.setStudent(student);
//            enroll.setDirection(direction);
//
//            enrolls.add(enroll);
//        }
//        List<Enroll> enrolls = wuEnrollMapper.selectByParam(deptId, directId, status);
        //新建student对象来添加条件
        Student student = new Student();
        Direction direction = new Direction();
        DirectionClass directionClass = new DirectionClass();
        User user = new User();
        Dept dept = new Dept();

        direction.setId(directId);
        directionClass.setId(classId);
        directionClass.setDirection(direction);
        dept.setId(deptId);
        user.setDept(dept);
        student.setDirectionClass(directionClass);
        student.setUser(user);

        List<Student> students = studentMapper.selectStudentByParams(student);
        PageHelper.startPage(nowPage, 8);
        PageInfo<Student> page = new PageInfo<>(students);

        System.out.println("pageSize" + page.getPageSize());
//        map.put("depts", depts);
        map.put("directions", directions);
        map.put("directionClassList", directionClassList);
        map.put("page", page);
        return new ModelAndView("leader/divideInfo", "map", map);
    }


    @Override
    public boolean modifyEnrollStatus(String enrollId, Integer status, String reason) {
        int flag = enrollMapper.updateEnroll(enrollId, status, reason);

        return flag == 1 ? true : false;
    }
}
