package com.helloworld.epidemicmanagement.service;

import com.helloworld.epidemicmanagement.domain.Role;

public interface RoleService{


    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

}
