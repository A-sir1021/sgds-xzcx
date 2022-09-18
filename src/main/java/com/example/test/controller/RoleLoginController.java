package com.example.test.controller;

import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.example.Commen.Constant.Constant;
import com.example.Commen.CookieUtil.CookieUtil;
import com.example.Commen.MsgUtil.CodeMsg;
import com.example.Commen.MsgUtil.parse_Msg;
import com.example.Commen.Util.DateUtil;
import com.example.Commen.Util.MachineIp;
import com.example.test.pojo.Role;
import com.example.test.pojo.MsgVehicle;
import com.example.test.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.test.service.UserService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.context.WebContext;

/*登录以及校验密码*/
@Controller
@RequestMapping("/role")
public class RoleLoginController {

	@Autowired
	private DataSource dataSource;
	@Autowired
	UserService service;
	@Resource
	RoleService roleService;
	@Resource
	Role role;
	@Resource
	MsgVehicle msgVehicle;

	ModelAndView andView;
	Context ctx;
	Logger logger = LoggerFactory.getLogger(RoleLoginController.class);

	/**
	 * 登录页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = {"login","/"})
	public String login_load(MsgVehicle msgVehicle, HttpServletResponse response,
							 HttpServletRequest request) throws Exception {
		ctx = new Context();
		andView = new ModelAndView();
		andView.addObject("role", msgVehicle);
		andView.addObject("fail",msgVehicle.getFail());
		ctx.setVariable("qq","123");
		logger.info("主机ip+ip"+MachineIp.getHostIp()+";》》:"+MachineIp.getIpAddr(request));
		return "login/login";
	}

	@GetMapping(value = "/acc/{id}")
	@ResponseBody
	public String login_id(@PathVariable("id") Object acc) {
		System.out.println(acc);
		logger.info(this.dataSource+"acc"+acc);
		return "yes";
	}

	/**
	 * 校验账号
	 * @param acc
	 * @return
	 */
	@PostMapping(value = "acc")
	@ResponseBody
	public String login_post(@RequestBody(required = false) String acc) {
logger.error(		ctx.getVariableNames().toString());
		String acc1 = "";
		if (!acc.contains("=")){
			return CodeMsg.USER_NOT_EXITS.getCode();
		} else {
			String[] split = acc.split("=");
			acc1 = split[1];
		}
		Role role = roleService.selectByPhone(acc1);
		logger.info("接受的账号:"+acc+"role"+role);

		//TODO
		//可放到redis
		if (role != null ){
			return "succ";
		} else {
			return CodeMsg.USER_NOT_EXITS.getCode();
		}
	}

	/**
	 * 校验登录（手机号/密码）
	 * @param result
	 * @return
	 */
	@RequestMapping(value = {"/login/login_role"},method =RequestMethod.POST)
	public String login_pwd(RedirectAttributes ra,MsgVehicle msgVehicle,
							BindingResult result) {
		//andView.clear();
		String Phone = msgVehicle.getRolePhone();
		logger.info("phone:"+Phone+";   result"+result);
	    if(!result.hasErrors()){
	   		//校验密码
		   role = roleService.selectByPhone(Phone);
		   logger.debug("role>>>>",role);
		   String password = validatePassword(role,msgVehicle);

		   if(andView ==null){
			   return "redirect:/role/login";
		   }

		   if (password.equals("pass")){
			   msgVehicle.setRolePhone(role.getRolePhone());
			   ra.addFlashAttribute("msgVehicle",msgVehicle);
			   ra.addFlashAttribute("role",role);

			   return "redirect:/role/dire/";
		   } else {
		   }
		//报错
		}else{
	    	   logger.warn("result"+result);
			   parse_Msg.parse_Msg(result);
			   String defaultMessage = Objects.requireNonNull(result.getFieldError()).getDefaultMessage();
			   andView.addObject(CodeMsg.LOGIN_Fail.getCode(),defaultMessage);
			   msgVehicle.setFail(defaultMessage);
	   }

	    //不通过返回登录页
		ra.addFlashAttribute(msgVehicle);
		return "redirect:/role/login";
	}

	/**
	 * 校验密码账户
	 * @param role
	 * @param msgVehicle
	 * @return
	 */
	private String validatePassword(Role role, MsgVehicle msgVehicle){
		if(role ==null){
			msgVehicle.setFail(CodeMsg.USER_NOT_EXITS.getMsg())	;
			//throw new RuntimeException("账户输入错误");
		} else if (role.getRole_Pwd().equals(msgVehicle.getRole_Pwd())){
			msgVehicle.setSucc(CodeMsg.SUCCESS.getMsg());
			return "pass";
		} else {
			msgVehicle.setFail(CodeMsg.PASSWORD_ERROR.getMsg());
		}

		return "dispass";
	}

	@GetMapping(value = {"/dire"})
	private String  redi_main(Role role, MsgVehicle msgVehicle, RedirectAttributes ra,
							  HttpServletResponse response, HttpServletRequest request) throws Exception {
		andView = new ModelAndView();
		ra.addFlashAttribute(Constant.TOKEN_ROLE,role);
		if (role.getRoleAuth() != null && role.getRolePhone() != null){

			andView.addObject("role",role);
			CookieUtil.set(response,request,Constant.TOKEN_ROLE,role.getRoleName(),60*60);
			CookieUtil.set(response,request,Constant.TOKEN_ROLE_TIME, DateUtil.getDateTime_ymdhms(),60*60);
			CookieUtil.set(response,request,Constant.TOKEN_ROLE_Phone,role.getRolePhone(),60*60);
			CookieUtil.setJsonValue(response,request,Constant.TOKEN_ROLE_BEAN,role,60*15);
		}
		return "redirect:/main/";
	}

	@GetMapping(value = {"/login/login_role"})
	private String get_role(){
		if (msgVehicle == null) {
			new MsgVehicle().setFail(CodeMsg.LOGIN_Fail.getMsg());
		} else {
			msgVehicle.setFail(CodeMsg.LOGIN_TYPE.getMsg());
		}
		return "redirect:/role/login";
	}
}

