package com.example.test.service.impl;

import com.example.test.controller.RoleLoginController;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.test.dao.RoleMapper;
import com.example.test.pojo.Role;
import com.example.test.service.RoleService;

import javax.annotation.Resource;

@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleMapper mapper;

	Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Role record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public Role selectByPrimaryKey(String rolePhone) {
		if(rolePhone != null && !rolePhone.isEmpty()){
			logger.warn(rolePhone);
			return mapper.selectOneByPhone(rolePhone);
		} else {
			return null;
		}

	}

	@Override
	public Role selectByPhone(String rolePhone) {
		if (rolePhone != null && !rolePhone.isEmpty()) {

			return mapper.selectOneByPhone(rolePhone);
		} else {
			return null;
		}
	}
	/*@Override
	public List<Role> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}*/

	/*@Override
	public int updateByPrimaryKey(String record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}*/

}
