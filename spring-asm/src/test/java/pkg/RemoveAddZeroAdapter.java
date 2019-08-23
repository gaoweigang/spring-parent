package pkg;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class RemoveAddZeroAdapter extends PatternMethodAdapter{
	
	private static int SEEN_ICONST_0 = 1;

	public RemoveAddZeroAdapter(MethodVisitor mv) {
		super(mv);
	}

	@Override
	public void visitInsn(int opcode) {
		if(state == SEEN_ICONST_0){
			if(opcode == Opcodes.IADD){
				state = SEEN_NOTHING;
				return;
			}
		}
		visitInsn();
		if(opcode == Opcodes.ICONST_0){
			state = SEEN_ICONST_0; //标识访问过ICONST_0指令
			return;
		}
		mv.visitInsn(opcode);
	}

	@Override
	protected void visitInsn() {
		 if(state == SEEN_ICONST_0){
			 mv.visitInsn(Opcodes.ICONST_0);
		 }
		 state = SEEN_NOTHING;
		
	}
	
	

}
