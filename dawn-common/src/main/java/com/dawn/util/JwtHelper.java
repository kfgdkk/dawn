package com.dawn.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/**
 * Created by lenovo on 2018/1/26.
 */
public class JwtHelper {
    private static final String secret = "sfoggdfjoifs";
    //进行解析
    public static Claims parseJWT(String jsonWebToken){
        try
        {
            SecretKey key = generalKey();
            Claims claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        }
        catch(Exception ex)
        {
            return null;
        }
    }

    /**
     * *头部（Header），格式如下：
     * *{
     *     "typ":"JWT",
     *     "alg":"HS256"
     *}
     * 有效载荷（Playload）（还可以存其他值）
     * （标准中注册的声明）
     * iss:jwt签发者
     * sub:jwt所面向的用户
     * aud:接受jwt的一方
     * exp:jwt的过期时间，这个过期时间必须大于签发时间
     * nbf：定义在什么时间之前，该jwt都是不可用的
     * iat:jwt的签发时间
     * jti：jwt的唯一身份标识，主要用来作为一次性token，从而回避重放攻击
     *
     * 签名（Signature）：
     * 将Header和Playload拼接生成一个字符串str=“eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyaWQiOjB9”，
     * 使用HS256算法和我们提供的密钥（secret,服务器自己提供的一个字符串）对str进行加密生成最终的JWT，
     * 即我们需要的令牌（token），形如：str.”签名字符串”。
     *
     * @param mapClamis
     * @param seconds
     * @return
     */

    //
    public static String createJWT(Map<String,String> mapClamis, long seconds)
    {
        //签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        //生成iat  jwt的签发时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //生成jti
        String jti = UUID.randomUUID().toString();

        //生成签名密钥
        SecretKey key = generalKey();

        //生产默认的jwtBuilder
       JwtBuilder builder = Jwts.builder()
               .setHeaderParam("typ","JWT")
               .setHeaderParam("alg",signatureAlgorithm.getValue())
               .setId(jti)
               .setIssuedAt(now);

        Iterator<Map.Entry<String, String>> iterator = mapClamis.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            builder.claim(entry.getKey(),entry.getValue());
        }
        builder.signWith(signatureAlgorithm,key);
        if(seconds>=0){
            builder.setExpiration(new Date(nowMillis+seconds*1000));
        }
        return builder.compact();

    }

    /**
     * 由字符串生成加密key
     * @return
     */
    private static SecretKey generalKey(){
        String stringKey = secret;
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }
}
