package pkg;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.TraceClassVisitor;
import org.objectweb.asm.util.TraceMethodVisitor;

public class MethodGenerate {
	
	/**
	 * 通过ASMifier 打印出使用ASM 如何生成  pkg/Bean
	 * @throws IOException 
	 */
	@Test
	public void testASMToBean() throws IOException{
		ClassWriter cw = new ClassWriter(0);
		TraceClassVisitor tcv = new TraceClassVisitor(cw, new ASMifier(), new PrintWriter(System.out));
		ClassReader cr = new ClassReader("pkg.Bean");
		cr.accept(tcv, 0);
		
	}
	
	@Test
	public void testMethodGenerate() throws InstantiationException, IllegalAccessException, IntrospectionException, IllegalArgumentException, InvocationTargetException{
		//将不会自动进行计算。你必须自己计算帧，局部变量和操作数栈的大小
		ClassWriter cw = new ClassWriter(0);
		TraceClassVisitor tcv = new TraceClassVisitor(cw, new PrintWriter(System.out));
		cw.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC, "pkg/MethodGenerateTest", null, "java/lang/Object", null);
		FieldVisitor f1 = cw.visitField(Opcodes.ACC_PRIVATE, "f", "I", null, null);
		f1.visitEnd();
		//生成默认的构造方法
		MethodVisitor mv0 = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
		mv0.visitCode();
		mv0.visitVarInsn(Opcodes.ALOAD, 0);
		mv0.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
		mv0.visitInsn(Opcodes.RETURN);
		mv0.visitMaxs(1, 1);
		mv0.visitEnd();

		//生成setter方法
		MethodVisitor mv1 = cw.visitMethod(Opcodes.ACC_PUBLIC, "getF", "()I", null, null);
		mv1.visitCode();
		mv1.visitVarInsn(Opcodes.ALOAD, 0);
		mv1.visitFieldInsn(Opcodes.GETFIELD, "pkg/MethodGenerateTest", "f", "I");
		mv1.visitInsn(Opcodes.IRETURN);
		mv1.visitMaxs(1, 1);
		mv1.visitEnd();
		
		MethodVisitor mv2 = cw.visitMethod(Opcodes.ACC_PUBLIC, "setF", "(I)V", null, null);
		mv2.visitCode();
		mv2.visitVarInsn(Opcodes.ALOAD, 0);
		mv2.visitVarInsn(Opcodes.ILOAD, 1);
		mv2.visitFieldInsn(Opcodes.PUTFIELD, "pkg/MethodGenerateTest", "f", "I");
		mv2.visitInsn(Opcodes.RETURN);
		mv2.visitMaxs(2, 2);
		mv2.visitEnd();
		
		cw.visitEnd();
		byte[] b = cw.toByteArray();
		
		ClassReader cr = new ClassReader(b);
		cr.accept(tcv, 0);
		
		//加载自定义的类
		Class clazz = new MyClassLoader().defineClass(null, b);
		Object obj = clazz.newInstance();
		
		//通过内省
		BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
		PropertyDescriptor[] propertyDescriptorArr = beanInfo.getPropertyDescriptors();
		Method setFMethod = null;
		Method getFMethod = null;
	    for(PropertyDescriptor p : propertyDescriptorArr){
	    	if("f".equals(p.getName())){
	    		setFMethod = p.getWriteMethod();
	    		getFMethod = p.getReadMethod();
	    	}
	    }
	    //设置对象成员变量f的值
	    setFMethod.invoke(obj, 23);
	    System.out.println(getFMethod.invoke(obj));
	    
	
		
	}
	
	

}
