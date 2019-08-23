package com.gwg.spring.java.core.propertydescriptor.test;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;

public class PropertyDescriptorTest {
	
	@Test
	public void testGetAndSetProperty() throws Exception {
		//创建Person
		Person person = new Person("高伟刚", 20);
		//声明Person里面的一个属性名称
		String propertyName = "name";
		
		//获取值
		Object obj = getProperty(person, propertyName);
		System.out.println(obj);
		
		//设置值
		Object value = "高红程";
		setProperty(person, propertyName, value);
		System.out.println(person.getName());
		
	}
	
	
	private static Object getProperty(Object obj, String propertyName) throws Exception{
		//在这里 通过调用 getName 和 setName 存取方法，为符合标准 Java 约定的属性构造一个 PropertyDescriptor。
		PropertyDescriptor pd = new PropertyDescriptor(propertyName, obj.getClass());
		//获得应该用于读取属性值的方法，即getName()
		Method getMethod = pd.getReadMethod();
		//调用对象读取属性值的方法
		return getMethod.invoke(obj);
	}
	
	private static void setProperty(Object obj, String propertyName, Object value) throws Exception{
		PropertyDescriptor pd = new PropertyDescriptor(propertyName, obj.getClass());
		//获得应该用于写入属性值的方法。
		Method setMethod = pd.getWriteMethod();
		//调用对象写入属性值的方法
		setMethod.invoke(obj, value);
	}
	
	@Test
	public void testPropertyDescriptor() throws IntrospectionException{
		Person person = new Person("高伟刚", 22);
		String propertyName = "name";
		
		PropertyDescriptor pd = new PropertyDescriptor(propertyName, person.getClass());
		
		//获取属性的类型
		System.out.println(pd.getPropertyType());
		
	}

}
