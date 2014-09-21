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

import com.nhncorp.mgr.vo.Course;
import com.nhncorp.mgr.vo.TakeCourse;
import com.nhncorp.mgr.vo.User;

public class TakeCourseDAOTest {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private static ClassPathXmlApplicationContext appContext;
	private static TakeCourseDAO takeCourseDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		appContext = new ClassPathXmlApplicationContext(
				new String[]{
						"file:web/WEB-INF/applicationContext.xml"
				});
		takeCourseDAO = appContext.getBean("takeCourseDAO", TakeCourseDAO.class);
	}
	
	@Before
	public void setUp() throws Exception {	}
	
	@Test
	public void testSelectTakeTakeCourseById() throws Exception {
		//when : 기능 수행(~했을 때)
		List<TakeCourse> list = takeCourseDAO.selectTakeCourseById("test");

		//then : 결과 확인(~가 되어야 한다)
		logger.info("testSelectTakeTakeCourseById : " + list);
	}

	@Test
	public void testInsertTakeTakeCourse() throws Exception {
		//Given : 선행조건(~상태라 가정하고)
		TakeCourse takeCourse = new TakeCourse();
		
		User user = new User();
		user.setId("test");
		takeCourse.setUser(user);
		
		Course course = new Course();
		course.setCode("0");
		
		takeCourse.setCourse(course);
		
		//when : 기능 수행(~했을 때)
		takeCourseDAO.insertTakeCourse(takeCourse);

		//then : 결과 확인(~가 되어야 한다)
		List<TakeCourse> list = takeCourseDAO.selectTakeCourseById("test");
		logger.info("testInsertTakeCourse : " + list);
	}

	@Test
	public void testDeleteTakeCourse() throws Exception {
		//Given : 선행조건(~상태라 가정하고)
		List<TakeCourse> list = takeCourseDAO.selectTakeCourseById("test");
		logger.info("testDeleteTakeCourse : 삭제 전 : " + list.size());
		
		//when : 기능 수행(~했을 때)
		takeCourseDAO.deleteTakeCourse("1");

		//then : 결과 확인(~가 되어야 한다)
		list = takeCourseDAO.selectTakeCourseById("test");
		logger.info("testDeleteTakeCourse : 삭제 후 : " + list.size());
	}
	
	@After
	public void tearDown() throws Exception{	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{	}
}
