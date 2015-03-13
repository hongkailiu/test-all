package com.hongkailiu.test.webapp.cxf.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;

import com.hongkailiu.test.webapp.cxf.service.PersonServiceRest;
import com.hongkailiu.test.webapp.cxf.vo.Person;

//@Repository("personServiceRestImpl")
public class PersonServiceSRestImpl implements PersonServiceRest {
	
	static Logger logger = Logger.getLogger(PersonServiceSRestImpl.class);

	@Override
	public Person create(Person person) {
		logger.debug("create");
		Person p = new Person();
		p.setUsername("a");
		p.setPassword("b");
		p.setBirthdate(new Date());
		return p;
	}

	@Override
	public Person read(String id) {
		logger.debug("read");
		Person p = new Person();
		p.setUsername("a");
		p.setPassword("b");
		p.setBirthdate(new Date());
		return p;
	}

	@Override
	public void update(String uuid, Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String uuid) {
		// TODO Auto-generated method stub
		
	}

}
