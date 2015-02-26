package com.hongkailiu.test.app.mybatis;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hongkailiu.test.app.mybatis.entity.Person;
import com.hongkailiu.test.app.mybatis.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyBatisTest {
	static Logger logger = Logger.getLogger(MyBatisTest.class);

	@Autowired
	private PersonService personService;

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
		personService.insert(p1);
		
		Person p2 = new Person();
		p2.setName("testname2");
		p2.setCountry("country_bbb");
		personService.insert(p2);
	}

	@After
	public void tearDown() throws Exception {
		cleanDBTables();
	}
	
	private void cleanDBTables() {

		List<Person> bbbList = personService.list();
		if (bbbList != null && bbbList.size() > 0) {
			for (Person p : bbbList) {
				logger.debug("p: " + p);
				personService.deleteById(p.getId());
			}
		} else {
			logger.debug("certificateDAO.list() is null or size()==0");
		}

	}

	@Test
	public void test() {
		//fail("Not yet implemented");
		List<Person> list = personService.list();
		logger.debug("list:" + list);
		
	}

}
