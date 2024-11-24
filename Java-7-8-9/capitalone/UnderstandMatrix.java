package com.capitalone;

import java.util.Stack;

public class UnderstandMatrix {
	
	public static void main(String a[]) {
		//int[][] matrix = new int[8][5];
		int[][] matrix = new int[5][8]; //mxn where m=5 and n=8 m=row and n=column
		
		int[][] matrix1 = new int[5][8] ; 
		

		//System.out.println(matrix1[0].length); //8 column
		//System.out.println(matrix1.length);//5 //row
		
		
		for(int i=0;i<matrix1.length;i++) {
			for(int j=0;j<matrix1[0].length;j++) {
				matrix1[i][j] = i+j;
			}
		}
		for(int i=0;i<matrix1.length;i++) {
			for(int j=0;j<matrix1[0].length;j++) {
				//System.out.print(" "+ matrix1[i][j]);
			}
			//System.out.println();
		}		
		
		
		int []C = new int[10];
		for(int i=0;i<C.length;i++) {
			C[i] = i;
		}
		
		for(int i=0;i<C.length;i++) {
			
			for(int j=0;j<C.length;j++) {
				//System.out.print(" i:  "+ i);
				//System.out.print(" j:  "+ j);
			}
			
		}
		System.out.println();
		
		for(int i=0;i<C.length;i++) {
			
			for(int j=i;j<C.length;j++) {
				//System.out.print(" i:  "+ i);
				//System.out.print(" j:  "+ j);
			}
			
		}
		
		String str = "---ABC".concat(" a");
		System.out.println("----------------------------------");
		System.out.println(str);
		
		int []Temp = new int[10];
		//Temp = C;
		
		for(int i=0;i<C.length;i++) {
			System.out.print("C: "+ C[i]);
		}
		
		System.arraycopy(C, 5, Temp, 5, 4);
		System.out.println("----------------------------------");
		for(int i=0;i<C.length;i++) {
			System.out.print("TEMP: "+ Temp[i]);
		}
		System.out.println("----------------------------------");
		Stack<String> s1 = new Stack<String>();
		
		s1.push("C");s1.push("B");s1.push("A");
		System.out.println("----------------------------------"+s1.pop());

		System.out.println("----------------------------------"+s1.peek());
		
		int count[] = new int[256];
		String str1 = "testmystring";
		
		for(int t=0;t<str1.length();t++) {
			count[str1.charAt(t)] ++;
		}
		
		int max=0; 
		char char1 = 'a';
		for(int c=0;c<count.length;c++) {
			int temp = count[c];
			if(temp>max) {
				max = temp;
				char1=(char)temp;
				char1 = char1='a';
			}
		}
		
		System.out.println("MAX----------------------------------"+max);
		System.out.println("MAX char----------------------------------"+""+char1);
		
	}
}
