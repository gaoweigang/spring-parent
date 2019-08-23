package com.gwg.spring.configfile.filenameplaceholer.test;

public class TestOneBean {

	private String testStr = "testOneBean";

	public TestOneBean(String testStr){
		this.testStr = testStr;
	}


	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}

}
