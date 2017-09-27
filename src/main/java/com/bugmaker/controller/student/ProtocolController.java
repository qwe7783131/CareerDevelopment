package com.bugmaker.controller.student;

import com.bugmaker.bean.Protocol;

import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;
import com.bugmaker.constant.ProtocolConstant;

import com.bugmaker.service.ProtocolService;
import com.bugmaker.utils.SaveFileUtil;
import com.bugmaker.utils.UploadUtil;
import org.apache.commons.fileupload.FileItem;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("student")
public class ProtocolController {

    @Resource
    private ProtocolService protocolService;
    /**
     * 学生顶岗文档上传
     * @return
     */
    @RequestMapping("documentPostjobUpload.do")
    public ModelAndView documentUpload(HttpServletRequest request, Model model){
        // 从session取出student的学号
        String stuId = "201424133209";
        Protocol protocol = protocolService.getOneByStuId(ProtocolConstant.OUTJOB, stuId);
        //将学生对应的文档id存入session
        HttpSession session = request.getSession();
        session.setAttribute("protocolId", protocol.getId());
        System.out.println("pro" + protocol);
        model.addAttribute("protocol", protocol);
        return new ModelAndView("student/documentPostjobUpload", "map", model);
    }

    @RequestMapping(value = "uploadProtocol.do", method = RequestMethod.POST)
    @ResponseBody
    public boolean addStudentProtocol(HttpServletRequest request) throws IOException{
        List<FileItem> fileItems = UploadUtil.getUploadFileStream(request);
        InputStream in = null;
        Protocol protocol = new Protocol();
        int result = 0;
        int jobType = -1, docType = -1;
        for(FileItem fileItem : fileItems){
            if(!fileItem.isFormField()){
                in = fileItem.getInputStream();


            }else {
                // 取到岗位类型，文档类型，学号

                String fieldName = fileItem.getFieldName();
                String value = fileItem.getString();
                System.out.println(fieldName + "" +value);
                if (fieldName != null && value != null){
                    if (fieldName.equals("jobType")){
                        jobType = Integer.parseInt(value);
                    }else if (fieldName.equals("docType")){
                        docType = Integer.parseInt(value);
                    }
                }

            }
//            System.out.println(fileItem.ge);
        }

        // 从session取出student的学号
        String stuId = "201424133209";
        User user = new User();
        user.setId(stuId);
        Student student = new Student();
        student.setUser(user);
        protocol.setStudent(student);

        // 获得项目的路径
        ServletContext sc = request.getSession().getServletContext();
        // 上传位置
        String path = sc.getRealPath("/protocol") + "/"; // 设定文件保存的目录
        String proId = UUID.randomUUID().toString().replace("-","");
        String newFileName = stuId + proId + ".xls";

        boolean flag = SaveFileUtil.saveFile(path, newFileName, in);
        if (flag){
            HttpSession session = request.getSession();
            protocol.setId(session.getAttribute("protocolId").toString());
            String finalFileName = "/protocol/" + newFileName;
            switch (jobType){
                case ProtocolConstant.ONJOB: protocol.setType("跟岗");break;
                case ProtocolConstant.OUTJOB: protocol.setType("顶岗");break;
            }
            switch (docType){
                case ProtocolConstant.SAFEPROTOCAL: protocol.setSafeProtocal(finalFileName);break;
                case ProtocolConstant.ACCEPTPROVE:  protocol.setAcceptProve(finalFileName);break;
                case ProtocolConstant.INTERNSHIPASSESS: protocol.setInternshipAssess(finalFileName);break;
                case ProtocolConstant.INTERNSHIPRECORD: protocol.setInternshipRecord(finalFileName);break;
                case ProtocolConstant.INTERSHIPAPPLICATION: protocol.setInternshipApplication(finalFileName);break;
                case ProtocolConstant.REPORT: protocol.setReport(finalFileName);break;
            }
            System.out.println(protocol);
            return protocolService.setProtocolFileUrl(protocol);
        }
        else{
            return true;
        }

    }
}
