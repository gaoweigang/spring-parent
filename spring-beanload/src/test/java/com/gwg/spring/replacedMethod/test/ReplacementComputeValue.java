package com.gwg.spring.replacedMethod.test;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class ReplacementComputeValue implements MethodReplacer {

	public Object reimplement(Object o, Method m, Object[] args)
			throws Throwable {
		// get the input value, work with it, and return a computed result
		System.out.println("kobe not that good, YaoMing perfect");
		System.out.println("======================="+o);
		return args[0];
	}

}
