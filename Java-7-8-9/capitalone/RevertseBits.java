package com.capitalone;

public class RevertseBits {
	
	public static void main(String a[]) {
		int binaryNum = 100;
		for(int i=0;i<32;i++) {
	       // binaryNum = binaryNum<<1;        //binaryNum = binaryNum + (n&1);   n=n>>1; 
	        //System.out.println(binaryNum + "n&1--> "+ (binaryNum&1));
			System.out.print(":"+binaryNum);
	        binaryNum=binaryNum>>1;
	        System.out.print("n>>1:"+binaryNum);
	        System.out.println();
	    }
	}

}
