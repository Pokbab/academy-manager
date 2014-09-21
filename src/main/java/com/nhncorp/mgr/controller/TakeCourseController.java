package com.nhncorp.mgr.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nhncorp.mgr.bo.TakeCourseBO;
import com.nhncorp.mgr.vo.Course;
import com.nhncorp.mgr.vo.TakeCourse;
import com.nhncorp.mgr.vo.User;

@Controller
public class TakeCourseController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private TakeCourseBO takeCourseBO;
	
	@RequestMapping("/takeCourse/list.nhn")
	public ModelAndView myCourseList(HttpSession session){
		
		User user = (User) session.getAttribute("USER");
		List<TakeCourse> list = takeCourseBO.readTakeCourseList(user.getId());
		
		ModelAndView mav = new ModelAndView("student/takeCourse/list");
        mav.addObject("list", list);
		
		return mav;
	}
	
	@RequestMapping("/takeCourse/addForm.nhn")
	public ModelAndView addForm(){
		logger.info("addForm 시작");
		
		List<Course> list = takeCourseBO.addForm();
		
		ModelAndView mav = new ModelAndView("student/takeCourse/addForm");
        mav.addObject("list", list);
        
    	return mav;
	}
	
	@RequestMapping("/takeCourse/add.nhn")
    public ModelAndView add(Course course, HttpSession session) {
		User user = (User) session.getAttribute("USER");
		logger.info("add 시작 : course : "+course+", id : "+user.getId());
		
		takeCourseBO.addTakeCourse(course, user);
		
		return new ModelAndView("redirect:/takeCourse/list.nhn");
    }
	
	@RequestMapping("/takeCourse/remove.nhn")
    public String remove(String code) {        
    	logger.info("remove 시작 " + code);
    	takeCourseBO.removeTakeCourse(code);
    	return "redirect:/takeCourse/list.nhn";
    }
}
