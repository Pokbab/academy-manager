package com.nhncorp.mgr.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nhncorp.mgr.dao.CourseDAO;
import com.nhncorp.mgr.dao.TakeCourseDAO;
import com.nhncorp.mgr.vo.Course;
import com.nhncorp.mgr.vo.TakeCourse;
import com.nhncorp.mgr.vo.User;

@Service("takeCourseBO")
public class TakeCourseBOImpl implements TakeCourseBO{

	@Resource(name = "takeCourseDAO")
    private TakeCourseDAO takeCourseDAO;
	@Resource(name = "courseDAO")
    private CourseDAO courseDAO;
	
	
	@Override
	public List<TakeCourse> readTakeCourseList(String id) {
		
		List<TakeCourse> list = takeCourseDAO.selectTakeCourseById(id);
		for (TakeCourse takeCourse : list) {
			
			Course course = takeCourse.getCourse();
			course = courseDAO.selectCourseByCode(course.getCode());
			takeCourse.setCourse(course);
		}
		
		return list;
	}
	
	@Override
	public List<Course> addForm() {

		List<Course> list = courseDAO.selectCourseList();
		
		return list;
	}
	
	@Override
	public Map<String, Object> addTakeCourse(Course course, User user) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<TakeCourse> list = takeCourseDAO.selectTakeCourseById(user.getId());
		for (TakeCourse takeCourse : list) {
			
			String Coursecode = takeCourse.getCourse().getCode();
			
			if (Coursecode.equals(course.getCode())) {
				
				result.put("STATUS", "ERROR");
				result.put("MESSAGE", "이미 수강하고 있는 강의입니다.");
				
				return result;
			}
		}
		TakeCourse takeCourse = new TakeCourse();
		takeCourse.setCourse(course);
		takeCourse.setUser(user);
		
		takeCourseDAO.insertTakeCourse(takeCourse);
		courseDAO.increaseUserNum(course.getCode());
		
		result.put("STATUS", "OK");
		return result;
	}
	
	
	@Override
	public void removeTakeCourse(String code){
		
		takeCourseDAO.deleteTakeCourse(code);
		courseDAO.decreaseUserNum(code);
	}


}
