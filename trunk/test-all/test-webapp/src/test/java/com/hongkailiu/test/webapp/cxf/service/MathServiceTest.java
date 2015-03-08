package com.hongkailiu.test.webapp.cxf.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.hongkailiu.test.webapp.cxf.service.impl.MathServiceImpl;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:cxf-sei.xml")
public class MathServiceTest {

	// @Autowired
	// @Qualifier("mathServiceClient")
	// private MathService mathServiceClient;

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
	@Ignore
	public void test1() throws MalformedURLException {

		// unit test method 1:
		// hongkai: using @RunWith(SpringJUnit4ClassRunner.class) for unit test with the service running
		//<jaxws:client id="mathServiceClient" serviceClass="com.hongkailiu.test.webapp.cxf.service.MathService" 
		//	    address="http://localhost:8080/test-webapp/services/mathService"/>
		// assertNotNull(mathServiceClient);
		// boolean isOdd1 = mathServiceClient.isOdd(3);
		// assertEquals(true, isOdd1);
		//
		// boolean isOdd2 = mathServiceClient.isOdd(2);
		// assertEquals(false, isOdd2);

		// unit test method 2: 
		// http://www.mkyong.com/webservices/jax-ws/jax-ws-hello-world-example/
		// URL url = new URL(
		// "http://localhost:8081/test-webapp/services/mathService?wsdl");
		//
		// // 1st argument service URI, refer to wsdl document above
		// // 2nd argument is service name, refer to wsdl document above
		// QName qname = new
		// QName("http://impl.service.cxf.webapp.test.hongkailiu.com/",
		// "MathServiceImplService");
		//
		// Service service = Service.create(url, qname);
		//
		// MathService mathService = service.getPort(MathService.class);
		//
		// boolean isOdd = mathService.isOdd(3);
		// assertEquals(true, isOdd);
	}
	
	@Test
	public void test2() {

		String address = "http://localhost:8081/test-webapp/services/mathService/";
		MathServiceImpl endpoint = new MathServiceImpl();
	    JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
	    svrFactory.setServiceClass(MathService.class);
	    svrFactory.setAddress(address);
	    svrFactory.setServiceBean(endpoint);
	    svrFactory.create();

	    JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
	    factory.setServiceClass(MathService.class);
	    factory.setAddress(address);
	    MathService client = (MathService) factory.create();
	    
	    Integer number1 = new Integer(3);
	    boolean a1 = client.isOdd(number1);
	    assertTrue(a1);
	    
	    Integer number2 = new Integer(4);
	    boolean a2 = client.isOdd(number2);
	    assertFalse(a2);
	}

}
