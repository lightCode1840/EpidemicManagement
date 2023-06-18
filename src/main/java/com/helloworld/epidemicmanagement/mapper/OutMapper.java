package com.helloworld.epidemicmanagement.mapper;

import com.helloworld.epidemicmanagement.domain.Out;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OutMapper {
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
    int insert(Out record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Out record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Out selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Out record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Out record);

    List<Out> selectAllByUserId(@Param("userId")Long userId);


    int updateStateById(@Param("id") Long id, @Param("state") String state);
}
