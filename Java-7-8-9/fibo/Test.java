package com.fibo;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Test {
	
	public static void main(String a[]) {
		
		String inputString = "0..1.0.0";
		String str[] = inputString.split("\\.");
		
		
		 for(String s:str) {
			// System.out.println(s);
		 }
		 
		 ArrayList al = new ArrayList<Integer>();
		 StringTokenizer st =  new StringTokenizer("0..1.0.0","\\.");

		 while(st.hasMoreElements()) {
			// System.out.println(st.nextToken());
			 al.add(st.nextElement());
			// st.nextElement();
		 }
		 
	}

}
