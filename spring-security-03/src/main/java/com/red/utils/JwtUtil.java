package com.red.utils;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

/**
 * JWT工具类
 */
public class JwtUtil {
    // 有效时间1小时
    public static final Long JWT_TTL = 60 * 60 * 1000L;

    // 设置密钥
    private static final String JWT_KEY = "p@SsW0rd";

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getJwt(String username, String role, String subject) {
        return Jwts.builder().setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .claim("username", username)
                .claim("role", role)
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TTL))
                .setId(getUUID())
                .signWith(SignatureAlgorithm.HS256, JWT_KEY)
                .compact();

    }

    public static Claims parseJwt(String jwtToken) {
        JwtParser parser = Jwts.parser();
        Jws<Claims> claimsJws = parser.setSigningKey(JWT_KEY).parseClaimsJws(jwtToken);
        return claimsJws.getBody();
    }

}
