package com.helloworld.epidemicmanagement.service;

import com.helloworld.epidemicmanagement.domain.Access;
import com.helloworld.epidemicmanagement.domain.vo.AccessVo;

import java.util.List;

public interface AccessService{


    int deleteByPrimaryKey(Long id);

    Long insert(Access record);

    int insertSelective(Access record);

    Access selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Access record);

    int updateByPrimaryKey(Access record);

    List<AccessVo> selectListByUserid(Long userId);

    int returnSchool(Access containAccess);

    int returnSchoolById(Long accessId);
}
