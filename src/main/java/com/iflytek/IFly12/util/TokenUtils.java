package com.iflytek.IFly12.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.iflytek.IFly12.entity.User;
import java.util.Date;

public class TokenUtils {
    //发行人
    private static final String ISSUE="IFly12";
    //token到期时间一天
    private static final Integer EXPIRE_TIME=86400000;
    //密钥盐
    private static final String TOKEN_SECRET="ljdyaishijin**3nkjnj??";

    /**
     * 为用户生成一个签名。
     * @param user 需要生成签名的用户。
     * @return 如果成功，返回生成的签名；否则返回null。
     */
    public static String sign(User user){
        String token=null;
        try {
            Date expireAt=new Date(System.currentTimeMillis()+EXPIRE_TIME);
            token = JWT.create()
                    //发行人
                    .withIssuer(ISSUE)
                    //存放数据
                    .withClaim("userId",user.getUserId())
                    //过期时间
                    .withExpiresAt(expireAt)
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
            System.out.println(token);
        } catch (IllegalArgumentException | JWTCreationException je) {
        }
        return token;
    }



    /**
     * 验证token是否有效。
     * @param token 需要验证的token。
     * @return 如果token有效，返回true；否则返回false。
     */
    public static Boolean verify(String token){
        try {
            //创建token验证器
            JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer(ISSUE).build();
            jwtVerifier.verify(token);
        } catch (IllegalArgumentException | JWTVerificationException e) {
            //抛出错误即为验证不通过
            return false;
        }
        return true;
    /**
     * 获取用户ID。
     * @param token 用户的token。
     * @return 如果token有效，返回对应的用户ID；否则抛出异常。
     */
    }
    public static Integer getUserId(String token){
        JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer(ISSUE).build();
        return Integer.valueOf(jwtVerifier.verify(token).getClaim("userId").asString());
    }
}