package com.gwg.spring.java.test;

import java.beans.ConstructorProperties;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class ConstructorTest {

    @ConstructorProperties(value="name_a")
	protected ConstructorTest(String name) {
		System.out.println("************name:"+name);
	}

	@ConstructorProperties(value="age")
	public ConstructorTest(int age) {
		System.out.println("***********age:"+ age);
	}

	@Test
	public void testConstructorModifier() throws NoSuchMethodException,
			SecurityException {

		Class clazz = ConstructorTest.class;
		Constructor[] constructors = clazz.getDeclaredConstructors();
		// 获取参数类型为java.lang.String的构造方法
		Constructor constructorWithString = clazz.getDeclaredConstructor(new Class[] { String.class });
		System.out.println("获取指定构造方法：" + constructorWithString);

		Constructor constructor = null;
		if (constructors != null && constructors.length > 0) {
			constructor = constructors[0];
			/**
			 * 以整数形式返回此 Constructor 对象所表示构造方法的 Java 语言修饰符。可以使用 Modifier
			 * 类对这些修饰符进行解码。 constructor.getModifiers() :
			 * 返回Constructor对象表示的构造方法的java语言修饰符整数形式 Modifier.toString():
			 * 使用Modifier类对这些修饰符进行解码
			 */
			System.out.println("构造函数修饰符：" + constructor.getModifiers()
					+ "********************** 使用Modifier类对这些修饰符进行解码:"
					+ Modifier.toString(constructor.getModifiers()));
		}

	}

	@Test
	public void testGetSpecialConstructorWithString()
			throws NoSuchMethodException, SecurityException {

		Class clazz = ConstructorTest.class;
		Constructor[] constructors = clazz.getDeclaredConstructors();
		// 获取参数类型为java.lang.String的构造方法
		//思考： 如果获取int类型的构造函数???
		Constructor constructorWithString = clazz.getDeclaredConstructor(new Class[] { String.class});
		System.out.println("获取指定构造方法：" + constructorWithString);
		
	}
	
	/**
	 * ConstructorProperties注解的作用
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	@Test
	public void testAnnotationConstructorProperties() throws NoSuchMethodException, SecurityException{
	    Class clazz = ConstructorTest.class;
		
		Constructor constructorWithString = clazz.getDeclaredConstructor(new Class[]{String.class});
		
		ConstructorProperties cp = (ConstructorProperties) constructorWithString.getAnnotation(ConstructorProperties.class);
		if (cp != null) {
			String[] names = cp.value();
			System.out.println(names);
		}
	}
	
	@Test
	public void testInt() {
		Class clazz = ConstructorTest.class;
		
		Constructor[] constructors = clazz.getDeclaredConstructors();
		for(Constructor constructor : constructors){
			Class[] parameterTypes = constructor.getParameterTypes();
			for(Class type : parameterTypes){
				System.out.println(type);
			}

		}
	}
	

	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		System.out.println("*******************************");
		Class clazz = ConstructorTest.class;
		Constructor[] constructors = clazz.getDeclaredConstructors();
		// 获取参数类型为java.lang.String的构造方法
		Constructor<?> constructorWithString = clazz.getDeclaredConstructor(new Class[] { String.class });
		System.out.println("获取指定构造方法：" + constructorWithString);

		
		ConstructorProperties cp = constructorWithString.getAnnotation(ConstructorProperties.class);
		String[] names = cp.value();
		System.out.println("获取指定构造方法：" + names);
	}

}
