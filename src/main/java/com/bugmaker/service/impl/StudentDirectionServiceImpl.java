package com.bugmaker.service.impl;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.Direction;
import com.bugmaker.bean.Enroll;
import com.bugmaker.bean.User;
import com.bugmaker.mapper.DirectionMapper;
import com.bugmaker.mapper.EnrollMapper;
import com.bugmaker.service.StudentDirectionService;
import com.bugmaker.utils.RequestUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by guan on 2017/9/25.
 */
@Service
public class StudentDirectionServiceImpl implements StudentDirectionService {
    @Resource
    DirectionMapper directionMapper;
    @Resource
    EnrollMapper enrollMapper;

    /**
     * 根据学院查询所有专业方向
     */
    @Override
    public ModelAndView selectDirectionByDept(String curr) {
        ModelAndView modelAndView = new ModelAndView();
//        System.out.println(curr);
        int nowPage = Integer.valueOf(curr);
        User currentUser = RequestUtil.getCurrentUser();
        PageHelper.startPage(nowPage, 5);
        List<Direction> directions = directionMapper.studentSelectDirectionByDept(currentUser.getDept());
        //一页显示5条数据
//        System.out.println("depts"+directions);

        PageInfo<Direction> page = new PageInfo<>(directions);
//        System.out.println(page);
        modelAndView.addObject("page",page);


        //获取当前用户的状态（判断他是否填写过志愿）
        String isChooseEnroll = enrollMapper.isChooseEnroll(currentUser.getId());
//        System.out.println("isChooiseEnroll"+isChooseEnroll);
        if (isChooseEnroll == null){     //学生还没填写过,判断为空必须放前面
            modelAndView.addObject("isChooseEnroll",3);
        } else if(isChooseEnroll.equals("0")) {   //0表示志愿不通过
            modelAndView.addObject("isChooseEnroll", 0);
        } else if(isChooseEnroll.equals("1")){ //表示志愿已经通过
            modelAndView.addObject("isChooseEnroll",1);
        } else if(isChooseEnroll.equals("2")){    //表示志愿待审核
            modelAndView.addObject("isChooseEnroll",2);
        }

        //获取当前用户的志愿录取情况
        Enroll enroll = enrollMapper.selectEnrollByStudentId(currentUser.getId());
        modelAndView.addObject("enroll",enroll);
//        System.out.println(enroll);


        modelAndView.setViewName("student/direction");

        return modelAndView;
    }
}
