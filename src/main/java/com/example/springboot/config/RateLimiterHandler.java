package com.example.springboot.config;

import com.example.springboot.utils.RateLimiter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Aspect
@Component
public class RateLimiterHandler {

    @Resource
    private RateLimiter rateLimiter;

    @Pointcut("@annotation(com.example.springboot.annotation.RateLimiter)")
    public void limiterPointCut(){
        
    }

    /**
     * 判断访问量是否在10qps以下。
     * @param point
     * @throws Throwable
     */
    @Around("limiterPointCut()")
    public void RateLimiterHandler(ProceedingJoinPoint point) throws Throwable {
        boolean flag = rateLimiter.acquire();
        Object[] objects;
        if(flag){
            objects = new Object[]{true};
        }else {
            objects = new Object[]{false};
        }
        point.proceed(objects);
    }
}
