package com.example.test.controller.Error;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@ResponseStatus(HttpStatus.FORBIDDEN)
public class errorHandler {

    @RequestMapping(value = {"/login/error","error/500"})
    public ModelAndView loginError(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        AuthenticationException exception =
                (AuthenticationException)request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        String message = exception.getMessage();
        if (message ==null){
        } else {

            System.out.println(message);

            try {
                String[] split = exception.toString().split(":");
                if (message.contains("Bad credentials")){
                    message= split[0]+">>错误提示:密码/账号输入错误/权限不足";
                }
                System.out.println(message+"message<<<<<<<<<<<<<<"+exception.toString());
                response.getWriter().write(message);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(response.getStatus()+">>>>>>>>");

       while (request.getSession().getAttributeNames().hasMoreElements()){
           System.out.println(request.getSession().getAttributeNames().nextElement());
       }


        ModelAndView andView = new ModelAndView();
        andView.setViewName("error/error");
        return andView;
    }


    /*@Component
public class SomeExceptionErrorViewResolver implements ErrorViewResolver {
  @Override
  public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map model) {
    return new ModelAndView("custom-error-view-resolver/some-ex-error", model);
  }*/
}
