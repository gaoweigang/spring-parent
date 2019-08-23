package com.gwg.spring.java.core.propertydescriptor.test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.ParameterDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class IntrospectorTest {
	
	/**
	 * 属性描述符
	 * @throws Exception
	 */
	@Test
	public void testPropertyDescriptor() throws Exception {
		Person person = new Person("gaoweigang", 20);
		String propertyName = "name";
		BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		Object returnVal = null;
		for(PropertyDescriptor pd : pds){
			if(pd.getName().equals(propertyName)){
				returnVal = pd.getReadMethod().invoke(person);
			}
		}
		System.out.println(returnVal);
	}
	
	/**
	 * 方法描述符
	 */
	@Test
	public void testMethodDescriptor() throws Exception {
		Person person = new Person("gaoweigang", 20);
		String methodName = "setName";
		BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
		MethodDescriptor[] mds = beanInfo.getMethodDescriptors();
		Object returnVal = null;
		for(MethodDescriptor md : mds){
			if(md.getName().equals(methodName)){
				System.out.println(md.getName());
				System.out.println(md.getDisplayName());
				System.out.println(md.getShortDescription());
				ParameterDescriptor[] pds = md.getParameterDescriptors();
				for(ParameterDescriptor pd : pds){
					System.out.println(pd.getName());
				}

			}
		}
	}
	
	/**
	 * 方法参数描述符
	 */
	@Test
	public void testParameterDescriptor() throws Exception {
		Person person = new Person("gaoweigang", 20);
		String propertyName = "setName";
		BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
		MethodDescriptor[] mds = beanInfo.getMethodDescriptors();
		Object returnVal = null;
		for(MethodDescriptor md : mds){
			System.out.println(md.getName());
			System.out.println(md.getParameterDescriptors());
			if(md.getName().equals(propertyName)){
			}
		}
		System.out.println(returnVal);
	}
	
	/**
	 * 内省
	 */
	@Test
	public void testInterface() throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		String propertyAge = "age";
		String propertyName = "name";
		Cat cat = new Cat("猫咪", 1);
		Person person = new Person("gaoweigang", 21);
		BeanInfo beanInfo = Introspector.getBeanInfo(Animal.class);
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		//属性描述符
		for(PropertyDescriptor pd : pds){
			System.out.println("属性类型："+pd.getPropertyType()+"，属性名称："+pd.getName());
			//只要有 getter/setter 方法中的其中一个，那么 Java 的内省机制就会认为存在一个属性
			if(pd.getName().equals(propertyName)){
				System.out.println("*******************************************");
				System.out.println(pd.getName());
				Method getMethod = pd.getReadMethod();
				System.out.println(getMethod.invoke(cat));
				Method setMethod = pd.getWriteMethod();
				setMethod.invoke(cat, "高weigang");
				System.out.println(getMethod.invoke(cat, null));
				System.out.println("*******************************************");
			}else if(pd.getName().equals(propertyAge)){
				System.out.println("######################################");
				System.out.println(pd.getName());
				//尝试调用Animal接口的setAge方法
				Method setMethod = pd.getWriteMethod();
				/*setMethod.invoke(person, 20);
				System.out.println(person.getAge());*/
				System.out.println("######################################");
			}
			
		}
		
	}
	
	
}
