package com.gwg.spring.java.core.propertydescriptor.test;

import java.beans.MethodDescriptor;
import java.lang.reflect.Method;
//import java.lang.reflect.Parameter;  jdk1.8中提供的类

import org.junit.Test;

/**
 * jdk1.8获取方法参数的名称
 * @author Administrator
 *
 */
public class MethodDescriptorTest {
	
	@Test
	public void testMethodDescriptor(){
		
		Method[] methods = Person.class.getMethods();
		
		for(Method method : methods){
			System.out.println(method.getName());
			//
			/*Parameter[] parameters = method.getParameters();
			for(Parameter p : parameters){
				System.out.println("方法名称："+method.getName()+"，参数名称："+p.getName()+"，参数类型："+p.getType());
			}*/
			//MethodDescriptor md = new MethodDescriptor(method);
			
		}
	}
	
	
	

}
