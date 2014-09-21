package com.nhncorp.mgr.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nhncorp.mgr.bo.UserBO;
import com.nhncorp.mgr.vo.User;

@Controller
public class UserController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private UserBO userBO;
	
	@RequestMapping("/user/list.nhn")
	public ModelAndView UserList(){
		
		List<User> list = userBO.readUserList();
		
		ModelAndView mav = new ModelAndView();
        mav.addObject("list", list);
        mav.setViewName("mgr/user/list");
		
		return mav;
	}
	
	@RequestMapping("/user/addForm.nhn")
	public String addForm(User user){
		logger.info("addForm 시작");
		
		return "mgr/user/addForm";
	}
	
	@RequestMapping("/user/add.nhn")
    public String add(User user) {        
		userBO.addUser(user);
        return "redirect:/user/list.nhn";
    }
	
	@RequestMapping("/user/editForm.nhn")
    public ModelAndView editForm(User user) {
    	logger.info("editForm 시작");
    	
    	user = userBO.readUser(user.getId());
    	
    	ModelAndView mav = new ModelAndView("mgr/user/editForm");
        mav.addObject(user);
    	return mav;
    }
	
	@RequestMapping("/user/edit.nhn")
    public String edit(User user) {    
    	logger.info("edit 시작 " + user);
    	userBO.editUser(user);
        return "redirect:/user/list.nhn";
    }
	
	@RequestMapping("/user/remove.nhn")
    public String remove(String id) {        
    	logger.info("remove 시작 " + id);
    	userBO.removeUser(id);
    	return "redirect:/user/list.nhn";
    }
}
