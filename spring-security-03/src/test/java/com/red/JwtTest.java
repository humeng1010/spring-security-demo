package com.red;

import io.jsonwebtoken.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;

@SpringBootTest
public class JwtTest {

    private final Long time = 1000 * 60 * 60 * 24L;

    // 签名信息
    private static final String SIGNATURE = "wuluwulu";

    @Test
    public void jwtTest() {
        // 获取JwtBuilder对象
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                // header头部
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                // payload载荷
                .claim("username", "zhangsan")
                .claim("role", "admin")
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .setId(UUID.randomUUID().toString())
                // signature签名
                .signWith(SignatureAlgorithm.HS256, SIGNATURE)
                .compact();
        System.out.println(jwtToken);
        // eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InpoYW5nc2FuIiwicm9sZSI6ImFkbWluIiwic3ViIjoiYWRtaW4tdGVzdCIsImV4cCI6MTY4MjIzMDAzNywianRpIjoiNDI4YWY3MGYtNDIzYi00NWYzLTljNDQtYjZlOTY5ZjhhM2IyIn0._E92zGizzJ0D5TM_j2Gv3JxEnfUumG1Hz_uoeBCzTJE

    }

    @Test
    public void parseJwt() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InpoYW5nc2FuIiwicm9sZSI6ImFkbWluIiwic3ViIjoiYWRtaW4tdGVzdCIsImV4cCI6MTY4MjIzMDAzNywianRpIjoiNDI4YWY3MGYtNDIzYi00NWYzLTljNDQtYjZlOTY5ZjhhM2IyIn0._E92zGizzJ0D5TM_j2Gv3JxEnfUumG1Hz_uoeBCzTJE";
        JwtParser parser = Jwts.parser();
        Jws<Claims> claimsJws = parser.setSigningKey(SIGNATURE)
                .parseClaimsJws(token);

        Claims claims = claimsJws.getBody();
        System.out.println("payload:username:" + claims.get("username"));
        System.out.println("payload:role:" + claims.get("role"));
        System.out.println("payload:id:" + claims.getId());
        System.out.println("payload:subject:" + claims.getSubject());
        System.out.println("payload:exp:" + claims.getExpiration());

    }
}
