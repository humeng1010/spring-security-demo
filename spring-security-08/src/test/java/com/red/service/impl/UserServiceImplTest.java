package com.red.service.impl;

import com.red.entity.User;
import com.red.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
@Slf4j
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void insertUser() {
        User user = User.builder()
                .username("zhangsan")
                .password(new BCryptPasswordEncoder().encode("123"))
                .sex("男")
                .address("上海")
                .build();
        User insertUser = userService.insertUser(user);
        log.info("新增的用户:{}", insertUser);
    }

    @Test
    void deleteUser() {
        userService.deleteUser(2L);
    }

    @Test
    void updateUser() {
        User user = User.builder()
                .userId(7L)
                .username("zhangsan33")
                .password(new BCryptPasswordEncoder().encode("123456qwer"))
                .sex("女")
                .address("北京")
                .build();
        User user1 = userService.updateUser(user);
        log.info("修改后:{}", user1);
    }

    @Test
    void findAllUser() {
        List<User> allUser = userService.findAllUser();
        Assertions.assertNotNull(allUser);
    }

    @Test
    void findUserById() {
        User userById = userService.findUserById(1L);
        log.info("1号用户:{}", userById);
    }
}