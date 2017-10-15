package com.bugmaker.service;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.User;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

public interface ProfessteacherService {
    //获取数据跳转到leaderManage
    ModelAndView professteacherManageView(String currentPage);

    //添加单个系领导
    public String addOneProfessteacher(String userString) throws IOException;

    //查询所有学院
    public List<Dept> selectAllDept();

    //查询所有系领导
    public List<User> selectAllProfessteacher();

    //修改系领导信息
    public String updateProfessteacher(String userString,String id) throws IOException;

    //删除系领导
    public int deleteProfessteacher(String id);

    //模糊查询
    public ModelAndView selectProfessteacherByParams(String id, String username, String dept, String currentPage);
}
