package org.fenxisoft.clazz;

/**
 * 异常内字节码分析
 * 生成try-catch快捷键 ctrl + alt +t
 */
public class ExceptionClass {

    public long inc(){
        int i;
        try {
            i = 1;
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            i = 2;
            return i;
        } finally {
            i = 3;
        }
    }

}
