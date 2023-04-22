package com.red.config;

import cn.hutool.core.lang.Dict;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 使用了UserDetailsServiceImpl实现了UserDetailsService并注入到Spring容器中
    /*@Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        userDetailsManager
                .createUser(User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("123456"))
                        .roles("admin")
                        .build());

        userDetailsManager
                .createUser(User.builder()
                        .username("teacher")
                        .password(passwordEncoder().encode("123456"))
                        .roles("teacher")
                        .build());

        return userDetailsManager;
    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // // 任何请求均需要认证
        // http.authorizeRequests().anyRequest().authenticated();

        http.formLogin()
                .successHandler(((request, response, authentication) -> {
                    Dict dict = new Dict();
                    dict.set("code", 200).set("message", "登录成功!");
                    ObjectMapper objectMapper = new ObjectMapper();
                    String s = objectMapper.writeValueAsString(dict);
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().write(s);
                }))
                .failureHandler((request, response, authentication) -> {
                    Dict dict = new Dict();
                    dict.set("code", 0).set("message", "登录失败!");
                    ObjectMapper objectMapper = new ObjectMapper();
                    String s = objectMapper.writeValueAsString(dict);
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().write(s);
                });
        // 配置退出处理器
        http.logout().logoutSuccessHandler(((httpServletRequest, httpServletResponse, authentication) -> {
            Dict dict = new Dict();
            dict.set("code", 200).set("message", "注销成功!");

            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(dict);

            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(s);
        }));
        // 配置访问拒绝处理器
        http.exceptionHandling().accessDeniedHandler(((httpServletRequest, httpServletResponse, e) -> {
            Dict dict = new Dict();
            dict.set("code", 403).set("message", "你没有权限");

            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(dict);

            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.setStatus(403);
            httpServletResponse.getWriter().write(s);
        }));
    }
}
