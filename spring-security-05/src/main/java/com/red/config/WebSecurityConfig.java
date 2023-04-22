package com.red.config;

import cn.hutool.core.lang.Dict;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

// @Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)// 开启全局方法安全,并启用预授权和后授权
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        UserDetails student = User.builder()
                .username("student")
                .password(passwordEncoder().encode("123456"))
                .roles("student")
                .build();

        UserDetails teacher = User.builder()
                .username("teacher")
                .password(passwordEncoder().encode("123456"))
                .authorities("teacher:query")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("123456"))
                .authorities("teacher:add", "teacher:delete", "teacher:update", "teacher:query").build();

        manager.createUser(student);
        manager.createUser(teacher);
        manager.createUser(admin);
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 任何请求均需要认证
        http.authorizeRequests().anyRequest().authenticated();
        // 放开登陆接口
        http.formLogin()
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .permitAll();
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
