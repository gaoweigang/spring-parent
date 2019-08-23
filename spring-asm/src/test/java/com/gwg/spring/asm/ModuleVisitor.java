package com.gwg.spring.asm;

/**
 * A visitor to visit a Java module. The methods of this class must be called in
 * the following order: <tt>visitVersion</tt> | <tt>visitMainClass</tt> |
 * <tt>visitTargetPlatform</tt> | ( <tt>visitConcealedPackage</tt> | <tt>visitRequire</tt> |
 * <tt>visitExport</tt> | <tt>visitUse</tt> | <tt>visitProvide</tt> )* <tt>visitEnd</tt>.
 * 
 * @author Remi Forax
 */
public abstract class ModuleVisitor {
    /**
     * The ASM API version implemented by this visitor. The value of this field
     * must be {@link Opcodes#ASM6}.
     */
    protected final int api;
    
    /**
     * The module visitor to which this visitor must delegate method calls. May
     * be null.
     */
    protected ModuleVisitor mv;
    
    
    public ModuleVisitor(final int api) {
        this(api, null);
    }

    /**
     * Constructs a new {@link MethodVisitor}.
     * 
     * @param api
     *            the ASM API version implemented by this visitor. Must be {@link Opcodes#ASM6}.
     * @param mv
     *            the method visitor to which this visitor must delegate method
     *            calls. May be null.
     */
    public ModuleVisitor(final int api, final ModuleVisitor mv) {
        if (api != Opcodes.ASM6) {
            throw new IllegalArgumentException();
        }
        this.api = api;
        this.mv = mv;
    }
    
    /**
     * Visit the main class of the current module.
     * 
     * @param mainClass the main class of the current module.
     */
    public void visitMainClass(String mainClass) {
        if (mv != null) {
            mv.visitMainClass(mainClass);
        }
    }
    
    /**
     * Visit a concealed package of the current module.
     * 
     * @param packaze name of a concealed package
     */
    public void visitPackage(String packaze) {
        if (mv != null) {
            mv.visitPackage(packaze);
        }
    }
    
    /**
     * Visits a dependence of the current module.
     * 
     * @param module the module name of the dependence
     * @param access the access flag of the dependence among
     *        ACC_TRANSITIVE, ACC_STATIC_PHASE, ACC_SYNTHETIC
     *        and ACC_MANDATED.
     * @param version the module version at compile time or null.
     */
    public void visitRequire(String module, int access, String version) {
        if (mv != null) {
            mv.visitRequire(module, access, version);
        }
    }
    
    /**
     * Visit an exported package of the current module.
     * 
     * @param packaze the name of the exported package.
     * @param access the access flag of the exported package,
     *        valid values are among {@code ACC_SYNTHETIC} and
     *        {@code ACC_MANDATED}.
     * @param modules names of the modules that can access to
     *        the public classes of the exported package or
     *        <tt>null</tt>.
     */
    public void visitExport(String packaze, int access, String... modules) {
        if (mv != null) {
            mv.visitExport(packaze, access, modules);
        }
    }
    
    /**
     * Visit an open package of the current module.
     * 
     * @param packaze the name of the opened package.
     * @param access the access flag of the opened package,
     *        valid values are among {@code ACC_SYNTHETIC} and
     *        {@code ACC_MANDATED}.
     * @param modules names of the modules that can use deep
     *        reflection to the classes of the open package or
     *        <tt>null</tt>.
     */
    public void visitOpen(String packaze, int access, String... modules) {
        if (mv != null) {
            mv.visitOpen(packaze, access, modules);
        }
    }
    
    /**
     * Visit a service used by the current module.
     * The name must be the name of an interface or an
     * abstract class.
     * 
     * @param service the internal name of the service.
     */
    public void visitUse(String service) {
        if (mv != null) {
            mv.visitUse(service);
        }
    }
    
    /**
     * Visit an implementation of a service.
     * 
     * @param service the internal name of the service
     * @param providers the internal names of the implementations
     *        of the service (there is at least one provider).
     */
    public void visitProvide(String service, String... providers) {
        if (mv != null) {
            mv.visitProvide(service, providers);
        }
    }
    
    public void visitEnd() {
        if (mv != null) {
            mv.visitEnd();
        }
    }
}
