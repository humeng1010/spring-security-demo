package com.red.service;

import cn.hutool.core.lang.Dict;

public interface SysUserService {
    Dict getUserByName(String username);
}
