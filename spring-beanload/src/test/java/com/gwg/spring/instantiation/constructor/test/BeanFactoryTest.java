package com.gwg.spring.instantiation.constructor.test;

import java.beans.ConstructorProperties;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
/**
 * beanA: singleton
 * beanTwo与beanOne交换位置后,初始化对象的属性不一样
 * 
 *
 * beanA: prototype 
 * 
 */
public class BeanFactoryTest {
	/**
	 * beanA: singleton
	 */
	@Test
	public void testOne() {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("instantiationWithConstructorTest.xml"));
		
		BeanA beanOne = (BeanA) beanFactory.getBean("beanA");
		System.out.println(beanOne);
		
        BeanA beanTwo = (BeanA) beanFactory.getBean("beanA", "高伟刚");
		System.out.println(beanTwo);

	}
	
	/**
	 * 正常
	 */
	@Test
	public void testTwo() {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("instantiationWithConstructorTest.xml"));
		
	    BeanA bean = (BeanA) beanFactory.getBean("beanATwo");
		System.out.println(bean+"***name:"+bean.getName()+"*****age:"+bean.getAge());
		
        BeanA beanATwo = (BeanA) beanFactory.getBean("beanATwo", "高伟刚");
		System.out.println(beanATwo+"***name:"+bean.getName()+"*****age:"+bean.getAge());

	}
	
	/**
	 * 异常， 测试@ConstructorProperties 带来的影响
	 */
	@Test
	public void testThree() {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("instantiationWithConstructorTest.xml"));
		
		BeanA bean = (BeanA) beanFactory.getBean("beanAThree");
		System.out.println(bean+"***name:"+bean.getName()+"*****age:"+bean.getAge());
		

	}
	
	/**
	 * 测试Int
	 */
	@Test
	public void testFix() {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("instantiationWithConstructorTest.xml"));
		
		BeanB bean = (BeanB) beanFactory.getBean("beanAFix");
		System.out.println(bean+"***name:"+bean.getName()+"*****age:"+bean.getWeight());
		

	}
	
	/**
	 * 测试Int
	 */
	@Test
	public void testSix() {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("instantiationWithConstructorTest.xml"));
		
		BeanB bean = (BeanB) beanFactory.getBean("beanBSix");
		System.out.println(bean+"***name:"+bean.getName()+"*****age:"+bean.getWeight());
		

	}
	
	/**
	 * 为什么会有这样的输出？在实例化bean的时候输出的
	 * 在XML配置中没有指定构造函数参数名称的情况下，为什么会选择public BeanC(java.lang.String),而不是public BeanC(int)?
	 * 有两个构造函数，一个参数类型是String,另一个int
	 * 
	 * 这个说明基于XML配置的参数与java编码的参数或者属性不应会自动丢弃，而不会报错
	 */
	@Test
	public void testSeven() {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("instantiationWithConstructorTest.xml"));
		
		BeanC bean = (BeanC) beanFactory.getBean("beanCSeven");
		System.out.println(bean+"***name:"+bean.getName()+"*****age:"+bean.getAge());
		

	}
	
	@Test
	public void testEight() {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("instantiationWithConstructorTest.xml"));
		
		BeanD bean = (BeanD) beanFactory.getBean("beanDEight");
		System.out.println(bean+"***name:"+bean.getName()+"*****age:"+bean.getAge());
		

	}

}
