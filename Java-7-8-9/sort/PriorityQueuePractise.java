package com.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueuePractise {
	
	 static class test {
		 int x;
		 int y;
	}
	
	public static void main(String a[]) {
		
		PriorityQueue<test> pq = null;
		 
		//int a[] = {5,4,3,2,1};
		//int b[] = {100,101,102,103,104}; 
		//PriorityQueue<Integer> pq = null;
		
		//pq = new PriorityQueue<>(a -> Math.abs(a.row - numRows / 2) + Math.abs(a.col - numCols / 2));
		
		pq = new PriorityQueue<>(Comparator.comparingInt(z -> z.x));
		//pq = new PriorityQueue<>(a -> Math.abs(a.row - numRows / 2) + Math.abs(a.col - numCols / 2));
		
		//pq = new PriorityQueue<>(Comparator.comparingInt(c->c.x));
		
     //   pq = new PriorityQueue<>(Comparator.comparingInt(z -> z.x));


		
	}

}
