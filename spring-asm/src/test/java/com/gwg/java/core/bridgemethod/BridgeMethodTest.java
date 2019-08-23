package com.gwg.java.core.bridgemethod;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gwg.asm.methodparam.ParameterNameDiscoveringVisitor;
import com.gwg.asm.methodparam.TestBean;
import com.gwg.spring.asm.ClassReader;
import com.gwg.util.ModifierUtil;

/**
 * Java中的Bridge方法
 * 尝试通过反射判断一个方法是不是桥接方法
 *
 */
public class BridgeMethodTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BridgeMethodTest.class);
	
	@Test
	public void testBridgeMethod() throws IOException{
		//获取class文件名称
    	Class clazz = B.class;
    	String classFileFullName = clazz.getName();
    	LOGGER.info("classFileFullName:"+classFileFullName);
    	int lastDotIndex = classFileFullName.lastIndexOf(".");
    	LOGGER.info("lastDotIndex:"+lastDotIndex);
    	String className = classFileFullName.substring(lastDotIndex + 1) + ".class";
    	LOGGER.info("className:"+className);
    	//获取class文件的输入流
    	InputStream inputStream = clazz.getResourceAsStream(className);
    	ClassReader cr = new ClassReader(inputStream);
    	Map<Member, String[]> map = new HashMap<Member, String[]>();
    	cr.accept(new ParameterNameDiscoveringVisitor(clazz, map), 0);
    	LOGGER.info("map大小:"+map.size());
		
		
	}
	
	/**
	 * 通过反射判断一个方法是不是交接方法java.lang.reflect.Method.isBridge()
	 * 分析字段/方法访问修饰符最准确的方法就是直接分析字段/方法的访问修饰值
	 */
	@Test
	public void testIsBridgeByReflect(){
		Class clazz = B.class;
		//通过反射获取类中的所有方法
		Method[] methods = clazz.getMethods();
	
		LOGGER.info("类中拥有的方法数量："+methods.length);
		for(Method method : methods){
			System.out.println("方法名称："+method.getName()+", 方法修饰符："+method.getModifiers()+" : "+ModifierUtil.toString(method)+
					"，是不是桥接方法："+method.isBridge()+"，是不是编译器生成的方法："+method.isSynthetic());
		}
	}

}
