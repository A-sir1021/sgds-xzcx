/*
package com.example.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.dao.CommentMapper;
import com.example.test.pojo.Comment;
import com.example.test.pojo.PageDataResult;

import com.example.test.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentMapper mapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(int id,String record) {
		// TODO Auto-generated method stub
		System.out.println(id);
		return mapper.insert(id,record);
	}

	@Override
	public Comment selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Comment> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}
	@Override
	public int updateByPrimaryKey(Integer id,String comment) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(id,comment);
	}

	@Override
	public PageDataResult getArticles(Comment userSearch, int page, int limit) {
		// TODO Auto-generated method stub
		PageDataResult pdr = new PageDataResult();
		PageHelper.startPage(page, limit);
		List<Comment> urList =  mapper.selectAll();
		// 获取分页查询后的数据
		PageInfo<Comment> pageInfo = new PageInfo<>(urList);
		// 设置获取到的总记录数total：
		pdr.setTotals(Long.valueOf(pageInfo.getTotal()).intValue());
		
		pdr.setList(urList);
		return pdr;
	}



	

}
*/
