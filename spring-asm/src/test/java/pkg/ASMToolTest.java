package pkg;

import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.CheckClassAdapter;
import org.objectweb.asm.util.TraceClassVisitor;

public class ASMToolTest {
	
	/**
	 * TraceClassVisitor 打印转换后的class
	 * @throws IOException 
	 */
	@Test
	public void testTraceClassVisitor() throws IOException{
		ClassWriter cw = new ClassWriter(0);
		TraceClassVisitor cv = new TraceClassVisitor(cw, new PrintWriter(System.out));
		AddFieldAdapter addFieldAdapter = new AddFieldAdapter(cv, Opcodes.ACC_PUBLIC, "name", "Ljava.lang.String");
		ClassReader cr = new ClassReader("pkg.Dog");
		cr.accept(addFieldAdapter, 0);
		byte[] b = cw.toByteArray();
		
	}
	
	/**
	 * TraceClassVisitor 打印转换后的class
	 * @throws IOException 
	 */
	@Test
	public void testCheckClassAdapter() throws IOException{
		ClassWriter cw = new ClassWriter(0);
		TraceClassVisitor cv = new TraceClassVisitor(cw, new PrintWriter(System.out));
		AddFieldAdapter addFieldAdapter = new AddFieldAdapter(cv, Opcodes.ACC_PUBLIC, "name", "Ljava.lang.String");
		CheckClassAdapter checkClassAdapter = new CheckClassAdapter(addFieldAdapter);
		//checkClassAdapter.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC, "test", "()", "pkg/Animal", null);
		//checkClassAdapter.visitEnd();
		ClassReader cr = new ClassReader("pkg.Dog");
		cr.accept(addFieldAdapter, 0);
		byte[] b = cw.toByteArray();
		
	}
	
	/**
	 * ASMifier 来打印出 如何用ASM来动态生成所需要的类
	 * @throws IOException 
	 */
	@Test
	public void testASMifierGenerateRunnable() throws IOException{
		ClassWriter cw = new ClassWriter(0);
		TraceClassVisitor cv = new TraceClassVisitor(cw, new ASMifier(), new PrintWriter(System.out));
		ClassReader cr = new ClassReader("java.lang.Runnable");
		cr.accept(cv, 0);
	}
	
	/**
	 * ASMifier 来打印出 如何用ASM来动态生成所需要的类
	 * @throws IOException 
	 */
	@Test
	public void testASMifier() throws IOException{
		ClassWriter cw = new ClassWriter(0);
		TraceClassVisitor cv = new TraceClassVisitor(cw, new ASMifier(), new PrintWriter(System.out));
		AddFieldAdapter addFieldAdapter = new AddFieldAdapter(cv, Opcodes.ACC_PUBLIC, "name", "Ljava.lang.String");
		ClassReader cr = new ClassReader("pkg.Dog");
		cr.accept(addFieldAdapter, 0);
	}
	
	/**
	 * TraceClassVisitor 打印转换后的class
	 * @throws IOException 
	 */
	@Test
	public void testMethodExample() throws IOException{
		ClassWriter cw = new ClassWriter(0);
		TraceClassVisitor traceClassVisitor = new TraceClassVisitor(cw, new PrintWriter(System.out));
		ClassReader cr = new ClassReader("pkg.MethodExample");
		cr.accept(traceClassVisitor, 0);
	}
	

	

}
