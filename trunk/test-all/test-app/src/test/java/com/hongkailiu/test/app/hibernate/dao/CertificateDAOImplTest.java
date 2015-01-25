package com.hongkailiu.test.app.hibernate.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hongkailiu.test.app.hibernate.entity.Certificate;
import com.hongkailiu.test.app.hibernate.entity.Person;
import com.hongkailiu.test.app.string.TestString;

public class CertificateDAOImplTest {

	// @Autowired
	// ApplicationContext context;

	static Logger logger = Logger.getLogger(CertificateDAOImplTest.class);

	@Test
	public void test() {

		logger.debug("testSave");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CertificateDAO certificateDAO = context.getBean(CertificateDAO.class);
		Certificate c = new Certificate();
		c.setName("xxx");
		Person p = new Person();
		p.setId(11);
		c.setPerson(p);
		certificateDAO.save(c);
		logger.debug("certificate::" + c);
		List<Certificate> list = certificateDAO.list();
		for (Certificate cert : list) {
			logger.debug("certificate List::" + cert);
		}
		context.close();
	}

	@Test
	public void testList() {
		// fail("Not yet implemented");
	}

}
