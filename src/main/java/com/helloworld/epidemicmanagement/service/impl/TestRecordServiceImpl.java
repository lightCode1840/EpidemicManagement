package com.helloworld.epidemicmanagement.service.impl;


import com.helloworld.epidemicmanagement.domain.TestRecord;
import com.helloworld.epidemicmanagement.domain.vo.Test;
import com.helloworld.epidemicmanagement.mapper.TestRecordMapper;
import com.helloworld.epidemicmanagement.service.TestRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestRecordServiceImpl implements TestRecordService {

    @Resource
    private TestRecordMapper testRecordMapper;

    @Override
    public int insert(TestRecord record) {
        return testRecordMapper.insert(record);
    }

    @Override
    public int insertSelective(TestRecord record) {
        return testRecordMapper.insertSelective(record);
    }

    @Override
    public Test getRecordById(int Listid) {
        return testRecordMapper.getRecordById(Listid);
    }

    @Override
    public List<Test> getRecordList(Long userId) {
        return testRecordMapper.getRecordList(userId);
    }

}
