
package com.example.test.controller;

import com.example.Commen.MsgUtil.CodeMsg;
import com.example.test.pojo.MsgVehicle;
import com.example.test.pojo.Salary;
import com.example.test.service.IEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Templates;


@Controller
@RequestMapping("/main")
public class UploadController {

    @Resource
    IEmailService emailService;
    @Resource
    TemplateEngine templateEngine;
    @Resource
    Salary salary;
    @Resource
    MsgVehicle msgVehicle;
    public String UploadByName(Model model, HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        //创建邮件正文
        Context context = new Context();
        templateEngine = new TemplateEngine();
        msgVehicle = new MsgVehicle();
        msgVehicle.setSucc(CodeMsg.SEND_SUNCC.getMsg());
        salary.setSalaBenfit("123123");
        salary.setSalaBz("3242424");

        context.setVariable("salary",salary);
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("/main/email", context);

        emailService.sendHtmlMail("3426564320@qq.com","主题：这是模板邮件",emailContent);

        return "main/home::salarly_refresh";
    }

/*
通过Ajax定时轮循的方式获取会话中的进度值，并展示在页面中；

public class UploadProgressListener implements ProgressListener {

    public void update(long pBytesRead, long pContentLength, int pItems) {
        if (pContentLength == 0) {
            return;
        }
        // 计算上传进度百分比
        double percent = (double) pBytesRead / (double) pContentLength;
        // 将百分比存储在用户会话中
        WebContext.getContext().getSession().put("upload_progress", percent);
    }
}*/
}
