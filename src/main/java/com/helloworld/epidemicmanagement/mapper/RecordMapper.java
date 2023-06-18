package com.helloworld.epidemicmanagement.mapper;


import com.helloworld.epidemicmanagement.domain.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Record record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Record record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Record selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Record record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Record record);

    /**
     * select all record by userId
     * @param userId primaryKey
     * @return object by primaryKey
     * **/
    List<Record> getRecordList(Long userId);
}
