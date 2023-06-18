package com.helloworld.epidemicmanagement.service;

import com.helloworld.epidemicmanagement.domain.Out;
import com.helloworld.epidemicmanagement.domain.vo.OutVo;

import java.util.List;

public interface OutService{


    int deleteByPrimaryKey(Long id);

    Long insert(Out record);

    int insertSelective(Out record);

    Out selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Out record);

    int updateByPrimaryKey(Out record);

    List<OutVo> selectListByUserid(Long userId);

    int outSchool(Out outApply);

    int outSchoolById(Long outId);
}
