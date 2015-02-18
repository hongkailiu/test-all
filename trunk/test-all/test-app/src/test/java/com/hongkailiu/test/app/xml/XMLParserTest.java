package com.hongkailiu.test.app.xml;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hongkailiu.test.app.xml.entity.Company;
import com.hongkailiu.test.app.xml.entity.Staff;
import com.hongkailiu.test.app.xml.impl.dom.DomXMLParser;
import com.hongkailiu.test.app.xml.impl.sax.SaxXMLParser;

public class XMLParserTest {
	
	private XMLParser parser;
	private final static String FILENAME = "file\\staff.xml";
	//private final static String FILENAME = "file\\staff-result.xml";
	private final static Company expectedCompany = new Company();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Set<Staff> staffSet = new HashSet<Staff>();
		Staff s0 = new Staff();
		s0.setId(1001);
		s0.setFirstname("yong");
		s0.setLastname("mook kim");
		s0.setNickname("mkyong");
		s0.setSalary(100000);
		staffSet.add(s0);
		
		Staff s1 = new Staff();
		s1.setId(2001);
		s1.setFirstname("low");
		s1.setLastname("yin fong");
		s1.setNickname("fong fong");
		s1.setSalary(200000);
		staffSet.add(s1);
		expectedCompany.setStaffSet(staffSet);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		parser = null;
	}

	@Test
	public void testparseXML2CompanyWithDom() {
		parser = new DomXMLParser();
		Company company = parser.parseXML2Company(FILENAME);
		//boolean a = CollectionUtils.isEqualCollection(expectedCompany.getStaffSet(), company.getStaffSet());
		//assertTrue(a);
		assertEquals(expectedCompany, company);
		
	}
	
	@Test
	public void testparseXML2CompanyWithSax() {
		parser = new SaxXMLParser();
		Company company = parser.parseXML2Company(FILENAME);
		//boolean a = CollectionUtils.isEqualCollection(expectedCompany.getStaffSet(), company.getStaffSet());
		//assertTrue(a);
		assertEquals(expectedCompany, company);
		
	}

}
