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

import com.nhncorp.mgr.vo.Academy;

@Repository
public class AcademyDAOImpl implements AcademyDAO{
	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private SqlMapClientTemplate sqlMapClientTemplate;

	@SuppressWarnings("unused")
	@Resource
	private TransactionTemplate transactionTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<Academy> selectAcademyList() {

		return sqlMapClientTemplate.queryForList("academy.selectAcademyList");
	}

	@Override
	public Academy selectAcademyByCode(String code) {

		return (Academy) sqlMapClientTemplate.queryForObject(
				"academy.selectAcademyByCode", code);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insertAcademy(Academy academy) {

		sqlMapClientTemplate.insert("academy.insertAcademy", academy);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateAcademy(Academy academy) {

		sqlMapClientTemplate.update("academy.updateAcademy", academy);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteAcademy(String code) {

		sqlMapClientTemplate.delete("academy.deleteAcademy", code);
	}

}
