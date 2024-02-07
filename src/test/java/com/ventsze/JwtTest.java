package com.ventsze;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGen(){

        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","章文泽");

        //生成jwt的代码
        String token = JWT.create()
                .withClaim("user",claims) //添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*24)) //添加过期时间
                .sign(Algorithm.HMAC256("ventsze")); //指定算法，配置密钥

        System.out.println(token);
    }

    @Test
    public void testParse(){
        //定义字符串，模拟token
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9." +
                "eyJleHAiOjE3MDczODU5ODAsInVzZXIiOnsiaWQiOjEsInVzZXJuYW1lIjoi56ug5paH5rO9In19." +
                "Q7zTsbkPWjLtEfGTlgPVwa4uzLbDuEPefBWYo6CecsI";

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("ventsze")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token); //验证token，生成一个解析后的jwt
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));

        // 如果篡改了头部和载荷的数据，则验证失败
        // 如果密钥改了，验证失败
        // token过期也验证失败

    }

}
