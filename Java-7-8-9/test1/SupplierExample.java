package com.test1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SupplierExample {
	
	public static void main(String[] args) {
		
		Supplier<Double> supplier =  () -> Math.random();
		
		System.out.println("Random number :"+supplier.get());
		
		Supplier<String> constantSupplier = () -> "Hello, Supplier!";
		
		 String constantValue = constantSupplier.get();
	     System.out.println("Constant value: " + constantValue);
	     
	     int k;
	     
	     
	     List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	     
	     Predicate<Integer> predicate =  number -> number > 5 ;
	     
	     numbers.stream().filter(predicate).forEach(System.out::println);;
	     
	     System.out.println("=================================");
	     
	     List<Integer> numbers1 = numbers.stream().filter(predicate).map(i->i%2).collect(Collectors.toList());
	     
	     System.out.println("numbers1:================================="+numbers1.toString());
	     
	        
		
		

	}

}
