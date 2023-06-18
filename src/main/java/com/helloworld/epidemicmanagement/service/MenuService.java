package com.helloworld.epidemicmanagement.service;

import com.helloworld.epidemicmanagement.domain.Menu;

public interface MenuService{


    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

}
