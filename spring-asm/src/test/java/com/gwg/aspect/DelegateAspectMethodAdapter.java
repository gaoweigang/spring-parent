package com.gwg.aspect;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class DelegateAspectMethodAdapter extends MethodVisitor{

    private String pointcutDescriptor = "Lcom/gwg/aspect/Pointcut;";
    private String beforeDescriptor = "Lcom/gwg/aspect/Before;";
    //是不是切入点
    protected boolean isPointcut = false;
    protected boolean isBefore = false;
    protected String pointcutMethodName;
    protected MethodInsn methodInsn = new MethodInsn();


    private static final Logger LOGGER = LoggerFactory.getLogger(DelegateAspectMethodAdapter.class);

    public DelegateAspectMethodAdapter(MethodVisitor mv) {
        super(Opcodes.ASM4, mv);
    }

    /**
     * @param desc 注解类的类描述符
     * @param visible true 如果注解在运行时有效
     * @return
     */
    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        LOGGER.info("方法注解："+desc+"   :   "+ visible);
        if(this.pointcutDescriptor.equals(desc)){
            this.isPointcut = true;
        }else if(this.beforeDescriptor.equals(desc)){
            this.isBefore = true;
        }
        return super.visitAnnotation(desc, visible);
    }

    @Override
    public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
        LOGGER.info("参数注解");
        return super.visitParameterAnnotation(parameter, desc, visible);
    }


    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc) {
        if(this.isPointcut){
            this.pointcutMethodName = name;
        }else if(this.isBefore){
            methodInsn.setOpcode(opcode);
            methodInsn.setOwner(owner);
            methodInsn.setName(name);
            methodInsn.setDesc(desc);
        }
        super.visitMethodInsn(opcode, owner, name, desc);
    }

    @Override
    public void visitInsn(int opcode) {
        super.visitInsn(opcode);
    }
}
