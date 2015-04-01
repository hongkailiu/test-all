package com.hongkailiu.test.testjenkins.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import hudson.model.FreeStyleBuild;
import hudson.model.TopLevelItem;
import hudson.model.FreeStyleProject;
import hudson.plugins.collabnet.util.BuildCompleteListener;

import java.io.IOException;
import java.util.Date;

import jenkins.model.Jenkins;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;
import org.xml.sax.SAXException;

public class JenkinsUtilTest {
	
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
		if (project!=null){
			JenkinsUtil.deleteProject(project);
		}
		project=null;
	}

	@Rule
	public JenkinsRule j = new JenkinsRule();
	
	private FreeStyleProject project;

	@Test
	public void testCreateFreeStyleProject() throws IOException, SAXException {
		
		final String projectNamePrefix = "myjob-";
		Date date = new Date();
		String name = projectNamePrefix + date;
		project = JenkinsUtil.createFreeStyleProject(name);
		String relative = "api/json?pretty=true";
		String expectedContentType = "application/json";
		String response = j.createWebClient()
				.goTo(relative, expectedContentType).getWebResponse()
				.getContentAsString();
		System.out.println("response" + response);
		assertTrue(StringUtils.isNotEmpty(response));
		assertTrue(response.contains(name));
	}
	
	@Test
	public void testBuildFreeStyleProject() throws IOException, SAXException, InterruptedException {
		final String projectNamePrefix = "myjob-";
		Date date = new Date();
		String name = projectNamePrefix + date;
		project = JenkinsUtil.createFreeStyleProject(name);
		String relative = "api/json?pretty=true";
		String expectedContentType = "application/json";
		String response = j.createWebClient()
				.goTo(relative, expectedContentType).getWebResponse()
				.getContentAsString();
		System.out.println("response" + response);
		assertTrue(StringUtils.isNotEmpty(response));
		assertTrue(response.contains(name));
		FreeStyleBuild build = project.getLastBuild();
		assertNull(build);
		JenkinsUtil.buildFreeStyleProject(project);
		assertTrue(project.isInQueue());
		
		// TODO should be callbacks available: RunListen?
		//System.out.println("waiting 10 sec...");
		//Thread.sleep(10*1000);
		BuildCompleteListener listener = new BuildCompleteListener(FreeStyleProject.class, project);
		listener.waitForBuildToComplete(10*1000);
		
		TopLevelItem item = Jenkins.getInstance().getItem(name);
		project = (FreeStyleProject) item;
		
		FreeStyleBuild build2 = project.getLastBuild();
		assertNotNull(build2);
		
		int number = build2.getNumber();
		System.out.println("number" + number);
//		
//		project.getBuilders();
	}
	
	@Test
	public void testDeleteFreeStyleProject() throws IOException, SAXException, InterruptedException {
		
		final String projectNamePrefix = "myjob-";
		Date date = new Date();
		String name = projectNamePrefix + date;
		project = JenkinsUtil.createFreeStyleProject(name);
		String relative = "api/json?pretty=true";
		String expectedContentType = "application/json";
		String response = j.createWebClient()
				.goTo(relative, expectedContentType).getWebResponse()
				.getContentAsString();
		System.out.println("response" + response);
		assertTrue(StringUtils.isNotEmpty(response));
		assertTrue(response.contains(name));
		JenkinsUtil.deleteProject(project);
		String response2 = j.createWebClient()
				.goTo(relative, expectedContentType).getWebResponse()
				.getContentAsString();
		System.out.println("response2:" + response2);
		assertTrue(StringUtils.isNotEmpty(response2));
		assertFalse(response2.contains(name));
	}

}
