package pkg;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class RemoveGetFieldPutFieldAdapter extends PatternMethodAdapter{
	
	private final static int SEEN_ALOAD_0 = 1;
	
	private final static int SEEN_ALOAD_0ALOAD_0 = 2;
	
	private final static int SEEN_ALOAD_0ALOAD_0GETFIELD = 3;
	
	private String fieldOwner;
	
	private String fieldName;
	
	private String fieldDesc;

	public RemoveGetFieldPutFieldAdapter(MethodVisitor mv) {
		super(mv);
	}

	@Override
	public void visitVarInsn(int opcode, int var) {
		switch (state) {
		case SEEN_NOTHING:
			if(opcode == Opcodes.ALOAD && var == 0){
				state = SEEN_ALOAD_0;
				return;
			}
			break;
		case SEEN_ALOAD_0:
			if(opcode == Opcodes.ALOAD && var == 0){
				state = SEEN_ALOAD_0ALOAD_0;
				return;
			}
			visitInsn();
			break;
		default:
			
			break;
		}
		
		mv.visitVarInsn(opcode, var);
		
	
	}

	@Override
	public void visitFieldInsn(int opcode, String owner, String name,
			String desc) {
		
		switch(state){
		case SEEN_ALOAD_0ALOAD_0:
			if(opcode == Opcodes.GETFIELD){
				state = SEEN_ALOAD_0ALOAD_0GETFIELD;
				fieldOwner = owner;
				fieldName = name;
				fieldDesc = desc;
				return;
			}
			visitInsn();
			break;
		case SEEN_ALOAD_0ALOAD_0GETFIELD:
			if(opcode == Opcodes.PUTFIELD){
				if(this.fieldOwner == owner && this.fieldName == name && this.fieldDesc == desc){
					state = SEEN_NOTHING;
					return;
				}
			}
			visitInsn();
			break;
		default:
			break;
		}
		
		mv.visitFieldInsn(opcode, owner, name, desc);
	}
	
	@Override
	protected void visitInsn() {//如果不成立则需要添加之前删除掉的指令
		switch (state) {
		case SEEN_ALOAD_0:
			mv.visitVarInsn(Opcodes.ALOAD, 0);
			break;
		case SEEN_ALOAD_0ALOAD_0 :
			mv.visitVarInsn(Opcodes.ALOAD, 0);
			mv.visitVarInsn(Opcodes.ALOAD, 0);
			break;
		case SEEN_ALOAD_0ALOAD_0GETFIELD:
			mv.visitVarInsn(Opcodes.ALOAD, 0);
			mv.visitVarInsn(Opcodes.ALOAD, 0);
			mv.visitFieldInsn(Opcodes.GETFIELD, this.fieldOwner, this.fieldName, this.fieldDesc);
			break;
		default:
			break;
		}
		state = SEEN_NOTHING;
		
	}
	

}
