package com.red.password;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
public class BCryptPasswordEncoderTest {

    @Test
    public void testBcrypt() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode1 = bCryptPasswordEncoder.encode("123456");
        String encode2 = bCryptPasswordEncoder.encode("123456");
        String encode3 = bCryptPasswordEncoder.encode("123456");
        log.info(encode1);
        log.info(encode2);
        log.info(encode3);
        // $2a$10$ANg11d1ZSJr5sgxbeqo.DuDs6aF5KxAP.C9jAJqmM8AB6MpkbwwvC
        // $2a$10$L0EQ/n2DBUQbtPeT7BewW.x/75E3H2S.ivILF2czWdJwaK304r3M6
        // $2a$10$oUD0nspoxQybHNW3G9MqbuYOlPYi6IcX0yAnyl48VLNG2hI7d729K
        // 每一时刻生成的并不一样
        boolean res1 = bCryptPasswordEncoder.matches("123456", encode1);
        boolean res2 = bCryptPasswordEncoder.matches("123456", encode2);
        boolean res3 = bCryptPasswordEncoder.matches("123456", encode3);
        assertTrue(res1);
        assertTrue(res2);
        assertTrue(res3);

    }
}
