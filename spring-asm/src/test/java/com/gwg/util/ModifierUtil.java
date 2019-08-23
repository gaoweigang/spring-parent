package com.gwg.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 此工具类提供快速分析字段/方法的访问修饰符
 * @author gaoweigang
 *
 */
public class ModifierUtil {
	
	 /**
     * The {@code int} value representing the {@code public}
     * modifier.
     */
    public static final int PUBLIC           = 0x00000001;

    /**
     * The {@code int} value representing the {@code private}
     * modifier.
     */
    public static final int PRIVATE          = 0x00000002;

    /**
     * The {@code int} value representing the {@code protected}
     * modifier.
     */
    public static final int PROTECTED        = 0x00000004;

    /**
     * The {@code int} value representing the {@code static}
     * modifier.
     */
    public static final int STATIC           = 0x00000008;

    /**
     * The {@code int} value representing the {@code final}
     * modifier.
     */
    public static final int FINAL            = 0x00000010;

    /**
     * The {@code int} value representing the {@code synchronized}
     * modifier.
     */
    public static final int SYNCHRONIZED     = 0x00000020;

    /**
     * The {@code int} value representing the {@code volatile}
     * modifier.
     */
    public static final int VOLATILE         = 0x00000040;

    /**
     * The {@code int} value representing the {@code transient}
     * modifier.
     */
    public static final int TRANSIENT        = 0x00000080;

    /**
     * The {@code int} value representing the {@code native}
     * modifier.
     */
    public static final int NATIVE           = 0x00000100;

    /**
     * The {@code int} value representing the {@code interface}
     * modifier.
     */
    public static final int INTERFACE        = 0x00000200;

    /**
     * The {@code int} value representing the {@code abstract}
     * modifier.
     */
    public static final int ABSTRACT         = 0x00000400;

    /**
     * The {@code int} value representing the {@code strictfp}
     * modifier.
     */
    public static final int STRICT           = 0x00000800;
    
    // Bits not (yet) exposed in the public API either because they
    // have different meanings for fields and methods and there is no
    // way to distinguish between the two in this class, or because
    // they are not Java programming language keywords
    static final int BRIDGE    = 0x00000040;
    static final int VARARGS   = 0x00000080;
    static final int SYNTHETIC = 0x00001000;
    static final int ANNOTATION  = 0x00002000;
    static final int ENUM      = 0x00004000;
    static final int MANDATED  = 0x00008000;
    
	/**
	 * &运算符：
	 * @param o
	 * @return
	 */
    public static String toString(Object o) {
        StringBuilder sb = new StringBuilder();
        int len;
        if(o instanceof Field){
              int mod = ((Field) o).getModifiers();
	    	  if ((mod & PUBLIC) != 0)        sb.append("public ");
	          if ((mod & PROTECTED) != 0)     sb.append("protected ");
	          if ((mod & PRIVATE) != 0)       sb.append("private ");
	
	          /* Canonical order */
	          if ((mod & ABSTRACT) != 0)      sb.append("abstract ");
	          if ((mod & STATIC) != 0)        sb.append("static ");
	          if ((mod & FINAL) != 0)         sb.append("final ");
	          if ((mod & TRANSIENT) != 0)     sb.append("transient ");
	          if ((mod & VOLATILE) != 0)      sb.append("volatile ");
	          if ((mod & SYNCHRONIZED) != 0)  sb.append("synchronized ");
	          if ((mod & NATIVE) != 0)        sb.append("native ");
	          if ((mod & STRICT) != 0)        sb.append("strictfp ");
	          if ((mod & INTERFACE) != 0)     sb.append("interface ");
	          //gaoweigeang add 
	          if ((mod & SYNTHETIC) != 0)     sb.append("synthetic ");
	          if ((mod & ENUM) != 0)     sb.append("enum ");

	          if ((len = sb.length()) > 0)    /* trim trailing space */
	              return sb.toString().substring(0, len-1);
        }else if(o instanceof Method){
        	  int mod = ((Method) o).getModifiers();
        	  if ((mod & PUBLIC) != 0)        sb.append("public ");
	          if ((mod & PROTECTED) != 0)     sb.append("protected ");
	          if ((mod & PRIVATE) != 0)       sb.append("private ");
	
	          /* Canonical order */
	          if ((mod & ABSTRACT) != 0)      sb.append("abstract ");
	          if ((mod & STATIC) != 0)        sb.append("static ");
	          if ((mod & FINAL) != 0)         sb.append("final ");
	          if ((mod & TRANSIENT) != 0)     sb.append("transient ");
	          if ((mod & BRIDGE) != 0)      sb.append("bridge ");
	          if ((mod & SYNCHRONIZED) != 0)  sb.append("synchronized ");
	          if ((mod & NATIVE) != 0)        sb.append("native ");
	          if ((mod & STRICT) != 0)        sb.append("strictfp ");
	          if ((mod & INTERFACE) != 0)     sb.append("interface ");
	          //gaoweigang add 
	          if ((mod & SYNTHETIC) != 0)     sb.append("synthetic ");
	          if ((mod & VARARGS) != 0)     sb.append("varargs ");//方法是否接受不定参数

	          if ((len = sb.length()) > 0)    /* trim trailing space */
	              return sb.toString().substring(0, len-1);
        }
      
        return "";
    }

}
