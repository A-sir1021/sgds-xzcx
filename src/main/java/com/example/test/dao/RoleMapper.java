package com.example.test.dao;

import com.example.test.pojo.Role;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(@Param("role") Role role);

    Role selectOneByPhone(@Param("rolePhone") String  rolePhone);

    int deleteByPhone(@Param("rolePhone") String  rolePhone);
   /* List<Role> selectAll();*/

   /* int updateByPrimaryKey(String record);*/
}