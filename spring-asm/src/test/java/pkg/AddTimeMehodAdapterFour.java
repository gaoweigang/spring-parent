package pkg;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AnalyzerAdapter;
import org.objectweb.asm.commons.LocalVariablesSorter;

public class AddTimeMehodAdapterFour extends MethodVisitor{
	
	public LocalVariablesSorter lvs;
	
	public AnalyzerAdapter aa;
	
	public int time;
	
	public int maxStack;

	protected AddTimeMehodAdapterFour(MethodVisitor mv) {
		super(Opcodes.ASM4, mv);
	}
	
	@Override
	public void visitCode() {
		mv.visitCode();
		mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J");
		time = lvs.newLocal(Type.LONG_TYPE);
		mv.visitVarInsn(Opcodes.LSTORE, time);
		//long类型的数据占用2个slot
		maxStack = 4;
		
	}

	@Override
	public void visitInsn(int opcode) {
		//如果指令opcode是返回指令，或者是抛出异常指令
		if((opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN) || opcode == Opcodes.ATHROW){
		    mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentMillis", "()J");
		    mv.visitVarInsn(Opcodes.LLOAD, time);
		    mv.visitInsn(Opcodes.LSUB);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "pkg/C", "timer", "J");
		    mv.visitInsn(Opcodes.LADD);
		    mv.visitFieldInsn(Opcodes.PUTSTATIC, "pkg/C", "timer", "J");
		    //this.maxStack = Math.max(maxStack, stack.size() + 4);
		}
	    super.visitInsn(opcode);
	}

	

}
