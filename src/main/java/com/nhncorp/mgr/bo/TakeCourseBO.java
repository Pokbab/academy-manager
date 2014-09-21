package com.nhncorp.mgr.bo;

import java.util.List;
import java.util.Map;

import com.nhncorp.mgr.vo.Course;
import com.nhncorp.mgr.vo.TakeCourse;
import com.nhncorp.mgr.vo.User;

public interface TakeCourseBO {

	void removeTakeCourse(String code);

	List<TakeCourse> readTakeCourseList(String id);

	List<Course> addForm();

	Map<String, Object> addTakeCourse(Course course, User user);

}
