package pkg;

import org.objectweb.asm.Handle;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public abstract class PatternMethodAdapter extends MethodVisitor{
	
	protected final static int SEEN_NOTHING = 0;
	
	protected int state;

	public PatternMethodAdapter(MethodVisitor mv) {
		super(Opcodes.ASM4, mv);
	}

	/**
	 * 访问没有操作数的指令
	 */
	@Override
	public void visitInsn(int opcode) {
		visitInsn();
	    mv.visitInsn(opcode);
	}

	/**
	 * 访问只有一个操作数为int的指令 
	 */
	@Override
	public void visitIntInsn(int opcode, int operand) {
		visitInsn();
		 mv.visitIntInsn(opcode, operand);
	}

	protected abstract void visitInsn();
	

}
