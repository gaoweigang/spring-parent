package pkg.metadata;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.objectweb.asm.signature.SignatureReader;
import org.objectweb.asm.signature.SignatureVisitor;
import org.objectweb.asm.signature.SignatureWriter;

public class Example {
	
	public static void main(String[] args) {
		//HashMap
	}
	
	@Test
	public void testRenameSignature(){
		//类类型签名
		String signature = "Ljava/util/HashMap<TK;TV;>.HashIterator<TK;>;";
		Map<String, String > renaming = new HashMap<String, String>();
		renaming.put("java/util/HashMap", "A");
		renaming.put("java/util/HashMap.HashIterator", "B");
		SignatureWriter sw = new SignatureWriter();
		SignatureVisitor sv = new RenameSignatureAdapter(sw, renaming);
		SignatureReader sr = new SignatureReader(signature);
		sr.accept(sv);
		System.out.println(sw.toString());
		
	}

}
