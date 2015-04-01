package com.hongkailiu.test.testjenkins;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

public class HelloWorldBuilderTest {

	@Rule
	public JenkinsRule j = new JenkinsRule();

	@Test
	public void testDoMyWork() throws Exception {

	    
	    HelloWorldBuilder hwb = new HelloWorldBuilder("HelloWorldBuilderTest");
	    String name = hwb.doMyWork();
	    String relative = "api/json?pretty=true";
	    String expectedContentType = "application/json";
	    String response = j.createWebClient().goTo(relative, expectedContentType).getWebResponse().getContentAsString();
	    System.out.println("response" + response);	
	    assertTrue(StringUtils.isNotEmpty(response));
	    assertTrue(response.contains(name));
	   
	}

}
