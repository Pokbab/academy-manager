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

public class AcademyDAOTest {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private static ClassPathXmlApplicationContext appContext;
	private static AcademyDAO academyDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		appContext = new ClassPathXmlApplicationContext(
				new String[]{
						"file:web/WEB-INF/applicationContext.xml"
				});
		academyDAO = appContext.getBean("academyDAO", AcademyDAO.class);
	}
	
	@Before
	public void setUp() throws Exception {	}
	
	@Test
	public void testSelectAcademyList() throws Exception {
		//when : 기능 수행(~했을 때)
		List<Academy> list = academyDAO.selectAcademyList();
		
		//then : 결과 확인(~가 되어야 한다)
		logger.info("testSelectAcademyList : " + list);
	}

	@Test
	public void testSelectAcademyByCode() throws Exception {
		//when : 기능 수행(~했을 때)
		Academy academy = academyDAO.selectAcademyByCode("0");

		//then : 결과 확인(~가 되어야 한다)
		logger.info("testSelectAcademyByCode : " + academy);
	}

	@Test
	public void testInsertAcademy() throws Exception {
		//Given : 선행조건(~상태라 가정하고)
		Academy academy = new Academy();
		academy.setName("삼성SDS");
		academy.setPhone("010-1234-1234");
		academy.setAddress("서울시 어딘가");
		
		//when : 기능 수행(~했을 때)
		academyDAO.insertAcademy(academy);

		//then : 결과 확인(~가 되어야 한다)
		academy = academyDAO.selectAcademyByCode("1");
		logger.info("testInsertAcademy : " + academy);
	}

	@Test
	public void testUpdateAcademy() throws Exception {
		//Given : 선행조건(~상태라 가정하고)
		Academy academy = academyDAO.selectAcademyByCode("1");
		logger.info("testUpdateAcademy : 변경 전 : " + academy);
		
		academy.setCode("1");
		academy.setName("삼성SDS");
		academy.setPhone("010-1234-1234");
		academy.setAddress("서울시 어딘가");
		
		//when : 기능 수행(~했을 때)
		academyDAO.updateAcademy(academy);

		//then : 결과 확인(~가 되어야 한다)
		academy = academyDAO.selectAcademyByCode("1");
		logger.info("testUpdateAcademy : 변경 후 : " + academy);
	}

	@Test
	public void testDeleteAcademy() throws Exception {
		//Given : 선행조건(~상태라 가정하고)
		Academy academy = academyDAO.selectAcademyByCode("1");
		logger.info("testDeleteAcademy : 삭제 전 : " + academy);
		
		//when : 기능 수행(~했을 때)
		academyDAO.deleteAcademy("1");

		//then : 결과 확인(~가 되어야 한다)
		academy = academyDAO.selectAcademyByCode("1");
		logger.info("testDeleteAcademy : 삭제 후 : " + academy);
	}
	
	@After
	public void tearDown() throws Exception{	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{	}
}
