package com.hongkailiu.test.app.xml.impl.sax;

import com.hongkailiu.test.app.xml.XMLWriter;
import com.hongkailiu.test.app.xml.entity.Company;
import com.hongkailiu.test.app.xml.entity.Staff;
import lombok.extern.log4j.Log4j;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Set;

/**
 * ref. http://blog.csdn.net/chenghui0317/article/details/11990891
 *
 * @author Liu
 */
@Log4j public class SaxXMLWriter implements XMLWriter {

    @Override public void writeCompany2File(String filename, Company company) {
        if (company == null) {
            return;
        }
        try {
            //创建保存xml的结果流对象
            Result resultXml = new StreamResult(new FileOutputStream(new File(filename)));
            //获取sax生产工厂对象实例
            SAXTransformerFactory saxTransformerFactory =
                (SAXTransformerFactory) SAXTransformerFactory.newInstance();
            //获取sax生产处理者对象实例
            TransformerHandler transformerHandle = saxTransformerFactory.newTransformerHandler();
            transformerHandle.setResult(resultXml);
            //获取sax生产器
            Transformer transformer = transformerHandle.getTransformer();
            //transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");//xml的编码格式
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");//换行
            //开始封装document文档对象，这里和解析一样都是成双成对的构造标签

            transformerHandle.startDocument();
            AttributesImpl attrImple = new AttributesImpl();
            transformerHandle.startElement("", "", "company", attrImple);

            Set<Staff> staffSet = company.getStaffSet();
            if (staffSet != null) {
                for (Staff staff : staffSet) {
                    if (staff != null) {
                        attrImple.addAttribute("", "", "id", "", Integer.toString(staff.getId()));
                        transformerHandle.startElement("", "", "staff", attrImple);
                        attrImple.clear();
                        if (staff.getFirstname() != null) {
                            transformerHandle.startElement("", "", "firstname", attrImple);
                            transformerHandle.characters(staff.getFirstname().toCharArray(), 0,
                                staff.getFirstname().length());
                            transformerHandle.endElement("", "", "firstname");
                        }
                        if (staff.getLastname() != null) {
                            transformerHandle.startElement("", "", "lastname", attrImple);
                            transformerHandle.characters(staff.getLastname().toCharArray(), 0,
                                staff.getLastname().length());
                            transformerHandle.endElement("", "", "lastname");
                        }
                        if (staff.getNickname() != null) {
                            transformerHandle.startElement("", "", "nickname", attrImple);
                            transformerHandle.characters(staff.getNickname().toCharArray(), 0,
                                staff.getNickname().length());
                            transformerHandle.endElement("", "", "nickname");
                        }

                        transformerHandle.startElement("", "", "salary", attrImple);
                        transformerHandle
                            .characters(Float.toString(staff.getSalary()).toCharArray(), 0,
                                Float.toString(staff.getSalary()).length());
                        transformerHandle.endElement("", "", "salary");

                        transformerHandle.endElement("", "", "staff");
                    }
                }
            }

            transformerHandle.endElement("", "", "company");
            //因为没有appendChild等等添加子元素的方法，sax提供的是构造在startElement()和endElement()区间内的标签为包含的节点的父节点
            transformerHandle.endDocument();

            log.info("xml文档生成成功！");

        } catch (FileNotFoundException | TransformerConfigurationException | SAXException e) {
           log.error(e);
        }

    }



}
