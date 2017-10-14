package com.bugmaker.service;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.User;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

public interface LeaderService {
    //获取数据跳转到leaderManage
    ModelAndView leaderManageView(String currentPage);

    //添加单个系领导
    public String addOneLeader(String userString) throws IOException;

    //查询所有学院
    public List<Dept> selectAllDept();

    //查询所有系领导
    public List<User> selectAllLeader();

    //修改系领导信息
    public String updateLeader(String userString) throws IOException;

    //删除系领导
    public int deleteLeader(String id);

    //模糊查询
    public ModelAndView selectLeaderByParams(String id, String username , String dept, String currentPage);
}
