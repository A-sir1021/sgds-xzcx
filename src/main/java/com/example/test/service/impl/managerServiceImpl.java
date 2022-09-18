/*
package com.example.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.dao.managerMapper;
import com.example.test.pojo.PageDataResult;
import com.example.test.pojo.manager;
import com.example.test.service.managerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class managerServiceImpl implements managerService {

	@Autowired
	managerMapper mapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Integer id, String username, String password, Integer pid, Integer zindex) {
		// TODO Auto-generated method stub
		return mapper.insert(id, username, password, pid, zindex);
	}

	@Override
	public manager selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<manager> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Integer id, String username, String password, Integer pid, Integer zindex) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(id, username, password, pid, zindex);
	}

	@Override
	public List<manager> getUserPerms(Integer id) {
		// TODO Auto-generated method stub
		return mapper.getUserPerms(id);
	}

	@Override
	public PageDataResult getArticles(manager userSearch, int page, int limit) {
		// TODO Auto-generated method stub
		PageDataResult pdr = new PageDataResult();
		PageHelper.startPage(page, limit);
		List<manager> urList =  mapper.selectAll();
		// 获取分页查询后的数据
		PageInfo<manager> pageInfo = new PageInfo<>(urList);
		// 设置获取到的总记录数total：
		pdr.setTotals(Long.valueOf(pageInfo.getTotal()).intValue());
		
		pdr.setList(urList);
		return pdr;
	}

	@Override
	public int updatePwd(Integer id, String password) {
		// TODO Auto-generated method stub
		return mapper.updatePwd(id, password);
	}

}
*/
