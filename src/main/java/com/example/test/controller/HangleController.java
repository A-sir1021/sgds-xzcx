/*
package com.example.test.controller;

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

import com.example.test.dao.HangleMapper;
import com.example.test.pojo.Hangle;
import com.example.test.pojo.PageDataResult;
import com.example.test.service.HangleService;
@Controller
public class HangleController {
	@Autowired
	HangleService service;
@RequestMapping("/hangle")
	public String hangle(Model model) {
		return "hangle";
	}
@RequestMapping(value = "/Hangle", method = RequestMethod.POST)
@ResponseBody
public PageDataResult getUsers(@RequestParam("page") Integer page,
		@RequestParam("limit") Integer limit, Hangle userSearch) {
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
@RequestMapping(value="/AddHangle", method = RequestMethod.POST)
@ResponseBody
public String Addtest(@Param("id")Integer id, @Param("name")String name,@Param("firm")String firm,@Param("consumer")String consumer,@Param("ship")String ship,@Param("delivery")String delivery,@Param("logistics")String logistics) throws Exception {

	System.out.println("test11111111111111111111111111111111111111111111111111111111");

	System.out.println("id："+id);
	System.out.println(" name："+name);
	service.insert(id, name, firm, consumer, ship, delivery, logistics);
	return "success";
}
@RequestMapping(value = "/HangleDeleteByName", method = RequestMethod.POST)
@ResponseBody
public String DeleteByName(Model model,HttpServletRequest request,
		HttpServletResponse response) throws Exception{  
	int id = Integer.parseInt(request.getParameter("id"));
	service.deleteByPrimaryKey(id);
	return "success";
}
@RequestMapping(value="/selectHangleAll", method = RequestMethod.POST)
@ResponseBody
public List<Hangle> selectAll(Model model,HttpServletRequest request,
		HttpServletResponse response) throws Exception{  

	return service.selectAll();
}
	@RequestMapping(value="/UpdateHanglelogin", method = RequestMethod.POST)
	@ResponseBody
	public String update(@Param("id")Integer id, @Param("name")String name,@Param("firm")String firm,@Param("consumer")String consumer,@Param("ship")String ship,@Param("delivery")String delivery,@Param("logistics")String logistics) throws Exception {
		System.out.println("test11111111111111111111111111111111111111111111111111111111");
	
		System.out.println("id："+id);
		System.out.println("name："+name);
		service.updateByPrimaryKey(id, name, firm, consumer, ship, delivery, logistics);
		return "success";
}
	@RequestMapping(value="/queryByNameHangle",method=RequestMethod.POST)
	@ResponseBody
	public Hangle getUserAndRoles(@Param("id") Integer id) {
		 System.out.println("gggggggggggggggggggggggggg");
		return service.selectByPrimaryKey(id);
	}
}
*/
