package com.red.repository;

import com.red.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindAll() {
        List<User> all = userRepository.findAll();
        log.info("所有用户信息:{}", all);
        assertNotNull(all);
    }

    @Test
    public void testFindUserByUsername() {
        User admin = userRepository.findUserByUsername("teacher");
        System.out.println(admin);
        assertNotNull(admin);
    }

    @Test
    public void testFindMenuCodeByUserId() {
        // List<String> code = userRepository.findMenuCodeByUserId(1L);
        // System.out.println(code);
    }

}