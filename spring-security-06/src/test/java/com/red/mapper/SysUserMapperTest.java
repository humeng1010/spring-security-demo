package com.red.mapper;

import com.red.entity.SysUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SysUserMapperTest {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void testGetUserByName() {
        SysUser admin = sysUserMapper.getUserByName("admin");
        Assertions.assertNotNull(admin);

    }
}
