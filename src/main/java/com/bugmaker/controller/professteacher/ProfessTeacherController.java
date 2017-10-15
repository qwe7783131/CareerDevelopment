package com.bugmaker.controller.professteacher;

import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bugmaker.bean.Score;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;
import com.bugmaker.constant.ProtocolConstant;
import com.bugmaker.service.GScoreExportService;
import com.bugmaker.service.ScoreExportService;
import com.bugmaker.service.TeacherScoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by wurenjie on 2017/9/12.
 */
@Controller
@RequestMapping("/professteacher")
public class ProfessTeacherController {
	
	@Resource
	public TeacherScoreService teacherScoreService;
	@Resource
	public ScoreExportService scoreExportService;
	@Resource
	public GScoreExportService gscoreExportService;
	
	
    @RequestMapping("index.do")
    public String indexView(){
        return "professteacher/index";
    }
    
    //顶岗
    @RequestMapping("selectScroeTeac.do")
    public String selectScroeTeacView(Model model,
			@RequestParam(defaultValue="1") String currentPage){
    	Student student =new Student();
    	Integer currPage = Integer.valueOf(currentPage);
		PageHelper.startPage(currPage, 5);		
		List<Score> ins = teacherScoreService.selectScoreByParam(ProtocolConstant.OUTJOB,student);
		PageInfo page = new PageInfo(ins, 5);
		page.getNavigatePages();
		model.addAttribute("page",page);
        return "professteacher/selectScroePro";
    }
    @RequestMapping("getScoreByName.do")
    public String getScoreByName(Model model,String name){
    	Student student =new Student();
    	User user = new User();
    	user.setUsername(name);
    	student.setUser(user);
			
		List<Score> scores = teacherScoreService.selectScoreByParam(ProtocolConstant.OUTJOB,student);
		
		model.addAttribute("scores",scores);
        return "professteacher/selectScroePro";
    }
    @RequestMapping("scoreExcel.do")
    public void scoreExcel(HttpServletRequest request, HttpServletResponse response)throws Exception{
       
    	Student student =new Student();
		List<Score> scores = teacherScoreService.selectScoreByParam(ProtocolConstant.OUTJOB,student); 
        HSSFWorkbook wb = scoreExportService.export(scores);    
        response.setContentType("application/vnd.ms-excel");    
        response.setHeader("Content-disposition", "attachment;filename=studentpro.xls");    
        OutputStream ouputStream = response.getOutputStream();    
        wb.write(ouputStream);    
        ouputStream.flush();    
        ouputStream.close();  
    	
    }
    
    //跟岗
    @RequestMapping("selectggScroeTeac.do")
    public String selectggScroeTeacView(Model model,
			@RequestParam(defaultValue="1") String currentPage){
    	Student student =new Student();
    	Integer currPage = Integer.valueOf(currentPage);
		PageHelper.startPage(currPage, 5);		
		List<Score> ins = teacherScoreService.selectScoreByParam(ProtocolConstant.ONJOB,student);
		PageInfo page = new PageInfo(ins, 5);
		page.getNavigatePages();
		model.addAttribute("page",page);
        return "professteacher/selectggScroePro";
    }
    @RequestMapping("getggScoreByName.do")
    public String getggScoreByName(Model model,String name){
    	Student student =new Student();
    	User user = new User();
    	user.setUsername(name);
    	student.setUser(user);
			
		List<Score> scores = teacherScoreService.selectScoreByParam(ProtocolConstant.ONJOB,student);
		
		model.addAttribute("scores",scores);
        return "professteacher/selectggScroePro";
    }
    @RequestMapping("ggscoreExcel.do")
    public void ggscoreExcel(HttpServletRequest request, HttpServletResponse response)throws Exception{
       
    	Student student =new Student();
    	List<Score> ins = teacherScoreService.selectScoreByParam(ProtocolConstant.ONJOB,student); 
        System.out.println(ins);
    	HSSFWorkbook wb = gscoreExportService.export(ins);    
        response.setContentType("application/vnd.ms-excel");    
        response.setHeader("Content-disposition", "attachment;filename=studentscorepro.xls");    
        OutputStream ouputStream = response.getOutputStream();    
        wb.write(ouputStream);    
        ouputStream.flush();    
        ouputStream.close();  
    	
    }
}
