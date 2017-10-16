package com.bugmaker.service.impl;

import com.bugmaker.bean.*;
import com.bugmaker.mapper.StuLogMapper;
import com.bugmaker.mapper.SurveyMapper;
import com.bugmaker.service.StuLogService;
import com.bugmaker.service.SurveyService;
import com.bugmaker.utils.RequestUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    SurveyMapper surveyMapper;



    /**
     * 导出调查结果数据
     */
    public void dataExcel(HttpServletRequest request, HttpServletResponse response, String surveyId)throws Exception {
        List<SurveyResult> surveyResults = surveyMapper.selectSurveyResyltById(surveyId);
        HSSFWorkbook wb = surveyData(surveyResults);
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=surveyResult.xls");
        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
    }

    public HSSFWorkbook surveyData(List<SurveyResult> surveyResults) {
        String[] excelHeader = { "学生姓名", "性别","学院","联系方式","单位","单位联系人","单位电话","填表时间"};
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("surveyResults");
        HSSFRow row = sheet.createRow((int) 0);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        for (int i = 0; i < excelHeader.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(excelHeader[i]);
            cell.setCellStyle(style);
            sheet.autoSizeColumn(i);
        }

        for (int i = 0; i < surveyResults.size(); i++) {
            row = sheet.createRow(i + 1);
            SurveyResult surveyResult = surveyResults.get(i);
            row.createCell(0).setCellValue(surveyResult.getStudent().getUser().getUsername());
            row.createCell(1).setCellValue(surveyResult.getStudent().getUser().getSex());
            row.createCell(2).setCellValue(surveyResult.getStudent().getUser().getDept().getDeptName());
            row.createCell(3).setCellValue(surveyResult.getStudent().getUser().getPhone());
            row.createCell(4).setCellValue(surveyResult.getUnitName());
            row.createCell(5).setCellValue(surveyResult.getUnitPerson());
            row.createCell(6).setCellValue(surveyResult.getUnitPhone());
            row.createCell(7).setCellValue(surveyResult.getCreateTime());


        }
        return wb;
    }

    /**
     * 根据调查表id获取对应的调查表的结果
     * @param curr
     * @return
     */
    public ModelAndView selectSurveyResyltById(String surveyId,String curr) {
        int nowPage = Integer.valueOf(curr);
        ModelAndView modelAndView = new ModelAndView();
        User user = RequestUtil.getCurrentUser();
        PageHelper.startPage(nowPage, 5);
        List<SurveyResult> surveyResults = surveyMapper.selectSurveyResyltById(surveyId);
        PageInfo<SurveyResult> page = new PageInfo<>(surveyResults);
        modelAndView.addObject("surveyId",surveyId);
        modelAndView.addObject("page",page);
        modelAndView.setViewName("leader/surveyResult");
        return modelAndView;
    }

    /**
     *  通过当前用户获取学院，在通过学院获取所有的调查表
     * @return
     */
    public ModelAndView selectAllSurveyByDeptId(String curr) {
        int nowPage = Integer.valueOf(curr);
        ModelAndView modelAndView = new ModelAndView();
        User user = RequestUtil.getCurrentUser();
        PageHelper.startPage(nowPage, 5);
        List<Survey> surveys = surveyMapper.selectAllSurveyByDeptId(user.getDept().getId());
        PageInfo<Survey> page = new PageInfo<>(surveys);
//        System.out.println(page);
        modelAndView.addObject("page",page);
        modelAndView.setViewName("leader/survey");
        return modelAndView;
    }

    /**
     * 添加调查表
     * @return
     */
    public int addSurvey() {
        User user = RequestUtil.getCurrentUser();
        return surveyMapper.addSurvey(user.getDept().getId(), new Date());
    }

    /**
     * 设置调查表为共私有
     * @param surveyid
     * @param status
     * @return
     */
    public int surveyStatus(String surveyid, String status) {
        return surveyMapper.surveyStatus(surveyid,Integer.valueOf(status));
    }

    /**
     * 设置调查表结束，发布
     * @param surveyid
     * @param enable
     * @return
     */
    public int surveyEnable(String surveyid, String enable) {
        return surveyMapper.surveyEnable(surveyid,Integer.valueOf(enable));
    }
}
