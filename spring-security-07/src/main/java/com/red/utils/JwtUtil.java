package com.red.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class JwtUtil {

    private static final String JWT_KEY = "PASSWORD";
    // 一小时
    private static final Long TTL = 60 * 60 * 1000L;

    public static String createJwt(Long userId, String username, List<String> authList) {
        Date currentDate = new Date();
        HashMap<String, Object> headerClaims = new HashMap<>();
        headerClaims.put("alg", "HS256");
        headerClaims.put("typ", "JWT");
        return JWT.create()
                // header
                .withHeader(headerClaims)
                // payload
                .withClaim("userId", userId)
                .withClaim("username", username)
                .withClaim("authList", authList)
                .withIssuer("admin")// 设置签发人
                .withIssuedAt(currentDate)// 设置签发时间
                .withExpiresAt(new Date(currentDate.getTime() + TTL))// 过期时间 1小时

                .sign(Algorithm.HMAC256(JWT_KEY));// 设置签名(使用JWT_KEY密钥)
    }

    public static Boolean verifyToken(String jwtToken) {
        try {
            //    创建校验器
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(JWT_KEY))
                    .build();
            jwtVerifier.verify(jwtToken);
            return true;
        } catch (JWTVerificationException e) {
            System.out.println("token验证失败!");
            return false;
        }
    }

    public static Long getUserIdFromToken(String jwtToken) {
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(JWT_KEY)).build();
            return jwtVerifier.verify(jwtToken).getClaim("userId").asLong();
        } catch (Exception e) {
            return -1L;
        }
    }

    public static String getUsernameFromToken(String jwtToken) {
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(JWT_KEY)).build();
            return jwtVerifier.verify(jwtToken).getClaim("username").asString();
        } catch (Exception e) {
            return null;
        }
    }

    public static List<String> getAuthListFromToken(String jwtToken) {
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(JWT_KEY)).build();
            return jwtVerifier.verify(jwtToken).getClaim("authList").asList(String.class);
        } catch (Exception e) {
            return null;
        }
    }
}
