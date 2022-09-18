/*
package com.example.test.service;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.test.pojo.PageDataResult;
import com.example.test.pojo.manager;

public interface managerService {
	int deleteByPrimaryKey(Integer id);

    int insert(@Param("id")Integer id, @Param("username")String username,@Param("password")String password,@Param("pid")Integer pid,@Param("zindex")Integer zindex);

    manager selectByPrimaryKey(Integer id);

    List<manager> selectAll();

    int updateByPrimaryKey(@Param("id")Integer id, @Param("username")String username,@Param("password")String password,@Param("pid")Integer pid,@Param("zindex")Integer zindex);

	List<manager> getUserPerms(Integer id);
	
	public PageDataResult getArticles(manager userSearch, int page, int limit);
	
	int updatePwd (@Param("id")Integer id,@Param("password")String password);
}
*/
