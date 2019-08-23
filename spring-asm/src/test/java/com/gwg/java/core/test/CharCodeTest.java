package com.gwg.java.core.test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.Test;

public class CharCodeTest {
	    /** 
	     * 将byte转换为对应的二进制字符串 
	     * @param src 要转换成二进制字符串的byte值 
	     * @return 
	     */  
	    public static String byteToBinary(byte src) {  
	        StringBuilder result = new StringBuilder();  
	        for (int i = 0; i < 8; i++) {  
	        	/**
	        	 * 0000 11101  % 2^3 + 2^2 +2^1 + 2^0 10111 0000
	        	 * 字节码序列最后一位是0的话，与2取模之后就是0，反则是1
	        	 */
	            result.append(src%2 == 0 ? '0' : '1'); //
	            src = (byte)(src >>> 1);  
	        }  
	        return result.reverse().toString(); //将字符串用其反转形式取代
	    }  
	       
	    /**
	     * 获取字符在内存中的存储格式，即二进制编码格式
	     */
	    @Test
	    public void test(){
	    	String remark = "啊";
	    	System.out.println(Charset.defaultCharset());
	    	System.out.println(Arrays.toString(remark.getBytes()));
	        System.out.println("");
	        for(byte b : remark.getBytes()){
	        	System.out.print(byteToBinary(b)+" ");;
	        }
	    }
	    /**
	     * StringBuilder.reverse() 将此字符序列用其反转形式取代
	     */
	    @Test
	    public void testReverse(){
	    	StringBuilder sb = new StringBuilder("101110000");
	    	System.out.println(sb.reverse().toString());
	    }
	  
	} 