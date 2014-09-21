package com.nhncorp.mgr.dao;

import java.util.List;

import com.nhncorp.mgr.vo.Course;

public interface CourseDAO {

	List<Course> selectCourseList();

	Course selectCourseByCode(String code);

	void insertCourse(Course course);

	void updateCourse(Course course);

	void deleteCourse(String code);

	void increaseUserNum(String code);

	void decreaseUserNum(String code);

}
