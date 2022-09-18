package com.example.test.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.dao.UserMapper;
import com.example.test.pojo.User;
import com.example.test.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper mapper;
	@Override
	public int deleteByPrimaryKey(Integer user_id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(user_id);
	}

	
	@Override
	public User selectByPrimaryKey(Integer user_id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(user_id);
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}




	@Override
	public int insert(Integer id, String username, String password, Timestamp last_login_time, String last_login_ip,
			String mobile, String email) {
		// TODO Auto-generated method stub
		return mapper.insert(id, username, password, last_login_time, last_login_ip, mobile, email);
	}


	@Override
	public int updateByPrimaryKey(Integer id, String username, String password, Timestamp last_login_time,
			String last_login_ip, String mobile, String email) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(id, username, password, last_login_time, last_login_ip, mobile, email);
	}


	@Override
	public String selectByPassword(String username) {
		// TODO Auto-generated method stub
		return mapper.selectByPassword(username);
	}

}
