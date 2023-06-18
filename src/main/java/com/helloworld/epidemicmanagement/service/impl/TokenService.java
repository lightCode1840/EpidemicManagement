package com.helloworld.epidemicmanagement.service.impl;

import com.helloworld.epidemicmanagement.domain.LoginUser;
import com.helloworld.epidemicmanagement.utils.RedisCache;
import com.helloworld.epidemicmanagement.utils.UUIDUtil;
import com.helloworld.epidemicmanagement.utils.constans.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * token验证处理
 *
 * @author ruoyi
 */
@Service("tokenService")
public class TokenService {
    // 令牌秘钥
    @Value("${token.secret}")
    private String secret;

    // 令牌有效期（默认30分钟）
    @Value("${token.expireTime}")
    private int expireTime;

    protected static final long MILLIS_SECOND = 1000;

    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;

    @Autowired
    private RedisCache redisCache;


    public String createToken(LoginUser user) {
        String tokenId = UUIDUtil.getUUID();
        user.setTokenId(tokenId);

        Map<String, Object> claims = new HashMap<>(1);
        claims.put(Constants.LOGIN_USER_KEY, tokenId);
        String token = createToken(claims);
        // 刷新Token
        token = refreshToken(token, user);
        return token;
    }

    /**
     * 刷新缓存，如果Token过期则冲新设置
     *
     * @param token
     * @param user
     * @return
     */
    public String refreshToken(String token, LoginUser user) {
        redisCache.setCacheObject(user.getTokenId(), user, expireTime, TimeUnit.MINUTES);
        if (tokenExpire(token)) {
            // Token过期，需要重新设置Token
            token = createToken(user);
        }
        return token;
    }

    private Boolean tokenExpire(String token) {
        Claims claim = getClaimFromToken(token);
        return claim.getExpiration().before(new Date());
    }


    public Claims getClaimFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private String createToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("hello world")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(getExpireDate())
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    private Date getExpireDate() {
        long currentTimeMillis = System.currentTimeMillis();
        return new Date(currentTimeMillis + ((long) expireTime * 60 * 1000));
    }

    public SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(secret);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }

    public LoginUser verifyToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        String tokenId = (String) claims.get(Constants.LOGIN_USER_KEY);
        return redisCache.getCacheObject(tokenId);
    }
}
