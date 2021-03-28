package com.example.springboot.utils;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class RateLimiter {

    //桶最大容量(默认)
    private final static int maxCapacity = 10;
    //当前容量
    public static AtomicInteger token;

    static {
        token = new AtomicInteger(maxCapacity);
    }

    /**
     * 获取一个令牌,剩余容量减一
     */
    public boolean acquire(){
        if(token.getAndDecrement()>0){
            return true;
        }else {
            return false;
        }
    }
}
