package com.example.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.dao.ViewSpaceMapper;
import com.example.test.pojo.ViewSpace;
import com.example.test.service.ViewSpaceService;
@Service
public class ViewSpaceServiceImpl implements ViewSpaceService{
	@Autowired
	ViewSpaceMapper mapper;
	@Override
	public int deleteByPrimaryKey(Integer space_id) {
		return mapper.deleteByPrimaryKey(space_id);
	}

	@Override
	public int insert(int record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public ViewSpace selectByPrimaryKey(Integer space_id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(space_id);
	}

	@Override
	public List<ViewSpace> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(int record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}
}