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

import com.nhncorp.mgr.vo.User;

@Repository
public class UserDAOImpl implements UserDAO{
	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private SqlMapClientTemplate sqlMapClientTemplate;

	@SuppressWarnings("unused")
	@Resource
	private TransactionTemplate transactionTemplate;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectUserList() {

		return sqlMapClientTemplate.queryForList("user.selectUserList");
	}

	@Override
	public User selectUserById(String id) {
		
		return (User) sqlMapClientTemplate.queryForObject("user.selectUserById", id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertUser(User user) {
		
		sqlMapClientTemplate.insert("user.insertUser", user);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateUser(User user) {
		
		sqlMapClientTemplate.update("user.updateUser", user);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteUser(String id) {
		
		sqlMapClientTemplate.delete("user.deleteUser", id);
	}
	
	
}
