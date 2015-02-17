package com.hongkailiu.test.app.xml.impl.dom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.hongkailiu.test.app.xml.XMLParser;
import com.hongkailiu.test.app.xml.entity.Company;
import com.hongkailiu.test.app.xml.entity.Staff;

public class DomXMLParser implements XMLParser {

	@Override
	public Company parseXML2Company(String filename) {
		Company company = null;
		try {
			
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document document = builder.parse(new FileInputStream(filename));
			
			// optional but advised
			document.getDocumentElement().normalize();
			
			Element rootElement = document.getDocumentElement();
			// root is <company>
			if (rootElement!=null && "company".equals(rootElement.getTagName())) {
				company = new Company();
			}
			NodeList nodes = rootElement.getChildNodes();
			Set<Staff> staffSet = new HashSet<Staff>();
			company.setStaffSet(staffSet);
			for(int i=0; i<nodes.getLength(); i++){
			  Node node = nodes.item(i);
			  
			  if (node.getNodeType() == Node.ELEMENT_NODE) {
				  
					Element element = (Element) node;
					if ("staff".equals(element.getTagName())) {
						Staff s = new Staff();
						s.setId(Integer.parseInt(element.getAttribute("id")));
						s.setFirstname(element.getElementsByTagName("firstname").item(0).getTextContent());
						s.setLastname(element.getElementsByTagName("lastname").item(0).getTextContent());
						s.setNickname(element.getElementsByTagName("nickname").item(0).getTextContent());
						s.setSalary(Float.parseFloat(element.getElementsByTagName("salary").item(0).getTextContent()));
						staffSet.add(s);
					}
//					System.out.println("Staff id : " + element.getAttribute("id"));
//					System.out.println("First Name : " + element.getElementsByTagName("firstname").item(0).getTextContent());
//					System.out.println("Last Name : " + element.getElementsByTagName("lastname").item(0).getTextContent());
//					System.out.println("Nick Name : " + element.getElementsByTagName("nickname").item(0).getTextContent());
//					System.out.println("Salary : " + element.getElementsByTagName("salary").item(0).getTextContent());
		 
				}
			}
		} catch (ParserConfigurationException e) {
		    e.printStackTrace();  
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return company;
	}

}