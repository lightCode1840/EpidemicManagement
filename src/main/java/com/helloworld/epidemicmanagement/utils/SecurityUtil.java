package com.helloworld.epidemicmanagement.utils;

import com.helloworld.epidemicmanagement.domain.LoginUser;
import com.helloworld.epidemicmanagement.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author fsyj
 */
public class SecurityUtil {

    /**
     * 获取Authentication
     */
    private static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static Long getUserId() {
        Authentication authentication = getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return loginUser.getUser().getId();
    }

    public static User getUserInfo() {
        Authentication authentication = getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return loginUser.getUser();
    }

    public static LoginUser getLoginUser() {
        Authentication authentication = getAuthentication();
        return (LoginUser) authentication.getPrincipal();
    }
}
