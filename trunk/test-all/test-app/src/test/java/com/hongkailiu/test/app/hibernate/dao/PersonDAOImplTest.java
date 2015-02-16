package com.hongkailiu.test.app.hibernate.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hongkailiu.test.app.hibernate.entity.Certificate;
import com.hongkailiu.test.app.hibernate.entity.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PersonDAOImplTest {

	static Logger logger = Logger.getLogger(PersonDAOImplTest.class);
	
	@Autowired
	private CertificateDAO certificateDAO;

	//@Resource(name="tvSeriesServiceImpl")
	@Autowired
	private PersonDAO personDAO;

	private Set<Certificate> cSet;
	private List<Person> pList;
	private Certificate c;
	private Person p;

	@Before
	public void setUp() throws Exception {
		cleanDBTables();
		
		pList = new ArrayList<Person>();
		p = new Person();
		p.setName("testname");
		p.setCountry("country_ccc");
		pList.add(p);
		
		cSet = new HashSet<Certificate>();
		c = new Certificate();
		c.setName("xxx");
		c.setPerson(p);
		cSet.add(c);
		c = new Certificate();
		c.setName("yyy");
		c.setPerson(p);
		cSet.add(c);
		p.setCertificates(cSet);
		
		
	}
	
	@After
	public void tearDown() throws Exception {
		cleanDBTables();
	}
	
	private void cleanDBTables() {
		List<Certificate> aaaList = certificateDAO.list();
		if (aaaList != null) {
			for (Certificate c : aaaList) {
				logger.debug("c: " + c);
				certificateDAO.delete(c);
			}
		} else {
			logger.debug("certificateDAO.list() is null");
		}

		List<Person> bbbList = personDAO.list();
		if (aaaList != null) {
			for (Person p : bbbList) {
				logger.debug("p: " + p);
				personDAO.delete(p);
			}
		} else {
			logger.debug("certificateDAO.list() is null");
		}

	}
	
	@Test
	public void testCascade() {

		logger.debug("testCascade: begin");
		personDAO.save(p);
		logger.debug("testCascade: end");
	}
	
	@Test
	public void testFetchEager() {

		logger.debug("testCascade: begin");
		personDAO.save(p);
		List<Person> list = personDAO.findByName(p.getName());
		assertEquals(1, list.size());
		Person p1 = list.get(0);
		assertEquals(2, p1.getCertificates().size());
		logger.debug("testCascade: end");
	}

}
