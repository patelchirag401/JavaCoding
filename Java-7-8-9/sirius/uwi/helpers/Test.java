package com.sirius.uwi.helpers;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

//import java.compiler;

public class Test {
	
	public static void main(String a[]) {
		
		char[] chars = new char[] {'\u0097'};
		String str = new String(chars);
		System.out.println("test:--"+str);		
		System.out.print(Arrays.toString(str.getBytes())); 
		
		ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<String, String>();
		
		
		
		
	}

}
