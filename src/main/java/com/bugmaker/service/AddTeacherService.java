package com.bugmaker.service;

import com.bugmaker.bean.User;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface AddTeacherService {
    String addOneTea(User user);

    int addMulTea(HttpServletRequest request) throws IOException;

}
