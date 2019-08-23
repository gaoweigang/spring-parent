package org.fenxisoft.clazz;
/**
 * java中char类型能存储汉字吗？
 * 可以，char类型是一个单一的 16 位 Unicode 字符,这里的16等于4 + 6 + 6
 * 实现Unicode规范的字符集有utf-8,utf-16等，在本人电脑中JVM默认使用的是utf-8编码，可以通过Charset.defaultCharset(),
 * 可以通过指定JVM参数来指定JVM使用的编码。
 * 思考：证明是Utf-8编码，不是Utf-16编码
 * @author gaoweigang
 *
 */
public class ConstantCharChinaClass {
	
	public static final char a = '啊';
	
}
