package com.jff.java8.lambda.methodreference;

interface MethodReferenceNS {
	void helloMethodReference();
}

public class NonStaticMethodReferenceDemo {
	void helloMethodReference() {
		System.out.println("From helloMethodReference!");

	}
	
	public static Runnable r1 = () -> {
		System.out.println("TEST");
	};
	
	

	public static void main(String args[]) {
		NonStaticMethodReferenceDemo obj = new NonStaticMethodReferenceDemo();
		MethodReferenceNS methodReferenceNS = obj::helloMethodReference;
		methodReferenceNS.helloMethodReference();
		
		r1.run();
		
		String s1="abc";
		String s2="abc";
		
		String s3= new String("abc");
		String s4= new String("abc");
		
		System.out.println(s1==s2);
		System.out.println(s2==s3);
		System.out.println(s1==s3);
		
		s1=s3;
		System.out.println(s1==s3);
		
		
		
	}
}
