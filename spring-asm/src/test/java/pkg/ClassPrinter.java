package pkg;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

public class ClassPrinter extends ClassVisitor{

	public ClassPrinter(int api) {
		super(api);
	}

	@Override
	public void visit(int version, int access, String name, String signature,
			String superName, String[] interfaces) {
		System.out.println(name+"  extends "+ superName +" {");
		System.out.println(name+"  implements "+ ((interfaces != null && interfaces.length > 0 ) ? interfaces[0] : null));
	}

	@Override
	public void visitSource(String source, String debug) {
	}

	@Override
	public void visitOuterClass(String owner, String name, String desc) {
	}

	@Override
	public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
		return null;
	}

	@Override
	public void visitAttribute(Attribute attr) {
	}

	@Override
	public void visitInnerClass(String name, String outerName,
			String innerName, int access) {
	}

	@Override
	public FieldVisitor visitField(int access, String name, String desc,
			String signature, Object value) {
		System.out.println("   "+ desc + "  "+name);
		return null;
	}

	/**
	 * name : 方法名称，默认的构造函数的名称是<init>
	 * desc : 方法描述符，一个方法描述符就是一个包含参数类型的描述符以及方法返回类型描述符的字符串
	 */
	@Override
	public MethodVisitor visitMethod(int access, String name, String desc,
			String signature, String[] exceptions) {
		System.out.println("   "+ name + desc);
		return null;
	}

	@Override
	public void visitEnd() {
		
		System.out.println("}");
	}
	

}
