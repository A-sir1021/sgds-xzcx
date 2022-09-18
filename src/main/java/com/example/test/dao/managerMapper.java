/*
package com.example.test.dao;

import com.example.test.pojo.Permission;
import com.example.test.pojo.manager;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface managerMapper {
	int deleteByPrimaryKey(Integer id);

    int insert(@Param("id")Integer id, @Param("username")String username,@Param("password")String password,@Param("pid")Integer pid,@Param("zindex")Integer zindex);

    manager selectByPrimaryKey(Integer id);

    List<manager> selectAll();

    int updateByPrimaryKey(@Param("id")Integer id, @Param("username")String username,@Param("password")String password,@Param("pid")Integer pid,@Param("zindex")Integer zindex);

	List<manager> getUserPerms(Integer id);
	
	int updatePwd (@Param("id")Integer id,@Param("password")String password);
}*/
