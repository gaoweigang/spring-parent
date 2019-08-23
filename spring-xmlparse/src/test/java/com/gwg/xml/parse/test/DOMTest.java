package com.gwg.xml.parse.test;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.SAXException;
/**
 * 使用DOM解析器的基本步骤
 * 在JAXP(Java API for XML Processing，意为XML处理的Java API)中，DOM解析器是DocumentBuilder类的一个实例，该实例由DocumentBuilderFactory类
 * 负责创建
 * @author gaoweigang
 */
public class DOMTest {
	
	public static File file = null;
	
	@BeforeClass
	public static void testBeforeClass(){
		//创建资源文件
		file = new File("src/test/resources/beanFactoryTest.xml");
	}
	
	
	/**
	 * 使用DOM解析器解析beanFactoryTest.xml文件
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	@Test
	public void testUseDOMParse() throws ParserConfigurationException, SAXException, IOException{
		//1.使用javax.xml.parses包中的DocumentBuilderFactory类调用其类方法newInstance()实例化一个DocumentBuilderFactory对象：
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//2.factory对象调用newDocumentBuilder()方法返回一个DocumentBuilder对象(称作DOM解析器)，例如：
		DocumentBuilder builder = factory.newDocumentBuilder();
		//builder.setEntityResolver();
		//3.builder对象调用public Document parse(File f)方法解析参数f指定的文件，并返回一个实现了Document接口的实例，该实例称为Document对象，例如：
		Document document = builder.parse(file);
		//获取根节点
		Element root = document.getDocumentElement();
		
		//System.out.println(root.getAttribute("DOOR"));
		NodeList nl = root.getChildNodes();
		for(int i = 0; i< nl.getLength(); i++){
			Node node = nl.item(i);
			if(node instanceof Element){
				Element ele = (Element)node;
				System.out.println(ele.getNodeName());
				System.out.println(ele.getAttribute("id"));
				System.out.println(ele.getAttribute("class"));
				NodeList nodelist = ele.getChildNodes();
				System.out.println(nodelist.getLength());
			}
		}
	}
	
	/*
	 * test namespaceaware
	 */
	@Test
	public void testNamespaceAware() throws ParserConfigurationException, SAXException, IOException{
		//1.使用javax.xml.parses包中的DocumentBuilderFactory类调用其类方法newInstance()实例化一个DocumentBuilderFactory对象：
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//指定由该代码生成的解析器将提供对XML命名空间的支持。默认情况下，解析器的值将被设置成false
		factory.setNamespaceAware(true); //试一下多个配置文件
		//2.factory对象调用newDocumentBuilder()方法返回一个DocumentBuilder对象(称作DOM解析器)，例如：
		DocumentBuilder builder = factory.newDocumentBuilder();
		//3.builder对象调用public Document parse(File f)方法解析参数f指定的文件，并返回一个实现了Document接口的实例，该实例称为Document对象，例如：
		Document document = builder.parse(file);
		
		//获取根节点
		Element root = document.getDocumentElement();
}
	
	/*
	 * test validating
	 */
	@Test
	public void testValidating() throws ParserConfigurationException, SAXException, IOException{
		//1.使用javax.xml.parses包中的DocumentBuilderFactory类调用其类方法newInstance()实例化一个DocumentBuilderFactory对象：
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		/*
		 * 指定由此代码生成的解析器将验证被解析的文档。默认情况下，其值设置为true
		 * 注意，此处“验证”是指XML规范中定义的验证解析器。换句话说，它实际上仅控制DTD验证
		 */
		factory.setNamespaceAware(true);
		factory.setValidating(true);
		/*
		 * 设置解析器使用XML Schema语言
		 * 设置解析器使用的语言，解析器默认使用dtd语言
		 */
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		//2.factory对象调用newDocumentBuilder()方法返回一个DocumentBuilder对象(称作DOM解析器)，例如：
		DocumentBuilder builder = factory.newDocumentBuilder();
		//3.builder对象调用public Document parse(File f)方法解析参数f指定的文件，并返回一个实现了Document接口的实例，该实例称为Document对象，例如：
		Document document = builder.parse(file);
		//获取根节点
		Element root = document.getDocumentElement();
	}

	/*
	 * test EntiyResolver
	 */
	@Test 
	public void testEntityResolver() throws ParserConfigurationException, SAXException, IOException{
		//1.使用javax.xml.parses包中的DocumentBuilderFactory类调用其类方法newInstance()实例化一个DocumentBuilderFactory对象：
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//2.factory对象调用newDocumentBuilder()方法返回一个DocumentBuilder对象(称作DOM解析器)，例如：
		DocumentBuilder builder = factory.newDocumentBuilder();
		//指定使用 EntityResolver 解析要解析的 XML 文档中存在的实体。
		//EntityResolver entityResolver = new BeansDtdResolver();
		//builder.setEntityResolver(entityResolver);
		//3.builder对象调用public Document parse(File f)方法解析参数f指定的文件，并返回一个实现了Document接口的实例，该实例称为Document对象，例如：
		Document document = builder.parse(file);
		//获取根节点
		Element root = document.getDocumentElement();
	}
	
	/*
	 * test PluggableSchemaResolver
	 */
	@Test
	public void testPluggableSchemaResolver() throws ParserConfigurationException, SAXException, IOException{
		//1.使用javax.xml.parses包中的DocumentBuilderFactory类调用其类方法newInstance()实例化一个DocumentBuilderFactory对象：
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//2.factory对象调用newDocumentBuilder()方法返回一个DocumentBuilder对象(称作DOM解析器)，例如：
		DocumentBuilder builder = factory.newDocumentBuilder();
		//指定使用 EntityResolver 解析要解析的 XML 文档中存在的实体。
		//EntityResolver entityResolver = new PluggableSchemaResolver(null);
		//builder.setEntityResolver(entityResolver);
		//3.builder对象调用public Document parse(File f)方法解析参数f指定的文件，并返回一个实现了Document接口的实例，该实例称为Document对象，例如：
		Document document = builder.parse(file);
		//获取根节点
		Element root = document.getDocumentElement();
		
	}
}
