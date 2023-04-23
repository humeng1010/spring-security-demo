package com.red.service.impl;

import com.red.entity.SecurityUser;
import com.red.entity.SysUser;
import com.red.mapper.SysMenuMapper;
import com.red.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserMapper.getUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        // 获取该用户的角色
        String role = sysUserMapper.getRoleByUserName(username);

        // 获取该用户的权限
        List<String> userPermissions = sysMenuMapper.queryPermissionsByUserId(user.getUserId());

        // 把角色添加到权限中 ROLE_XXX
        userPermissions.add(role);


        // 把String类型的集合转为GrantedAuthority的实现类SimpleGrantedAuthority类型的集合

        // List<SimpleGrantedAuthority> authorityArrayList = new ArrayList<>();
        // for (String userPermission : userPermissions) {
        //     SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userPermission);
        //     authorityArrayList.add(simpleGrantedAuthority);
        // }

        // 使用Stream流优化
        List<SimpleGrantedAuthority> authorityArrayList = userPermissions.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        SecurityUser securityUser = new SecurityUser(user);

        securityUser.setUserPermissions(authorityArrayList);

        return securityUser;
    }
}
