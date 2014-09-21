package com.nhncorp.mgr.dao;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nhncorp.mgr.vo.User;

public class UserDAOTest {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private static ClassPathXmlApplicationContext appContext;
	private static UserDAOImpl userDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		appContext = new ClassPathXmlApplicationContext(
				new String[]{
						"file:web/WEB-INF/applicationContext.xml"
				});
		userDAO = appContext.getBean("userDAO", UserDAOImpl.class);
	}
	
	@Before
	public void setUp() throws Exception {	}
	
	@Test
	public void testSelectUserList() throws Exception {
		//when : 기능 수행(~했을 때)
		List<User> list = userDAO.selectUserList();
		
		//then : 결과 확인(~가 되어야 한다)
		logger.info("testSelectUserList : " + list);
	}

	@Test
	public void testSelectUserById() throws Exception {
		//when : 기능 수행(~했을 때)
		User user = userDAO.selectUserById("admin");

		//then : 결과 확인(~가 되어야 한다)
		logger.info("testSelectUserById : " + user);
	}

	@Test
	public void testInsertUser() throws Exception {
		//Given : 선행조건(~상태라 가정하고)
		User user = new User();
		user.setId("pokbab");
		user.setPassword("1234");
		user.setName("최강훈");
		user.setPhone("010-1234-1234");
		user.setAge("26");
		user.setType("A");
		
		//when : 기능 수행(~했을 때)
		userDAO.insertUser(user);

		//then : 결과 확인(~가 되어야 한다)
		user = userDAO.selectUserById("pokbab");
		logger.info("testInsertUser : " + user);
	}

	@Test
	public void testUpdateUser() throws Exception {
		//Given : 선행조건(~상태라 가정하고)
		User user = userDAO.selectUserById("pokbab");
		logger.info("testUpdateUser : 변경 전 : " + user);
		
		user.setId("pokbab");
		user.setPassword("1234");
		user.setName("홈길똥");
		user.setPhone("010-1111-1111");
		user.setAge("55");
		user.setType("A");
		
		//when : 기능 수행(~했을 때)
		userDAO.updateUser(user);

		//then : 결과 확인(~가 되어야 한다)
		user = userDAO.selectUserById("pokbab");
		logger.info("testUpdateUser : 변경 후 : " + user);
	}

	@Test
	public void testDeleteUser() throws Exception {
		//Given : 선행조건(~상태라 가정하고)
		User user = userDAO.selectUserById("pokbab");
		logger.info("testDeleteUser : 삭제 전 : " + user);
		
		//when : 기능 수행(~했을 때)
		userDAO.deleteUser("pokbab");

		//then : 결과 확인(~가 되어야 한다)
		user = userDAO.selectUserById("pokbab");
		logger.info("testDeleteUser : 삭제 후 : " + user);
	}
	
	@After
	public void tearDown() throws Exception{	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{	}
}
