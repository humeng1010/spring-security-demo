package cn.wuluwulu.service.impl;

import cn.wuluwulu.entity.User;
import cn.wuluwulu.entity.UserDetail;
import cn.wuluwulu.service.UserService;
import cn.wuluwulu.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("用户名:{}", username);

        Result<User> userResult = userService.getUserByUsername(username);

        User user = userResult.getData();
        Long userId = user.getUserId();

        UserDetail userDetail = new UserDetail(user);
// userDetail.setSimpleGrantedAuthorities();
        return userDetail;
    }
}
