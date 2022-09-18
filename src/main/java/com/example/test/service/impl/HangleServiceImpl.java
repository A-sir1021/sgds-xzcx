/*
package com.example.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.dao.HangleMapper;
import com.example.test.pojo.Hangle;
import com.example.test.pojo.PageDataResult;
import com.example.test.service.HangleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class HangleServiceImpl implements HangleService {

	@Autowired
	HangleMapper mapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Integer id, String name, String firm, String consumer, String ship, String delivery,
			String logistics) {
		// TODO Auto-generated method stub
		return mapper.insert(id, name, firm, consumer, ship, delivery, logistics);
	}

	@Override
	public Hangle selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Hangle> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Integer id, String name, String firm, String consumer, String ship, String delivery,
			String logistics) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(id, name, firm, consumer, ship, delivery, logistics);
	}

	@Override
	public List<Hangle> getUserPerms(Integer id) {
		// TODO Auto-generated method stub
		return mapper.getUserPerms(id);
	}

	@Override
	public PageDataResult getArticles(Hangle userSearch, int page, int limit) {
		// TODO Auto-generated method stub
		PageDataResult pdr = new PageDataResult();
		PageHelper.startPage(page, limit);
		List<Hangle> urList =  mapper.selectAll();
		// 获取分页查询后的数据
		PageInfo<Hangle> pageInfo = new PageInfo<>(urList);
		// 设置获取到的总记录数total：
		pdr.setTotals(Long.valueOf(pageInfo.getTotal()).intValue());
		
		pdr.setList(urList);
		return pdr;
	}

}
*/
