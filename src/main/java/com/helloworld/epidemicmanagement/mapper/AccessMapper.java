package com.helloworld.epidemicmanagement.mapper;

import com.helloworld.epidemicmanagement.domain.Access;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccessMapper {
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
    int insert(Access record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Access record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Access selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Access record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Access record);

    List<Access> selectAllByUserId(@Param("userId")Long userId);


    int updateStateByID(@Param("id") Long id, @Param("state") String state);
}
