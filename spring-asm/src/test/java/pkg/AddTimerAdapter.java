package pkg;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class AddTimerAdapter extends ClassVisitor{
	
	private String owner;
	
	private boolean isInterface;

	public AddTimerAdapter(ClassVisitor cv) {
		super(Opcodes.ASM4, cv);
	}

	@Override
	public void visit(int version, int access, String name, String signature,
			String superName, String[] interfaces) {
		
		cv.visit(version, access, name, signature, superName, interfaces);
		owner = name;
		/**
		 * Opcodes.ACC_INTERFACE ：512等于2^9 即二进制表示为10 0000 0000
		 * Opcodes.ACC_ABSTRACT  ：1024等于 2^10 即二进制表示为100 0000 0000 
		 * Opcodes.ACC_PUBLIC  ： 1 等于2^0 即二进制表示为  1
		 * Opcodes.ACC_POTECTED : 4 等于2^2 即二进制表示为 100
		 * Opcodes.ACC_FINAL   ： 16 等于2^4 即二进表示为 1 0000
		 * & 与运算： 两个操作数中位都为1，结果才为1，否则结果为0，两个操作数进行运算
		 * | 或运算：两个位只要有一个为1，那么结果就是1，否则就为0， 两个操作数进行运算
		 * ~ 非运算：如果位为0，结果是1，如果位为1，结果是0， 只有一个操作数
		 * ^ 异或运算：两个操作数的位中，相同则结果为0，不同则结果为1，两个操作数进行运算
		 */
		
		isInterface = ((access & Opcodes.ACC_INTERFACE) != 0); //判断是不是接口
	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc,
			String signature, String[] exceptions) {
		MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
		if(!this.isInterface && mv != null && !name.equals("<init>")){
			 mv = new AddTimerMethodAdapter(mv);//委托给专门的适配器增强
		}
		return mv;
	}

	@Override
	public void visitEnd() {
		if(!this.isInterface){
			FieldVisitor fv = cv.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "timer", "J", null, null);
			if(fv != null){
				fv.visitEnd();
			}
		}
		cv.visitEnd();
	}
	
	public static void main(String[] args) {
		System.out.println(0x0004);
	}
	

}
