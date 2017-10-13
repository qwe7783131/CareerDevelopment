package com.bugmaker.service;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

public interface CounselorService {

    //获取数据跳转到counselorManage
    ModelAndView counselorManageView(String currentPage);

    //添加单个学生
    public String addOneCounselor(String userString) throws IOException;

    //查询所有辅导员
    public List<Dept> selectAllDept();

    //查询所有辅导员
    public List<User> selectAllCoun();

    //修改教师信息
    public String updateCoun(String userString,String id) throws IOException;

    //删除辅导员
    public int deleteCoun(String id);

    //模糊查询
    public ModelAndView selectCounByParams(String id, String username , String dept, String currentPage);
}
