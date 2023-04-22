package com.example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello spring security");
        // 1.获取认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        System.out.println("身份信息:" + user.getUsername());
        System.out.println("权限信息:" + authentication.getAuthorities());
        System.out.println("详细信息:" + authentication.getDetails());
        System.out.println("是否认证:" + authentication.isAuthenticated());
        
        return "hello spring security";
    }
}
