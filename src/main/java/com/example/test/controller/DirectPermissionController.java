/*
package com.example.test.controller;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.test.pojo.Comment;
import com.example.test.service.PermissionService;
import com.example.test.pojo.Permission;
import com.example.test.pojo.PageDataResult;
//import com.example.test.pojo.User;
@Controller
public class DirectPermissionController {
	
	@Autowired
	PermissionService service;	
	@RequestMapping(value = "/Permissiontest", method = RequestMethod.POST)
	@ResponseBody
	public PageDataResult getUsers(@RequestParam("page") Integer page,
			@RequestParam("limit") Integer limit, Permission userSearch) {
		System.out.println("1111111");
		PageDataResult pdr = new PageDataResult();
		try {
			if (null == page) {
				page = 1;
			}
			if (null == limit) {
				limit = 10;
			}
			// 获取用户和角色列表
			
			pdr = service.getArticles(userSearch, page, limit);
			
			//pdr = articleService.getArticles(userSearch, page, limit);
			//logger.debug("用户列表查询=pdr:" + pdr);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pdr;
	}
	
	@RequestMapping(value="/Addlogin", method = RequestMethod.POST)
	@ResponseBody
	public String Addtest(@Param("id")Integer id, @Param("name")String name,@Param("pid")Integer pid,@Param("zindex")Integer zindex,@Param("istype")Integer istype,@Param("descpt")String descpt,@Param("code")String code,@Param("icon")String icon,@Param("page")String page,@Param("insert_time")Timestamp insertTimeStart,@Param("update_time")Timestamp updateTimeStart) throws Exception {

		System.out.println("test11111111111111111111111111111111111111111111111111111111");

		System.out.println("id："+id);
		System.out.println("comment："+name);
		System.out.println("insertTimeStart"+insertTimeStart);
		System.out.println("updateTimeStart"+updateTimeStart);
		service.insert(id, name, pid, zindex, istype, descpt, code, icon, page, insertTimeStart, updateTimeStart);
		return "success";
	}
	@RequestMapping(value = "/DeleteByName", method = RequestMethod.POST)
	@ResponseBody
	public String DeleteByName(Model model,HttpServletRequest request,
			HttpServletResponse response) throws Exception{  
		int id = Integer.parseInt(request.getParameter("id"));
		service.deleteByPrimaryKey(id);
		return "success";
	}
	@RequestMapping(value="/selectAll", method = RequestMethod.POST)
	@ResponseBody
	public List<Permission> selectAll(Model model,HttpServletRequest request,
			HttpServletResponse response) throws Exception{  
	
		return service.selectAll();
	}
		@RequestMapping(value="/Updatelogin", method = RequestMethod.POST)
		@ResponseBody
		public String update(@Param("id")Integer id, @Param("name")String name,@Param("pid")Integer pid,@Param("zindex")Integer zindex,@Param("istype")Integer istype,@Param("descpt")String descpt,@Param("code")String code,@Param("icon")String icon,@Param("page")String page,@Param("insert_time")Timestamp insertTimeStart,@Param("update_time")Timestamp updateTimeStart) throws Exception {
			System.out.println("test11111111111111111111111111111111111111111111111111111111");
		
			System.out.println("id："+id);
			System.out.println("comment："+name);
			System.out.println("insert_time："+insertTimeStart);
			System.out.println("update_time："+updateTimeStart);
			service.updateByPrimaryKey(id, name, pid, zindex, istype, descpt, code, icon, page, insertTimeStart, updateTimeStart);
			return "success";
	}
		@RequestMapping(value="/queryByName",method=RequestMethod.POST)
		public String getUserAndRoles(@RequestParam("id") Integer id,Model model) {
			 System.out.println("gggggggggggggggggggggggggg");
			 Permission per = service.selectByPrimaryKey(id);
			 model.addAttribute("per",per);
			return "PerQyeById";
		}
		*/
/*@RequestMapping(value = "/queryByName", method = RequestMethod.POST)
		@ResponseBody
		public List<Permission> getRoles(@Param("name")Integer id) {
			System.out.println("eeeeeeeeeeeeqqqqqqqqqqqqqqqq");
			List<Permission> roles=null;
			try {
				roles= service.selectByPrimaryKey(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(roles);
			return roles;
		}*//*

		*/
/*@RequestMapping(value = "/queryByName", method = RequestMethod.POST)
		@ResponseBody
		public PageDataResult getPermissionById(@RequestParam("page") Integer page,
				@RequestParam("limit") Integer limit, Permission userSearch,@Param("id")Integer id) {
			System.out.println("1111111");
			PageDataResult pdr = new PageDataResult();
			try {
				if (null == page) {
					page = 1;
				}
				if (null == limit) {
					limit = 10;
				}
				// 获取用户和角色列表
				
				pdr = service.getPermissionById(userSearch, page, limit, id);
				
				//pdr = articleService.getArticles(userSearch, page, limit);
				//logger.debug("用户列表查询=pdr:" + pdr);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return pdr;
		}*//*

		
	@RequestMapping("/Permission")
	public String Permission(Model model){  
		return "Permission";
	}
	
	
}
*/
