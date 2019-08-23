package com.gwg.designpattern.template.test;
/**
 * 咖啡因饮料是一种抽象类
 *
 */
public abstract class CaffeineBeverage {
	
	/**
	 * 模板方法模式
	 * 现在，用同一个prepareRecipe()方法来处理茶和咖啡。prepareRecipe()被声明为final,因为我们不希望子类覆盖这个方法。
	 * 我们将步骤2和步骤4泛化成为brew()和addCondiments()
	 * 
	 */
	final void prepareRecipe(){
		this.boilWater();
		this.brew();
		this.pourInCup();
		this.addCondiments();
	}
	
	/**
	 * 因为咖啡和茶处理这些方法的做法不同(咖啡的做法是brew(),而茶是steep())，所以这两个方法必须被声明为抽象，剩余的东西留给子类去操心
	 */
	abstract void brew();
	
	abstract void addCondiments();
	
	void boilWater(){
		System.out.println("Boiling water");
	}
	
	void pourInCup(){
		System.out.println("Pouring into cup");
	}
	
	
	

}
