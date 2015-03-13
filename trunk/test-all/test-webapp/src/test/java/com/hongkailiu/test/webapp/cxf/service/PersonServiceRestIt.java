package com.hongkailiu.test.webapp.cxf.service;

import static org.junit.Assert.*;

import java.util.Date;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hongkailiu.test.webapp.cxf.vo.Person;

public class PersonServiceRestIT {
	
	private final static String BASE_ADDRESS = "http://localhost:10001/test-webapp/services/rest";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testXML() {
		final Person person = WebClient.create(BASE_ADDRESS).path("/person/3")
                .accept(MediaType.APPLICATION_XML_TYPE)
                .get(Person.class);
		assertNotNull(person);
	}
	
	@Test
	public void testCreate() {
		Person inputPerson = new Person();
		inputPerson.setUsername("a");
		inputPerson.setPassword("b");
		inputPerson.setBirthdate(new Date());
		final Person person = WebClient.create(BASE_ADDRESS).path("/person/")
                .type(MediaType.APPLICATION_XML_TYPE).accept(MediaType.APPLICATION_XML_TYPE).post(inputPerson, Person.class);
		assertNotNull(person);
	}

}
