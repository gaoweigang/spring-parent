package com.gwg.spring.lookupMethod.test;

public abstract class CommandManager {
	
	public Object process(Object commandState){
		//获取一个Command类型的新实例
		Command command = createCommand();
		//在全新的Command实例上设置state
		command.setState(commandState);
		return command.execute();
	}
	
	/**
	 * okay...但是这个方法的实现在哪里呢？
	 * @return
	 */
	protected abstract Command createCommand();

}
