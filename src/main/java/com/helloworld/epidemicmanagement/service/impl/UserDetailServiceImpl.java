package com.helloworld.epidemicmanagement.service.impl;

import com.helloworld.epidemicmanagement.domain.LoginUser;
import com.helloworld.epidemicmanagement.domain.User;
import com.helloworld.epidemicmanagement.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        User user = userMapper.selectByPhone(phone);
        return new LoginUser(null, null, user, null);
    }
}
