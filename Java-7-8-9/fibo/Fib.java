package com.fibo;


// 0 1 1 2 3 5 8 13 
public class Fib {
	
	public static void main (String a[]) {
		fib(100);
	}
	
	public static void fib (int n) {
		
		int a[] =  new int[100];
		a[0] = 0;
		System.out.println(a[0]);
		a[1] = 1;
		System.out.println(a[1]);
		//int start1 = 0;
		//System.out.println(start1);
		//int start2 = 1;
		//System.out.println(start2);
		//int start2 = 1;
		//int k = start1+start2;
		//System.out.println(k);
		//n = 10;
		for (int i=2;i<=n;i++) {
			a[i] = a[i-1] + a[i-2];
			System.out.println(a[i]);
		}
	}

}
