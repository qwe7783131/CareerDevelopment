package com.bugmaker.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;


public interface DormitoryServiceAdmin {
    public ModelAndView toDormitoryManage(String curr);

    public ModelAndView toAddDormitory();

    public int addDormitory(String dormitoryString) throws IOException;

    public ModelAndView toModifyDormitory(String id,String companyName,String total,String personNum);

    public int modifyDormitory(String dormitoryString) throws IOException;

    public int deleteDormitory(String id);

    public ModelAndView getDormByCompany(String company,String curr);
}
