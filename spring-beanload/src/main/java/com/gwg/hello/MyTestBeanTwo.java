package com.gwg.hello;

public class MyTestBeanTwo {
	
	private MyTestBean myTestBean;

	private String testStr = "testStr";
	
	/**
	 * 默认的构造函数
	 */
	public MyTestBeanTwo(){}
	
	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}

	public void setMyTestBean(MyTestBean myTestBean) {
		this.myTestBean = myTestBean;
	}

	public MyTestBean getMyTestBean() {
		return myTestBean;
	}

}
