package com.red.service.impl;

import cn.hutool.core.lang.Dict;
import com.red.mapper.SysMenuMapper;
import com.red.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public Dict getPermissionsByUserId(Long userId) {
        List<String> userPermissions = sysMenuMapper.queryPermissionsByUserId(userId);
        if (userPermissions.isEmpty()) {
            return new Dict().set("code", 402).set("message", "没有查询到该用户的权限");
        }
        return new Dict().set("code", 200).set("data", userPermissions);
    }
}
