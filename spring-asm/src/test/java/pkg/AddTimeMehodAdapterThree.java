package pkg;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AnalyzerAdapter;
import org.objectweb.asm.commons.LocalVariablesSorter;

public class AddTimeMehodAdapterThree extends LocalVariablesSorter{
	
	private int time;

	protected AddTimeMehodAdapterThree(int access, String desc, MethodVisitor mv) {
		super(access, desc,  mv);
	}
	
	@Override
	public void visitCode() {
		super.visitCode();
		//获取指定类的静态域，并将其值压入栈顶
		mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J");
		//生成一个局部变量
		time = newLocal(Type.LONG_TYPE);
		//弹出栈顶操作数，将栈顶操作数值存放到局部变量区
		mv.visitVarInsn(Opcodes.LSTORE, time);
		
	}

	@Override
	public void visitInsn(int opcode) {
		//如果指令opcode是返回指令，或者是抛出异常指令
		if((opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN) || opcode == Opcodes.ATHROW){
			
		    mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentMillis", "()J");
		  //给局部变量time赋值
			mv.visitVarInsn(Opcodes.LLOAD, time);
		    mv.visitInsn(Opcodes.LSUB);
		    mv.visitFieldInsn(Opcodes.GETFIELD, "pkg/C", "timer", "J");
		    mv.visitInsn(Opcodes.LADD);
		    mv.visitFieldInsn(Opcodes.PUTFIELD, "pkg/C", "timer", "J");
		}
	    super.visitInsn(opcode);
	}

	@Override
	public void visitMaxs(int maxStack, int maxLocals) {
		// TODO Auto-generated method stub
		super.visitMaxs(maxStack + 4, maxLocals);
	}

	

}
