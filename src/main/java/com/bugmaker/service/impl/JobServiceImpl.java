package com.bugmaker.service.impl;

import com.bugmaker.bean.Company;
import com.bugmaker.bean.Job;
import com.bugmaker.bean.Outteacher;
import com.bugmaker.bean.User;
import com.bugmaker.mapper.CompanyMapper;
import com.bugmaker.mapper.JobMapper;
import com.bugmaker.service.JobService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

//岗位管理实现类
@Service("jobService")
public class JobServiceImpl implements JobService {

    @Autowired
    @Qualifier("jobService")
    JobService jobService;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private JobMapper jobMapper;

    public void setCompanyMapper(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }

    public void setJobMapper(JobMapper jobMapper) {
        this.jobMapper = jobMapper;
    }

    //查询所有job跳转到jobManage
    @Override
    public ModelAndView jobManageView(String currentPage) {
        Map<String ,Object> map = new HashMap<String, Object>();
        int nowPage = Integer.valueOf(currentPage);
        PageHelper.startPage(nowPage, 5);
        List<Job> jobList = jobService.selectAllJob();
        PageInfo<Job> page = new PageInfo<>(jobList);
        for(Job job: jobList){
            System.out.println(job);
        }
        System.out.println(page.getTotal());
        map.put("page",page);
        List<Company> companyList = jobService.getAllCompany();
        map.put("company",companyList);
        return new ModelAndView("/admin/jobManage","map",map);
    }

    //查询所有job
    @Override
    public List<Job> selectAllJob() {
        List<Job> jobList = jobMapper.getAllJob();

        return jobList;
    }

    //修改job
    @Override
    public String modifyJob(String jobString,String id) throws IOException {
//        System.out.println("jobString=" + jobString + "  id=" + id);
        ObjectMapper mapper = new ObjectMapper();
        Map userMap = mapper.readValue(jobString, Map.class);
        Job job = new Job();
        job.setId(id);
        job.setName(userMap.get("name").toString());
        job.setSalary(Double.parseDouble(userMap.get("salary").toString()));
        Outteacher outteacher = new Outteacher();
        outteacher.setId(userMap.get("outteacherId").toString());
        job.setOutteacher(outteacher);
        return String.valueOf(jobMapper.updateJobById(job));
    }

    //添加job
    @Override
    public String addJob(String jobString) throws IOException {
//        System.out.println("jobString: " + jobString);
        ObjectMapper mapper = new ObjectMapper();
        Map userMap = mapper.readValue(jobString, Map.class);
        Company company = new Company();
        Job job = new Job();
        job.setId(UUID.randomUUID().toString().replace("-",""));
        company.setId(userMap.get("companyId").toString());
        job.setCompany(company);
        job.setName(userMap.get("name").toString());
        job.setSalary(Double.parseDouble(userMap.get("salary").toString()));
        Outteacher outteacher = new Outteacher();
        outteacher.setId(userMap.get("outteacherId").toString());
        job.setOutteacher(outteacher);
        job.setEnable(1);
        return String.valueOf(jobMapper.insertJob(job));
    }

    //删除job
    @Override
    public int deleteJob(String id){
        System.out.println(id);
        return jobMapper.deleteJob(id.substring(3));
    }

    //模糊查询
//    public ModelAndView selectJobByName(String name,String currentPage){
//        Map<String,Object> map = new HashMap<String,Object>();
//        Company company = new Company();
//        company.setName(name);
//        Integer currPage = Integer.valueOf(currentPage);
//        PageHelper.startPage(currPage, 6);
//        List<Company> companyList = jobMapper.getJobByCompanyId(company);
//        PageInfo<Company> page = new PageInfo<>(companyList);
//        map.put("page",page);
//        if(name.equals("")){
//            return new ModelAndView("redirect:/admin/companyManage.do","map",map);
//        }
//        else {
//            return new ModelAndView("/admin/companyManage","map",map);
//        }
//    }

    //获取所有企业
    public List<Company> getAllCompany(){
        return companyMapper.selectAllCompany();
    }

    //获取数据跳转到addJob
    public ModelAndView toAddJob(String company_id,String outteacher_id){
        Map<String,Object> map = new HashMap<String,Object>();
        if(company_id!=null && !company_id.equals("")) {
            List<User> userList = jobMapper.getOutteacherByCompanyId(company_id);
//            for(User user:userList){
//                System.out.println(user);
//            }
            map.put("getOutteacherByCompanyId", userList);
        }
        List<Company> companyList = jobService.getAllCompany();
//        System.out.println("company_id="+ company_id + "   outteacher_id="+outteacher_id);
        map.put("getAllCompany",companyList);
        map.put("company_id",company_id);
        map.put("outteacher_id",outteacher_id);
        return new ModelAndView("admin/addJob","map",map);
    }
    //跳转到修改岗位
    public ModelAndView toUpdateJob(String id, String company_id, String name, String salary,  String outteacher_name) throws UnsupportedEncodingException {
//        System.out.println("id="+id+"  company_id="+company_id + " salary=" + salary +"name"+ new String(outteacher_name.getBytes("iso8859-1"), "utf-8"));
        Map<String,Object> map = new HashMap<String,Object>();
        List<User> userList = jobMapper.getOutteacherByCompanyId(company_id);
//        System.out.println(userList.size());
        map.put("getOutteacherByCompanyId",userList);
        map.put("id",id);
        map.put("name",new String(name.getBytes("iso8859-1"), "utf-8"));
        map.put("outteachername",new String(outteacher_name.getBytes("iso8859-1"), "utf-8"));
        map.put("salary",salary);
        return new ModelAndView("admin/modifyJob","map",map);
    }

    //模糊查询
    public ModelAndView selectAllJobByCompanyName(String name,String currentPage){
//        System.out.println(name);
        List<Job> jobList;
        Map<String ,Object> map = new HashMap<String, Object>();
        Integer currPage = Integer.valueOf(currentPage);
        PageHelper.startPage(currPage, 10);
        if(name!="") {
            jobList = jobMapper.selectAllJobByCompanyName(name);
        }
        else{
            jobList = jobMapper.getAllJob();
        }
        PageInfo<Job> page = new PageInfo<>(jobList);
//        for(Job job: jobList){
//            System.out.println(job);
//        }
        map.put("page",page);
        List<Company> companyList = jobService.getAllCompany();
        map.put("company",companyList);
        return new ModelAndView("/admin/jobManage","map",map);
    }
}
