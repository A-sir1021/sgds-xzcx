/*
package com.example.test.service;

import com.example.test.pojo.Comment;
import com.example.test.pojo.PageDataResult;
import com.example.test.pojo.Permission;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface PermissionService {
	
    int deleteByPrimaryKey(Integer id);

    int insert(@Param("id")Integer id, @Param("name")String name,@Param("pid")Integer pid,@Param("zindex")Integer zindex,@Param("istype")Integer istype,@Param("descpt")String descpt,@Param("code")String code,@Param("icon")String icon,@Param("page")String page,@Param("insert_time")Timestamp insert_time,@Param("update_time")Timestamp update_time);

    Permission selectByPrimaryKey(Integer id);

    List<Permission> selectAll();

    int updateByPrimaryKey(@Param("id")Integer id, @Param("name")String name,@Param("pid")Integer pid,@Param("zindex")Integer zindex,@Param("istype")Integer istype,@Param("descpt")String descpt,@Param("code")String code,@Param("icon")String icon,@Param("page")String page,@Param("insert_time")Timestamp insert_time,@Param("update_time")Timestamp update_time);

	List<Permission> permList();
	public PageDataResult getArticles(Permission userSearch, int page, int limit);
	
	//public PageDataResult getPermissionById(Permission userSearch, int page, int limit,@Param("id")Integer id);
	List<Permission> getUserPerms(Integer id);
}*/
