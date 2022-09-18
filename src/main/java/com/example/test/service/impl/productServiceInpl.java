/*
package com.example.test.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.dao.productMapper;
import com.example.test.pojo.PageDataResult;
import com.example.test.pojo.product;
import com.example.test.service.productService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class productServiceInpl implements productService {

	@Autowired
	productMapper mapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Integer id, String name, String description, Double price, Timestamp date, String permise) {
		// TODO Auto-generated method stub
		return mapper.insert( id,  name,  description,  price,  date,  permise);
	}

	@Override
	public product selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<product> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Integer id, String name, String description, Double price, Timestamp date,
			String permise) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(id,  name,  description,  price,  date,  permise);
	}

	@Override
	public List<product> permList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageDataResult getArticles(product userSearch, int page, int limit) {
		// TODO Auto-generated method stub
		PageDataResult pdr = new PageDataResult();
		PageHelper.startPage(page, limit);
		List<product> urList =  mapper.selectAll();
		// 获取分页查询后的数据
		PageInfo<product> pageInfo = new PageInfo<>(urList);
		// 设置获取到的总记录数total：
		pdr.setTotals(Long.valueOf(pageInfo.getTotal()).intValue());
		
		pdr.setList(urList);
		return pdr;
	}

	@Override
	public List<product> getUserPerms(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
*/
