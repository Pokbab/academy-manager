package com.nhncorp.mgr.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nhncorp.mgr.bo.AcademyBO;
import com.nhncorp.mgr.vo.Academy;

@Controller
public class AcademyController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private AcademyBO academyBO;
	
	@RequestMapping("/academy/list.nhn")
	public ModelAndView academyList(){
		
		List<Academy> list = academyBO.readAcademyList();
		
		ModelAndView mav = new ModelAndView();
        mav.addObject("list", list);
        mav.setViewName("mgr/academy/list");
		
		return mav;
	}
	
	@RequestMapping("/academy/addForm.nhn")
	public String addForm(Academy academy){
		logger.info("addForm 시작");
		
		return "mgr/academy/addForm";
	}
	
	@RequestMapping("/academy/add.nhn")
    public String add(Academy academy) {        
		academyBO.addAcademy(academy);
        return "redirect:/academy/list.nhn";
    }
	
	@RequestMapping("/academy/editForm.nhn")
    public ModelAndView editForm(Academy academy) {
    	logger.info("editForm 시작");
    	
    	academy = academyBO.readAcademy(academy.getCode());
    	
    	ModelAndView mav = new ModelAndView("mgr/academy/editForm");
        mav.addObject(academy);
    	return mav;
    }
	
	@RequestMapping("/academy/edit.nhn")
    public String edit(Academy academy) {    
    	logger.info("edit 시작 " + academy);
    	academyBO.editAcademy(academy);
        return "redirect:/academy/list.nhn";
    }
	
	@RequestMapping("/academy/remove.nhn")
    public String remove(String code) {        
    	logger.info("remove 시작 " + code);
    	academyBO.removeAcademy(code);
    	return "redirect:/academy/list.nhn";
    }
}
