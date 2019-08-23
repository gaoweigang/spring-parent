package com.gwg.xml.custom.xsd.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.logging.LogFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public class XSDParseTest {
	public static File file;
	
	@BeforeClass
	public static void testBeforeClass(){
		//创建资源文件
		file = new File("src/test/java/com/gwg/xml/custom/xsd/test/customXMLSchemaTest.xml");
	}
	
	/**
	 *自定义xsd的使用
	 * @throws Exception
	 */
	@Test
	public void testCustomXMLSchema() throws Exception{
		//1.使用javax.xml.parses包中的DocumentBuilderFactory类调用其类方法newInstance()实例化一个DocumentBuilderFactory对象：
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		factory.setValidating(true);
		/*
		 * 设置解析器使用XML Schema语言
		 * 设置解析器使用的语言，解析器默认使用dtd语言
		 */
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		
		//2.factory对象调用newDocumentBuilder()方法返回一个DocumentBuilder对象(称作DOM解析器)，例如：
		DocumentBuilder builder = factory.newDocumentBuilder();
		SimpleSaxErrorHandler errorHandler = new SimpleSaxErrorHandler(LogFactory.getLog(XSDParseTest.class));
		builder.setErrorHandler(errorHandler);
		
		builder.setEntityResolver(new MyEntityResolver());
		
		//获取字节流
		InputStream inputStream = new FileInputStream(file);
		InputSource inputSource = new InputSource(inputStream);
		Document document = builder.parse(inputSource);
		//获取根节点
		Element root = document.getDocumentElement();
		System.out.println(root.toString());
	}
	

	

}
