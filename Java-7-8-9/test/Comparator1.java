package com.test;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;
import java.util.Comparator;

public class Comparator1 {
	
	public static void main(String a[]) {
		
		Person p1=new Person();
		p1.testPerson();
		
		
		
	}
	
	static  class Person  {		
		String name;
		int age;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return name;
		}
		
		Person(){
		}
		
		Person(String name, int age) {
			this.name=name;
			this.age=age;
		}		
		int getAge() {return age;}
		String getName() {return name;}		
		
		
		public void testPerson() {
			
			
			
			Person p1 = new Person("Chirag",39);
			Person p2 = new Person("Parag",40);
			Person p3 = new Person("Test",31);
			
			ArrayList<Person> ageList = new ArrayList<Person>();
			ageList.add(p1);ageList.add(p2);ageList.add(p3);
			
			System.out.println("Before:"+ageList.toString());
			
			Collections.sort(ageList, new Comparator<Person>() {
				
				@Override
				public int compare(Person p1, Person p2) {
					return p1.getAge() - p2.getAge();
				}
				
				
			});
			
			System.out.println("After:"+ageList.toString());
		}
	}
	
	
	
	


}
