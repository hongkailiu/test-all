package com.hongkailiu.test.webapp.cxf.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.soap.SOAPFaultException;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MathServiceSIT {

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
	
	@Test(expected=SOAPFaultException.class)
	public void test1() throws MalformedURLException {
		String address = "http://localhost:10001/test-webapp/services/mathServiceS/";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		map.put(WSHandlerConstants.PASSWORD_TYPE, "PasswordText");
		map.put(WSHandlerConstants.USER, "cxfServer");
		map.put(WSHandlerConstants.PW_CALLBACK_REF,
				new ClientPasswordCallback("admin", "123e456"));
			
		WSS4JOutInterceptor wss4jInInterceptor = new WSS4JOutInterceptor(map);

	    JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
	    factory.setServiceClass(MathServiceS.class);
	    factory.setAddress(address);
	    factory.getOutInterceptors().add(wss4jInInterceptor);
	    MathServiceS client = (MathServiceS) factory.create();
	    
	 
	    Integer number1 = new Integer(3);
	    client.isOdd(number1);

	}
	
	@Test
	public void test2() {

		String address = "http://localhost:10001/test-webapp/services/mathServiceS/";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		map.put(WSHandlerConstants.PASSWORD_TYPE, "PasswordText");
		map.put(WSHandlerConstants.USER, "cxfServer");
		map.put(WSHandlerConstants.PW_CALLBACK_REF,
				new ClientPasswordCallback("admin", "123456"));
			
		WSS4JOutInterceptor wss4jInInterceptor = new WSS4JOutInterceptor(map);

	    JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
	    factory.setServiceClass(MathServiceS.class);
	    factory.setAddress(address);
	    factory.getOutInterceptors().add(wss4jInInterceptor);
	    MathServiceS client = (MathServiceS) factory.create();
	    
	 
	    Integer number1 = new Integer(3);
	    boolean a1 = client.isOdd(number1);
	    assertTrue(a1);
	    
	    Integer number2 = new Integer(4);
	    boolean a2 = client.isOdd(number2);
	    assertFalse(a2);
	}

}
