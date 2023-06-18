package com.helloworld.epidemicmanagement.service;


import com.helloworld.epidemicmanagement.domain.Record;

public interface RecordService{


    int deleteByPrimaryKey(Long id);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

}
