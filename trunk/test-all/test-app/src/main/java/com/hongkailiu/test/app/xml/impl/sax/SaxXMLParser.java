package com.hongkailiu.test.app.xml.impl.sax;

import com.hongkailiu.test.app.xml.XMLParser;
import com.hongkailiu.test.app.xml.entity.Company;
import com.hongkailiu.test.app.xml.entity.Staff;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.HashSet;

/**
 * ref. http://www.mkyong.com/java/how-to-read-xml-file-in-java-sax-parser/
 * http://tutorials.jenkov.com/java-xml/sax-example.html
 * http://blog.csdn.net/chenghui0317/article/details/11990891
 *
 * @author Liu
 */
public class SaxXMLParser implements XMLParser {

    @Override public Company parseXML2Company(String filename) {
        Company result = null;
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            saxParser.parse(filename, handler);
            result = handler.company;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public class MyHandler extends DefaultHandler {
        private Company company = null;
        private Staff tS;

        private String currentQName;
            // 因为startElement()才能获取到标签名称，但是标签的内容在characters()获取，而且他们的执行顺序一直是顺序的，所以可以使用currentQName来过渡一下获取上一次的标签名

        @Override public void startDocument() throws SAXException {
            super.startDocument();
        }

        @Override public void endDocument() throws SAXException {
            super.endDocument();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

            System.out.println("Start Element :" + qName);
            currentQName = qName;
            if (qName.equals("company")) {
                if (company == null) {
                    company = new Company();
                }
            }

            if (qName.equals("staff")) {
                if (company != null) {
                    tS = new Staff();
                    tS.setId(Integer.parseInt(attributes.getValue("id")));
                }
            }

            super.startElement(uri, localName, qName, attributes);
        }

        @Override public void endElement(String uri, String localName, String qName)
            throws SAXException {

            System.out.println("End Element :" + qName);
            if (qName.equals("staff")) {
                if (company != null) {
                    if (company.getStaffSet() == null) {
                        company.setStaffSet(new HashSet<Staff>());
                    }
                    company.getStaffSet().add(tS);
                }
            }
            // hongkai: 这个一定要有
            currentQName = null;
            super.endElement(uri, localName, qName);
        }

        public void characters(char ch[], int start, int length) throws SAXException {

            System.out.println("characters: " + new String(ch, start, length));
            if ("firstname".equals(currentQName)) {
                if (tS != null) {
                    tS.setFirstname(new String(ch, start, length));
                }
            } else if ("lastname".equals(currentQName)) {
                if (tS != null) {
                    tS.setLastname(new String(ch, start, length));
                }
            } else if ("nickname".equals(currentQName)) {
                if (tS != null) {
                    tS.setNickname(new String(ch, start, length));
                }
            } else if ("salary".equals(currentQName)) {
                if (tS != null) {
                    tS.setSalary(Float.parseFloat(new String(ch, start, length)));
                }
            }
            super.characters(ch, start, length);
        }
    }

}
