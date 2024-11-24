package com.capitalone;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Anagram1 {
	
	public static void main (String str[]) {
		int a[] = {25, 35, 872, 228, 53, 278, 872};
		System.out.println(solution(a));
	}




public static long solution(int[] a) {


    int count=0;
   // ArrayList<Integer> visited = new ArrayList<Integer>();
    for(int i=0;i<a.length-1;i++) {
      
       for(int j=i+1; j<a.length;j++) {
    	   //int temp = a[i];
           if(isAnagram(a[i],a[j])) {
              // visited.add(temp);
             //  visited.add(a[j]);
               count ++;
           }
       }
    }
    return count;
}




private static boolean isAnagram(int a, int b) {
   
    String s1 = ""+a;
    String s2 = ""+b;
   
    PriorityQueue<String> pq1 =  new PriorityQueue<String>();
    PriorityQueue<String> pq2 =  new PriorityQueue<String>();


   
    if(s1.length() != s2.length()) {
       
        return false;
    }
   
   
   
   
    for(int i=0;i<s1.length();i++) {
        pq1.add(""+s1.charAt(i));
    }
    for(int i=0;i<s2.length();i++) {
        pq2.add(""+s2.charAt(i));
    }
   
   
    if(pq1.toString().equals(pq2.toString())) {
        return true;
    }
    else {
        return false;
    }
   
     
}
}