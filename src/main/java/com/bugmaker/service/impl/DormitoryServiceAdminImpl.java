package com.bugmaker.service.impl;

import com.bugmaker.bean.Company;
import com.bugmaker.bean.DormArrange;
import com.bugmaker.bean.Dormitory;
import com.bugmaker.bean.Outteacher;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;
import com.bugmaker.mapper.DormArrangeMapper;
import com.bugmaker.mapper.DormitoryMapper;
import com.bugmaker.mapper.StudentMapper;
import com.bugmaker.service.CompanyService;
import com.bugmaker.service.DormitoryServiceAdmin;
import com.bugmaker.service.OutTeacherService;
import com.bugmaker.utils.RequestUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

@Service("dormitoryServiceAdmin")
public class DormitoryServiceAdminImpl implements DormitoryServiceAdmin {

    @Autowired
    private DormitoryMapper dormitoryMapper;
    
    @Resource
    private StudentMapper studentMapper;

    @Autowired
    @Qualifier("companyService")
    CompanyService companyService;
    
    @Resource
    private DormArrangeMapper dormArrangeMapper;

    //跳转到宿舍管理页面
    @Override
    public ModelAndView toDormitoryManage(String curr) {
        Map<String,Object> map = new HashMap<>();
        int nowPage = Integer.valueOf(curr);
        PageHelper.startPage(nowPage, 6);
        List<Dormitory> dormitoryList = dormitoryMapper.getAllDorm();
        for(Dormitory dormitory:dormitoryList){
            System.out.println(dormitory);
        }
        PageInfo<Dormitory> page = new PageInfo<>(dormitoryList);
        List<Company> companyList = companyService.selectAllCompany();
        map.put("page",page);
        map.put("companyList",companyList);
        return new ModelAndView("admin/dormitoryManage", "map", map);
    }

    @Override
    public ModelAndView toAddDormitory() {
        Map<String,Object> map = new HashMap<>();
        List<Company> companyList = companyService.selectAllCompany();
        map.put("companyList",companyList);
        return new ModelAndView("admin/addDormitory", "map", map);
    }

    @Override
    public int addDormitory(String dormitoryString) throws IOException {
//        System.out.println(dormitoryString);
        ObjectMapper mapper = new ObjectMapper();
        Map userMap = mapper.readValue(dormitoryString, Map.class);
        Dormitory dormitory = new Dormitory();
        Company company = new Company();
        dormitory.setId(userMap.get("id").toString());
        dormitory.setTotal(Integer.parseInt(userMap.get("total").toString()));
        dormitory.setPersonNum(Integer.parseInt(userMap.get("person_num").toString()));
        company.setId(userMap.get("company").toString());
        dormitory.setCompany(company);
//        System.out.println(dormitory);
        return dormitoryMapper.addDormitory(dormitory);
    }

    @Override
    public ModelAndView toModifyDormitory(String id,String companyName,String total,String personNum) {
//        System.out.println("id="+id+"  company="+companyName+"  total="+total+"  personNum="+personNum);
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("company",companyName);
        map.put("total",total);
        map.put("personNum",personNum);
        List<Company> companyList = companyService.selectAllCompany();
        map.put("companyList",companyList);
        return new ModelAndView("admin/modifyDormitory","map",map);
    }

    public int modifyDormitory(String dormitoryString) throws IOException {
//        System.out.println(dormitoryString);
        ObjectMapper mapper = new ObjectMapper();
        Map userMap = mapper.readValue(dormitoryString, Map.class);
        Dormitory dormitory = new Dormitory();
        Company company = new Company();
        dormitory.setId(userMap.get("name").toString());
        dormitory.setTotal(Integer.parseInt(userMap.get("total").toString()));
        dormitory.setPersonNum(Integer.parseInt(userMap.get("personNum").toString()));
        company.setId(userMap.get("company").toString());
        dormitory.setCompany(company);
        return dormitoryMapper.modifyDormitory(dormitory);
    }

    @Override
    public int deleteDormitory(String id) {
//        System.out.println(id);
        int i = dormitoryMapper.deleteDormitory(id.substring(3));
//        System.out.println(i);
        return i;
    }

