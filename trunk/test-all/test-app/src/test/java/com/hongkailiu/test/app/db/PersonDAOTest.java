package com.hongkailiu.test.app.db;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PersonDAOTest {

	static Logger logger = Logger.getLogger(PersonDAOTest.class);

	@Autowired
	@Qualifier("personDAOSJTImpl")
	private PersonDAO personDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		cleanDBTables();

		Person p1 = new Person();
		p1.setName("testname1");
		p1.setCountry("country_ccc");
		personDAO.save(p1);
		
		Person p2 = new Person();
		p2.setName("testname2");
		p2.setCountry("country_bbb");
		personDAO.save(p2);
	}

	private void cleanDBTables() {

		List<Person> bbbList = personDAO.list();
		if (bbbList != null && bbbList.size() > 0) {
			for (Person p : bbbList) {
				logger.debug("p: " + p);
				personDAO.deleteById(p.getId());
			}
		} else {
			logger.debug("certificateDAO.list() is null or size()==0");
		}

	}

	@After
	public void tearDown() throws Exception {
		cleanDBTables();
	}

	@Test
	public void testPersonDAO() {
		List<Person> bbbList = personDAO.list();
		assertTrue(bbbList.size() > 0);
		Person p1 = personDAO.findById(bbbList.get(0).getId());
		logger.debug("p1: " + p1);
		assertNotNull(p1);
	}

}
