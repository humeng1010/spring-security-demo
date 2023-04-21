package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfigurer {

    /**
     * 设置请求资源拦截规则
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http.authorizeRequests()
                .mvcMatchers("/index","/login.html").permitAll() //放行的资源需要写在任意的前面
                .anyRequest().authenticated()//任何请求都需要认证
                .and()
                .formLogin()//通过form表单登陆
                .loginPage("/login.html")//设置自己的登录页面
                .loginProcessingUrl("/login")//指定处理登陆的url[必须!]
                .usernameParameter("uname")
                .passwordParameter("passwd")
                // .successForwardUrl("/index") //认证成功 forward 跳转路径;注意始终在认证成功后跳转到指定路径
                .defaultSuccessUrl("http://wuluwulu.cn") //认证成功后 redirect 重定向到指定路径;注意如果之前被拦截到了,还是会重定向到之前的页面;如果直接访问登录页,则会跳转到配置的页面
                // .defaultSuccessUrl("http://wuluwulu.cn",true) //总是会重定向到指定路径
                .and().csrf().disable()//关闭csrf
                .build();
    }
}
