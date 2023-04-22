package com.red.service.impl;

import cn.hutool.core.util.StrUtil;
import com.red.entity.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StrUtil.isBlank(username)) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        if (!username.equals("zhangsan")) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        SecurityUser securityUser = new SecurityUser();

        return securityUser;
    }
}
