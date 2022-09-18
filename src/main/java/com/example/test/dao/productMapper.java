package com.example.test.dao;

import com.example.test.pojo.product;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface productMapper {

    List<product> selectAll();

	int deleteByPrimaryKey(@Param("id")Integer id);

	int insert(@Param("id")Integer id, @Param("name")String name,@Param("description")String description,@Param("price")Double price,@Param("date")Timestamp date,@Param("permise")String permise);

	product selectByPrimaryKey(@Param("id")Integer id);

	int updateByPrimaryKey(@Param("id")Integer id, @Param("name")String name,@Param("description")String description,@Param("price")Double price,@Param("date")Timestamp date,@Param("permise")String permise); 
}