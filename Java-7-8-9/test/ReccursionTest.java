package com.test;

public class ReccursionTest {

	public static void main(String a[]) {
		
		//System.out.println("function entered:"+factorial(5));
		System.out.println("function entered:"+fib(100));
	}
	
	public static int factorial(int n) {
		System.out.println("factorial function entered:"+n);
		if(n==0) return 0;
		if(n==1) return 1;
		return n*factorial(n-1);
	}
	
	public static int fib(int n) {
		System.out.println("fib function entered:"+n);
		
		if(n==0) return 0;
		if(n==1) return 1;
		if(n==2) return 3;
		return fib(n-1)+fib(n-2);
	}
}
