package com.gwg.xml.xsd.test;

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
		file = new File("src/test/java/com/gwg/xml/xsd/test/beanFactoryTest.xml");
	}
	
	/**
	 *获取publicId 和 systemId
	 * @throws Exception
	 */
	@Test
	public void testParserPublicIdAndSystemId() throws Exception{
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
		/*
		 * 指定解析器要使用的ErrorHandler。将其设置为 null 将会导致底层实现使用其自身的默认实现和行为。
		 * 
		 * ErrorHandler: SAX错误处理程序的基本接口
		 * 如果 SAX 应用程序需要实现自定义的错误处理，则它必须实现此接口，然后使用 setErrorHandler 方法向 XML 阅读器注册一个实例。然后解析器将通过此接口报告所有的错误和警告。
		 * 警告：如果应用程序不 注册 ErrorHandler，则将不报告 XML 解析错误，除了对严重的错误将抛出 SAXParseException 外
		 * 
		 */
		SimpleSaxErrorHandler errorHandler = new SimpleSaxErrorHandler(LogFactory.getLog(XSDParseTest.class));
		builder.setErrorHandler(errorHandler);
		
		/*
		 * 指定使用 EntityResolver 解析要解析的 XML 文档中存在的实体。
		 * 如果 SAX 应用程序需要实现自定义处理外部实体，则必须实现此接口并使用 setEntityResolver 方法向 SAX 驱动器注册一个实例。
		 */
		builder.setEntityResolver(new MyEntityResolver());
		
		//获取字节流
		InputStream inputStream = new FileInputStream(file);
		InputSource inputSource = new InputSource(inputStream);
		//这里必须使用inputSource,而不要直接使用文件File，否者无法获取publicId和systemId
		Document document = builder.parse(inputSource);
		//获取根节点
		Element root = document.getDocumentElement();
		System.out.println(root.toString());
	}
	
	/**
	 * 自定义xsd的使用
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
		/*
		 * 指定解析器要使用的ErrorHandler。将其设置为 null 将会导致底层实现使用其自身的默认实现和行为。
		 * 
		 * ErrorHandler: SAX错误处理程序的基本接口
		 * 如果 SAX 应用程序需要实现自定义的错误处理，则它必须实现此接口，然后使用 setErrorHandler 方法向 XML 阅读器注册一个实例。然后解析器将通过此接口报告所有的错误和警告。
		 * 警告：如果应用程序不 注册 ErrorHandler，则将不报告 XML 解析错误，除了对严重的错误将抛出 SAXParseException 外
		 * 
		 */
		SimpleSaxErrorHandler errorHandler = new SimpleSaxErrorHandler(LogFactory.getLog(XSDParseTest.class));
		builder.setErrorHandler(errorHandler);
		
		builder.setEntityResolver(new MyEntityResolver());
		
		//获取字节流
		InputStream inputStream = new FileInputStream(file);
		InputSource inputSource = new InputSource(inputStream);
		//这里需要传参InputSource,传InputSource与传File的处理方式不一样，传InputSource才能获取publicId和systemId
		Document document = builder.parse(inputSource);
		//获取根节点
		Element root = document.getDocumentElement();
		System.out.println(root.toString());
	}
	

}
