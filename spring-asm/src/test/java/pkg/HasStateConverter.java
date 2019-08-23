package pkg;

import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.IOException;
import java.io.PrintWriter;

public class HasStateConverter {

    @Test
    public void testASMifierToD() throws IOException {
        ClassWriter cw = new ClassWriter(0);
        //TraceClassVisitor tcv = new TraceClassVisitor(cw, new ASMifier(), new PrintWriter(System.out));
        TraceClassVisitor tcv = new TraceClassVisitor(cw, new PrintWriter(System.out));
        ClassReader cr = new ClassReader("pkg.D");
        cr.accept(tcv, 0);
    }
	
	

}
