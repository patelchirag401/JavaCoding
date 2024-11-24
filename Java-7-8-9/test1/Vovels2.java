package com.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Vovels2 {
	
	public static void main(String a[]) {
		
		System.out.println("test");
		
		String strvowels="AI the next step to digitalization";	
	
		//long count = strvowels.chars().filter(c-> strvowels.indexOf("AEIOUaeiou")!=-1).count();
		long count = strvowels.chars().filter(c-> "AEIOUaeiou".indexOf(c)!=-1).count();
		
		System.out.println("count:"+count);
		
		List<String> list =  new ArrayList<String>();
		list.add("apple");list.add("banana");list.add("mango");list.add("mango");
		
		List<String> upperCaseList = list.stream().distinct().filter(c->c.contains("g")).map(s->s.toUpperCase()).collect(Collectors.toList());
		
		System.out.println("upperCaseList:"+upperCaseList.toString());
		
		
		// Difference between flatMap and Map :-
		
		
		List<String> words = Arrays.asList("hello", "world");
		List<Integer> wordLengths = words.stream()
		                                  .map(String::length)
		                                  .collect(Collectors.toList());
		
		System.out.println("wordLengths:"+wordLengths);
		
		
		List<List<Integer>> numbers = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
		List<Integer> flattenedNumbers = numbers.stream()
		                                        .flatMap(Collection::stream)
		                                        .collect(Collectors.toList());
		
		System.out.println("flattenedNumbers:"+flattenedNumbers);
		// Output: [1, 2, 3, 4, 5, 6]

		
		
		List<String> words1 = Arrays.asList("hello", "world");
		boolean anyMatch = words.stream().anyMatch(c->c.contains("z"));
		boolean isAllMatch = words.stream().allMatch(c->c.contains("l"));
		
		System.out.println("anyMatch:"+anyMatch);
		System.out.println("isAllMatch:"+isAllMatch);
		
		
		//words.stream().collect(collector)
		
		
		
		
	}

}
