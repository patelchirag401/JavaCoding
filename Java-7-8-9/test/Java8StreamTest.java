package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8StreamTest {

	public static void main(String args[])
	 {
		System.out.println("TEST");
		
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(10);intList.add(9);intList.add(22);intList.add(3);
		
		intList = intList.stream().filter(s->s%3!=0).collect(Collectors.toList());
		
		System.out.println("Result List:"+intList);
		
		String textWithSpaces = "This is a text with spaces";
		
		textWithSpaces = textWithSpaces.chars().filter(c->!Character.isWhitespace(c)).mapToObj(c->String.valueOf((char)c)).collect(Collectors.joining());
		
		System.out.println("Result String:"+textWithSpaces);

	 }
	
	
}

interface i1{
	void a();
}

interface i2{
	void a();
}
class test implements i1,i2{
	
	public void a(){
		
	}
}
