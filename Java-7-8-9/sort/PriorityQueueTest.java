package com.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest  {
	
	
	static class PriorityQueueComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1>o2) return -1;
			else if(o1<o2) return 1;
			else return 0;
		}
	}
	
	public static void main(String a[]) {

		 /**
	     * Priority queue represented as a balanced binary heap: the two
	     * children of queue[n] are queue[2*n+1] and queue[2*(n+1)].  The
	     * priority queue is ordered by comparator, or by the elements'
	     * natural ordering, if comparator is null: For each node n in the
	     * heap and each descendant d of n, n <= d.  The element with the
	     * lowest value is in queue[0], assuming the queue is nonempty.
	     */
		
		Queue<Integer> naturalOrderPQ = new PriorityQueue<>();

//		for(int i=200;i>=1;i--) {
//			naturalOrderPQ.add(i);
//		}
		naturalOrderPQ.add(10);
		naturalOrderPQ.add(10);
		naturalOrderPQ.add(0);
		naturalOrderPQ.add(-10);
		naturalOrderPQ.add(110);
		naturalOrderPQ.add(210);
		naturalOrderPQ.add(-210);

		
		System.out.println("TEST PEEK:"+naturalOrderPQ.peek());
		
		System.out.println("END PEEK");
		
		System.out.println("START POLL");

//		for(int i=0;i<naturalOrderPQ.size(); i++) {
//			System.out.println(naturalOrderPQ.poll());
//		}
		
		while(!naturalOrderPQ.isEmpty()) {
			System.out.println(naturalOrderPQ.poll());
		}
		
		System.out.println("END POLL");
		
		Queue<Integer> comparatorOrderPQ = new PriorityQueue<Integer>(new PriorityQueueComparator());
		
		System.out.println("PriorityQueueComparator STARTS:");
		
		comparatorOrderPQ.add(10);
		comparatorOrderPQ.add(0);
		comparatorOrderPQ.add(-10);
		comparatorOrderPQ.add(110);
		comparatorOrderPQ.add(210);
		
	
		while(!comparatorOrderPQ.isEmpty()) {
			System.out.println(comparatorOrderPQ.poll());
		}
		
		System.out.println("Using collections revertese order STARTS:");
		Queue<Integer> collectionOrderPQ = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		collectionOrderPQ.add(10);
		collectionOrderPQ.add(0);
		collectionOrderPQ.add(-10);
		collectionOrderPQ.add(110);
		collectionOrderPQ.add(210);
		
		while(!collectionOrderPQ.isEmpty()) {
			System.out.println(collectionOrderPQ.poll());
		}
		
		
		

	}

}
