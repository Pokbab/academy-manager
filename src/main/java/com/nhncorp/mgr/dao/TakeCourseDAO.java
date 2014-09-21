package com.nhncorp.mgr.dao;

import java.util.List;

import com.nhncorp.mgr.vo.TakeCourse;

public interface TakeCourseDAO {

	void insertTakeCourse(TakeCourse takeCourse);

	void deleteTakeCourse(String code);

	List<TakeCourse> selectTakeCourseById(String id);

	void deleteTakeCourseByCourseCode(String code);


}
