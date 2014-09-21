package com.nhncorp.mgr.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nhncorp.mgr.bo.LoginBO;
import com.nhncorp.mgr.vo.User;

@Controller
public class CommonController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private LoginBO loginBO;
	
	@RequestMapping("/loginForm.nhn")
	public String loginForm(){
		
        return "login";
	}
	
	@RequestMapping("/login.nhn")
	public ModelAndView login(User user, HttpSession session){
		logger.info("login 시작 : user : "+user);
		
		Map<String, Object> result = loginBO.login(user);
		
		String status = (String) result.get("STATUS");
		
		if (status.equals("ERROR")) {
			
			return new ModelAndView("login", result);
			
		}else{
			user = (User) result.get("USER");
			session.setAttribute("USER", user);
			
			if ("M".equals(user.getType())) {
				return new ModelAndView("redirect:/manager.nhn");
			}else{
				return new ModelAndView("redirect:/student.nhn");
			}
		}
	}
	
	@RequestMapping("/manager.nhn")
	public String managerPage(){
		
        return "mgr/main";
	}
	
	@RequestMapping("/student.nhn")
	public String studentPage(){
		
        return "student/main";
	}
	
	
}