    @Override
    public ModelAndView getDormByCompany(String company, String curr) {
//        System.out.println(company+curr);
        List<Dormitory> dormitoryList;
        Map<String,Object> map = new HashMap<>();
        int nowPage = Integer.valueOf(curr);
        PageHelper.startPage(nowPage, 6);
        if(company!=null&&company!="") {
            dormitoryList = dormitoryMapper.getDormByCompany(company);
        }
        else{
            dormitoryList = dormitoryMapper.getAllDorm();
        }
//        for(Dormitory dormitory:dormitoryList){
//            System.out.println(dormitory);
//        }
        PageInfo<Dormitory> page = new PageInfo<>(dormitoryList);
        List<Company> companyList = companyService.selectAllCompany();
        map.put("page",page);
        map.put("companyList",companyList);
        return new ModelAndView("admin/dormitoryManage", "map", map);
    }

    //一键安排宿舍
	@Override
	public int doArrangeDormitory(String insType) {
		String type = null;
		if(insType.equals("0")){
			type = "跟岗";
		}else{
			type = "顶岗";
		}
		User outteacher = RequestUtil.getCurrentUser();
		List<Student> students = studentMapper.selectStudentsByOutTeacherId(outteacher.getId(),type);
		List<Dormitory> dormitories = dormitoryMapper.getDormitoryLeaveByOutTeacherId(outteacher.getId());
		List<DormArrange> dormArranges = new ArrayList<>();
		for (Dormitory dormitory : dormitories) {
			int leave = dormitory.getTotal() - dormitory.getPersonNum();
			int min = leave;
			int length = students.size();
			if(length == 0){
				break;
			}
			if(length < leave){
				min = length;
			}
			for(int i=0; i<min; i++){
				DormArrange dormArrange = new DormArrange();
				dormArrange.setDormitory(dormitory);
				dormArrange.setStudent(students.get(0));
				//添加一条宿舍安排记录
				dormArranges.add(dormArrange);
				//原宿舍入住人数+1
				dormitory.setPersonNum(dormitory.getPersonNum()+1);
				//未安排的学生人数-1
				students.remove(0);
			}
		}
		//宿舍安排写入数据库
		dormArrangeMapper.insertDormArranges(dormArranges);
		//更新宿舍情况
		dormitoryMapper.updateDormitorys(dormitories);
		return 1;
	}

	//跳转到宿舍管理页面
	@Override
	public ModelAndView toDormitoryManagePage(String insType, String pageNum) {
		int nowPage = Integer.valueOf(pageNum);
		ModelAndView modelAndView = new ModelAndView("outteacher/dormitory");
		User user = RequestUtil.getCurrentUser();
    	modelAndView.addObject("insType", insType);
    	String type = null;
		if(insType.equals("0")){
			type = "跟岗";
		}else{
			type = "顶岗";
		}
		PageHelper.startPage(nowPage, 10);
    	List<DormArrange> dormArranges = dormArrangeMapper.selectDormArrangeByOutTeacId(user.getId(),type);
		PageInfo<DormArrange> page = new PageInfo<>(dormArranges);
    	modelAndView.addObject("page", page);
    	return modelAndView;
	}

	//跳转到更换宿舍页面
	@Override
	public ModelAndView toChangeDormPage(String dormaid, String stuid,
			String dormid) {
		ModelAndView view = new ModelAndView("outteacher/changeDorm");
    	view.addObject("dormaid", dormaid);
    	view.addObject("stuid", stuid);
    	view.addObject("dormid", dormid);
    	User outteacher = RequestUtil.getCurrentUser();
    	List<Dormitory> dormitories = dormitoryMapper.getDormitoryLeaveByOutTeacherId(outteacher.getId());
    	view.addObject("dormitories", dormitories);
		return view;
	}

	//更换宿舍
	@Override
	public int doChangeDorm(String dormaid, String stuid, String dormid,
			String changDormId) {
		//修改宿舍
		dormArrangeMapper.changeDormByid(dormaid,changDormId);
		//原宿舍人数-1
		dormitoryMapper.downOnePersonNum(dormid);
		//更换的宿舍人数+1
		dormitoryMapper.upOnePersonNum(changDormId);
		return 1;
	}
}
