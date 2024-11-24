package com.test;

public class GenericsClass<T> {

	private T t;
	
	public T get(){
		return this.t;
	}
	
	public void set(T t1){
		this.t=t1;
	}
	
	public static void main(String args[]){
		GenericsClass<String> type = new GenericsClass<>();
		type.set("Pankaj"); //valid
		System.out.println(type.get());
		
		GenericsClass type1 = new GenericsClass(); //raw type
		type1.set("Pankaj"); //valid
		type1.set(10); //valid and autoboxing support
		System.out.println(type1.get());
	}
}