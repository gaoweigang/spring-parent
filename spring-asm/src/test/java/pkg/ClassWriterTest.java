package pkg;

import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.*;

public class ClassWriterTest {
	
	private byte[] clazzb;
	
	@Before
	public void before(){
		//动态生成字节码文件  ClassWriter extends ClassVisitor
		ClassWriter cw = new ClassWriter(0);
		/*
		 * 调用visit方法定义类的头
		 * V1_5 指定class文件的版本为java1.5，该参数是一个常量，像所有其它的ASM常量一样，定义在ASM的Opcodes接口
		 * 一个类的内部名称就是这个类的全路径名称，将包名中的点号替换为/。例如，String的内部名称为java/lang/String。
		 */
		cw.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT + Opcodes.ACC_INTERFACE, "pkg/Comparable"
				, null, "java/lang/Object", new String[]{"pkg/Mesurable"});
		cw.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "LESS", "I", null, new Integer(-1)).visitEnd();
		cw.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "EQUAL", "I", null, new Integer(0)).visitEnd();
		cw.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "GREATER", "I", null, new Integer(1)).visitEnd();
		cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT , "compareTo", "(Ljava/lang/Object;)I", null, null).visitEnd();
		cw.visitEnd();
		byte[] b = cw.toByteArray();
		//给成员变量赋值
		clazzb = b;
       
		//动态加载Class文件
		MyClassLoader classLoader = new MyClassLoader();
		Class clazz = classLoader.defineClass(null, b);
		
		//输出类名
		System.out.println(clazz.getName());
				
	}
	
	@Test
	public void convertClass(){
		ClassWriter cw = new ClassWriter(0);
		ClassReader cr = new ClassReader(clazzb);
		cr.accept(cw, 0);
		byte[] b2 = cw.toByteArray();///b2 代表与clazzb相同的class
		
	}
	
	/**
	 * 
	 */
	@Test
	public void testClassAdapter(){
		ClassWriter cw = new ClassWriter(0);
		//cv将所有事件转发给cw
		ClassVisitor cv = new ClassVisitor(Opcodes.ASM4, cw) {};
		ClassReader cr = new ClassReader(clazzb);
		cr.accept(cv, 0);
		byte[] b2 = cw.toByteArray(); //b2代表与clazzb相同的class
		
	}
	


	@Test
	public void testAddField() throws Exception{

		ClassWriter cw = new ClassWriter(0);
		AddFieldAdapter afd = new AddFieldAdapter(cw, Opcodes.ACC_PUBLIC, "name", "Ljava.lang.String");
		ClassReader cr = new ClassReader("pkg.Dog");
		cr.accept(afd, 0);
		byte[] b = cw.toByteArray();
		File classFile = new File("DogExtension.class");
		FileOutputStream fileOutputStream = new FileOutputStream(classFile);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		bufferedOutputStream.write(b);


	}
	
	@Test
	public void testInterfaceACC() throws IOException{
		ClassWriter cw = new ClassWriter(0);
		TraceClassVisitor tcv = new TraceClassVisitor(cw, new PrintWriter(System.out));
		ClassReader cr = new ClassReader("pkg.Animal");
		cr.accept(tcv, 0);
	}

}
