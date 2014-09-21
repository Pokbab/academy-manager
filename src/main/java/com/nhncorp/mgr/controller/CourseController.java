package com.nhncorp.mgr.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nhncorp.mgr.bo.CourseBO;
import com.nhncorp.mgr.vo.Academy;
import com.nhncorp.mgr.vo.Course;

@Controller
public class CourseController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private CourseBO courseBO;
	
	@RequestMapping("/course/list.nhn")
	public ModelAndView courseList(){
		logger.info("courseList 시작" );
		
		List<Course> list = courseBO.readCourseList();
		
		ModelAndView mav = new ModelAndView("mgr/course/list");
        mav.addObject("list", list);
		
		return mav;
	}
	
	@RequestMapping("/course/addForm.nhn")
	public ModelAndView addForm(Course course){
		logger.info("addForm 시작");
		
		List<Academy> list = courseBO.addForm();
		
		ModelAndView mav = new ModelAndView("mgr/course/addForm");
        mav.addObject("list", list);
		
		return mav;
	}
	
	@RequestMapping("/course/add.nhn")
    public String add(Course course){        
		courseBO.addCourse(course);
        return "redirect:/course/list.nhn";
    }
	
	@RequestMapping("/course/editForm.nhn")
    public ModelAndView editForm(Course course) {
    	logger.info("editForm 시작");
    	
    	Map<String, Object> result = courseBO.editForm(course.getCode());
    	
    	ModelAndView mav = new ModelAndView("mgr/course/editForm");
        mav.addAllObjects(result);
    	return mav;
    }
	
	@RequestMapping("/course/edit.nhn")
    public String edit(Course course) {    
    	logger.info("edit 시작 " + course);
    	courseBO.editCourse(course);
        return "redirect:/course/list.nhn";
    }
	
	@RequestMapping("/course/remove.nhn")
    public String remove(String code) {        
    	logger.info("remove 시작 " + code);
    	courseBO.removeCourse(code);
    	return "redirect:/course/list.nhn";
    }
}
