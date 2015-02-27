package com.hongkailiu.test.app.regex;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * ref.
 * http://www.tutorialspoint.com/java/java_regular_expressions.htm
 * @author Liu
 *
 */
public class RegExTest {
	
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
	public void test() {
		//fail("Not yet implemented");
		String regEx = "foo";
		String input = "fooooooooooooooooo";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(input);

		System.out.println("Current regEx is: " + regEx);
		System.out.println("Current INPUT is: " + input);

		System.out.println("lookingAt(): " + matcher.lookingAt());
		System.out.println("matches(): " + matcher.matches());
		
		assertTrue(matcher.lookingAt());
		assertFalse(matcher.matches());
	}

}
