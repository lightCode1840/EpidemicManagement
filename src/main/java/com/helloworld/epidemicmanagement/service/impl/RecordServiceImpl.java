package com.helloworld.epidemicmanagement.service.impl;

import com.helloworld.epidemicmanagement.domain.Record;
import com.helloworld.epidemicmanagement.mapper.RecordMapper;
import com.helloworld.epidemicmanagement.service.RecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class RecordServiceImpl implements RecordService {

    @Resource
    private RecordMapper recordMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return recordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Record record) {
        return recordMapper.insert(record);
    }

    @Override
    public int insertSelective(Record record) {
        return recordMapper.insertSelective(record);
    }

    @Override
    public Record selectByPrimaryKey(Long id) {
        return recordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Record record) {
        return recordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Record record) {
        return recordMapper.updateByPrimaryKey(record);
    }

}
