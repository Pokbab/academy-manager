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

import com.nhncorp.mgr.vo.TakeCourse;

@Repository
public class TakeCourseDAOImpl implements TakeCourseDAO{
	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private SqlMapClientTemplate sqlMapClientTemplate;

	@SuppressWarnings("unused")
	@Resource
	private TransactionTemplate transactionTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<TakeCourse> selectTakeCourseById(String id) {
		
		return sqlMapClientTemplate.queryForList("takeCourse.selectTakeCourseById", id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insertTakeCourse(TakeCourse takeCourse) {

		sqlMapClientTemplate.insert("takeCourse.insertTakeCourse", takeCourse);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteTakeCourse(String code) {

		sqlMapClientTemplate.delete("takeCourse.deleteTakeCourse", code);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteTakeCourseByCourseCode(String code) {

		sqlMapClientTemplate.delete("takeCourse.deleteTakeCourseByCourseCode", code);
	}

}
