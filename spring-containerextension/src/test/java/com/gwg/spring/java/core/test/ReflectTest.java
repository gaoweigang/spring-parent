package com.gwg.spring.java.core.test;

import java.lang.reflect.Constructor;

import org.junit.Test;

/**
 * 
 * 在jdk1.8中获取构造函数参数名称,但只能获取类似arg0, arg1这样的名称
 * 在jdk1.8之前无法获取构造函数参数名称
 *
 */
public class ReflectTest {
	
	@Test
	public void testGetConstructorArgNameInJdk8() throws NoSuchMethodException, SecurityException {
		Person person = new Person("高伟刚", 22);
		//获取指定构造函数
		Constructor constructor = person.getClass().getConstructor(new Class[]{String.class, int.class});
		System.out.println(constructor);

		Class[] parameterTypes = constructor.getParameterTypes();
		
		for(Class clazz : parameterTypes){
			System.out.println(clazz);
		}
		 
		 
		/* jdk1.8
		 * for(Parameter p : parameters){
			System.out.println(p.getName());
		}*/
		
	
	}
	
	
	/**
	 * 通过反射获取类的包名
	 */
	@Test
	public void testGetClassFullPackageName() throws NoSuchMethodException, SecurityException {
		Person person = new Person("高伟刚", 22);
		//获取指定构造函数
		Package p = person.getClass().getPackage();
		System.out.println(p.getName());

		
	
	}


}
