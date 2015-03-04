package com.hongkailiu.test.app.mongodb.dao;

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

import com.hongkailiu.test.app.mongodb.entity.Person;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PersonDAOSMTImplIT {
	
	static Logger logger = Logger.getLogger(PersonDAOSMTImplIT.class);

	@Autowired
	@Qualifier("personDAOSMTImpl")
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
		personDAO.insert(p1);
		
		Person p2 = new Person();
		p2.setName("testname2");
		p2.setCountry("country_bbb");
		personDAO.insert(p2);
		//> db.testData.find()
		//{ "_id" : ObjectId("54f75b8bfcc7a03bdf19e6b4"), "_class" : "com.hongkailiu.test.app.mongodb.entity.Person", "name" : "testname1", "country" : "country_ccc" }
		//{ "_id" : ObjectId("54f75bbffcc7a03bdf19e6b5"), "_class" : "com.hongkailiu.test.app.mongodb.entity.Person", "name" : "testname2", "country" : "country_bbb" }
	}
	
	private void cleanDBTables() {

		List<Person> bbbList = personDAO.findAll();
		if (bbbList != null && bbbList.size() > 0) {
			for (Person p : bbbList) {
				logger.debug("p: " + p);
				personDAO.remove(p);
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
	public void test() {
		//fail("Not yet implemented");
		List<Person> bbbList = personDAO.findAll();
		assertTrue(bbbList.size() > 0);
		Person p1 = personDAO.findById(bbbList.get(0).getId());
		logger.debug("p1: " + p1);
		assertNotNull(p1);
	}

}
