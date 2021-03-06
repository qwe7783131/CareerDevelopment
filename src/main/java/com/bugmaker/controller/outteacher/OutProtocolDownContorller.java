package com.bugmaker.controller.outteacher;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Internship;
import com.bugmaker.bean.Protocol;
import com.bugmaker.bean.Student;
import com.bugmaker.constant.ProtocolConstant;
import com.bugmaker.service.ProtocolService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by NY on 2017/9/30.
 */

@Controller
@RequestMapping("/outteacher")
public class OutProtocolDownContorller {
	
	@Resource
    private ProtocolService protocolService;
	
	
	/**
	 * 跳转到查询所有存档资料页面
	 */
	@RequestMapping("todoOutcumentDownload.do")
	public ModelAndView documentDownload(@RequestParam(defaultValue="1") String currentPage) { 
		Student student = new Student();
		int nowPage = Integer.valueOf(currentPage);
		PageHelper.startPage(nowPage, 5);
		List<Protocol> protocols = protocolService.getProtocolByParam(ProtocolConstant.OUTJOB,student);
		
		/*for (Protocol protocol : protocols) {
			System.out.println(protocol);
		}*/
		PageInfo<Protocol> page = new PageInfo<>(protocols);
		ModelAndView modelAndView =  new ModelAndView();
	    //modelAndView.addObject("protocols",protocols);
	    modelAndView.addObject("page",page);
		modelAndView.setViewName("outteacher/documentDownload");
		return modelAndView; 
		}
	@RequestMapping("toggdocumentDownload.do")
	public ModelAndView ggdocumentDownload(@RequestParam(defaultValue="1") String currentPage) { 
		Student student = new Student();
		int nowPage = Integer.valueOf(currentPage);
		PageHelper.startPage(nowPage, 5);
		List<Protocol> protocols = protocolService.getProtocolByParam(ProtocolConstant.ONJOB,student);
		
		/*for (Protocol protocol : protocols) {
			System.out.println(protocol);
		}*/
		PageInfo<Protocol> page = new PageInfo<>(protocols);
		ModelAndView modelAndView =  new ModelAndView();
	    //modelAndView.addObject("protocols",protocols);
	    modelAndView.addObject("page",page);
		modelAndView.setViewName("outteacher/ggdocumentDownload");
		return modelAndView; 
		}
	
	

}
