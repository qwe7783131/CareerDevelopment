package com.bugmaker.controller.leader;

import com.bugmaker.constant.ProtocolConstant;
import com.bugmaker.service.VolunteerCheckService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by guan on 2017/9/27.
 */
@Controller
@RequestMapping("/leader")
public class VolunteerCheckController {

    @Resource
    private VolunteerCheckService volunteerCheckService;

    @ResponseBody
    @RequestMapping("modifyAllInsVolunteerStatus.do")
    public String modifyAllInsVolunteerStatus(@RequestParam("type") int type,@RequestParam("status") int status) {
        return ""+volunteerCheckService.modifyAllInsVolunteerStatus(type,status);
    }


    /**
     * 根据id改变状态，所以不需要跟岗顶岗的type
     * @param insVolunteerId
     * @param status
     * @return
     */
    @ResponseBody
    @RequestMapping("modifyInsVolunteerStatus.do")
    public String  modifyInsVolunteerStatus(@RequestParam("insVolunteerId") String insVolunteerId, @RequestParam("status") int status) {
//        System.out.println(insVolunteerId+"  "+status);
        return ""+volunteerCheckService.modifyInsVolunteerStatus(insVolunteerId,status);
    }

    @RequestMapping("toVolunteerCheckPage.do")
    public ModelAndView toVolunteerCheckPage(@RequestParam(defaultValue = "") String professClassId,@RequestParam(defaultValue = "")String internshipId,@RequestParam(defaultValue = "1") String curr,@RequestParam(defaultValue = "2")String statusId) {
        ModelAndView modelAndView = volunteerCheckService.toVolunteerCheckPage(ProtocolConstant.OUTJOB, professClassId, internshipId, curr, statusId);
        modelAndView.setViewName("leader/volunteerCheck");
        return modelAndView;
    }

    @RequestMapping("toFollowVolunteerCheckPage.do")
    public ModelAndView toFollowVolunteerCheckPage(@RequestParam(defaultValue = "") String professClassId,@RequestParam(defaultValue = "")String internshipId,@RequestParam(defaultValue = "1") String curr,@RequestParam(defaultValue = "2")String statusId) {
        ModelAndView modelAndView = volunteerCheckService.toVolunteerCheckPage(ProtocolConstant.ONJOB, professClassId, internshipId, curr, statusId);
        modelAndView.setViewName("leader/followVolunteerCheck");
        return modelAndView;
    }
}
