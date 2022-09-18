package com.example.test.config.aspect;

import com.example.Commen.Util.MachineIp;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
@Aspect
@Component
@Slf4j
public class IpAspect {
    Logger log = LoggerFactory.getLogger(IpAspect.class);


    @Pointcut("execution(public * com.example.test.controller..*.*(..))")
    public void cut_ip() {}

    @Before("cut_ip()")
    public void doVerify_ip() throws Exception {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
    }

}
