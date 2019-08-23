package com.gwg.spring.java.core.synthetic.test;

import java.lang.reflect.Modifier;


public class SyntheticTest {
	
	private class Cat{
		
	}
	
	private static final class Dog{
		
	}
	
	
	public static void main(String[] args) {

	
		checkSynthetic("com.gwg.spring.java.core.synthetic.test.SyntheticTest");
		checkSynthetic("com.gwg.spring.java.core.synthetic.test.SyntheticTest$Cat");
		checkSynthetic("com.gwg.spring.java.core.synthetic.test.SyntheticTest$Dog");

		
	}
	
    static void checkSynthetic (String name) { 
        try { 
            System.out.println (name + " : " + Modifier.toString(Class.forName (name).getModifiers())+" : "+Class.forName (name).getModifiers()+"  : "+Class.forName (name).isSynthetic()); 
        } catch (ClassNotFoundException exc) { 
            exc.printStackTrace (System.out); 
        }
    }


}
