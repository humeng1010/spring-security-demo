package com.red;

import com.red.utils.JwtUtil;

import java.util.Arrays;

public class JwtTest {
    public static void main(String[] args) {
        String jwt = JwtUtil.createJwt(Long.MAX_VALUE >> 3, "root", Arrays.asList("student:add", "student:update"));

        System.out.println(jwt);
        System.out.println(JwtUtil.verifyToken(jwt));
        System.out.println(JwtUtil.getUserIdFromToken(jwt));
        System.out.println(JwtUtil.getUsernameFromToken(jwt));
        System.out.println(JwtUtil.getAuthListFromToken(jwt));

    }
}
