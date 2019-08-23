package com.gwg.classloader.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import sun.reflect.Reflection;

import org.junit.Test;


public class ClassLoaderTest {
	
	@Test
	public void testClassLoader() throws ClassNotFoundException, SQLException{
		
		// 加载Class到AppClassLoader（系统类加载器），然后注册驱动类
		Class.forName("com.mysql.jdbc.Driver"); 
		String url = "jdbc:mysql://localhost:3306/dev";    
		// 通过java库获取数据库连接
		Connection conn = DriverManager.getConnection(url, "root", "123456"); 
		
		
	}
	
	@Test
	public void testReflection(){
		
		Class clazz = Reflection.getCallerClass(1);
		System.out.println(clazz);
	}
	 
	@Test
	public void testCallerSensitiveAnnotation() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException{
		
		Class exmapleClazz = Class.forName("com.gwg.classloader.test.Example");
		Method method = exmapleClazz.getMethod("getName");
		Class<?> clazz = (Class<?>) method.invoke(null);
		/*Class<?> clazz = Example.getName();*/
		System.out.println(clazz);
	}
	
}
