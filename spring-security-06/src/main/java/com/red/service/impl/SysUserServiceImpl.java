package com.red.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Dict;
import com.red.entity.SysUser;
import com.red.mapper.SysUserMapper;
import com.red.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public Dict getUserByName(String username) {
        SysUser user = sysUserMapper.getUserByName(username);
        if (BeanUtil.isEmpty(user)) {
            return new Dict().set("code", 401).set("data", null).set("message", "根据用户名查询用户失败");
        }
        return new Dict().set("code", 200).set("data", user).set("message", "根据用户名查询用户成功");
    }
}
