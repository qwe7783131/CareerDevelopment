package com.bugmaker.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.bugmaker.bean.Score;

public interface ScoreExportService {
	
	//导出学生成绩
	public HSSFWorkbook export(List<Score> score);

}
