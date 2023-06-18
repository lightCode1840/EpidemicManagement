package com.helloworld.epidemicmanagement.service.impl;

import com.helloworld.epidemicmanagement.domain.LoginUser;
import com.helloworld.epidemicmanagement.exception.UserPasswordNotMatchException;
import com.helloworld.epidemicmanagement.service.LoginService;
import com.helloworld.epidemicmanagement.utils.RedisCache;
import com.helloworld.epidemicmanagement.utils.constans.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author fsyj
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private TokenService tokenService;

    @Resource
    private RedisCache redisCache;

    @Override
    public String login(String username, String password, String code, String uuid) {
        // 验证码验证
        validateCaptcha(code, uuid);
        Authentication authentication = null;
        try {
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            log.error("认证错误");
            throw new UserPasswordNotMatchException();
        }
        LoginUser user = (LoginUser) authentication.getPrincipal();
        return tokenService.createToken(user);
    }

    private void validateCaptcha(String code, String uuid) {
        if (uuid == null) {
            uuid = "";
        }
        String key = Constants.CAPTCHA_CODE_KEY + uuid;
        String verifyCode = redisCache.getCacheObject(key);
        redisCache.deleteObject(key);
        if (verifyCode == null || !verifyCode.equalsIgnoreCase(code)) {
            throw new RuntimeException("验证码过期或验证码不正确");
        }
    }
}
