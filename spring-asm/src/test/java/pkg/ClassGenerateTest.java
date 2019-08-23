package pkg;

import org.junit.Test;
import org.objectweb.asm.*;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.TraceClassVisitor;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassGenerateTest {

    @Test
    public void testASMifierToBean() throws IOException {
        ClassWriter cw = new ClassWriter(0);
        TraceClassVisitor tcv = new TraceClassVisitor(cw, new ASMifier(), new PrintWriter(System.out));
        ClassReader cr = new ClassReader("pkg.Bean");
        cr.accept(tcv, 0);

    }


    @Test
    public void testBeanGenerate() throws IllegalAccessException, InstantiationException, IntrospectionException, IllegalArgumentException, InvocationTargetException {
        ClassWriter cw = new ClassWriter(0);
        TraceClassVisitor tcv = new TraceClassVisitor(cw, new PrintWriter(System.out));
        cw.visitSource("pkg/bean", null);
        cw.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC, "pkg/Bean", null, "java/lang/Object", null);
        FieldVisitor f1 = cw.visitField(Opcodes.ACC_PRIVATE, "f", "I", null, null);
        f1.visitEnd();
        MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(1, 1);
        mv.visitEnd();

        MethodVisitor mv1 = cw.visitMethod(Opcodes.ACC_PUBLIC, "getF","()I", null, null);
        mv1.visitCode();
        mv1.visitVarInsn(Opcodes.ALOAD, 0);
        mv1.visitFieldInsn(Opcodes.GETFIELD, "pkg/Bean", "f", "I");
        mv1.visitInsn(Opcodes.IRETURN);
        mv1.visitMaxs(1,1);
        mv1.visitEnd();

        MethodVisitor mv2 = cw.visitMethod(Opcodes.ACC_PUBLIC, "setF", "(I)V", null, null);
        mv2.visitCode();
        mv2.visitVarInsn(Opcodes.ALOAD, 0);
        mv2.visitVarInsn(Opcodes.ILOAD, 1);
        mv2.visitFieldInsn(Opcodes.PUTFIELD, "pkg/Bean", "f", "I");
        mv2.visitInsn(Opcodes.RETURN);
        mv2.visitMaxs(2, 2);
        mv2.visitEnd();

        cw.visitEnd();
        //获取类的字节码数组
        byte[] b = cw.toByteArray();
        ClassReader cr = new ClassReader(b);
        cr.accept(cw, 0);

        MyClassLoader classLoader = new MyClassLoader();
        Class clazz = classLoader.defineClass(null, b);
        //创建一个对象
        Object obj = clazz.newInstance();
        System.out.println(obj);
        
        //使用这个对象
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        Method setMethod = null;
        Method getMethod = null;
        for(PropertyDescriptor p : propertyDescriptors){
        	if("f".equals(p.getName())){
        		setMethod = p.getWriteMethod();
        		getMethod = p.getReadMethod();
        	}
        	
        }
        setMethod.invoke(obj, 23);
        System.out.println(getMethod.invoke(obj));



    }
}
