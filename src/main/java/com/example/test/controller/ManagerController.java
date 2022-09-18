/*
package com.example.test.controller;

import java.sql.Timestamp;
import java.util.List;

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

import com.example.test.pojo.PageDataResult;
import com.example.test.pojo.manager;

@Controller
public class ManagerController {

	@RequestMapping(value = "/Manager", method = RequestMethod.POST)
	@ResponseBody
	public PageDataResult getUsers(@RequestParam("page") Integer page,
			@RequestParam("limit") Integer limit, manager userSearch) {
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
	@RequestMapping(value="/AddManage", method = RequestMethod.POST)
	@ResponseBody
	public String Addtest(@Param("id")Integer id, @Param("username")String username,@Param("password")String password,@Param("pid")Integer pid,@Param("zindex")Integer zindex) throws Exception {

		System.out.println("test11111111111111111111111111111111111111111111111111111111");

		System.out.println("id："+id);
		System.out.println(" name："+username);
		service.insert(id, username, password, pid, zindex);
		return "success";
	}
	@RequestMapping(value = "/ManagerDeleteByName", method = RequestMethod.POST)
	@ResponseBody
	public String DeleteByName(Model model,HttpServletRequest request,
			HttpServletResponse response) throws Exception{  
		int id = Integer.parseInt(request.getParameter("id"));
		service.deleteByPrimaryKey(id);
		return "success";
	}
	@RequestMapping(value="/selectManagerAll", method = RequestMethod.POST)
	@ResponseBody
	public List<manager> selectAll(Model model,HttpServletRequest request,
			HttpServletResponse response) throws Exception{  
	
		return service.selectAll();
	}
		@RequestMapping(value="/UpdateManagerlogin", method = RequestMethod.POST)
		@ResponseBody
		public String update(@Param("id")Integer id, @Param("username")String username,@Param("password")String password,@Param("pid")Integer pid,@Param("zindex")Integer zindex) throws Exception {
			System.out.println("test11111111111111111111111111111111111111111111111111111111");
		
			System.out.println("id："+id);
			System.out.println("name："+username);
			service.updateByPrimaryKey(id, username, password, pid, zindex);
			return "success";
	}
		@RequestMapping(value="/queryByNameManager",method=RequestMethod.POST)
		@ResponseBody
		public manager getUserAndRoles(@RequestParam("id") Integer id) {
			 System.out.println("gggggggggggggggggggggggggg");
			return service.selectByPrimaryKey(id);
		}
		@RequestMapping(value="/UpdatePwd")
		@ResponseBody
		public String updatepwd(@Param("id")Integer id,@Param("password")String password) {
			System.out.println("test11111111111111111111111111111111111111111111111111111111");
		
			System.out.println("id："+id);
			System.out.println("name："+password);
			service.updatePwd(id, password);
			return "修改成功";
	}
		@RequestMapping(value="/updatepassword")
		public String hangle(Model model) {
			return "updatePwd";
		}
	@RequestMapping(value="/manager")
	public String manager(Model model) {
		return "manager";
	}
}
*/
