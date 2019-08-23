package com.gwg.asm.methodparam;

import java.lang.reflect.Member;
import java.util.Map;

import com.gwg.spring.asm.Label;
import com.gwg.spring.asm.MethodVisitor;
import com.gwg.spring.asm.SpringAsmInfo;
import com.gwg.spring.asm.Type;


public class LocalVariableTableVisitor extends MethodVisitor {

	private static final String CONSTRUCTOR = "<init>";

	private final Class<?> clazz;

	private final Map<Member, String[]> memberMap;

	private final String name;

	private final Type[] args;

	private final String[] parameterNames;

	private final boolean isStatic;

	private boolean hasLvtInfo = false;

	/*
	 * The nth entry contains the slot index of the LVT table entry holding the
	 * argument name for the nth parameter.
	 */
	private final int[] lvtSlotIndex;

	public LocalVariableTableVisitor(Class<?> clazz, Map<Member, String[]> map, String name, String desc, boolean isStatic) {
		super(SpringAsmInfo.ASM_VERSION);
		this.clazz = clazz; //类字节码
		this.memberMap = map;
		this.name = name; //方法名称
		this.args = Type.getArgumentTypes(desc); //根据方法描述符获取方法参数类型数组
		this.parameterNames = new String[this.args.length];
		this.isStatic = isStatic; //是不是静态方法
		this.lvtSlotIndex = computeLvtSlotIndices(isStatic, this.args);//方法参数在局部变量表中起始索引位置数组
	}

	@Override
	public void visitLocalVariable(String name, String description, String signature, Label start, Label end, int index) {
		this.hasLvtInfo = true;
		for (int i = 0; i < this.lvtSlotIndex.length; i++) {
			if (this.lvtSlotIndex[i] == index) {
				this.parameterNames[i] = name;
			}
		}
	}

	@Override
	public void visitEnd() {
		if (this.hasLvtInfo || (this.isStatic && this.parameterNames.length == 0)) {
			// visitLocalVariable will never be called for static no args methods
			// which doesn't use any local variables.
			// This means that hasLvtInfo could be false for that kind of methods
			// even if the class has local variable info.
			this.memberMap.put(resolveMember(), this.parameterNames);
		}
	}

	private Member resolveMember() {
		ClassLoader loader = this.clazz.getClassLoader();
		Class<?>[] argTypes = new Class<?>[this.args.length];
		for (int i = 0; i < this.args.length; i++) {
			argTypes[i] = ClassUtils.resolveClassName(this.args[i].getClassName(), loader);
		}
		try {
			if (CONSTRUCTOR.equals(this.name)) {
				return this.clazz.getDeclaredConstructor(argTypes);
			}
			return this.clazz.getDeclaredMethod(this.name, argTypes);
		}
		catch (NoSuchMethodException ex) {
			throw new IllegalStateException("Method [" + this.name +
					"] was discovered in the .class file but cannot be resolved in the class object", ex);
		}
	}

	/**
	 * 获取方法参数在局部变量表中起始索引位置数组
	 * 静态方法中局部变量索引位置为0不是当前对象，而是参数
	 * @param isStatic
	 * @param paramTypes
	 * @return
	 */
	private static int[] computeLvtSlotIndices(boolean isStatic, Type[] paramTypes) {
		int[] lvtIndex = new int[paramTypes.length];
		int nextIndex = (isStatic ? 0 : 1); 
		for (int i = 0; i < paramTypes.length; i++) {
			lvtIndex[i] = nextIndex;
			if (isWideType(paramTypes[i])) {
				nextIndex += 2;
			}
			else {
				nextIndex++;
			}
		}
		return lvtIndex;
	}

	/**
	 * 获取Type所占的slot个数
	 */
	private static boolean isWideType(Type aType) {
		// float is not a wide type
		return (aType == Type.LONG_TYPE || aType == Type.DOUBLE_TYPE);
	}
	
}