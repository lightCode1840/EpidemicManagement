package com.helloworld.epidemicmanagement.service;

import com.helloworld.epidemicmanagement.domain.TestRecord;
import com.helloworld.epidemicmanagement.domain.vo.Test;

import java.util.List;

public interface TestRecordService{


    int insert(TestRecord record);

    int insertSelective(TestRecord record);

    Test getRecordById(int Listid);

    List<Test> getRecordList(Long userId);

//    List<> getPlace(Long userId);

}
