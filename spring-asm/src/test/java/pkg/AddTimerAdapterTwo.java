package pkg;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.AnalyzerAdapter;

public class AddTimerAdapterTwo extends AnalyzerAdapter{

    public AddTimerAdapterTwo(String owner, int access, String name, String desc, MethodVisitor mv) {
        super(owner, access, name, desc, mv);
    }
}
