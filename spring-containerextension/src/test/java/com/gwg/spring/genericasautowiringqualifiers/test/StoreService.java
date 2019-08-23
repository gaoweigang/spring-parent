package com.gwg.spring.genericasautowiringqualifiers.test;

import org.springframework.beans.factory.annotation.Autowired;

public class StoreService {
	
	@Autowired
	private Store<String> s1;
	
	@Autowired
	private Store<Integer> s2;

	public Store<String> getS1() {
		return s1;
	}

	public void setS1(Store<String> s1) {
		this.s1 = s1;
	}

	public Store<Integer> getS2() {
		return s2;
	}

	public void setS2(Store<Integer> s2) {
		this.s2 = s2;
	}

}
