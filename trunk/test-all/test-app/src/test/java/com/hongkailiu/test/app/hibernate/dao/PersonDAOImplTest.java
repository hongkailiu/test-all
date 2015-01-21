package com.hongkailiu.test.app.hibernate.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hongkailiu.test.app.hibernate.entity.Person;
import com.hongkailiu.test.app.string.TestString;

public class PersonDAOImplTest {

	// @Autowired
	// ApplicationContext context;

	static Logger logger = Logger.getLogger(TestString.class);

	@Test
	public void test() {

		logger.debug("testSave");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		PersonDAO personDAO = context.getBean(PersonDAO.class);
		Person person = new Person();
		person.setName("Pankaj");
		person.setCountry("India");
		personDAO.save(person);
		logger.debug("Person::" + person);
		List<Person> list = personDAO.list();
		for (Person p : list) {
			logger.debug("Person List::" + p);
		}
		context.close();
	}

	@Test
	public void testList() {
		// fail("Not yet implemented");
	}

}
