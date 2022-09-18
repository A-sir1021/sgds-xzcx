package com.example.test.config.Annotate.Interceptor;

import com.example.Commen.Util.MachineIp;
import com.example.test.config.Annotate.RequestLimit;
import com.example.test.controller.Error.RequestLimitException;
import com.example.test.pojo.CacheData.CacheData;
import com.example.test.pojo.CacheData.CacheOperation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;
//import net.sf.ehcache.CacheManager; //导入方法依赖的package包/类

@Aspect
@Component
public class RequestLimitInterceptor {
    CacheData cacheData;
    CacheOperation instance ;
    Logger log =LoggerFactory.getLogger(RequestLimitInterceptor.class);
    //@javax.ws.rs.Path *
    @Before("within(@org.springframework.web.bind.annotation.RequestMapping * ) && @annotation(limit)")
    public void requestLimit(final JoinPoint joinPoint, RequestLimit limit) throws RequestLimitException {
        try {
            instance = CacheOperation.getInstance();
            // 获取 HttpServletRequest
            Object[] args = joinPoint.getArgs();
            HttpServletRequest request = null;
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof HttpServletRequest) {
                    request = (HttpServletRequest) args[i];
                    break;
                }
            }
            if (request == null) {
                throw new RequestLimitException("调用方法中缺少HttpServletRequest参数");
            }

            String ip = MachineIp.getIpAddr(request);
            String url = request.getRequestURL().toString();
            String key = "req_".concat(url).concat(ip);
            log.warn(url+"  "+ip);
            cacheData = (CacheData) instance.getKeyCache(key);
            if (null == cacheData) {
                instance.addCacheData(key,cacheData);
                //TimeUnit.MILLISECONDS)
            } else {
                //已经访问了次数
                Object cacheData1 = instance.getCacheData(key,cacheData, limit.time(), limit.count());
                if(cacheData1 == null){
                    log.info("用户IP[{}], 访问地址[{}], 超过了限定的次数[{}]", ip, url, limit.count());
                    throw new RequestLimitException();
                }
            }

        } catch (RequestLimitException e) {
            throw e;
        } catch (Exception e) {
            log.error("发生异常", e);
        }
    }

}

