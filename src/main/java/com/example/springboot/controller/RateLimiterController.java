package com.example.springboot.controller;

import com.example.springboot.annotation.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("limiter")
@Slf4j
public class RateLimiterController {

    @GetMapping("sale")
    @RateLimiter
    public String sale(boolean flag){
        if(flag){
            System.out.println("success");
            return "success";
        }else {
            System.out.println("throttle");
            return "throttle";
        }
    }
}
