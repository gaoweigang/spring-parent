package com.gwg.hello;

public class MyTestBean {
	
	private MyTestBeanTwo myTestBeanTwo;

	private String testStr = "testStr";

	public MyTestBean(String testStr){
		this.testStr = testStr;
	}


	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}

	public void setMyTestBeanTwo(MyTestBeanTwo myTestBeanTwo) {
		this.myTestBeanTwo = myTestBeanTwo;
	}

	public MyTestBeanTwo getMyTestBeanTwo() {
		return myTestBeanTwo;
	}

}
