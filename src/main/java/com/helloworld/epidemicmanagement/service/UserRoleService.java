package com.helloworld.epidemicmanagement.service;

import com.helloworld.epidemicmanagement.domain.UserRole;

public interface UserRoleService{


    int deleteByPrimaryKey(Long userId,Long roleId);

    int insert(UserRole record);

    int insertSelective(UserRole record);

}
