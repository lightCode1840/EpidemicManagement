package com.helloworld.epidemicmanagement.service.impl;

import com.helloworld.epidemicmanagement.domain.HealthEnum;
import com.helloworld.epidemicmanagement.domain.LoginUser;
import com.helloworld.epidemicmanagement.domain.User;
import com.helloworld.epidemicmanagement.domain.vo.Test;
import com.helloworld.epidemicmanagement.mapper.UserMapper;
import com.helloworld.epidemicmanagement.service.TestRecordService;
import com.helloworld.epidemicmanagement.service.UserService;
import com.helloworld.epidemicmanagement.utils.DateTimeUtil;
import com.helloworld.epidemicmanagement.utils.RedisCache;
import com.helloworld.epidemicmanagement.utils.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisCache redisCache;

    @Resource
    private TestRecordService testRecordServiceImpl;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public User getInfo(String phone) {
        if (StringUtils.hasLength(phone)) {
            User user = userMapper.selectByPhone(phone);
            user.setPassword("");
            return user;
        }
        return null;
    }

    @Override
    public HealthEnum getHealthState(Long userId) {
        Test test = null;
        HealthEnum result = null;
        try {
             test = testRecordServiceImpl.getRecordList(userId).get(0);
            boolean positive = isPositive(test.getData());
            boolean before = beforeThreeDay(test.getTime());
            if (positive) {
                result = HealthEnum.POSITIVE;
            } else {
                if (before) {
                    result = HealthEnum.NOT_DETECTED;
                } else {
                    result = HealthEnum.NO_RISK;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            result = HealthEnum.NOT_DETECTED;
        }
        return result;
    }

    @Override
    public User selectByPhone(String phone) {
        return userMapper.selectByPhone(phone);
    }

    @Override
    public void logout() {
        LoginUser loginUser = SecurityUtil.getLoginUser();
        String tokenId = loginUser.getTokenId();
        redisCache.deleteObject(tokenId);
    }

    @Override
    public User getInfoById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }


    private boolean isPositive(String data) {
        return data.contains("阳性");
    }

    private boolean beforeThreeDay(String time) {
        Date testRecordTime = null;
        boolean before = false;
        try {
            testRecordTime = DateTimeUtil.parseToDateBy19(time);
            Calendar instance = Calendar.getInstance();
            instance.add(Calendar.DAY_OF_MONTH, -3);
            before = instance.getTime().after(testRecordTime);
        } catch (ParseException e) {
            log.error(e.getMessage());
            throw new RuntimeException("获取失败，请稍后重试");
        }
        return before;
    }

}
