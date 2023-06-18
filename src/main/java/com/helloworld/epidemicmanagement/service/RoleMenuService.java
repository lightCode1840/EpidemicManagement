package com.helloworld.epidemicmanagement.service;

import com.helloworld.epidemicmanagement.domain.RoleMenu;

public interface RoleMenuService{


    int deleteByPrimaryKey(Long roleId,Long menuId);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

}
