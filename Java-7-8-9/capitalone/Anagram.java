package com.capitalone;

import java.util.ArrayList;
import java.util.PriorityQueue;


public class Anagram {
	
	public static void main(String a[]) {
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		//al.co
		//BinaryTree
		PriorityQueue<String> pq1 = new PriorityQueue<String>();
		PriorityQueue<String> pq2 = new PriorityQueue<String>();

		pq1.add("2");pq1.add("7");pq1.add("8"); 
		pq2.add("2");pq2.add("8");pq2.add("7");
		
		System.out.println(pq1.toString());
		System.out.println(pq2.toString());
		
		if(pq1.toString().equals(pq2.toString())) {
			System.out.println("EQ");
		} else {
			System.out.println("NEQ");
		}
	}

}
