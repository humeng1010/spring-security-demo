package com.red.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class SysMenuMapperTest {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Test
    void queryPermissionsByUserId() {
        List<String> userPermissions = sysMenuMapper.queryPermissionsByUserId(1L);
        log.info("1号用户的权限信息:{}", userPermissions);
        Assertions.assertNotNull(userPermissions);
    }
}