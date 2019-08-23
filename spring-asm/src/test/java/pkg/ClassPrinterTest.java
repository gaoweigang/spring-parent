package pkg;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.util.CheckClassAdapter;
import org.objectweb.asm.util.TraceClassVisitor;

public class ClassPrinterTest {
	
	
	@Test
	public void testClassPrinter() throws IOException {
		//
		ClassPrinter cp = new ClassPrinter(Opcodes.ASM4);
		//ClassReader cr = new ClassReader("com.gwg.asm.core.test.Dog");
		ClassReader cr = new ClassReader("java.lang.Runnable");
		/**
		 * public void accept(ClassVisitor classVisitor, int flags)
		 * classVisitor:必须访问这个类的访问者
		 * flags：用于修改该类默认行为的可选标志，查看SKIP_DEBUG, EXPAND_FRAMES , SKIP_FRAMES, SKIP_CODE.
		 */
		cr.accept(cp, 0);
		
		ClassLoader cl = ClassPrinterTest.class.getClassLoader();
		InputStream inputStream = cl.getResourceAsStream("java.lang.Runnable".replace(".", "/") + ".class");
		ClassReader reader = new ClassReader(inputStream);
		reader.accept(cp, 0);
		
	}
	
	/**
	 * 给Dog添加一个属性
	 * @throws IOException 
	 */
	@Test
	public void testAddField() throws IOException{
		ClassWriter cw = new ClassWriter(0);
		AddFieldAdapter addFieldAdapter = new AddFieldAdapter(cw, Opcodes.ACC_PUBLIC, "name", "Ljava.lang.String");
		ClassReader cr = new ClassReader("pkg.Dog");
		cr.accept(addFieldAdapter, 0);
		byte[] b = cw.toByteArray();
		
		File classFile = new File("E:/workspace/spring_workspace/spring-parent/spring-asm/target/test-classes/pkg/DogExtension.class");
		FileOutputStream fileOutputStream = new FileOutputStream(classFile);
		fileOutputStream.write(b);
	}
	
	
	
	/**
	 * 给Dog添加一个方法
	 */
	

}
