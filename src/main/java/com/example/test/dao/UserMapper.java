package com.example.test.dao;

import com.example.test.pojo.User;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserMapper {

	  int deleteByPrimaryKey(@Param("id")Integer user_id);

	    int insert(@Param("id")Integer id,@Param("username")String username,@Param("password")String password,@Param("last_login_time")Timestamp last_login_time,@Param("last_login_ip")String last_login_ip,@Param("mobile")String mobile,@Param("email")String email);

	    User selectByPrimaryKey(@Param("id")Integer user_id);

	    List<User> selectAll();

	    int updateByPrimaryKey(@Param("id")Integer id,@Param("username")String username,@Param("password")String password,@Param("last_login_time")Timestamp last_login_time,@Param("last_login_ip")String last_login_ip,@Param("mobile")String mobile,@Param("email")String email);

	    String selectByPassword(@Param("username")String username);
}