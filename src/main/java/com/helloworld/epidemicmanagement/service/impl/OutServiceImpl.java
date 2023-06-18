package com.helloworld.epidemicmanagement.service.impl;

import com.helloworld.epidemicmanagement.domain.ApplyStateEnum;
import com.helloworld.epidemicmanagement.domain.Out;
import com.helloworld.epidemicmanagement.domain.vo.OutVo;
import com.helloworld.epidemicmanagement.mapper.OutMapper;
import com.helloworld.epidemicmanagement.service.OutService;
import com.helloworld.epidemicmanagement.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OutServiceImpl implements OutService {

    @Value("${interval}")
    private Integer interval;

    @Resource
    private OutMapper outMapper;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return outMapper.deleteByPrimaryKey(id);
    }


    @Override
    public Long insert(Out record) {
        return outMapper.insert(record) == 1? record.getId(): null;
    }

    @Override
    public int insertSelective(Out record) {
        return outMapper.insertSelective(record);
    }

    @Override
    public Out selectByPrimaryKey(Long id) {
        return outMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Out record) {
        return outMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Out record) {
        return outMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<OutVo> selectListByUserid(Long userId) {
        List<Out> outs = outMapper.selectAllByUserId(userId);
        ArrayList<OutVo> outVos = new ArrayList<>(outs.size());
        for (Out out : outs) {
            Date start = out.getTime();
            Date end = DateTimeUtil.getDayAfter(start, interval, Calendar.DAY_OF_MONTH);
            outVos.add(new OutVo(out.getId(), out.getName(), out.getIdCard(), out.getReason(), DateTimeUtil.get19StrTime(start),
                    DateTimeUtil.get19StrTime(end), out.getVehicle(), out.getDirection(), out.getRemark(), out.getState(), out.getUserId()));
        }
        return outVos;
    }

    @Override
    public int outSchool(Out outApply) {
        return outMapper.updateStateById(outApply.getId(), ApplyStateEnum.INVALID.getState());
    }

    @Override
    public int outSchoolById(Long outId) {
        return outSchool(selectByPrimaryKey(outId));
    }

}
