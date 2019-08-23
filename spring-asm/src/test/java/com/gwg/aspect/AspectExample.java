package com.gwg.aspect;

import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AspectExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(AspectExample.class);

    @Test
    public void testAspectExample() throws Exception{
        LOGGER.info("测试开始");
        ClassWriter cw = new ClassWriter(0);
        AspectClasssAdapter aca = new AspectClasssAdapter(cw);
        ClassReader cr = new ClassReader("com.gwg.aspect.AspectTest");
        //ClassReader cr = new ClassReader("com.gwg.aspect.TestBean");
        cr.accept(aca, 0);

    }
}
