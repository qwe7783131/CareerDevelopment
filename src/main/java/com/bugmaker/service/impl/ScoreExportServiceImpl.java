package com.bugmaker.service.impl;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.bugmaker.bean.Score;
import com.bugmaker.service.ScoreExportService;

@Service
public class ScoreExportServiceImpl implements ScoreExportService{

	@Override
	public HSSFWorkbook export(List<Score> score) {
		String[] excelHeader = { "学生姓名", "成绩"}; 
		HSSFWorkbook wb = new HSSFWorkbook();    
        HSSFSheet sheet = wb.createSheet("scores");    
        HSSFRow row = sheet.createRow((int) 0);    
        HSSFCellStyle style = wb.createCellStyle();    
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);    
    
        for (int i = 0; i < excelHeader.length; i++) {    
            HSSFCell cell = row.createCell(i);    
            cell.setCellValue(excelHeader[i]);    
            cell.setCellStyle(style);    
            sheet.autoSizeColumn(i);    
        }    
    
        for (int i = 0; i < score.size(); i++) {    
            row = sheet.createRow(i + 1);    
            Score sc = score.get(i);    
            row.createCell(0).setCellValue(sc.getStudent().getUser().getUsername());    
            row.createCell(1).setCellValue(sc.getTeacScore());    
               
        }    
        return wb;    
	}

}
