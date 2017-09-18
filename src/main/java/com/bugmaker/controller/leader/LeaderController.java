package com.bugmaker.controller.leader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wurenjie on 2017/9/12.
 */
@Controller
@RequestMapping("/leader")
public class LeaderController {
    @RequestMapping("index.do")
    public String indexView(){
        return "leader/index";
    }
    /**
     * 系领导管理顶岗项目页面
     * @return
     */
	@RequestMapping("internshipCRUD.do")
	public String teacherRU(){
		return "leader/internshipCRUD";
	}
	 /**
     * 添加顶岗页面
     * @return
     */
	@RequestMapping("addInternship.do")
	public String addInternship(){
		return "leader/addInternship";
	}
}
