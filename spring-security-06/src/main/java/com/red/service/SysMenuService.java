package com.red.service;

import cn.hutool.core.lang.Dict;

public interface SysMenuService {
    Dict getPermissionsByUserId(Long userId);
}
