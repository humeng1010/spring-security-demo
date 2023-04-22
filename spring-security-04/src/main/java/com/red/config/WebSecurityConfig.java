package com.red.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 针对URL进行授权
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/student/**")
                // .hasAnyAuthority("student:add")
                // access匹配规则: 有任何授权:student的操作或者角色是teacher的 都可以访问/student/**下的任意请求
                .access("hasAnyAuthority('student:add','student:delete','student:query') or hasRole('ROLE_teacher')")


                .mvcMatchers("/teacher/**")
                .hasAnyAuthority("ROLE_teacher")


                .mvcMatchers("/admin/**")
                .hasAnyAuthority("admin:add")

                
                .anyRequest()
                .authenticated();
        http.formLogin().permitAll();
    }

}
