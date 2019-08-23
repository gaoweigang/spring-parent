package com.gwg.asm.methodparam;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gwg.spring.asm.ClassVisitor;
import com.gwg.spring.asm.MethodVisitor;
import com.gwg.spring.asm.Opcodes;
import com.gwg.spring.asm.SpringAsmInfo;


/**
 * Helper class that inspects all methods (constructor included) and then
 * attempts to find the parameter names for that member.
 */
 public class ParameterNameDiscoveringVisitor extends ClassVisitor {
	 
	 private static final Logger LOGGER = LoggerFactory.getLogger(ParameterNameDiscoveringVisitor.class);

	private static final String STATIC_CLASS_INIT = "<clinit>";

	private final Class<?> clazz;

	private final Map<Member, String[]> memberMap;

	public ParameterNameDiscoveringVisitor(Class<?> clazz, Map<Member, String[]> memberMap) {
		super(SpringAsmInfo.ASM_VERSION);
		this.clazz = clazz;
		this.memberMap = memberMap;
	}

	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
		// exclude synthetic + bridged && static class initialization
		LOGGER.info("方法访问修饰符："+Modifier.toString(access)+"方法名称:"+name);
		if (!isSyntheticOrBridged(access) && !STATIC_CLASS_INIT.equals(name)) {
			return new LocalVariableTableVisitor(clazz, memberMap, name, desc, isStatic(access));
		}
		return null;
	}

	//判断方法的访问修饰符是不是同时为ACC_SYNTHETIC和ACC_BRIDGE (这个是不是针对jdk的版本？)
	private static boolean isSyntheticOrBridged(int access) {
		LOGGER.info("access:"+Modifier.toString(access));
		return (((access & Opcodes.ACC_SYNTHETIC) | (access & Opcodes.ACC_BRIDGE)) > 0);
	}

	private static boolean isStatic(int access) {
		return ((access & Opcodes.ACC_STATIC) > 0);
	}
}
