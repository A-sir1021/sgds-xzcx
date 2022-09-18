/*
package com.example.test.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.dao.PermissionMapper;
import com.example.test.pojo.PageDataResult;
import com.example.test.pojo.Permission;
import com.example.test.service.PermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	PermissionMapper mapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	

	@Override
	public Permission selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Permission> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}



	@Override
	public int insert(Integer id, String name, Integer pid, Integer zindex, Integer istype, String descpt, String code,
			String icon, String page, Timestamp insert_time, Timestamp update_time) {
		// TODO Auto-generated method stub
		return mapper.insert(id, name, pid, zindex, istype, descpt, code, icon, page, insert_time, update_time);
	}



	@Override
	public int updateByPrimaryKey(Integer id, String name, Integer pid, Integer zindex, Integer istype, String descpt,
			String code, String icon, String page, Timestamp insert_time, Timestamp update_time) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(id, name, pid, zindex, istype, descpt, code, icon, page, insert_time, update_time);
	}



	@Override
	public List<Permission> permList() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public PageDataResult getArticles(Permission userSearch, int page, int limit) {
		// TODO Auto-generated method stub
		PageDataResult pdr = new PageDataResult();
		PageHelper.startPage(page, limit);
		List<Permission> urList =  mapper.selectAll();
		// 获取分页查询后的数据
		PageInfo<Permission> pageInfo = new PageInfo<>(urList);
		// 设置获取到的总记录数total：
		pdr.setTotals(Long.valueOf(pageInfo.getTotal()).intValue());
		
		pdr.setList(urList);
		return pdr;
	}



	@Override
	public List<Permission> getUserPerms(Integer id) {
		// TODO Auto-generated method stub
		return mapper.getUserPerms(id);
	}



	*/
/*@Override
	public PageDataResult getPermissionById(Permission userSearch, int page, int limit, Integer id) {
		// TODO Auto-generated method stub
		PageDataResult pdr = new PageDataResult();
		PageHelper.startPage(page, limit);
		List<Permission> urList =  mapper.selectByPrimaryKey(id);
		// 获取分页查询后的数据
		PageInfo<Permission> pageInfo = new PageInfo<>(urList);
		// 设置获取到的总记录数total：
		pdr.setTotals(Long.valueOf(pageInfo.getTotal()).intValue());
		
		pdr.setList(urList);
		return pdr;
	}
	*//*


	

}
*/
