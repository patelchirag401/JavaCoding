package com.capitalone;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxArrayLength {
	public static void main(String a[]) {
		
		// ["aba", "aa", "ad", "vcd", "aba"]
		String[] inputArray = new String[] {"aba", "aa", "ad", "vcd", "aba"};
		 inputArray = solution(inputArray);
		 for(int i=0;i<inputArray.length;i++) {
				//maxLength[i] = inputArray[i].length();
				System.out.print(inputArray[i]+ " ");
			}
		
		
		
	}

	
	public static String[] solution(String[] inputArray) {
		
		int[] maxLength = new int [inputArray.length]; // remember to decleare length like this
		
		for(int i=0;i<inputArray.length;i++) {
			maxLength[i] = inputArray[i].length();
		}
		
		Arrays.sort(maxLength);
		
		int maxL = maxLength[maxLength.length-1];
		
		ArrayList<String> al = new ArrayList<String>();
		for(int i=0;i<inputArray.length;i++) {
			if(inputArray[i].length() == maxL) {
				al.add(inputArray[i]);
			}
		}
		
		String[] result = al.toArray(new String[al.size()]);
		
		return result;
		
	}
}
