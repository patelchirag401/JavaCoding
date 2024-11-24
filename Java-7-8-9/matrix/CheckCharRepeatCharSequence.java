package com.matrix;

public class CheckCharRepeatCharSequence {
	
	public static void main(String a[]) {
		
		
		String str = "beabeefeab";
	    int NUM_LETTERS = 26;
	    int length =str.length();
	    
	    /* Create arrays representing the 26^2 subproblems */
	    int[][] pair = new int[NUM_LETTERS][NUM_LETTERS];
	    int[][] count = new int[NUM_LETTERS][NUM_LETTERS];
	    
	    for (int i = 0; i < length; i++) {
	        char letter = str.charAt(i);
	        System.out.print("Letter: "+letter);
	        int letterNum = letter - 'a';
	        System.out.print("   letterNum: "+letterNum);
	        
	        for (int col = 0; col < NUM_LETTERS; col++) {
	            if (pair[letterNum][col] == letter) {
	              count[letterNum][col] = -1;
	            }
	            if (count[letterNum][col] != -1) {
	              pair[letterNum][col] = letter;
	              count[letterNum][col]++;
	            }
	          }
	        
	        /* Update column */
	        for (int row = 0; row < NUM_LETTERS; row++) {
	          if (pair[row][letterNum] == letter) {
	            count[row][letterNum] = -1;
	          }
	          if (count[row][letterNum] != -1) {
	            pair[row][letterNum] = letter;
	            count[row][letterNum]++;
	          }
	        }
	      }

	    }
	    
	    
	

}
