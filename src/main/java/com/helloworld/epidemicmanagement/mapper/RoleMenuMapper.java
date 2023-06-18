package com.helloworld.epidemicmanagement.mapper;


import com.helloworld.epidemicmanagement.domain.RoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleMenuMapper {
    /**
     * delete by primary key
     * @param roleId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("menuId") Long menuId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(RoleMenu record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(RoleMenu record);
}
