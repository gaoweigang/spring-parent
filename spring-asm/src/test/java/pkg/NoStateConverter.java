package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.util.TraceClassVisitor;

/**
 * 无状态转换
 *
 */
public class NoStateConverter {
	
	@Test
	public void testASMifierToC() throws IOException{
		ClassWriter cw = new ClassWriter(0);
		TraceClassVisitor tcv = new TraceClassVisitor(cw, new PrintWriter(System.out));
		ClassReader cr = new ClassReader("pkg.C");
		cr.accept(tcv, 0);
	}
	
	@Test
	public void testNoStateConverter() throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException{
		
		ClassWriter cw = new ClassWriter(0);
		TraceClassVisitor tcv = new TraceClassVisitor(cw, new PrintWriter(System.out));
		AddTimerAdapter addTimerMethodAdapter = new AddTimerAdapter(tcv);
		ClassReader cr = new ClassReader("pkg.C");
		cr.accept(addTimerMethodAdapter, 0);
		byte[] b = cw.toByteArray();
		
		MyClassLoader classLoader = new MyClassLoader();
		Class clazz = classLoader.defineClass(null, b);
		Object obj = clazz.newInstance();
		
		Method[] methods = clazz.getMethods();
		Field timerField = clazz.getField("timer");
		Method method = null;
		for(Method m : methods){
			System.out.println(m.getName());
	        if("m".equals(m.getName())){
	        	method = m;
	        }
		}
		
		System.out.println(timerField.getLong(obj));
		method.invoke(obj);//调用方法
		System.out.println(timerField.getLong(obj));

	}

}
