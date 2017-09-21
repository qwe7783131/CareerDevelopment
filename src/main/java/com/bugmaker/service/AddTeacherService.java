package com.bugmaker.service;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.User;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface AddTeacherService {
    String addOneTea(User user);

    int addMulTea(HttpServletRequest request) throws IOException;

    List<Dept> selectAllDept();
}
