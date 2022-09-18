package com.example.test.dao;

import com.example.test.pojo.work;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface workMapper {
    int insert(@Param("id")Integer id, @Param("name")String name,@Param("situation")String situation,@Param("date")Timestamp date,@Param("author")String author,@Param("page")Integer page,@Param("icon")Integer icon);

    List<work> selectAll();

	int deleteByPrimaryKey(Integer id);
	
	 work selectByPrimaryKey(Integer id);
	 
	int update(@Param("id")Integer id, @Param("name")String name,@Param("situation")String situation,@Param("date")Timestamp date,@Param("author")String author,@Param("page")Integer page,@Param("icon")Integer icon);

}