package com.bugmaker.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

import javax.annotation.Resource;

import com.bugmaker.bean.Company;
import com.bugmaker.service.CompanyService;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.Outteacher;
import com.bugmaker.bean.User;
import com.bugmaker.mapper.DeptMapper;
import com.bugmaker.mapper.OutTeacherMapper;
import com.bugmaker.mapper.UserRoleMapper;
import com.bugmaker.service.OutTeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("outteacherService")
public class OutTeacherServiceImpl implements OutTeacherService{
	@Resource
	OutTeacherMapper outTeacherMapper;

	@Autowired
	@Qualifier("companyService")
	CompanyService companyService;

	@Autowired
	@Qualifier("outteacherService")
	OutTeacherService outTeacherService;
	
	@Resource
	private DeptMapper deptMapper;
	
	@Resource
	private UserRoleMapper userRoleMapper;

	//查询出所有企业教师
	@Override
	public ModelAndView selectAllOutTeacher(String curr) {
		int nowPage = Integer.valueOf(curr);
		PageHelper.startPage(nowPage, 5);
		List<Outteacher> outteachers = outTeacherMapper.selectAllOutTeacher();
		//System.out.println(outteachers);
		PageInfo<Outteacher> page = new PageInfo<>(outteachers);
		return new ModelAndView("teacher/selectOut", "page", page);
	}

	//模糊搜索
	@Override
	public List<Outteacher> selectAllOutTeacherByParams(Outteacher outteacher) {
		List<Outteacher> outteachers = outTeacherMapper.selectAllOutTeacherByParams(outteacher);
		//System.out.println(outteachers);
		return outteachers;
	}

///////////////////////////////////////////////////xuxu///////////////////////////////////////////////////////////////////////////

	//查询所有企业教师
	public List<Outteacher> getAllOutteacher(){
		List<Outteacher> outteacherList = outTeacherMapper.selectAllOutTeacher();
//		for(Outteacher outteacher :outteacherList){
//			System.out.println(outteacher);
//		}
		return outteacherList;
	}

	//查询出所有企业

    //添加企业教师
    public String addOutteacher(String userInfo) throws IOException {
        System.out.println(userInfo);
        ObjectMapper mapper = new ObjectMapper();
        Map userMap = mapper.readValue(userInfo, Map.class);
        Outteacher outteacher = new Outteacher();
        outteacher.setId(UUID.randomUUID().toString().replace("-",""));
        User user = new User();
        user.setId(userMap.get("id").toString());
        user.setUsername(userMap.get("username").toString());
        user.setPassword(new Md5Hash(userMap.get("id").toString(),userMap.get("password").toString()).toString());
        user.setSex(userMap.get("sex").toString());
        user.setAge(Integer.parseInt(userMap.get("age").toString()));
        user.setPhone(userMap.get("phone").toString());
        user.setEmail(userMap.get("email").toString());
        user.setType(3);
        user.setEnable(1);
        user.setCreatTime(new Date());
        Company company = new Company();
        company.setId(userMap.get("company").toString());
        outteacher.setCompany(company);
        outteacher.setUser(user);
        outTeacherMapper.insertOutteacherUserRole(outteacher);
        outTeacherMapper.insertOutteacherUser(outteacher);
        return String .valueOf(outTeacherMapper.insertOutteacher(outteacher));
    }

	//跳转到企业教师
	public ModelAndView toModifyOutteacher(String id,String companyid,String name,String sex,String age,String phone,String email) throws UnsupportedEncodingException {
		Map<String,Object> map = new HashMap<>();
		map.put("id",id);
		map.put("companyid",companyid);
		map.put("name",new String(name.getBytes("iso8859-1"), "utf-8"));
		map.put("sex",sex);
		map.put("age",age);
		map.put("phone",phone);
		map.put("email",email);
		return new ModelAndView("admin/modifyOutteacher","map",map);
	}

	//修改企业教师
	public String modifyOutteacher(String userInfo,String id) throws IOException {
		System.out.println(userInfo + id);
		ObjectMapper mapper = new ObjectMapper();
		Map userMap = mapper.readValue(userInfo,Map.class);
		User user = new User();
		user.setId(id);
//		if(userMap.get("password").toString()!=null&&userMap.get("password").toString()!="") {
//			user.setPassword((new Md5Hash(id, userMap.get("password").toString())).toString());
//		}
		user.setUsername(userMap.get("name").toString());
		user.setSex(userMap.get("sex").toString());
		user.setAge(Integer.parseInt(userMap.get("age").toString()));
		user.setPhone(userMap.get("phone").toString());
		user.setEmail(userMap.get("email").toString());
		System.out.println(user);
		return String.valueOf(outTeacherMapper.updateOutteacher(user));
	}


	//删除企业教师
	public String deleteOutteacher(String id){
//		System.out.println(id);
		return String.valueOf(outTeacherMapper.deleteOutteacher(id.substring(3)));
	}

	//查询数据跳转到outteacherManage
	public ModelAndView toOutteacherManage(String currentPage){
		Map<String,Object> map = new HashMap<String,Object>();
		List<Company> companyList = companyService.selectAllCompany();
		map.put("company",companyList);
		Integer currPage = Integer.valueOf(currentPage);
		PageHelper.startPage(currPage,5);
		List<Outteacher> outteacherList = outTeacherService.getAllOutteacher();
		PageInfo<Outteacher> page = new PageInfo<>(outteacherList);
		map.put("page",page);
		return new ModelAndView("admin/outteacherManage","map",map);
	}

	//查询出所有企业跳转到addOutteacher
	public ModelAndView toAddOutteacher(){
		Map<String,Object> map = new HashMap<String,Object>();
		List<Company> companyList = companyService.selectAllCompany();
		map.put("company",companyList);
		return new ModelAndView("admin/addOutteacher","map",map);
	}

	//模糊搜索
	public ModelAndView selectOutTeacherByParams(String compamy,String name,String currentPage) {
//		System.out.println(compamy + name);
		Outteacher outteacher = new Outteacher();
		User user = new User();
		user.setUsername(name);
		outteacher.setUser(user);
		Company company = new Company();
		company.setId(compamy);
		outteacher.setCompany(company);

		Map<String,Object> map = new HashMap<>();
		Integer currPage = Integer.valueOf(currentPage);
		PageHelper.startPage(currPage,5);
		List<Outteacher> outteachers = outTeacherMapper.selectOutTeacherByParams(outteacher);
//		for(Outteacher outteacher1 :outteachers){
//			System.out.println(outteacher1);
//		}
		PageInfo<Outteacher> page = new PageInfo<>(outteachers);
		map.put("page",page);

		List<Company> companyList = companyService.selectAllCompany();
		map.put("company",companyList);
		return new ModelAndView("admin/outteacherManage","map",map);
	}

}
