package com.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.HashMap;

@Configuration
public class WebSecurityConfigurer {

    /**
     * 设置请求资源拦截规则
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests()
                .mvcMatchers("/index", "/login.html").permitAll() // 放行的资源需要写在任意的前面
                .anyRequest().authenticated()// 任何请求都需要认证
                .and()
                .formLogin()// 通过form表单登陆
                .loginPage("/login.html")// 设置自己的登录页面
                .loginProcessingUrl("/login")// 指定处理登陆的url[必须!]
                .usernameParameter("uname")
                .passwordParameter("passwd")
                // .successForwardUrl("/index") //认证成功 forward 跳转路径;注意始终在认证成功后跳转到指定路径
                // .defaultSuccessUrl("http://wuluwulu.cn") //认证成功后 redirect 重定向到指定路径;注意如果之前被拦截到了,还是会重定向到之前的页面;如果直接访问登录页,则会跳转到配置的页面
                // .defaultSuccessUrl("http://wuluwulu.cn",true) //总是会重定向到指定路径
                // 用于处理前后端分离开发[重要]
                .successHandler((request, response, authentication) -> {
                    HashMap<String, Object> result = new HashMap<>();
                    result.put("message", "登陆成功");
                    result.put("status", 200);
                    result.put("authentication", authentication);
                    response.setContentType("application/json;charset=UTF-8");
                    String s = new ObjectMapper().writeValueAsString(result);
                    response.getWriter().write(s);
                })// 认证成功时的处理
                // .failureForwardUrl("/login.html")//认证失败之后的 forward 跳转
                // .failureUrl("/login.html")// 默认 认证失败后 redirect 跳转
                .failureHandler(((request, response, exception) -> {
                    String message = exception.getMessage();
                    HashMap<String, Object> result = new HashMap<>();
                    result.put("message", message);
                    result.put("status", 500);
                    String s = new ObjectMapper().writeValueAsString(result);
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().write(s);
                }))// 自定义认证失败处理 前后端分离解决方案
                .and().csrf().disable()// 关闭csrf
                .build();
    }
}
