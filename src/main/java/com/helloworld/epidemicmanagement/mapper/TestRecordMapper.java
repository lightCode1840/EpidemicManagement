package com.helloworld.epidemicmanagement.mapper;


import com.helloworld.epidemicmanagement.domain.TestRecord;
import com.helloworld.epidemicmanagement.domain.vo.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TestRecordMapper {
    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(TestRecord record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(TestRecord record);

    /**
     * select record by ListId
     * @param ListId int
     * @return TestRecord
     * **/
    Test getRecordById(int ListId);

    /***
     *
     * @param userId
     * @return List<TestRecord>
     */
    List<Test> getRecordList(@Param("userId") Long userId);
}
