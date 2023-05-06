package cn.wuluwulu.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.wuluwulu.entity.User;
import cn.wuluwulu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
@Slf4j
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void testGetUserList() {
        List<User> users = userService.list();
        log.info("users:{}", users);
        Assertions.assertNotNull(users);
    }

    @Test
    public void testAddUser() {
        User user = User.builder().username("super" + RandomUtil.randomString(10)).password(new BCryptPasswordEncoder().encode("123456")).sex("女").address("北京").build();
        boolean save = userService.save(user);
        Assertions.assertTrue(save);
    }
}
