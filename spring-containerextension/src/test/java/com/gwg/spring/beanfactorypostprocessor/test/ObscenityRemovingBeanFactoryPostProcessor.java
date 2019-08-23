package com.gwg.spring.beanfactorypostprocessor.test;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

public class ObscenityRemovingBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	private Set<String> obsenities;
	
	public ObscenityRemovingBeanFactoryPostProcessor(){
		this.obsenities = new HashSet<String>();
	}
	
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String[] beanNames = beanFactory.getBeanDefinitionNames();
		
		for(String beanName : beanNames){
			BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
			StringValueResolver valueResolver = new StringValueResolver() {
				
				public String resolveStringValue(String strVal) {
					if(isObscene(strVal)){
						return "*****";
					}
					return strVal;
				}
			};
			
			BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
			visitor.visitBeanDefinition(bd);
		}
		
		
		
	}
	
	public boolean isObscene(Object value){
		String potentialObscenity = value.toString().toUpperCase();
		return this.obsenities.contains(potentialObscenity);
	}

	public void setObsenities(Set<String> obsenities) {
		this.obsenities = obsenities;
	}

}
