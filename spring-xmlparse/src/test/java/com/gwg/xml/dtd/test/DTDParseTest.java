package com.gwg.xml.dtd.test;

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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class DTDParseTest {
	public static File file;
	
	@BeforeClass
	public static void testBeforeClass(){
		//创建资源文件
		file = new File("src/test/java/com/gwg/xml/dtd/test/customTest.xml");
	}
	
	/**
	 *自定义xsd的使用
	 * @throws Exception
	 */
	@Test
	public void testCustomDtd() throws Exception{
		//1.使用javax.xml.parses包中的DocumentBuilderFactory类调用其类方法newInstance()实例化一个DocumentBuilderFactory对象：
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		/*
		 * 2.指定由此代码生成的解析器将提供对 XML 名称空间的支持。
		 * 设置true, 生成的解析器将提供对 XML 名称空间的支持,说明xml文件中的元素来至于命名空间。
		 * 设置false, 元素DOM元素namespaceURI为空
		 * 
		 * NamespaceAware是不是针对SAX,而对DOM无效
		 */
		factory.setNamespaceAware(true);
		/*
		 * 3.XML文件校验
		 * 设置false,则不会根据dtd文件对xml文件进行校验，例如：在xml文件添加dtd文件中没规定的属性test
		 * 设置true,则会根据dtd文件对xml文件进行校验，例如：在xml文件中添加dtd文件中没规定的属性test,则会报错
		 */
		factory.setValidating(true);
		//factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		
		//2.factory对象调用newDocumentBuilder()方法返回一个DocumentBuilder对象(称作DOM解析器)，例如：
		DocumentBuilder builder = factory.newDocumentBuilder();
		SimpleSaxErrorHandler errorHandler = new SimpleSaxErrorHandler(LogFactory.getLog(DTDParseTest.class));
		builder.setErrorHandler(errorHandler);
		
		builder.setEntityResolver(new MyEntityResolver());
		
		//获取字节流
		InputStream inputStream = new FileInputStream(file);
		InputSource inputSource = new InputSource(inputStream);
		Document document = builder.parse(inputSource);
		//NodeList nl = document.getElementsByTagNameNS("http://www.example.org/CustomXMLSchema/beans", "bean");
		//获取根节点
		Element root = document.getDocumentElement();
		//doc.getElementsByTagNameNS
		//doc.getElementsByTagName("Signature")
		System.out.println("NodeName:"+root.getNodeName()+",id:"+root.getAttribute("id")+",class:"+root.getAttribute("class")+",namespaceURI:"+root.getNamespaceURI());
		NodeList nl = root.getChildNodes();
		for(int i = 0; i< nl.getLength(); i++){
			Node node = nl.item(i);
			if(node instanceof Element){
				Element ele = (Element)node;
				System.out.println("NodeName:"+ele.getNodeName()+",id:"+ele.getAttribute("id")+",class:"+ele.getAttribute("class")+",namespaceURI:"+ele.getNamespaceURI());
			}
		}
	}
	

	

}
