package com.capitalone;

import java.util.ArrayList;
import java.util.Stack;

public class TestChar {
	
	public static void main(String a[]) {
		//String[] inputArray = new String[] {"a", "aa", "ad", "vcd", "aba"};
		// inputArray = solution(inputArray);
		String str =  "TestString";
		 for(int i=0;i<str.length();i++) {
				//maxLength[i] = inputArray[i].length();
			 int k = str.charAt(i);
				System.out.print(k+" ");
			}
		 
		 // remeber to add an element in list
		 
		 ArrayList<String> al = new ArrayList<String>();
		 //al.add(5, "-1");
		 
		 Stack s1 = new Stack<String>();
		 s1.push("a");s1.push("b");s1.push("c");
		 
		 System.out.print(s1.pop()); System.out.print(s1.pop()); System.out.print(s1.pop());
	}

}
