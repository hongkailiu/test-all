package com.hongkailiu.test.app.hibernate.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hongkailiu.test.app.hibernate.entity.Certificate;
import com.hongkailiu.test.app.hibernate.entity.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CertificateDAOImplTest {

	static Logger logger = Logger.getLogger(CertificateDAOImplTest.class);

	@Autowired
	@Qualifier("certificateDaoImpl")
	private CertificateDAO certificateDAO;

	@Autowired
	@Qualifier("personDaoImpl")
	private PersonDAO personDAO;

//	private List<Certificate> cList;
//	private List<Person> pList;
//	private Certificate c;
//	private Person p;

	@Before
	public void setUp() throws Exception {
		cleanDBTables();
		
//		pList = new ArrayList<Person>();
//		p = new Person();
//		p.setName("testname");
//		p.setCountry("country_ccc");
//		pList.add(p);
//		
//		cList = new ArrayList<Certificate>();
//		c = new Certificate();
//		c.setName("xxx");
//		c.setPerson(p);
//		cList.add(c);
//		c = new Certificate();
//		c.setName("yyy");
//		c.setPerson(p);
//		cList.add(c);
		
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
	public void testFKNull() {
		
		logger.debug("testFKNull: begin");
		Certificate c1 = new Certificate();
		String name = "xxx";
		c1.setName(name);
		certificateDAO.persist(c1);
		List<Certificate> list = certificateDAO.findByName(name);
		assertEquals(1, list.size());
		logger.debug("testFKNull: end");
	}

}
