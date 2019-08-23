package pkg;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.AnalyzerAdapter;

public class AddTimeMehodAdapterTwo extends AnalyzerAdapter{
	
	private int maxStack;

	protected AddTimeMehodAdapterTwo(int api, String owner, int access,
			String name, String desc, MethodVisitor mv) {
		super(api, owner, access, name, desc, mv);
	}
	
	@Override
	public void visitCode() {
		super.visitCode();
		mv.visitFieldInsn(Opcodes.GETSTATIC, "pkg/C", "timer", "J");
		mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J");
		mv.visitInsn(Opcodes.LSUB);
		mv.visitFieldInsn(Opcodes.PUTSTATIC, "pkg/C", "timer", "J");
		//long类型的数据占用2个slot
		maxStack = 4;
		
	}

	@Override
	public void visitInsn(int opcode) {
		//如果指令opcode是返回指令，或者是抛出异常指令
		if((opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN) || opcode == Opcodes.ATHROW){
			//获取指定类的静态域，并将其值压入操作数栈顶
			mv.visitFieldInsn(Opcodes.GETSTATIC, "pkg/C", "timer", "J");
		    mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentMillis", "()J");
		    mv.visitInsn(Opcodes.LADD);
		    mv.visitFieldInsn(Opcodes.PUTSTATIC, "pkg/C", "timer", "J");
		    this.maxStack = Math.max(maxStack, stack.size() + 4);
		}
	    super.visitInsn(opcode);
	}

	@Override
	public void visitMaxs(int maxStack, int maxLocals) {
		super.visitMaxs(Math.max(this.maxStack, maxStack), maxLocals);
	}

	

}
