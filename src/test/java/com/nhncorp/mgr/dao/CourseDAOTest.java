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

import com.nhncorp.mgr.vo.Academy;
import com.nhncorp.mgr.vo.Course;

public class CourseDAOTest {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private static ClassPathXmlApplicationContext appContext;
	private static CourseDAO courseDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		appContext = new ClassPathXmlApplicationContext(
				new String[]{
						"file:web/WEB-INF/applicationContext.xml"
				});
		courseDAO = appContext.getBean("courseDAO", CourseDAO.class);
	}
	
	@Before
	public void setUp() throws Exception {	}
	
	@Test
	public void testSelectCourseList() throws Exception {
		//when : 기능 수행(~했을 때)
		List<Course> list = courseDAO.selectCourseList();
		
		//then : 결과 확인(~가 되어야 한다)
		logger.info("testSelectCourseList : " + list);
	}

	@Test
	public void testSelectCourseByCode() throws Exception {
		//when : 기능 수행(~했을 때)
		Course course = courseDAO.selectCourseByCode("0");

		//then : 결과 확인(~가 되어야 한다)
		logger.info("testSelectCourseByCode : " + course);
	}

	@Test
	public void testInsertCourse() throws Exception {
		//Given : 선행조건(~상태라 가정하고)
		Course course = new Course();
		course.setName("JAVA Core");
		Academy academy = new Academy();
		academy.setCode("0");
		course.setAcademy(academy);
		
		//when : 기능 수행(~했을 때)
		courseDAO.insertCourse(course);

		//then : 결과 확인(~가 되어야 한다)
		course = courseDAO.selectCourseByCode("1");
		logger.info("testInsertCourse : " + course);
	}
	
	@Test
	public void testUpdateCourse() throws Exception {
		//Given : 선행조건(~상태라 가정하고)
		Course course = courseDAO.selectCourseByCode("1");
		logger.info("testUpdateCourse : 변경 전 : " + course);
		
		course.setCode("1");
		course.setName("C언어");
		Academy academy = new Academy();
		academy.setCode("0");
		course.setAcademy(academy);
		
		//when : 기능 수행(~했을 때)
		courseDAO.updateCourse(course);

		//then : 결과 확인(~가 되어야 한다)
		course = courseDAO.selectCourseByCode("1");
		logger.info("testUpdateCourse : 변경 후 : " + course);
	}

	@Test
	public void testDeleteCourse() throws Exception {
		//Given : 선행조건(~상태라 가정하고)
		Course course = courseDAO.selectCourseByCode("1");
		logger.info("testDeleteCourse : 삭제 전 : " + course);
		
		//when : 기능 수행(~했을 때)
		courseDAO.deleteCourse("1");

		//then : 결과 확인(~가 되어야 한다)
		course = courseDAO.selectCourseByCode("1");
		logger.info("testDeleteCourse : 삭제 후 : " + course);
	}
	
	@After
	public void tearDown() throws Exception{	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{	}
}
