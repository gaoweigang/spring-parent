package pkg;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class AddTimerMethodAdapter extends MethodVisitor{

	public AddTimerMethodAdapter(MethodVisitor mv) {
		super(Opcodes.ASM4, mv);
	}

	@Override
	public void visitCode() {
		mv.visitCode();
		mv.visitFieldInsn(Opcodes.GETSTATIC, "pkg/C", "timer", "J");
		mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J");
		mv.visitInsn(Opcodes.LSUB);
		mv.visitFieldInsn(Opcodes.PUTSTATIC, "pkg/C", "timer", "J");

	}

	@Override
	public void visitInsn(int opcode) {
		if((opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN) || opcode == Opcodes.ATHROW){
			mv.visitFieldInsn(Opcodes.GETSTATIC, "pkg/C", "timer", "J");
			mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J");
			mv.visitInsn(Opcodes.LADD);
			mv.visitFieldInsn(Opcodes.PUTSTATIC, "pkg/C", "timer", "J");
			
		}
		mv.visitInsn(opcode);
	}
    
	/**
	 * 一个long类型的数据占2个slot
	 */
	@Override
	public void visitMaxs(int maxStack, int maxLocals) {
		System.out.println(maxStack + " :  " + maxLocals);
		mv.visitMaxs(maxStack + 4, maxLocals);
	}
	

}
