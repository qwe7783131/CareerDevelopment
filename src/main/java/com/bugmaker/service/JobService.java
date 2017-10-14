package com.bugmaker.service;

import com.bugmaker.bean.Company;
import com.bugmaker.bean.Job;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface JobService {
    //查询所有job跳转到jobManage
    public ModelAndView jobManageView(String currentPage);

    //查询所有job
    public List<Job> selectAllJob();

    //修改job
    public String modifyJob(String job,String id) throws IOException;

    //添加job
    public String addJob(String jobString) throws IOException;

    //删除job
    public int deleteJob(String id);

    //模糊查询
//    public ModelAndView selectJobByName(String name,String currentPage);

    //获取所有企业
    public List<Company> getAllCompany();

    //获取数据跳转到addJob
    public ModelAndView toAddJob(String company_id,String job_id);

    //跳转到修改岗位
    public ModelAndView toUpdateJob(String id,String company_id,String name,String salary, String outteacher_id) throws UnsupportedEncodingException;

    //模糊查询
    public ModelAndView selectAllJobByCompanyName(String name,String currentPage);
}
