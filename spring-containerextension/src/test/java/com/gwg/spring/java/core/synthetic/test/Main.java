package com.gwg.spring.java.core.synthetic.test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

enum Spy {
	BLACK, WHITE
}

public class Main {

	public static void main(String... args) throws Exception {
		Class<?> c = Class.forName("com.gwg.spring.java.core.synthetic.test.Spy");
		Field[] flds = c.getDeclaredFields();
		for (Field f : flds) {
			System.out.println(f.getName()+"  :  "+f.getModifiers()+"  :  "+Modifier.toString(f.getModifiers())+"  :  "+f.isSynthetic());
		}
	}
}

/*
BLACK  :  false
WHITE  :  false
ENUM$VALUES  :  true  

*/