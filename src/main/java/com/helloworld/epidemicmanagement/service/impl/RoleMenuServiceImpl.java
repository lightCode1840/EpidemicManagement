package com.helloworld.epidemicmanagement.service.impl;


import com.helloworld.epidemicmanagement.domain.RoleMenu;
import com.helloworld.epidemicmanagement.mapper.RoleMenuMapper;
import com.helloworld.epidemicmanagement.service.RoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Override
    public int deleteByPrimaryKey(Long roleId,Long menuId) {
        return roleMenuMapper.deleteByPrimaryKey(roleId,menuId);
    }

    @Override
    public int insert(RoleMenu record) {
        return roleMenuMapper.insert(record);
    }

    @Override
    public int insertSelective(RoleMenu record) {
        return roleMenuMapper.insertSelective(record);
    }

}
