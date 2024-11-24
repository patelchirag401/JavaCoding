package com.fibo;


// 0 1 1 2 3 5 8 13 
public class FibRec {
	
	public static void main(String a[]) {
		System.out.println(fib(3));
		
		for(int i=0;i<10;i++) {
			System.out.println(fib(i));
		}
	}
	
	public static int fib (int n) {
		
		if(n==0 || n==1) {
			return n;
		}		
		return fib(n-1) + fib(n-2);
	}

}
