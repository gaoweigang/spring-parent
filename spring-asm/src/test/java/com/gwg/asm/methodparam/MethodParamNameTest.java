package com.gwg.asm.methodparam;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Member;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gwg.spring.asm.ClassReader;

/**
 * java中有7种移位运算符，如下：
 * & 与运算符： 两个操作数中位都为1，结果才为1，否则结果为0
 * | 或运算符： 两个位只要有一个为1，那么结果就是1，否则就为0
 * ~ 非运算符： 如果位为0，结果是1，如果位为1，结果是0
 * ^ 异或运算符：两个操作数的位中，相同则结果为0，不同则结果为1
 * <<  :  左移位运算符，num << 1,相当于num乘以2
 * >>  :  右移位运算符，num >> 1,相当于num除以2
 * >>> :  无符号右移，忽略符号位，空位都以0补齐
 */
public class MethodParamNameTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodParamNameTest.class);
	
	private byte[] b;
	
	/**
	 * 移位运算
	 */
    @Test
    public void testShiftOperator(){
        int number = 16; // 2^4 : 10000
        //原始数的二进制
        System.out.println(Integer.toBinaryString(number));
        //左移1位
        number = number << 1;

        System.out.println(Integer.toBinaryString(number));

        //右移1位
        number = number >> 1;
        System.out.println(Integer.toBinaryString(number));

    }
    
    /**
     * 获取方法参数名称
     * @throws Exception
     */
    @Test
    public void testParameterNameDiscover() throws Exception{
    	//获取class文件名称
    	Class clazz = TestBean.class;
    	String classFileFullName = clazz.getName();
    	LOGGER.info("classFileFullName:"+classFileFullName);
    	int lastDotIndex = classFileFullName.lastIndexOf(".");
    	LOGGER.info("lastDotIndex:"+lastDotIndex);
    	String className = classFileFullName.substring(lastDotIndex + 1) + ".class";
    	LOGGER.info("className:"+className);
    	//获取class文件的输入流
    	InputStream inputStream = clazz.getResourceAsStream(className);
    	ClassReader cr = new ClassReader(inputStream);
    	Map<Member, String[]> map = new HashMap<Member, String[]>();
    	cr.accept(new ParameterNameDiscoveringVisitor(clazz, map), 0);
    	LOGGER.info("map大小:"+map.size());
        for(Member member : map.keySet()){
        	System.out.println(member);
        	System.out.println(map.get(member).length);
        }
    	
    }
    
    /**
     * & 与运算符： 两个操作数中位都为1，结果才为1，否则结果为0
     * | 或运算符： 两个位只要有一个为1，那么结果就是1，否则就为0
     * ~ 非运算符： 如果位为0，结果是1，如果位为1，结果是0
     * ^ 异或运算符：两个操作数的位中，相同则结果为0，不同则结果为1
     * 获取class文件的版本
     * (short) (((b[index] & 0xFF) << 8) | (b[index + 1] & 0xFF))
     * @throws IOException 
     */
    @Test
    public void testClassVersion() throws IOException{
    	//获取class文件名称
    	Class clazz = TestBean.class;
    	//获取class文件全路径名，不包括文件类型
    	String classFileFullName = clazz.getName();
    	int lastDotIndex = classFileFullName.lastIndexOf(".");
    	String classFileName = classFileFullName.substring(lastDotIndex + 1) + ".class";
    	InputStream is = clazz.getResourceAsStream(classFileName);
    	//ByteArrayOutputStream out = new ByteArrayOutputStream();
    	int byteLength = 1024;
    	byte[] b = new byte[1024 * 4];
    	int offset = 0;
    	do{
    	   int n = is.read(b, offset, byteLength);
    	   if(n == -1){
    		   break;
    	   }
    	   offset += n;
    	}while(true);
    	
    	//类字节码数组
    	byte[] byteArr = new byte[offset];
    	//数组复制
    	System.arraycopy(b, 0 , byteArr, 0 , offset);
    	
    	
    	System.out.println(offset);
    }
    
    /**
     * 输出字符所占字节数
     */
    @Test
    public void testInputCharByteNum(){
    	//a字符占一个字节
    	System.out.println(String.valueOf('a').getBytes().length);
    	//'高'字符占3个字节
    	System.out.println(String.valueOf('高').getBytes().length);
    	
    	
    	char c='\u2605';
    	char b = '高';
    	System.out.println(c);
    	System.out.println(b);

    }
    
    /**
     * 获取此 Java 虚拟机的默认 charset。 
     */
    @Test
    public void testDefaultCharset(){
    	System.out.println(Charset.defaultCharset());
    }
    
   



}
