package com.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackTest {
	
	public static void main(String a[]) {
		
		Stack s1 =  new Stack();
		s1.empty();
		
		s1.push("5");s1.push("7");s1.push("3");
		
		System.out.println(s1.toString());
		System.out.println(s1.pop());
		System.out.println(s1.toString());
		
		Map<String, Integer> map = new HashMap<>();
		int test = map.getOrDefault("5", 0);
		
		
		
		
		
	}

}
