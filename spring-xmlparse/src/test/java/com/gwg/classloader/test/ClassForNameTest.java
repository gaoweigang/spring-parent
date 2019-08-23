package com.gwg.classloader.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;

import sun.reflect.Reflection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Test;


public class ClassForNameTest {
	
	
	@Test
	public void testForName() throws ClassNotFoundException{
		
		/*使用加载当前类的类加载其加载com.gwg.hello.MyTestBean*/
		Class clazz = Class.forName("com.gwg.hello.MyTestBean");
		System.out.println(clazz.getClassLoader());
		//等价于
		Class clazz1 = Class.forName("com.gwg.hello.MyTestBean", true, ClassForNameTest.class.getClassLoader());
		System.out.println(clazz == clazz1);
		
	}
	
	@Test
	public void testMySqlDriver() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/dev";
		
		//
		Connection conn = DriverManager.getConnection(url, "root", "123456");
		
	}
	
	@Test
	public void testCopyOnWriteArrayList(){
		CopyOnWriteArrayList<Student> registeredDrivers = new CopyOnWriteArrayList<Student>();
		Student stu = new Student();
		registeredDrivers.addIfAbsent(stu);
		registeredDrivers.addIfAbsent(stu);
		System.out.println(registeredDrivers.size());
		
		
	}
	

	@Test
	public void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		System.out.println(System.getProperty("java.ext.dirs"));
		/*ReflectionTest在扩展类加载器加载路径下面*/
		Class clazz = Class.forName("com.gwg.resource.test.test");
		Method method = clazz.getDeclaredMethod("test",null);
		Class c1 =  (Class) method.invoke(clazz.newInstance());
		System.out.println(c1);
		
		
		System.out.println(clazz.getClassLoader());
		
		/*Class clazz = Reflection.getCallerClass(0);
		System.out.println(clazz);
		System.out.println(clazz.getClassLoader());*/
		
	}

	/**
	 * 重新编译了可调试rt.jar
	 * 注释掉了@CallerSensitive之后，看看能不能调用Reflection.getCallerClass()方法，并且看看类加载器是什么
	 * 
	 */
	@Test
	public void testCallerSensitive(){
		
		
	}
}
