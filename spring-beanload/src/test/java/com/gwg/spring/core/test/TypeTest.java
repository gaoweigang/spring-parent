package com.gwg.spring.core.test;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
/**
 * Type是java语言中所有类型的公共父接口。它们包括原始类型、参数化类型、数组类型、类型变量(即泛型变量)和基本类型。
 * Type所有类型指代的有：原始类型 (raw types)【对应Class】，参数化类型 (parameterizedtypes)【对应ParameterizedType】， 
 * 数组类型 (array types)【对应GenericArrayType】，类型变量 (type variables)【对应TypeVariable】，基本数据类型(primitivetypes)【仍然对应Class】 
 * 
 * 参数化类型(parameterizedtypes):List<? extends Number>, List<?>, List<V>, List<String> 
 * 数组类型：T[] , String[] 均是数组类型，只是类型不同而已
 * 原始类型(Class)： String
 * 变量类型： V
 */
public class TypeTest {
	public static <T, V> void fun(List<? extends Number> list, T[] param, String[] strs, String str, V v, List<V> listv, 
			List<?> list2, List<String> listStr){
		
	}
	public static <E> String  funIV(String str){
		
		return null;
	}
	
	public static <E> void methodIV(ArrayList<ArrayList> al1, ArrayList al2, ArrayList al3, ArrayList<? extends Number> al4,
			ArrayList al5){
		
	}
	
	/**
	 * 参数类型
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	@Test
	public void testType() throws NoSuchMethodException, SecurityException{
		Method method = getClass().getMethod("fun", List.class, Object[].class, String[].class, String.class, Object.class, List.class, List.class, List.class);
		
		//获取参数类型
		Type[] genericParameterTypes = method.getGenericParameterTypes();
		
		//参数类型又可以细分为多种
		for(Type type : genericParameterTypes){  
			System.out.println("*************start*****************************");
			if(type instanceof GenericArrayType){
				GenericArrayType genericArrayType = (GenericArrayType) type;
				System.out.println("GenericArrayType#############"+genericArrayType);
				if(genericArrayType.getGenericComponentType() instanceof TypeVariable){//
					System.out.println("GenericArrayType#############"+genericArrayType.getGenericComponentType());
				}
			}
			/**
			 * 可参数化类型：>
			 */
			if(type instanceof ParameterizedType){
				ParameterizedType parameterizedType = (ParameterizedType) type;
				System.out.println("ParameterizedType#############"+parameterizedType);
			    //
				System.out.println("真实参数类型大小："+parameterizedType.getActualTypeArguments().length);
				if(parameterizedType.getActualTypeArguments()[0] instanceof WildcardType){
					 WildcardType wildcardType=(WildcardType) parameterizedType.getActualTypeArguments()[0];  
					 System.out.println("ParameterizedType : WildcardType#############"+parameterizedType.getActualTypeArguments()[0]);
					 Type upperType=null;  
                     Type lowerType=null;  
                     Type[] upperBounds = wildcardType.getUpperBounds();  
                     if(upperBounds.length>0)upperType=upperBounds[0];  
                     Type[] lowerBounds = wildcardType.getLowerBounds();  
                     if(lowerBounds.length>0)lowerType=lowerBounds[0];  
                       
                     System.out.println("的下限为 "+lowerType);  
                     System.out.println("的上限为 "+upperType);  
					
				}
				System.out.println("parameterizedType原始类型："+parameterizedType.getRawType());
				if(parameterizedType.getRawType() instanceof Class){
					
				}
			}
			if(type instanceof TypeVariable){
				TypeVariable typeVariable=(TypeVariable) type;  
				System.out.println("TypeVariable#############"+type);
                Type[] bounds = typeVariable.getBounds();  
                String name = typeVariable.getName();  
                GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();  
                System.out.println("bounds="+Arrays.toString(bounds));  
                System.out.println("name="+name);  
                System.out.println("genericDeclaration="+genericDeclaration);  
			}
			if(type instanceof WildcardType){
				WildcardType wildcardType = (WildcardType) type;
				System.out.println("WildcardType#############"+wildcardType);

			}
			if(type instanceof Class){
				Class clazz = (Class) type;
				System.out.println("Class#############"+clazz);

			}
				
			System.out.println("*************end*****************************");

		}
		
		
	}
	
	/**
	 * 区分原始类型 和 基本类型
	 * 基本类型有8种byte, short, int, long, float, dubble, boolean ,char
	 * 原始类型：
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	
	
	
	/**
	 * 返回类型
	 */
	
	
	/**
	 * 类型变量，比如<E> 变量类型是E，个数为1
	 *              <A, V> 变量类型是A和V， 个数为2
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	@Test
	public void testTypeVariable() throws NoSuchMethodException, SecurityException{
		Method method = getClass().getMethod("fun", List.class, Object[].class, String[].class, String.class, Object.class, List.class, List.class, List.class);
		//获取类型变量(Type variable)
		TypeVariable<Method>[] typeParameters  = method.getTypeParameters();
		System.out.println("类型变量的个数："+typeParameters.length);
		
		for(TypeVariable typeVariable : typeParameters){
			System.out.println(typeVariable);
		}
		
		Method method2 = getClass().getMethod("funIV", String.class);
		TypeVariable<Method>[] typeParameters2  = method2.getTypeParameters();
		System.out.println("类型变量的个数***："+typeParameters2.length);
	}
	
	
}
