package com.gwg.java.core.bridgemethod;
/**
 * 思考：这个为什么会生成桥接方法
 * @author gaoweigang
 *
 */
public class B extends A<String>{

	@Override
	public String method1(String arg) {
		return arg;
	}

	@Override
	public String method2() {
		return "abc";
	}
	
	

}
