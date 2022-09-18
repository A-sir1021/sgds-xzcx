/*
package com.example.test.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test.pojo.Comment;
import com.example.test.pojo.Permission;



@Controller
@RequestMapping("/per")
public class PermissionController {

	@Autowired
	PermissionService service;
	
	@RequestMapping("/QuerySpace")
	@ResponseBody
	public List<Permission> QuerySpacetest(Model model){  
		//List<Comment> list = service.selectAll();
		return service.selectAll();
		}
	*/
/*@RequestMapping("/Addlogin")
	
	public String Addtest(@Param("id")Integer id, @Param("name")String name,@Param("pid")Integer pid,@Param("zindex")Integer zindex,@Param("istype")Integer istype,@Param("descpt")String descpt,@Param("code")String code,@Param("icon")String icon,@Param("page")String page,@Param("insert_time")Date insert_time,@Param("update_time")Date update_time) throws Exception {

		System.out.println("test11111111111111111111111111111111111111111111111111111111");

		System.out.println("id："+id);
		System.out.println("comment："+name);
		System.out.println("insert_time"+insert_time);
	
		service.insert(id, name, pid, zindex, istype, descpt, code, icon, page, insert_time, update_time);
		return "success";
	}*//*

	@RequestMapping("/DeleteByName")
	public String DeleteByName(Model model,HttpServletRequest request,
			HttpServletResponse response) throws Exception{  
		int id = Integer.parseInt(request.getParameter("id"));
		service.deleteByPrimaryKey(id);
		return "success";
	}
*/
/*	@RequestMapping("/Updatelogin")
	public String Update(@Param("id")Integer id, @Param("name")String name,@Param("pid")Integer pid,@Param("zindex")Integer zindex,@Param("istype")Integer istype,@Param("descpt")String descpt,@Param("code")String code,@Param("icon")String icon,@Param("page")String page,@Param("insert_time")Date insert_time,@Param("update_time")Date update_time) throws Exception {
System.out.println("test11111111111111111111111111111111111111111111111111111111");
		
		System.out.println("id："+id);
		System.out.println("comment："+name);
		service.updateByPrimaryKey(id, name, pid, zindex, istype, descpt, code, icon, page, insert_time, update_time);
		return "/Permission/success";
	}*//*

	@RequestMapping("/addmiddle")
	public String addmiddle(Model model){  
		return "/Permission/addmiddle";
	}
	@RequestMapping("/Deletemiddle")
	public String Delmiddle(Model model){  
		return "/Permission/delmiddle";
	}
	@RequestMapping("/updatemiddle")
	public String updatemiddle(Model model){  
		return "/Permission/updatemiddle";
	}
	@RequestMapping("/controller")
	public String home(Model model){  
		return "/Permission/controller";
	}
}*/
