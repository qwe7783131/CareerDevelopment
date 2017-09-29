package com.bugmaker.controller.admin;

import com.bugmaker.service.CompanyService;
import com.bugmaker.service.JobService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class JobController {

    @Autowired
    @Qualifier("jobService")
    JobService jobService;

    //跳转到jobManage.html
    @RequestMapping("jobManage.do")
    public ModelAndView jobManage(@RequestParam(defaultValue="1") String currentPage){
        return jobService.jobManageView(currentPage);
    }

    //跳转到添加岗位
    @RequestMapping("toAddJob.do")
    public ModelAndView addJobView(String company_id,String outteacher_id){
        return jobService.toAddJob(company_id,outteacher_id);
    }

    //添加岗位
    @RequestMapping("addJob.do")
    @ResponseBody
    public String addJob(@RequestBody String userString) throws IOException {
        return jobService.addJob(userString);
    }

    //跳转到修改岗位
    @RequestMapping("toUpdateJob.do")
    public ModelAndView toUpdateJob(String id, String company_id, String name, String salary, String outteacher_name) throws IOException {
        return jobService.toUpdateJob(id,company_id,name,salary,outteacher_name);
    }

    //修改岗位
    @RequestMapping("updateJob.do")
    @ResponseBody
    public String updateJob(@RequestBody String jobString,String id) throws IOException {
        return jobService.modifyJob(jobString,id);
    }

    //删除岗位
    @RequestMapping(value = "deleteJob.do",method = RequestMethod.POST)
    @ResponseBody
    public String deleteJob(@RequestBody String id){
        return String.valueOf(jobService.deleteJob(id));
    }

    //模糊查询
    @RequestMapping(value = "selectAllJobByCompanyName.do",method = RequestMethod.POST)
    public ModelAndView selectAllJobByCompanyName(String name,@RequestParam(defaultValue="1") String currentPage){
        return jobService.selectAllJobByCompanyName(name,currentPage);
    }

}
