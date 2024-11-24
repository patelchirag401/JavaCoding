package com.sort;

public class LargestStockProfiltLeetcode {
	
	// Youtube video : https://www.youtube.com/watch?v=ioFPBdChabY
	
	
	
	public static void main(String a[]) {
		
		int[] prices = new int[] {7,1,5,3,6,4};
		
		// we have to track two pointers here, one points to the min buy and other points to max profit...
		
		int min_price = prices[0];
        int maxprof = 0;

        for(int i=0;i<prices.length;i++){
            maxprof = Math.max(maxprof,prices[i]-min_price);
            min_price = Math.min(prices[i],min_price);
        }
        
        System.out.println("maxprof:"+maxprof);

	}

}
