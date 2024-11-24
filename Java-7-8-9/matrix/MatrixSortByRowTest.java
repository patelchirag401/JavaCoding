package com.matrix;

import java.util.Arrays;


public class MatrixSortByRowTest {
	 public static void main(String[] args) {
		 
		 
		// int m[][] = new int[26][2];
		 
		int[][] m = { { 31, 1, -1 },
	   				{ 31, 5, -1},
	   				{ 31, 25, 35 },
	    };
		 System.out.println("Original:");
		 printArray(m);

		 
		 // remember a technique to sort via row
		 Arrays.sort(m, (a,b) -> {
			 
			 for(int k=0;k<3;k++) {
				 if(a[k]<b[k]) {
					 return 1; // return descending order
				 } else if(a[k]>b[k]) {
					 return -1; //// return descending order
				 }
			 }
			 
			 return 0;
			 
		 });
		 
		 
		 // remember a technique to sort via row
		 Arrays.sort(m, (a,b) -> {
			 
			 for(int k=0;k<3;k++) {
				 if(a[k]<b[k]) {
					 return -1; // return ascending order
				 } else if(a[k]>b[k]) {
					 return 1; //// return ascending order
				 }
			 }
			 
			 return 0;
			 
		 });
		 
		 System.out.println("After Sort:");
		 printArray(m);
		 
		 
	 }
	 
	 public static void printArray(int m[][]) {
		 for(int i=0;i<m.length;i++) {
			 for(int j=0;j<m[0].length;j++) {
				 System.out.print(" "+m[i][j]);
			 }
			 System.out.println();
		 }
	 }
}
