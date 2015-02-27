package com.hongkailiu.test.webapp.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.URI;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TVSeriesControllerIT {
	
	private URI siteBase;
	private WebDriver drv;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		siteBase = new URI("http://localhost:10001/test-webapp/tvseries/all");
		//drv = new FirefoxDriver();
		drv = new HtmlUnitDriver();
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				drv.close();
			}
		});
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
		drv.get(siteBase.toString());
		assertTrue(drv.getPageSource().contains("episodeOnAir"));
		assertFalse(drv.getPageSource().contains("xxxepisodeOnAir"));
	}

}
