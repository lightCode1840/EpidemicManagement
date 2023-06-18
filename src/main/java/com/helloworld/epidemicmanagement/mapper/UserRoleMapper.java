package com.helloworld.epidemicmanagement.mapper;


import com.helloworld.epidemicmanagement.domain.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRoleMapper {
    /**
     * delete by primary key
     * @param userId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(@Param("userId") Long userId, @Param("roleId") Long roleId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(UserRole record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserRole record);
}
