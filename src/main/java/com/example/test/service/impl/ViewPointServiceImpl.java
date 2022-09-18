package com.example.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.dao.ViewPointMapper;
import com.example.test.pojo.ViewPoint;
import com.example.test.service.ViewPointService;
@Service
public class ViewPointServiceImpl implements ViewPointService {

	@Autowired
	ViewPointMapper mapper;
	@Override
	public int deleteByPrimaryKey(Integer point_id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(point_id);
	}

	@Override
	public int insert(ViewPoint record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public ViewPoint selectByPrimaryKey(Integer point_id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(point_id);
	}

	@Override
	public List<ViewPoint> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(ViewPoint record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

}
