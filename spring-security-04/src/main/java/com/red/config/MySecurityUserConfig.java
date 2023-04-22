package com.red.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * 自定义类实现用户详情服务接口,替换默认的实现
 */
@Configuration
public class MySecurityUserConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("admin")   // 角色
                .authorities("teacher:add", "teacher:delete", "student:delete", "student:add")   // 权限在角色后则权限生效
                .build());
        manager.createUser(User.builder()
                .username("teacher")
                .password(passwordEncoder().encode("teacher"))
                .authorities("student:delete", "student:add")
                .roles("teacher")   // 角色在权限后则角色生效为权限:ROLE_teacher
                .build());
        manager.createUser(User.builder()
                .username("student")
                .password(passwordEncoder().encode("student"))
                // .roles("student")
                .authorities("student:query")// 角色和权限必须配置其中一个
                .build());
        return manager;

    }

    /**
     * 自定义密码加密器
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
