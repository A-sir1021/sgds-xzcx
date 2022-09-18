/*
package com.example.test.controller;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.example.test.pojo.Permission;
import com.example.test.pojo.PageDataResult;
//import com.example.test.pojo.User;

@Controller
public class DirectController {
	
	@Resource
	CommentService service;
	
	
	
	@RequestMapping(value = "/QuerySpacetest", method = RequestMethod.POST)
	@ResponseBody
	public PageDataResult getUsers(@RequestParam("page") Integer page,
			@RequestParam("limit") Integer limit, Comment userSearch) {
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
			

			//pdr = articleService.getArticles(userSearch, page, limit);
			//logger.debug("用户列表查询=pdr:" + pdr);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pdr;
	}
	
	
	@RequestMapping(value="/QuerySpace")
	@ResponseBody
	public List<Comment> QuerySpacetest(Model model,HttpServletRequest request,
			HttpServletResponse response)throws Exception{  
	JSONArray array = null;
        List<Comment> com = service.selectAll();
        //将list集合装换成json对象
        array= JSONArray.parseArray(JSON.toJSONString(com));            
        response.setCharacterEncoding("utf-8");
            //得到输出流
        PrintWriter respWritter = response.getWriter();
            //将JSON格式的对象toString()后发送
        respWritter.append(array.toString());

  return service.selectAll();

		List<Comment> list = service.selectAll();
		model.addAttribute("list", list);  
		return list;
List<Comment> list = service.selectAll();
		String result = JSON.toJSONString(list);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		//model.addAttribute("list", list);  
		return "success";

    }
	@RequestMapping("/login")
	public String login(Model model){  
		return "/home";
	}
	@RequestMapping("/addmiddle")
	public String addmiddle(Model model){  
		System.out.println("1111111111111111111111111111111111111111111111111");
		return "addmiddle";
	}
	@RequestMapping("/Deletemiddle")
	public String Delmiddle(Model model){  
		return "delmiddle";
	}
	@RequestMapping("/updatemiddle")
	public String updatemiddle(Model model){  
		return "updatemiddle";
	}
	@RequestMapping("/Article")
	public String Article(Model model){  
		return "comment";
	}
	@RequestMapping("/member")
	public String Manage(Model model){  
		return "member";
	}
}
*/
