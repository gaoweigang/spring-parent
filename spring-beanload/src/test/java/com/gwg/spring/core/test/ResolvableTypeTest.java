package com.gwg.spring.core.test;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.springframework.core.ResolvableType;
/**
 * ResolvableType 封装了java类型，提供了与解析类相关的超类型，接口，和通用参数的访问
 * @author gaoweigang
 *
 */
public class ResolvableTypeTest {
	
	
	 private HashMap<Integer, List<String>> myMap;

	 @Test
	 public void example() throws NoSuchFieldException, SecurityException {
		 System.out.println(getClass());//getClass是从Object继承过来的
		 System.out.println(getClass().getDeclaredField("myMap"));
		 
	     ResolvableType t = ResolvableType.forField(getClass().getDeclaredField("myMap"));
	     t.getSuperType(); // AbstractMap<Integer, List<String>>
	     System.out.println(t.getSuperType());
	     t.asMap(); // Map<Integer, List<String>>
	     t.getGeneric(0).resolve(); // Integer
	     t.getGeneric(1).resolve(); // List
	     t.getGeneric(1); // List<String>
	     t.resolveGeneric(1, 0); // String
	 }

}
