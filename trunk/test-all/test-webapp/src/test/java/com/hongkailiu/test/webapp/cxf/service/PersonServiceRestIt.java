package com.hongkailiu.test.webapp.cxf.service;

import static org.junit.Assert.*;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hongkailiu.test.webapp.cxf.vo.Person;

public class PersonServiceRestIt {

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
		final Person person = WebClient.create("http://localhost:8080").path("/test-webapp/services/rest/person/3")
                .accept(MediaType.APPLICATION_XML_TYPE)
                .get(Person.class);
		assertNotNull(person);
	}

}
