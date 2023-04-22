package com.red.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * 自定义类实现用户详情服务接口,替换默认的实现
 */
@Configuration
public class MySecurityUserConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(User.builder().username("admin").password("{noop}admin").roles("admin").build());
        manager.createUser(User.builder().username("teacher").password("{noop}teacher").roles("teacher").build());
        manager.createUser(User.builder().username("student").password("{noop}student").roles("student").build());
        return manager;

    }
}
