package com.hongkailiu.test.webapp.cxf.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hongkailiu.test.webapp.cxf.service.impl.PersonServiceRestImpl;
import com.hongkailiu.test.webapp.cxf.vo.Person;

/**
 * ref.
 * https://cwiki.apache.org/confluence/display/CXF20DOC/JAXRS+Testing
 * 
 * @author Liu
 *
 */
public class PersonServiceRestTest {
	
//	private final static String ENDPOINT_ADDRESS = "http://localhost:8080/rest";
//	private final static String WADL_ADDRESS = ENDPOINT_ADDRESS + "?_wadl";
	
	private final static String ENDPOINT_ADDRESS = "http://localhost:10001/test-webapp/services/rest";
	private final static String WADL_ADDRESS = ENDPOINT_ADDRESS + "?_wadl";
	private static Server server;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 startServer();
	     waitForWADL();
	}
	
	private static void startServer() throws Exception {
	     JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
	     sf.setResourceClasses(PersonServiceRestImpl.class);
	         
	     List<Object> providers = new ArrayList<Object>();
	     // add custom providers if any
	     JacksonJsonProvider jsonProvider = new JacksonJsonProvider();
	     providers.add(jsonProvider);
	     sf.setProviders(providers);
	         
	     sf.setResourceProvider(PersonServiceRestImpl.class,
	                            new SingletonResourceProvider(new PersonServiceRestImpl()));
	     //WebClient.create("http://localhost:8080").path("/test-webapp/services/rest/person/3")
	     sf.setAddress(ENDPOINT_ADDRESS);
	 
	     server = sf.create();
	}
	 
	// Optional step - may be needed to ensure that by the time individual
	// tests start running the endpoint has been fully initialized
	private static void waitForWADL() throws Exception {
	    WebClient client = WebClient.create(WADL_ADDRESS);
	    // wait for 20 secs or so
	    for (int i = 0; i < 20; i++) {
	        Thread.currentThread();
			Thread.sleep(1000);
	        Response response = client.get();
	        if (response.getStatus() == 200) {
	            break;
	        }
	    }
	    // no WADL is available yet - throw an exception or give tests a chance to run anyway
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		server.stop();
		server.destroy();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWithWebClient1() {
		//String myEA = "http://localhost:8080/test-webapp/services/rest/person/3"; 
		WebClient client = WebClient.create(ENDPOINT_ADDRESS);
		 client.accept("application/xml");
		 client.path("/person/3");
		 Person person = client.get(Person.class);
		 //assertEquals(123L, book.getId());
		 assertNotNull(person);
	}
	
	@Test
	public void testWithWebClient2() {
		
		// ref. http://stackoverflow.com/questions/20948507/how-to-send-json-data-in-request-body-suing-apache-cxf-webclient
		
		List<Object> providers = new ArrayList<Object>();
		providers.add( new JacksonJaxbJsonProvider() );
		
		//String myEA = "http://localhost:8080/test-webapp/services/rest/person/3"; 
		WebClient client = WebClient.create(ENDPOINT_ADDRESS, providers);
		 client.accept("application/json");
		 client.path("/person/3");
		// client.p
		 Person person = client.get(Person.class);
		 //assertEquals(123L, book.getId());
		 assertNotNull(person);
	}

}
