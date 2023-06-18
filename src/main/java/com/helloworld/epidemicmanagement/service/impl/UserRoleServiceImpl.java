package com.helloworld.epidemicmanagement.service.impl;

import com.helloworld.epidemicmanagement.domain.UserRole;
import com.helloworld.epidemicmanagement.mapper.UserRoleMapper;
import com.helloworld.epidemicmanagement.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public int deleteByPrimaryKey(Long userId,Long roleId) {
        return userRoleMapper.deleteByPrimaryKey(userId,roleId);
    }

    @Override
    public int insert(UserRole record) {
        return userRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(UserRole record) {
        return userRoleMapper.insertSelective(record);
    }

}
