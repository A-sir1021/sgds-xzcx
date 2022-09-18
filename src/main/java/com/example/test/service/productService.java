package com.example.test.service;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.test.pojo.PageDataResult;
import com.example.test.pojo.product;

public interface productService {
	
	int deleteByPrimaryKey(Integer id);

    int insert(@Param("id")Integer id, @Param("name")String name,@Param("description")String description,@Param("price")Double price,@Param("date")Timestamp date,@Param("permise")String permise);

    product selectByPrimaryKey(Integer id);

    List<product> selectAll();

    int updateByPrimaryKey(@Param("id")Integer id, @Param("name")String name,@Param("description")String description,@Param("price")Double price,@Param("date")Timestamp date,@Param("permise")String permise);

	List<product> permList();
	PageDataResult getArticles(product userSearch, int page, int limit);
	
	//public PageDataResult getPermissionById(Permission userSearch, int page, int limit,@Param("id")Integer id);
	List<product> getUserPerms(Integer id);
}
