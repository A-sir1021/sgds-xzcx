package com.example.test.config.Annotate;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Documented
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface RequestLimit {
    /**
     * 允许访问的最大次数 Integer.MAX_VALUE
     */
    int count() default 2;

    /**
     * 时间段，单位为毫秒，默认值san分钟
     */
    long time() default 60000*3;
}
