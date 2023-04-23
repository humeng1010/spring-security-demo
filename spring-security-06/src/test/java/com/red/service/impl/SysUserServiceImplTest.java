package com.red.service.impl;

import cn.hutool.core.lang.Dict;
import com.red.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SysUserServiceImplTest {

    @Autowired
    private SysUserService sysUserService;

    @Test
    void getUserByName() {
        Dict teacher = sysUserService.getUserByName("teacher");
        assertNotNull(teacher);
    }
}