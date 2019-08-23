package com.gwg.java.core.genric;

import java.util.List;

public class GenericTest {
	
	public static void main(String[] args) {
		Pair<StringBuffer> pair1 = new Pair(1, 2);
		System.out.println(pair1.getFirst());
		System.out.println(pair1.getSecond());
		
	}

}
