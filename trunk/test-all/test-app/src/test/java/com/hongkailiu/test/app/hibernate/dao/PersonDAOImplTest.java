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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hongkailiu.test.app.hibernate.dao.CertificateDAO;
import com.hongkailiu.test.app.hibernate.dao.PersonDAO;
import com.hongkailiu.test.app.hibernate.entity.Certificate;
import com.hongkailiu.test.app.hibernate.entity.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PersonDAOImplTest {

	static Logger logger = Logger.getLogger(PersonDAOImplTest.class);
	
	@Autowired
	@Qualifier("certificateDaoImpl")
	private CertificateDAO certificateDAO;

	@Autowired
	@Qualifier("personDaoImpl")
	private PersonDAO personDAO;

	private Set<Certificate> cSet;
	private List<Person> pList;
	private Certificate c;
	private Person p;

	@Before
	public void setUp() throws Exception {
		logger.debug("setUp: begin");
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
		logger.debug("setUp: end");
		
	}
	
	@After
	public void tearDown() throws Exception {
		logger.debug("tearDown: begin");
		cleanDBTables();
		logger.debug("tearDown: end");
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
		if (bbbList != null) {
			for (Person p : bbbList) {
				logger.debug("p: " + p);
				personDAO.delete(p);
			}
		} else {
			logger.debug("certificateDAO.list() is null");
		}

	}
	
	@Test
	public void test() {

		logger.debug("testFetchEager: begin");
		
		personDAO.persist(p);
		List<Person> list2 = personDAO.findByName2(p.getName());
		assertEquals(1, list2.size());
		List<Person> list = personDAO.findByName(p.getName());
		assertEquals(1, list.size());
		Person p1 = list.get(0);
		assertEquals(2, p1.getCertificates().size());
		logger.debug("testFetchEager: end");
	}

}
