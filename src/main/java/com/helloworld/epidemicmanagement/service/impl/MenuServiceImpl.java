package com.helloworld.epidemicmanagement.service.impl;


import com.helloworld.epidemicmanagement.domain.Menu;
import com.helloworld.epidemicmanagement.mapper.MenuMapper;
import com.helloworld.epidemicmanagement.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Menu record) {
        return menuMapper.insert(record);
    }

    @Override
    public int insertSelective(Menu record) {
        return menuMapper.insertSelective(record);
    }

    @Override
    public Menu selectByPrimaryKey(Long id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {
        return menuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Menu record) {
        return menuMapper.updateByPrimaryKey(record);
    }

}
