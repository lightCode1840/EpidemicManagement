package com.helloworld.epidemicmanagement.service;

import com.helloworld.epidemicmanagement.domain.HealthEnum;
import com.helloworld.epidemicmanagement.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserService{


    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 获取用户基本信息
     *
     * @param phone
     * @return
     */
    User getInfo(@Param("phone") String phone);

    /**
     * 获取用户健康状况
     * @param userId
     * @return
     */
    HealthEnum getHealthState(Long userId);


    User selectByPhone(String phone);

    void logout();

    User getInfoById(Long id);
}
