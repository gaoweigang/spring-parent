package pkg;

import java.io.IOException;
import java.io.PrintWriter;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.util.TraceClassVisitor;

/**
 * ASM开发指南中的例子
 * @author gaoweigang
 *
 */
public class ExampleTraceClassVisitor {
	
	public static void main(String[] args) throws IOException {
		ClassWriter cw = new ClassWriter(0);
		TraceClassVisitor traceClassVisitor = new TraceClassVisitor(cw, new PrintWriter(System.out));
		ClassReader cr = new ClassReader("pkg.Example");
		cr.accept(traceClassVisitor, 0);
		
	}

}
