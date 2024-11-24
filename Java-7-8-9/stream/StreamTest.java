package com.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest {
	public static void main(String a[]) {
		System.out.println("------");
		
		String str = "abd def";
		
		long count = str.chars().filter(s->"AEIOUaeiou".indexOf(s)!=-1).count();
		System.out.println("Count------:"+count);	
		
		 List<String> list = Arrays.asList("apple", "banana", "grape", "kiwi");
		 list.stream().filter(s->s.contains("a")).forEach(System.out::println);

		
	}
}
