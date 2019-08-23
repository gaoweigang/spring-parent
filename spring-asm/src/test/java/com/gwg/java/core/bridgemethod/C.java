package com.gwg.java.core.bridgemethod;
/**
 * 思考：这个为什么不会生成桥接方法
 * @author gaoweigang
 *
 * @param <T>
 */
public class C<T> extends A<T>{

	@Override
	public T method1(T arg) {
		return null;
	}

	@Override
	public T method2() {
		return null;
	}
	

}
