package com.nhncorp.mgr.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nhncorp.mgr.dao.AcademyDAO;
import com.nhncorp.mgr.dao.CourseDAO;
import com.nhncorp.mgr.dao.TakeCourseDAO;
import com.nhncorp.mgr.vo.Academy;
import com.nhncorp.mgr.vo.Course;

@Service("courseBO")
public class CourseBOImpl implements CourseBO{

	@Resource(name = "courseDAO")
    private CourseDAO courseDAO;
	@Resource(name = "academyDAO")
    private AcademyDAO academyDAO;
	@Resource(name = "takeCourseDAO")
    private TakeCourseDAO takeCourseDAO;
	
	@Override
	public List<Course> readCourseList(){
		
		return courseDAO.selectCourseList();
	}
	
	@Override
	public List<Academy> addForm() {

		return academyDAO.selectAcademyList();
	}
	
	@Override
	public void addCourse(Course Course){
		
		courseDAO.insertCourse(Course);
	}
	
	@Override
	public Map<String, Object> editForm(String code) {

		Course course = courseDAO.selectCourseByCode(code);
		List<Academy> list = academyDAO.selectAcademyList();
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("course", course);
		result.put("list", list);
		
		return result;
	}
	
	@Override
	public void editCourse(Course Course){
		
		courseDAO.updateCourse(Course);
	}
	
	@Override
	public void removeCourse(String code){
		
		courseDAO.deleteCourse(code);
		takeCourseDAO.deleteTakeCourseByCourseCode(code);
	}

}
