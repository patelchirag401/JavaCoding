package com.test;

public class TestSmallSnippets {
	public static void main(String a[]) {
		
		// Split TEST
		String s="abc defv ddf";		
		String[] str = s.split(" ");
		System.out.print(str);	

		
		// Number of 1 Bits
		int n = 00000000000000000000000000001011;
		int count = 0;
		while(n!=0) {			
			if((n&1)==1) {
				count ++;
			}			
			n=n>>>1;			
		}		
		System.out.print("COUNT:"+count);
		
		
		
  // Method1:::Leetcode Count bits
		n=10;
		 int[] arr = new int[n+1];
	        arr[0] = 0;
	      for(int i =1;i<=n;i++){
	            int temp = i;
	             count = 0 ;
	            while(temp != 0){ 
	                temp = temp & (temp-1); // new value of numer is temp and previous value of number....this is the main logic
	                // youtube video : https://www.youtube.com/watch?v=bnNonZETedE
	                count++;
	            }
	            arr[i] = count;
	        }
		
	      System.out.println("Method 1:");
	      for(int i=0;i<arr.length;i++) {
	    	  System.out.print(":"+arr[i]);
	      }
		
	// Method 2:
	      
	 //Bitwise right shifting i >> 1 essentially removes the last bit, and i & 1 extracts the last bit. 
	 //This helps us compute the result for i using previously computed results.     
	
	      int[] ans = new int[n + 1];
	        for (int i = 1; i <= n; i++) {
	            ans[i] = ans[i >> 1] + (i & 1);
	        }
	        
	        System.out.println("Method 2:");
		      for(int i=0;i<ans.length;i++) {
		    	  System.out.print(":"+ans[i]);
		      }  
		      
		      
		      
	// reverseBits  --- did not understand well
		int num=00000000000000000000000000000101;
		//int num = 2147483641;
		int binaryNum = 0;
		for(int i=0;i<32;i++) {
	        binaryNum = binaryNum<<1;                   //multiply by 2
	        binaryNum = binaryNum + (n&1);              //add last digit to binaryNum 
	        n=n>>1;                                     //update n by removing last digit
	    }
		
		 System.out.print(":         ");
		 
		 System.out.print("binaryNum:"+binaryNum);
		      
	}
}
