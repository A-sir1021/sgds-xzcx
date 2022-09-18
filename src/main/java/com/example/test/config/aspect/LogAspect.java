package com.example.test.config.aspect;


import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
//申明是个spring管理的bean
@Component
public class LogAspect {

    Logger log = LoggerFactory.getLogger(LogAspect.class);
    private final Gson gson = new Gson();
    //申明一个切点 里面是 execution表达式
    @Pointcut("execution(* com.example.test.controller..*.*(..))")
    private void controllerAspect(){}
    //请求method前打印内容
    @Before(value = "controllerAspect()")
    public void methodBefore(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //打印请求内容
        //log.warn("===============请求内容开始===============");
        //log.warn("请求地址:"+request.getRequestURL().toString() + ":"+request.getMethod());
        //log.warn("请求类方法:"+joinPoint.getSignature());
       // log.warn("请求类方法参数:"+ Arrays.toString(joinPoint.getArgs()));
        //log.warn("===============请求内容结束===============");
    }
    //在方法执行完结后打印返回内容
   // @AfterReturning(returning = "o",pointcut = "controllerAspect()")
   // public void methodAfterReturing(Object o ){
    //    log.info("返回Response内容:"+gson.toJson(o));
   // }
}
