package com.nhncorp.mgr.bo;

import java.util.List;
import java.util.Map;

import com.nhncorp.mgr.vo.Academy;
import com.nhncorp.mgr.vo.Course;

public interface CourseBO {

	List<Course> readCourseList();

	void addCourse(Course course);

	void editCourse(Course course);

	void removeCourse(String code);

	List<Academy> addForm();

	Map<String, Object> editForm(String code);

}
