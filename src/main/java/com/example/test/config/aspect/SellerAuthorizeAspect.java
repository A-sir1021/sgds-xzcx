package com.example.test.config.aspect;

import com.example.Commen.Constant.Constant;
import com.example.Commen.CookieUtil.CookieUtil;
import com.example.Commen.MsgUtil.CodeMsg;
import com.example.Commen.Util.DateUtil;
import com.example.Commen.Util.MachineIp;
import com.example.test.controller.Error.SellerAuthorizeException;
import com.example.test.pojo.MsgVehicle;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

import static com.example.Commen.Util.DateUtil.local_time;

@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Resource
    MsgVehicle msgVehicle;
    Logger log = LoggerFactory.getLogger(SellerAuthorizeAspect.class);



    //自动注入redisTemplate操作redis
    //@Autowired
   // private StringRedisTemplate redisTemplate;
    //定义一个切面,注意这里将卖家端中用户操作这块的排除了,因为这里包含用户登陆登出,不需要校验.
    @Pointcut("execution(public * com.example.test.controller..*.*(..))" +
            "&& !execution(public * com.example.test.controller.RoleLoginController.*(..))" +
            "&& !execution(public * com.example.test.controller.IndexController.*(..))" +
            "&& !execution(public * com.example.test.controller.Error..*.*(..))")
    public void verify() {}


    @Before("verify()")
    public void doVerify() throws Exception {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        //获取request
        //查询cookie,使用封装好的工具类
        Cookie cookie = CookieUtil.getCookie(request, Constant.TOKEN_ROLE);
        Cookie cookie1 = CookieUtil.getCookie(request, Constant.TOKEN_ROLE_Phone);
        log.warn("【登录校验】"+cookie+"  "+cookie1+"  ");
        if (StringUtils.isEmpty(cookie) && StringUtils.isEmpty(cookie1)) {
            //若为空说明没登陆
            throw new SellerAuthorizeException("【登录校验】Cookie中查不到token,请·重新·登录");

        } else {
            if (!CookieUtil.ExpiCookie(request,Constant.TOKEN_ROLE_TIME)){
              //  todo
                System.out.println(CookieUtil.getCookie(request,"time").getName()+">>>>>>>>>>"+local_time());
                throw new SellerAuthorizeException("会话过期+");

            } else{

            }

        }

        //去redis里查询
        /*String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("【登录校验】Redis中查不到token");
            throw new SellerAuthorizeException();
        }*/
    }

}
