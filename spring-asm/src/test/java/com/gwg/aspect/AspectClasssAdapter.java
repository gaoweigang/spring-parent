package com.gwg.aspect;

import java.lang.reflect.Modifier;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AspectClasssAdapter extends ClassVisitor {

    private static final Logger LOGGER = LoggerFactory.getLogger(AspectClasssAdapter.class);


    public AspectClasssAdapter(ClassVisitor cv) {
        super(Opcodes.ASM4, cv);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        return super.visitAnnotation(desc, visible);
    }


    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        return super.visitField(access, name, desc, signature, value);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        LOGGER.info("访问方法 start....");
        LOGGER.info("访问方法访问修饰符:"+ Modifier.toString(access)+",名称为："+name+"，方法描述符："+desc);
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        if(mv  != null){
            mv = new DelegateAspectMethodAdapter(mv);
        }
        return mv;
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
    }
}
