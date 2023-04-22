package com.red.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@Slf4j
public class CurrentLoginUserController {


    @GetMapping("/getLoginUser1")
    public Authentication getLoginUser1(Authentication authentication) {
        return authentication;
    }

    @GetMapping("/getLoginUser2")
    public Principal getLoginUser2(Principal principal) {
        return principal;
    }

    @GetMapping("/getLoginUser3")
    public Principal getLoginUser3() {
        SecurityContext context = SecurityContextHolder.getContext();
        return context.getAuthentication();
    }
}
