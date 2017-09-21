package com.bugmaker.service.impl;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.User;
import com.bugmaker.mapper.DeptMapper;
import com.bugmaker.mapper.UserMapper;
import com.bugmaker.service.AddTeacherService;
import com.bugmaker.utils.UploadUtil;
import com.bugmaker.utils.XslResolveUtil;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service("teaService")
public class AddTeacherServiceImpl implements AddTeacherService {
    @Autowired
    private UserMapper userMapper ;
    @Autowired
    private DeptMapper deptMapper;

    public void setDeptMapper(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String addOneTea(User user) {
        return  String.valueOf(userMapper.insertUser(user));
    }

    @Override
    public int addMulTea(HttpServletRequest request) throws IOException {
        int result =0;
        List<FileItem> fileItems = UploadUtil.getUploadFileStream(request);
        List<User> teachers = null;
        for(FileItem fileItem : fileItems){
            if(!fileItem.isFormField()){
                InputStream in = fileItem.getInputStream();
                List<Dept> depts = new ArrayList<Dept>();
                teachers = XslResolveUtil.getTeachersFromXSL(in,depts);
                //数据库插入出错的话没处理，会全部插入失败
                result = userMapper.insertUsers(teachers);
                for (User teacher : teachers){
                    System.out.println(teacher.getAge());
                }
            }
        }
        return result;
    }

    @Override
    public List<Dept> selectAllDept() {
        List<Dept> deptList = deptMapper.selectAllDept();
        return deptList;
    }


}
