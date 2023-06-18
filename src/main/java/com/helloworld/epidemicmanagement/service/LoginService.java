package com.helloworld.epidemicmanagement.service;

/**
 * @author fsyj
 */
public interface LoginService {

    /**
     * 登录
     * @param username 手机号
     * @param password 密码
     * @param code 验证码
     * @param uuid
     * @return Token
     */
    String login(String username, String password, String code, String uuid);

}
