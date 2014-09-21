package com.nhncorp.mgr.dao;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import com.nhncorp.mgr.vo.Course;

@Repository
public class CourseDAOImpl implements CourseDAO{
	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private SqlMapClientTemplate sqlMapClientTemplate;

	@SuppressWarnings("unused")
	@Resource
	private TransactionTemplate transactionTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> selectCourseList() {

		return sqlMapClientTemplate.queryForList("course.selectCourseList");
	}

	@Override
	public Course selectCourseByCode(String code) {

		return (Course) sqlMapClientTemplate.queryForObject(
				"course.selectCourseByCode", code);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insertCourse(Course course) {

		sqlMapClientTemplate.insert("course.insertCourse", course);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateCourse(Course course) {

		sqlMapClientTemplate.update("course.updateCourse", course);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void increaseUserNum(String code) {

		sqlMapClientTemplate.update("course.increaseUserNum", code);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void decreaseUserNum(String code) {

		sqlMapClientTemplate.update("course.decreaseUserNum", code);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteCourse(String code) {

		sqlMapClientTemplate.delete("course.deleteCourse", code);
	}

}
