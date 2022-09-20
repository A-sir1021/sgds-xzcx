package com.example.test.controller;


import com.example.Commen.Constant.Constant;
import com.example.Commen.CookieUtil.CookieUtil;
import com.example.Commen.MsgUtil.CodeMsg;
import com.example.test.config.Annotate.RequestLimit;
import com.example.test.pojo.MsgVehicle;
import com.example.test.pojo.Role;
import com.example.test.pojo.Salary;
import com.example.test.service.IEmailService;
import com.example.test.service.SalaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.StringWriter;

@Controller
@RequestMapping("/main")
public class MainController {

    @Resource
    MsgVehicle msgVehicle;
    @Resource
    Role role;

    Role role1;

    @Resource
    SalaryService salaryService;
    @Resource
    Salary salary;

    Salary salary1;

    ModelAndView model;

    @Autowired
    TemplateEngine templateEngine;

    @Resource
    IEmailService emailService;
    Cookie cookie;
    @Value("${sendform.msg}")
    private String msg;

    ClassLoaderTemplateResolver resolver;


    //获取对象
    String strBean ="";
    Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping({"/","/home",""})
    public String index(ModelAndView model, Role role, MsgVehicle msgVehicle1,HttpServletRequest request){
        model = new ModelAndView();
        model.addObject("fail",msgVehicle.getFail());
        model.addObject("role",msgVehicle);
        role1 = null;
        salary1 = null;
        return "main/home";
    }

    @PostMapping({"/","/home",""})
    public String index_post(ModelAndView model, Role role, MsgVehicle msgVehicle,HttpServletRequest request){
       return "redirect:/main/";
    }

    @PostMapping("/queryPerson")
    @RequestLimit(time = 1000*60,count = 10)
    public String queryPerson(@RequestBody(required = true) @RequestParam("salary") String phone1, Model model,
                              HttpServletRequest request, HttpServletResponse response, RedirectAttributes ra) throws Exception {
        msgVehicle = new MsgVehicle();
        msgVehicle.setFail(CodeMsg.DEFULT.getMsg());
        model.addAttribute("msgVehicle",msgVehicle);

        if(role1 == null){
            role = getEntry(request);
        }
        logger.warn(role+"\n\t"+role1);
        //比对不一致
        if(role == null || !role.getRolePhone().equals(phone1)){
            msgVehicle.setFail(CodeMsg.USER_ERROR.getMsg());
            //ra.addFlashAttribute("msgVehicle",msgVehicle);
            CookieUtil.delCookieArgs(request,response);
            model.addAttribute("msgVehicle",msgVehicle);
            //主页面
            return "redirect:/role";
        }
        logger.info("cookie_phone:"+phone1+">>>role_phone:"+role.getRolePhone()+"  ");
        if(salary1 != null){
        } else {
            salary = getSalary(role.getRolePhone());
        }

        if(salary  == null){
            msgVehicle.setFail(CodeMsg.SALA_ERROR.getMsg());
            model.addAttribute("msgVehicle",msgVehicle);
            return "main/home::salarly_refresh";
        }
        String pho = phone1;
        //role.setRolePhone("**"+phone1.substring(phone1.length()-4,phone1.length()));
        model.addAttribute("role",role);
        //role1.setRolePhone(pho);
        model.addAttribute("salary",salary);
        return "main/home::salarly_refresh";
    }


    @GetMapping("upload")
    public String upload(){
        return "upload/upload";
    }


    @RequestLimit(time = 60000,count = 1)
    @GetMapping("/sendEmail")
    public String sendEmail(Model model,HttpServletRequest request) throws MessagingException {
        msgVehicle = new MsgVehicle();
        msgVehicle.setFail(CodeMsg.DEFULT.getMsg());
        Context context = new Context();
        if(salary1== null){
            try {
                if(role1 != null){
                } else {
                    role = getEntry(request);
                }
                salary = getSalary(role.getRolePhone());
            } catch (Exception e){
                msgVehicle.setFail(CodeMsg.SEND_FAIL.getMsg());
                return "main/home::salarly_refresh";
            }
        }

        StringWriter emailContent = new StringWriter();
        context.setVariable("salary",salary);
        context.setVariable("role",role);

        try{
            templateEngine.process("/main/email", context,emailContent);
            logger.warn(emailContent.toString());
            emailService.sendHtmlMail(role.getRoleEmail(),msg,emailContent.toString());
            msgVehicle = new MsgVehicle();
            msgVehicle.setSucc(CodeMsg.SEND_SUNCC.getMsg());
            model.addAttribute("msgVehicle",msgVehicle);

        } catch (Exception e){
            logger.warn(String.valueOf(e));
            msgVehicle.setSucc(null);
            msgVehicle.setFail(CodeMsg.SEND_FAIL.getMsg());
            model.addAttribute("msgVehicle",msgVehicle);
        }

        return "/main/home::salarly_refresh";

        // 图片占位写法  如果图片链接写入模板 注释下面这一行
        // helper.addInline("qr",new FileSystemResource(filePath))
       /* try {
            emailService.sendSimpleMail("3426564320@qq.com","工资查询详情","这是详情的content");
            logger.warn(">>>日志发送");
            return CodeMsg.SUCCESS.getCode();
        } catch (Exception e){
            logger.warn(">发送失败");
        }
        return CodeMsg.EMAIL_FAIL.getCode();*/
    }

    @GetMapping("/Msg")
    public MsgVehicle RetuMsg(MsgVehicle msgVehicle, RedirectAttributes ra){
        model = new ModelAndView();
        ra.addFlashAttribute(Constant.TOKEN_ROLE,msgVehicle);
        ra.addFlashAttribute(CodeMsg.USER_ERROR.getCode(),msgVehicle);
        return msgVehicle;
    }


    private Role getEntry(HttpServletRequest request){
        try {
            cookie = CookieUtil.getCookie(request, Constant.TOKEN_ROLE_BEAN);
            strBean = cookie.getValue();
            role1 = CookieUtil.JsonValue(strBean,Role.class);
            logger.info(role1.toString());
        } catch (Exception e) {
            role1 = null;
        }
        return role1;
    }


    private Salary getSalary(String phone1){
        salary1 = salaryService.querySalary(phone1);
        return salary1;
    }


}
