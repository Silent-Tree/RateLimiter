package com.example.springboot.scheduler;

import com.example.springboot.utils.RateLimiter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class LimitScheduler {

    //每秒增量,保证令牌数为10.模拟不断往令牌桶中添加令牌
    @Scheduled(cron = "0/1 * * * * ?")
    public void increase(){
        RateLimiter.token = new AtomicInteger(10);
    }
}
