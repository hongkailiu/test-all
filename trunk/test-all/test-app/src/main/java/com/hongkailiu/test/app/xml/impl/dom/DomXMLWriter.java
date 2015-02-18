package com.hongkailiu.test.app.xml.impl.dom;

import java.io.File;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.hongkailiu.test.app.xml.XMLWriter;
import com.hongkailiu.test.app.xml.entity.Company;
import com.hongkailiu.test.app.xml.entity.Staff;

/**
 * ref. http://www.mkyong.com/java/how-to-create-xml-file-in-java-dom/
 * http://stackoverflow.com/questions/7511400/how-to-remove-encoding-utf-8-standalone-no-from-xml-document-object-in-java
 * @author Liu
 *
 */
public class DomXMLWriter implements XMLWriter {

	@Override
	public void writeCompany2File(String filename, Company company) {
		if (company==null) {
			return;
		}
		try {
			 
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
			// root elements
			Document doc = docBuilder.newDocument();
			// hongkai: erase standalone="no" in <?xml version="1.0" encoding="UTF-8" standalone="no"?>
			doc.setXmlStandalone(true);
			Element rootElement = doc.createElement("company");
			doc.appendChild(rootElement);
	 
			Set<Staff> staffSet = company.getStaffSet();
			if (staffSet!=null){
				for (Staff staff : staffSet) {
					if (staff!=null) {
						// staff elements
						//Element staffElement = doc.createElement("Staff");
						// hongkai: 保持读写一直，S小写
						Element staffElement = doc.createElement("staff");
						rootElement.appendChild(staffElement);
				 
						// set attribute to staff element
						Attr attr = doc.createAttribute("id");
						attr.setValue(Integer.toString(staff.getId()));
						staffElement.setAttributeNode(attr);
				 
						// shorten way
						// staff.setAttribute("id", "1");
				 
						// firstname elements
						Element firstname = doc.createElement("firstname");
						firstname.appendChild(doc.createTextNode(staff.getFirstname()));
						staffElement.appendChild(firstname);
				 
						// lastname elements
						Element lastname = doc.createElement("lastname");
						lastname.appendChild(doc.createTextNode(staff.getLastname()));
						staffElement.appendChild(lastname);
				 
						// nickname elements
						Element nickname = doc.createElement("nickname");
						nickname.appendChild(doc.createTextNode(staff.getNickname()));
						staffElement.appendChild(nickname);
				 
						// salary elements
						Element salary = doc.createElement("salary");
						salary.appendChild(doc.createTextNode(Float.toString(staff.getSalary())));
						staffElement.appendChild(salary);
					}
				}
			}
	 
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filename));
	 
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
	 
			transformer.transform(source, result);
	 
			System.out.println("File saved!");
	 
		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
		
	}

	

}
