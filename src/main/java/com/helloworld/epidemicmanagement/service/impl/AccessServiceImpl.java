package com.helloworld.epidemicmanagement.service.impl;


import com.helloworld.epidemicmanagement.domain.Access;
import com.helloworld.epidemicmanagement.domain.ApplyStateEnum;
import com.helloworld.epidemicmanagement.domain.vo.AccessVo;
import com.helloworld.epidemicmanagement.mapper.AccessMapper;
import com.helloworld.epidemicmanagement.service.AccessService;
import com.helloworld.epidemicmanagement.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class AccessServiceImpl implements AccessService {

    @Value("${interval}")
    private Integer interval;

    @Resource
    private AccessMapper accessMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return accessMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Long insert(Access record) {
        return accessMapper.insert(record) == 1 ? record.getId() : null;
    }

    @Override
    public int insertSelective(Access record) {
        return accessMapper.insertSelective(record);
    }

    @Override
    public Access selectByPrimaryKey(Long id) {
        return accessMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Access record) {
        return accessMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Access record) {
        return accessMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<AccessVo> selectListByUserid(Long userId) {
        List<Access> accesses = accessMapper.selectAllByUserId(userId);
        ArrayList<AccessVo> list = new ArrayList<>(accesses.size());
        for (Access access : accesses) {
            Date start = access.getTime();
            Date end = DateTimeUtil.getDayAfter(start, interval, Calendar.DAY_OF_MONTH);
            list.add(new AccessVo(access.getId(), access.getName(), access.getIdCard(), access.getReason(),
                    DateTimeUtil.get19StrTime(start), DateTimeUtil.get19StrTime(end), access.getOriginLocation(),
                    access.getVehicle(), access.getPcr(), access.getImg(), access.getTc(), access.getRemark(), access.getState(), access.getUserId()));
        }
        return list;
    }


    @Override
    public int returnSchool(Access containAccess) {
        return accessMapper.updateStateByID(containAccess.getId(), ApplyStateEnum.INVALID.getState());
    }

    @Override
    public int returnSchoolById(Long accessId) {
        return returnSchool(selectByPrimaryKey(accessId));
    }

}
